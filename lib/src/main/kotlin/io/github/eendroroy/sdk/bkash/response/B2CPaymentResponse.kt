package io.github.eendroroy.sdk.bkash.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("response")
data class B2CPaymentResponse(
    @field:JsonProperty("completedTime") var completedTime: String? = null,
    @field:JsonProperty("trxID") var trxID: String? = null,
    @field:JsonProperty("transactionStatus") var transactionStatus: String? = null,
    @field:JsonProperty("amount") var amount: String? = null,
    @field:JsonProperty("currency") var currency: String? = null,
    @field:JsonProperty("merchantInvoiceNumber") var merchantInvoiceNumber: String? = null,
    @field:JsonProperty("receiverMSISDN") var receiverMSISDN: String? = null,
    @field:JsonProperty("b2cFee") var b2cFee: String? = null,
    @field:JsonProperty("message") var message: String? = null,
    @field:JsonProperty("errorCode") var errorCode: String? = null,
    @field:JsonProperty("errorMessage") var errorMessage: String? = null,
    @field:JsonProperty("errorType") var errorType: String? = null,
    @field:JsonProperty("stackTrace") var stackTrace: List<String>? = null
) : BaseResponse() {
    override fun httpResponseCode(httpResponseCode: Int): BaseResponse {
        this.httpResponseCode = httpResponseCode
        return this
    }

    override fun httpResponseMessage(httpResponseMessage: String): BaseResponse {
        this.httpResponseMessage = httpResponseMessage
        return this
    }
}
