package io.github.eendroroy.sdk.bkash.client

import io.github.eendroroy.sdk.bkash.config.BkashConfiguration
import io.github.eendroroy.sdk.bkash.converter.ResponseConverter
import io.github.eendroroy.sdk.bkash.definition.HttpHeader
import io.github.eendroroy.sdk.bkash.endpoint.BkashAuthEndpoints
import io.github.eendroroy.sdk.bkash.request.GrantTokenRequest
import io.github.eendroroy.sdk.bkash.request.RefreshTokenRequest
import io.github.eendroroy.sdk.bkash.response.BkashTokenResponse
import retrofit2.Response
import retrofit2.Retrofit

/**
 * @author indrajit
 */
class BkashAuthClient(
    private val retrofit: Retrofit,
    private val endpoints: BkashAuthEndpoints,
    private val configuration: BkashConfiguration
) {
    private val headers: HashMap<String, String>
        get() {
            val headers = HashMap<String, String>()
            headers[HttpHeader.ContentType.key()] = configuration.contentType()
            headers[HttpHeader.Accept.key()] = configuration.accept()
            headers[HttpHeader.Username.key()] = configuration.username()
            headers[HttpHeader.Password.key()] = configuration.password()
            return headers
        }

    @Throws(Exception::class)
    fun grantToken(request: GrantTokenRequest): BkashTokenResponse? {
        val apiResponse: Response<BkashTokenResponse?> = endpoints.grantToken(headers, request).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun refreshToken(request: RefreshTokenRequest): BkashTokenResponse? {
        val apiResponse: Response<BkashTokenResponse?> = endpoints.refreshToken(headers, request).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }
}
