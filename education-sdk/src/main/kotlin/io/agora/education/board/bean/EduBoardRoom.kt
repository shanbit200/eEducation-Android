package io.agora.education.board.bean

import io.agora.education.board.bean.EduBoardOperator

class EduBoardRoom constructor() {
    var boardFollow: Boolean = false
    lateinit var boardOperators: Array<EduBoardOperator?>
    var operatorCount: Int = 0

    constructor(boardFollow: Boolean, boardOperators: Array<EduBoardOperator?>,
                operatorCount: Int): this() {
        this.boardFollow = boardFollow
        this.boardOperators = boardOperators
        this.operatorCount = operatorCount
    }
}