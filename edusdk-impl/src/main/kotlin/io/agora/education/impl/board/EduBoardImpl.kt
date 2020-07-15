package io.agora.education.impl.board

import io.agora.education.api.EduCallback
import io.agora.education.api.board.EduBoard
import io.agora.education.api.board.data.EduBoardInfo
import io.agora.education.api.board.data.EduBoardRoom
import io.agora.education.api.user.data.EduUserInfo

class EduBoardImpl constructor() : EduBoard() {
    override fun followMode(enable: Boolean, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun grantPermission(user: EduUserInfo, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun revokePermission(user: EduUserInfo, callback: EduCallback<Unit>) {
        TODO("Not yet implemented")
    }

    override fun getBoardInfo(callback: EduCallback<EduBoardInfo>) {
        TODO("Not yet implemented")
    }


}