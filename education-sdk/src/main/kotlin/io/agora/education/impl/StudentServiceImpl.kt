package io.agora.education.impl

import io.agora.education.user.StudentService
import io.agora.education.user.User

class StudentServiceImpl internal constructor(
        localUser: User
) : LocalUserServiceImpl(localUser), StudentService
