package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class TransferType {
    Collection2Disbursement, Disbursement2Collection;

    fun value(): String {
        return name
    }
}
