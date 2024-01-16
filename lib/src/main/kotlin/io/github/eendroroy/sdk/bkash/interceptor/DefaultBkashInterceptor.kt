package io.github.eendroroy.sdk.bkash.interceptor

import okhttp3.Request
import okhttp3.Response

/**
 * @author indrajit
 */
class DefaultBkashInterceptor : AbstractBkashInterceptor() {
    override fun interceptRequest(request: Request): Request {
        return request
    }

    override fun interceptResponse(response: Response): Response {
        return response
    }
}
