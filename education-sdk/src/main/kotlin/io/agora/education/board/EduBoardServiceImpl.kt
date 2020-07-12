package io.agora.education.board

import io.agora.education.edumanager.EduUser

class EduBoardServiceImpl constructor() : EduBoardService() {

    override fun getBoardRoom(): EduBoardRoom {
        TODO("Not yet implemented")
    }

    override fun followMode(enable: Boolean, successCallback: (whiteInfo: WhiteInfoModel) -> Unit, failureCallback: (throwable: Throwable) -> Unit): Void {
        TODO("Not yet implemented")
    }

    override fun grantPermission(remoteUser: EduUser, successCallback: (whiteInfo: WhiteInfoModel) -> Unit, failureCallback: (throwable: Throwable) -> Unit): Void {
        TODO("Not yet implemented")
    }

    override fun revokePermission(remoteUser: EduUser, successCallback: (whiteInfo: WhiteInfoModel) -> Unit, failureCallback: (throwable: Throwable) -> Unit): Void {
        TODO("Not yet implemented")
    }

    override fun getWhiteInfo(successCallback: (whiteInfo: WhiteInfoModel) -> Unit, failureCallback: (throwable: Throwable) -> Unit): Void {
        TODO("Not yet implemented")
    }
}