package io.agora.education.user.bean

class EduShareScreenConfig constructor() {
    lateinit var streamUuid: String
    lateinit var streamName: String

    /**对齐RTC SDK， 比如可以设置是那个应用*/
    lateinit var owner: String
}