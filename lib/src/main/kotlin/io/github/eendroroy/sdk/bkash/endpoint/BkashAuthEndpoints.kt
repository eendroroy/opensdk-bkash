package io.github.eendroroy.sdk.bkash.endpoint

import io.github.eendroroy.sdk.bkash.request.GrantTokenRequest
import io.github.eendroroy.sdk.bkash.request.RefreshTokenRequest
import io.github.eendroroy.sdk.bkash.response.BkashTokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

/**
 * @author indrajit
 */
interface BkashAuthEndpoints {
    @POST("/v1.2.0-beta/checkout/token/grant")
    fun grantToken(
        @HeaderMap headers: Map<String, String>,
        @Body request: GrantTokenRequest
    ): Call<BkashTokenResponse?>

    @POST("/v1.2.0-beta/checkout/token/refresh")
    fun refreshToken(
        @HeaderMap headers: Map<String, String>,
        @Body request: RefreshTokenRequest
    ): Call<BkashTokenResponse?>
}
