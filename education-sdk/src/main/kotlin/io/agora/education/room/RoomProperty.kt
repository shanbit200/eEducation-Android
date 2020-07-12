package io.agora.education.room

class RoomProperty constructor()  {
    lateinit var key: String
    lateinit var value: Any

    constructor(key: String, value: Any): this() {
        this.key = key
        this.value = value
    }
}