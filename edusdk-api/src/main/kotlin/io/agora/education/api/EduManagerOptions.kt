package io.agora.education.api

import android.content.Context
import io.agora.education.api.logger.LogLevel

data class EduManagerOptions(
        val context: Context,
        val appId: String
) {
    var customerId: String? = null
    var customerCertificate: String? = null
    var logLevel: LogLevel = LogLevel.ALL
    var logFileDir: String? = null
}