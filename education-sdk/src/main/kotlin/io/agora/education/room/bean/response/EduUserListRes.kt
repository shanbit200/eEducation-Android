package io.agora.education.room.bean.response

import io.agora.education.user.enums.EduRoleType

/**@param count 本次返回的条数
 * @param total 数据总量
 * @param nextId 下一次查询的起始userId
 * @param list */
class EduUserListRes constructor(var count: Int,
                                 var total: Int,
                                 var nextId: String,
                                 var list: ArrayList<EduUserRes>) {


}

class EduUserRes constructor(var userId: String,
                             var userUuid: String,
                             var userName: String,
                             var role: EduRoleType
) {

}