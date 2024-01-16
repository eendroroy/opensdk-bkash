package io.github.eendroroy.sdk.bkash.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.bkash.definition.Currency
import io.github.eendroroy.sdk.bkash.definition.Intent

/**
 * @author indrajit
 */
@JsonRootName("request")
data class PaymentAuthorizeRequest(
    @field:JsonProperty("amount") var amount: String? = null,
    @field:JsonProperty("currency") var currency: String? = Currency.BDT.value(),
    @field:JsonProperty("intent") var intent: String? = Intent.AUTHORIZATION.value(),
    @field:JsonProperty("merchantInvoiceNumber") var merchantInvoiceNumber: String? = null
) {
    fun amount(amount: String) = apply { this.amount = amount }
    fun currency(currency: String) = apply { this.currency = currency }
    fun intent(intent: String) = apply { this.intent = intent }
    fun merchantInvoiceNumber(merchantInvoiceNumber: String) = apply {
        this.merchantInvoiceNumber = merchantInvoiceNumber
    }
}
