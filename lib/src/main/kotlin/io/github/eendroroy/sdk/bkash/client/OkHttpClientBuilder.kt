package io.github.eendroroy.sdk.bkash.client

import okhttp3.OkHttpClient
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

/**
 * @author indrajit
 */
object OkHttpClientBuilder {
    @JvmStatic
    fun builder(trustAnyRootCa: Boolean = false) = try {
        val trustManager = object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) = Unit
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) = Unit
            override fun getAcceptedIssuers() = arrayOf<X509Certificate>()
        }

        OkHttpClient.Builder().apply {
            if (trustAnyRootCa) {
                sslSocketFactory(
                    SSLContext.getInstance("SSL").apply {
                        init(null, arrayOf(trustManager), SecureRandom())
                    }.socketFactory,
                    trustManager
                )
                hostnameVerifier { _, _ -> true }
            }
        }
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}
