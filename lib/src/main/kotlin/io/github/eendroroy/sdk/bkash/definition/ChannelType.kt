package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class ChannelType {
    USSD, APP, PGW, WEB, SYSTEM;

    fun value(): String {
        return name
    }
}
