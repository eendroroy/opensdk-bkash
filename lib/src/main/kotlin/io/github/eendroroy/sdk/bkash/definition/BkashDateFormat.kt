package io.github.eendroroy.sdk.bkash.definition

import java.time.format.DateTimeFormatter

/**
 * @author indrajit
 */
enum class BkashDateFormat(private val value: String) {
    CREATE_TIME("yyyy-MM-dd'T'HH:mm:ss:SSS 'GMT'Z"),
    UPDATE_TIME("yyyy-MM-dd'T'HH:mm:ss:SSS 'GMT'Z"),
    INITIATION_TIME("yyyy-MM-dd'T'HH:mm:ss:SSS 'GMT'Z"),
    COMPLETED_TIME("yyyy-MM-dd'T'HH:mm:ss:SSS 'GMT'Z");

    fun value(): String {
        return value
    }

    fun format(): DateTimeFormatter {
        return DateTimeFormatter.ofPattern(value())
    }
}
