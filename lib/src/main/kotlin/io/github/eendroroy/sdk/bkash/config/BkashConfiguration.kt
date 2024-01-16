package io.github.eendroroy.sdk.bkash.config

/**
 * @author indrajit
 */
interface BkashConfiguration {
    // URL
    fun baseUrl(): String

    // Credentials
    fun username(): String
    fun password(): String
    fun appKey(): String
    fun appSecret(): String

    // Headers
    fun contentType(): String
    fun accept(): String

    // Http
    fun disableRootCaVerification(): Boolean
    fun timeOut(): Long
}
