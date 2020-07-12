package io.agora.education.record

import io.agora.education.statistics.RecordState

class EduRecordInfo constructor() {
    lateinit var appId: String
    lateinit var roomId: String
    lateinit var recordId: String
    lateinit var recordState: RecordState
    var recordingTime: Long = 0

    constructor(appId: String, roomId: String, recordId: String, recordState: RecordState,
                recordingTime: Long): this() {
        this.appId = appId
        this.roomId = roomId
        this.recordId = recordId
        this.recordState = recordState
        this.recordingTime = recordingTime
    }
}