package io.agora.education.impl.user.data.request

/**发送peerMsg
 * @param userId 接收方的userId*/
class EduUserMsgReq constructor(var userId: String,
                                var msg: String) {
}