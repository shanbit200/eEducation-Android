package io.agora.education.record

enum class RecordState(state: Int) {
    RecordStateRecording   (1),
    RecordStateFinished    (2),
    RecordStateWaitDownload(3),
    RecordStateWaitConvert (4),
    RecordStateWaitUpload  (5)
}