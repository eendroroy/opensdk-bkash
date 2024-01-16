package io.github.eendroroy.sdk.bkash.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("response")
data class IntraAccTransferResponse(
    @field:JsonProperty("amount") var amount: String? = null,
    @field:JsonProperty("completedTime") var completedTime: String? = null,
    @field:JsonProperty("currency") var currency: String? = null,
    @field:JsonProperty("transactionStatus") var transactionStatus: String? = null,
    @field:JsonProperty("transferType") var transferType: String? = null,
    @field:JsonProperty("trxID") var trxID: String? = null,
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
