package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class TransactionType {
    Payment,
    Refund,
    Cash_Back_Contribution("Cash Back Contribution"),
    Cash_Back_Contribution_Reversal("Cash Back Contribution Reversal"),
    Intra_Account_Transfer("Intra Account Transfer"),
    Bank_Settlement("Bank Settlement"),
    Bank_Settlement_Reversal("Bank Settlement Reversal"),
    Journal_Entry("Journal Entry");

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
