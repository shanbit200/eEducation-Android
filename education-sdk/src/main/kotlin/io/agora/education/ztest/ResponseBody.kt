package io.agora.education.ztest

open class ResponseBody<T> constructor() {
    var code: Int = 0
    var msg: T? = null
}