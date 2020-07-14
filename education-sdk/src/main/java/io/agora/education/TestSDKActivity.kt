package io.agora.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.agora.base.util.CryptoUtil
import io.agora.base.network.RetrofitManager
import java.util.*
import kotlin.text.Charsets.UTF_8

class TestSDKActivity : AppCompatActivity() {
    private val appAuth: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_s_d_k)
        RetrofitManager.instance().addHeader("Content-Type", "application/json");
        RetrofitManager.instance().addHeader("Authorization", CryptoUtil.getAuth(appAuth))


    }
}
