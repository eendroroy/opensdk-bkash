package io.github.eendroroy.sdk.bkash

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.eendroroy.sdk.bkash.client.BkashAuthClient
import io.github.eendroroy.sdk.bkash.client.BkashCheckoutClient
import io.github.eendroroy.sdk.bkash.client.OkHttpClientBuilder.builder
import io.github.eendroroy.sdk.bkash.config.BkashAuthProvider
import io.github.eendroroy.sdk.bkash.config.BkashConfiguration
import io.github.eendroroy.sdk.bkash.endpoint.BkashAuthEndpoints
import io.github.eendroroy.sdk.bkash.endpoint.BkashCheckOutEndpoints
import io.github.eendroroy.sdk.bkash.interceptor.BkashInterceptor
import io.github.eendroroy.sdk.bkash.interceptor.DefaultBkashInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author indrajit
 */
class BkashClientFactory @JvmOverloads constructor(
    private val configuration: BkashConfiguration,
    private val interceptor: BkashInterceptor = DefaultBkashInterceptor()
) {
    private val mapper = ObjectMapper().findAndRegisterModules()

    private inline fun <reified T> getEndPoints(): Pair<Retrofit, T> {
        val retrofit = Retrofit.Builder()
            .client(
                builder(configuration.disableRootCaVerification())
                    .addInterceptor(interceptor)
                    .connectTimeout(configuration.timeOut(), TimeUnit.SECONDS)
                    .readTimeout(configuration.timeOut(), TimeUnit.SECONDS)
                    .build()
            )
            .baseUrl(configuration.baseUrl())
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build()
        return Pair(retrofit, retrofit.create(T::class.java))
    }

    fun bkashAuthClient(): BkashAuthClient {
        val (retrofit, endPoints) = getEndPoints<BkashAuthEndpoints>()
        return BkashAuthClient(retrofit, endPoints, configuration)
    }

    fun bkashCheckoutClient(authProvider: BkashAuthProvider): BkashCheckoutClient {
        val (retrofit, endPoints) = getEndPoints<BkashCheckOutEndpoints>()
        return BkashCheckoutClient(retrofit, endPoints, configuration, authProvider)
    }
}
