package io.github.eendroroy.sdk.bkash.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import io.github.eendroroy.sdk.bkash.response.nested.OrganizationBalance

/**
 * @author indrajit
 */
@JsonRootName("response")
data class OrganizationBalanceResponse(
    @field:JsonProperty("organizationBalance") var organizationBalances: List<OrganizationBalance>? = null,
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
