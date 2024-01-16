package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class AccountType(private val value: String) {
    CollectionWallet("Organization eMoney Account"),
    DisbursementWallet("Organization Disbursement eMoney Account");

    fun value(): String {
        return value
    }
}
