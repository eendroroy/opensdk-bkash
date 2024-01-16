package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class Intent(private val value: String) {
    SALE("sale"), AUTHORIZATION("authorization");

    fun value(): String {
        return value
    }
}
