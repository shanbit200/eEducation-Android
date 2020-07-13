package io.agora.education.record

interface EduRecordEventListener {
    fun onStartRecord(recordInfo: EduRecordInfo):Void

    fun onStopRecord(recordInfo: EduRecordInfo):Void
}