package io.agora.education.ztest

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit
import io.agora.education.room.bean.response.ResponseBody

class RetrofitManager private constructor() {
    private val client: OkHttpClient
    private val headers: MutableMap<String, String>? = HashMap()
    private var logger: HttpLoggingInterceptor.Logger? = null
    fun addHeader(key: String, value: String) {
        headers!![key] = value
    }

    fun setLogger(logger: HttpLoggingInterceptor.Logger) {
        this.logger = logger
    }

    fun <T> getClient(baseUrl: String, tClass: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(tClass)
    }

    class Callback<T : ResponseBody<*>?>(private val code: Int, private val success: (Any) -> Unit,
                                                                                                  private var failure: (Any) -> Unit) : retrofit2.Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.errorBody() != null) {
                try {
                    failure(Throwable(response.errorBody()!!.string()))
                } catch (e: IOException) {
                    failure(e)
                }
            } else {
                val body = response.body()
                if (body == null) {
                    failure(Throwable("response body is null"))
                } else {
                    if (body.code != code) {
                        failure(BusinessException(body.code, body.msg.toString()))
                    } else {
                        success(body)
                    }
                }
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            failure(t)
        }
    }

    companion object {

        private var instance: RetrofitManager? = null
        fun instance(): RetrofitManager? {
            if (instance == null) {
                synchronized(RetrofitManager::class.java) {
                    if (instance == null) {
                        instance = RetrofitManager()
                    }
                }
            }
            return instance
        }
    }

    init {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        clientBuilder.readTimeout(30, TimeUnit.SECONDS)
        clientBuilder.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val request = chain.request()
            val requestBuilder = request.newBuilder()
                    .method(request.method, request.body)
            if (headers != null) {
                for ((key, value) in headers) {
                    requestBuilder.addHeader(key, value)
                }
            }
            chain.proceed(requestBuilder.build())
        })
        clientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        client = clientBuilder.build()
    }
}