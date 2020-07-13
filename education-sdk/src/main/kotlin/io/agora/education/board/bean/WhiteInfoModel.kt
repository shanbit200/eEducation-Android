package io.agora.education.board.bean

class WhiteInfoModel constructor() {
    lateinit var boardId: String
    lateinit var boardToken: String

    constructor(boardId: String, boardToken: String): this() {
        this.boardId = boardId
        this.boardToken = boardToken
    }
}