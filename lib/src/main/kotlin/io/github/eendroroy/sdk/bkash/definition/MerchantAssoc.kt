package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class MerchantAssoc {
    MI("Merchant Identifier"), MW("Merchant Wallet Number"), RF("Payment Reference");

    private val value: String
    private val description: String

    constructor(description: String) {
        value = name
        this.description = description
    }

    constructor(value: String, description: String) {
        this.value = value
        this.description = description
    }

    fun value(): String {
        return value
    }

    fun description(): String {
        return description
    }
}
