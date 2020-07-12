package io.agora.education.record

abstract class EduRecordService constructor() {
    lateinit var delegate: EduRecordDelegate

    abstract fun getRecordInfo(): EduRecordInfo

    abstract fun startRecord(successCallback: (recordInfo: EduRecordInfo) -> Unit,
                             failureCallback: (throwable: Throwable) -> Unit)

    abstract fun stopRecord(successCallback: (recordInfo: EduRecordInfo) -> Unit,
                             failureCallback: (throwable: Throwable) -> Unit)
}