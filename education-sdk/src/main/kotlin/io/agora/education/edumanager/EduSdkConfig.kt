package io.agora.education.edumanager

import io.agora.education.statistics.LogLevel

class EduSdkConfig constructor(
        appId: String,
        customerId: String,
        customerCertificate: String
) {
    var appId: String = appId
    var customerId: String = customerId
    var customerCertificate = customerCertificate
    var logLevel: LogLevel = LogLevel.LOG_LEVEL_NONE;
    var logDirectoryPath: String = "/usr/xxx"

    constructor (appId: String, customerId: String, customerCertificate: String, logLevel: LogLevel, logDirectoryPath: String):
            this(appId, customerId, customerCertificate) {
        this.logLevel = logLevel
        this.logDirectoryPath = logDirectoryPath
    }
}