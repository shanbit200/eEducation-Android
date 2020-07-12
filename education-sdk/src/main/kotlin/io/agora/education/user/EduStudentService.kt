package io.agora.education.user

import io.agora.education.board.EduBoardService
import io.agora.education.board.EduBoardServiceImpl

abstract class EduStudentService constructor() : EduUserService() {
    lateinit var delegate: EduStudentDelegate
}