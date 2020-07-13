package io.agora.education.board

import io.agora.education.board.bean.EduBoardRoom
import io.agora.education.board.bean.WhiteInfoModel
import io.agora.education.edumanager.bean.EduUser

abstract class EduBoardService constructor() {
    lateinit var eventListener: EduBoardEventListener

    abstract fun getBoardRoom(): EduBoardRoom

    abstract fun followMode(enable: Boolean, successCallback: (whiteInfo: WhiteInfoModel) -> Unit,
                            failureCallback: (throwable: Throwable) -> Unit): Void

    abstract fun grantPermission(remoteUser: EduUser, successCallback: (whiteInfo: WhiteInfoModel) -> Unit,
                                 failureCallback: (throwable: Throwable) -> Unit): Void

    abstract fun revokePermission(remoteUser: EduUser, successCallback: (whiteInfo: WhiteInfoModel) -> Unit,
                                  failureCallback: (throwable: Throwable) -> Unit): Void

    abstract fun getWhiteInfo(successCallback: (whiteInfo: WhiteInfoModel) -> Unit,
                              failureCallback: (throwable: Throwable) -> Unit): Void
}