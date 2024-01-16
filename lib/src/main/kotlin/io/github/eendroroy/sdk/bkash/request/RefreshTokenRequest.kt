package io.github.eendroroy.sdk.bkash.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("request")
class RefreshTokenRequest(
    @field:JsonProperty("app_key") var appKey: String? = null,
    @field:JsonProperty("app_secret") var appSecret: String? = null,
    @field:JsonProperty("refresh_token") var refreshToken: String? = null
) {
    fun appKey(appKey: String?) = apply { this.appKey = appKey }
    fun appSecret(appSecret: String?) = apply { this.appSecret = appSecret }
    fun refreshToken(refreshToken: String?) = apply { this.refreshToken = refreshToken }
}
