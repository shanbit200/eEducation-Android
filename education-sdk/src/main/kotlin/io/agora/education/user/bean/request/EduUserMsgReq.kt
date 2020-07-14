package io.agora.education.user.bean.request

/**发送peerMsg
 * @param userId 接收方的userId*/
class EduUserMsgReq constructor(var userId: String,
                                var msg: String) {
}