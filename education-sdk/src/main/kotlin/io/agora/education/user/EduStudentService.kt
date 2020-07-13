package io.agora.education.user

abstract class EduStudentService constructor() : EduUserService() {
    lateinit var eventListener: EduStudentEventListener
}