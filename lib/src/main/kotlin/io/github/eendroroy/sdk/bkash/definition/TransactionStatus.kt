package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class TransactionStatus {
    Initiated,
    Pending_Authorized("Pending Authorized"),
    Authorized,
    Expired,
    Completed,
    Cancelled,
    Declined;

    private val value: String

    constructor() {
        value = name
    }

    constructor(value: String) {
        this.value = value
    }

    fun value(): String {
        return value
    }
}
