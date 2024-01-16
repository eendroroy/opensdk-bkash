package io.github.eendroroy.sdk.bkash.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.bkash.definition.Currency

/**
 * @author indrajit
 */
@JsonRootName("request")
data class IntraAccTransferRequest(
    @field:JsonProperty("amount") var amount: String? = null,
    @field:JsonProperty("currency") var currency: String? = Currency.BDT.value(),
    @field:JsonProperty("transferType") var transferType: String? = null
) {
    fun amount(amount: String) = apply { this.amount = amount }
    fun currency(currency: String) = apply { this.currency = currency }
    fun transferType(transferType: String) = apply { this.transferType = transferType }
}
