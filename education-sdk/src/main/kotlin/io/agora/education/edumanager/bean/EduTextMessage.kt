package io.agora.education.edumanager.bean

class EduTextMessage constructor() {
    lateinit var userId: String
    lateinit var userName: String
    lateinit var message: String
    var timeStamp: Long = System.currentTimeMillis()

    constructor(userId: String, userName: String, message: String): this() {
        this.userId = userId
        this.userName = userName
        this.message = message
    }
    constructor(userId: String, userName: String, message: String, timeStamp: Long):
                this(userId, userName, message) {
        this.timeStamp = timeStamp
    }
}