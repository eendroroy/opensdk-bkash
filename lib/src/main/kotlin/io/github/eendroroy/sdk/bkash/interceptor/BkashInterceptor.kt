package io.github.eendroroy.sdk.bkash.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @author indrajit
 */
interface BkashInterceptor : Interceptor {
    fun rawRequestBody(request: Request): String
    fun rawResponseBody(response: Response): String
}
