package io.github.eendroroy.sdk.bkash

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.eendroroy.sdk.bkash.client.BkashAuthClient
import io.github.eendroroy.sdk.bkash.client.BkashCheckoutClient
import io.github.eendroroy.sdk.bkash.client.UnsafeOkHttpClientBuilder.unsafeOkHttpClientBuilder
import io.github.eendroroy.sdk.bkash.config.BkashAuthProvider
import io.github.eendroroy.sdk.bkash.config.BkashConfiguration
import io.github.eendroroy.sdk.bkash.endpoint.BkashAuthEndpoints
import io.github.eendroroy.sdk.bkash.endpoint.BkashCheckOutEndpoints
import io.github.eendroroy.sdk.bkash.interceptor.BkashInterceptor
import io.github.eendroroy.sdk.bkash.interceptor.DefaultBkashInterceptor
import okhttp3.OkHttpClient
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

    fun bkashAuthClient(): BkashAuthClient {
        val okHttpClient = (if (configuration.disableRootCaVerification()) unsafeOkHttpClientBuilder else OkHttpClient.Builder())
            .addInterceptor(interceptor)
            .connectTimeout(configuration.timeOut(), TimeUnit.SECONDS)
            .readTimeout(configuration.timeOut(), TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(configuration.baseUrl())
            .addConverterFactory(JacksonConverterFactory.create(mapper)).build()
        val endpoints = retrofit.create(BkashAuthEndpoints::class.java)
        return BkashAuthClient(retrofit, endpoints, configuration)
    }

    fun bkashCheckoutClient(authProvider: BkashAuthProvider): BkashCheckoutClient {
        val okHttpClient = if (configuration.disableRootCaVerification()) {
            unsafeOkHttpClientBuilder
        } else {
            OkHttpClient.Builder()
        }.addInterceptor(interceptor)
            .connectTimeout(configuration.timeOut(), TimeUnit.SECONDS)
            .readTimeout(configuration.timeOut(), TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(configuration.baseUrl())
            .addConverterFactory(JacksonConverterFactory.create(mapper)).build()
        val endpoints = retrofit.create(BkashCheckOutEndpoints::class.java)
        return BkashCheckoutClient(retrofit, endpoints, configuration, authProvider)
    }
}
