package io.github.eendroroy.sdk.bkash.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.bkash.definition.Currency

/**
 * @author indrajit
 */
@JsonRootName("request")
data class B2CPaymentRequest(
    @field:JsonProperty("amount") var amount: String? = null,
    @field:JsonProperty("currency") var currency: String? = Currency.BDT.value(),
    @field:JsonProperty("merchantInvoiceNumber") var merchantInvoiceNumber: String? = null,
    @field:JsonProperty("receiverMSISDN") var receiverMsisdn: String? = null
) {
    fun amount(amount: String?) = apply { this.amount = amount }
    fun currency(currency: String) = apply { this.currency = currency }
    fun merchantInvoiceNumber(merchantInvoiceNumber: String?) = apply {
        this.merchantInvoiceNumber = merchantInvoiceNumber
    }

    fun receiverMsisdn(receiverMsisdn: String?) = apply { this.receiverMsisdn = receiverMsisdn }
}
