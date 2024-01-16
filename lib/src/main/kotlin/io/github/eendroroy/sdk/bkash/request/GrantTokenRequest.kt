package io.github.eendroroy.sdk.bkash.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("request")
data class GrantTokenRequest(
    @field:JsonProperty("app_key") var appKey: String? = null,
    @field:JsonProperty("app_secret") var appSecret: String? = null
) {
    fun appKey(appKey: String?) = apply { this.appKey = appKey }
    fun appSecret(appSecret: String?) = apply { this.appSecret = appSecret }
}
