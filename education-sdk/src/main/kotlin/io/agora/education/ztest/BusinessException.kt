package io.agora.education.ztest

class BusinessException(val code: Int, override val message: String?) : RuntimeException()