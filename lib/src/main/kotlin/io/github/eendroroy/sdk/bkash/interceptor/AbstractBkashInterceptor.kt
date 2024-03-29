package io.github.eendroroy.sdk.bkash.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import java.io.IOException

/**
 * @author indrajit
 */
abstract class AbstractBkashInterceptor : BkashInterceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = interceptRequest(request)
        var response = chain.proceed(request)
        response = interceptResponse(response)
        return response
    }

    abstract fun interceptRequest(request: Request): Request
    abstract fun interceptResponse(response: Response): Response
    override fun rawResponseBody(response: Response): String {
        return try {
            val responseBody = response.body() ?: return ""
            val source = responseBody.source()
            source.request(Long.MAX_VALUE)
            val buffer = source.buffer.clone()
            buffer.readUtf8()
        } catch (e: IOException) {
            ""
        } catch (e: IllegalStateException) {
            ""
        }
    }

    override fun rawRequestBody(request: Request): String {
        return try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            val body = copy.body() ?: return ""
            body.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            ""
        }
    }
}
