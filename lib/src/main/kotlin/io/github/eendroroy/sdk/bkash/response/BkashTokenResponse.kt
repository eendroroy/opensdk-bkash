package io.github.eendroroy.sdk.bkash.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("response")
data class BkashTokenResponse(
    @field:JsonProperty("token_type") var tokenType: String? = null,
    @field:JsonProperty("id_token") var idToken: String? = null,
    @field:JsonProperty("expires_in") var expiresIn: Int? = null,
    @field:JsonProperty("refresh_token") var refreshToken: String? = null,
    @field:JsonProperty("status") var status: String? = null,
    @field:JsonProperty("msg") var message: String? = null,
    @field:JsonProperty("errorMessage") var errorMessage: String? = null,
    @field:JsonProperty("errorType") var errorType: String? = null,
    @field:JsonProperty("stackTrace") var stackTrace: List<String>? = null,
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
