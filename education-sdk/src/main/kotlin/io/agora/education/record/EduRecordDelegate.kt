package io.agora.education.record

interface EduRecordDelegate {
    fun onStartRecord(recordInfo: EduRecordInfo):Void

    fun onStopRecord(recordInfo: EduRecordInfo):Void
}