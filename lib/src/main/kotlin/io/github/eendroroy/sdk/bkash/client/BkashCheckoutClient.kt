package io.github.eendroroy.sdk.bkash.client

import io.github.eendroroy.sdk.bkash.config.BkashAuthProvider
import io.github.eendroroy.sdk.bkash.config.BkashConfiguration
import io.github.eendroroy.sdk.bkash.converter.ResponseConverter
import io.github.eendroroy.sdk.bkash.definition.HttpHeader
import io.github.eendroroy.sdk.bkash.endpoint.BkashCheckOutEndpoints
import io.github.eendroroy.sdk.bkash.request.B2CPaymentRequest
import io.github.eendroroy.sdk.bkash.request.IntraAccTransferRequest
import io.github.eendroroy.sdk.bkash.request.PaymentAuthorizeRequest
import io.github.eendroroy.sdk.bkash.request.PaymentSaleRequest
import io.github.eendroroy.sdk.bkash.response.B2CPaymentResponse
import io.github.eendroroy.sdk.bkash.response.CapturePaymentResponse
import io.github.eendroroy.sdk.bkash.response.CreatePaymentResponse
import io.github.eendroroy.sdk.bkash.response.ExecutePaymentResponse
import io.github.eendroroy.sdk.bkash.response.IntraAccTransferResponse
import io.github.eendroroy.sdk.bkash.response.OrganizationBalanceResponse
import io.github.eendroroy.sdk.bkash.response.QueryPaymentResponse
import io.github.eendroroy.sdk.bkash.response.SearchTransactionResponse
import io.github.eendroroy.sdk.bkash.response.VoidPaymentResponse
import okhttp3.internal.http.HttpHeaders
import retrofit2.Response
import retrofit2.Retrofit

/**
 * @author indrajit
 */
class BkashCheckoutClient(
    private val retrofit: Retrofit,
    private val endpoints: BkashCheckOutEndpoints,
    private val configuration: BkashConfiguration,
    private val authProvider: BkashAuthProvider
) {
    private val headers: HashMap<String, String>
        get() {
            val headers = HashMap<String, String>()
            headers[HttpHeader.Authorization.key()] = authProvider.accessToken
            headers[HttpHeader.ContentType.key()] = configuration.contentType()
            headers[HttpHeader.Accept.key()] = configuration.accept()
            headers[HttpHeader.XAppKey.key()] = configuration.appKey()
            return headers
        }

    @Throws(Exception::class)
    fun createPaymentAuthorize(request: PaymentAuthorizeRequest): CreatePaymentResponse? {
        val apiResponse: Response<CreatePaymentResponse?> =
            endpoints.createPaymentAuthorize(headers, request).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun createPaymentSale(request: PaymentSaleRequest): CreatePaymentResponse? {
        val apiResponse: Response<CreatePaymentResponse?> =
            endpoints.createPaymentSale(headers, request).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun executePayment(paymentId: String): ExecutePaymentResponse? {
        val apiResponse: Response<ExecutePaymentResponse?> =
            endpoints.executePayment(headers, paymentId).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun capturePayment(paymentId: String): CapturePaymentResponse? {
        val apiResponse: Response<CapturePaymentResponse?> =
            endpoints.capturePayment(headers, paymentId).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun queryPayment(paymentId: String): QueryPaymentResponse? {
        val apiResponse: Response<QueryPaymentResponse?> =
            endpoints.queryPayment(headers, paymentId).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun voidPayment(paymentId: String): VoidPaymentResponse? {
        val apiResponse: Response<VoidPaymentResponse?> =
            endpoints.voidPayment(headers, paymentId).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun b2cPayment(request: B2CPaymentRequest): B2CPaymentResponse? {
        val apiResponse: Response<B2CPaymentResponse?> =
            endpoints.b2cPayment(headers, request).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun organizationBalance(): OrganizationBalanceResponse? {
        val apiResponse: Response<OrganizationBalanceResponse?> =
            endpoints.organizationBalance(headers).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun intraAccountTransfer(request: IntraAccTransferRequest): IntraAccTransferResponse? {
        val apiResponse: Response<IntraAccTransferResponse?> =
            endpoints.intraAccountTransfer(headers, request).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }

    @Throws(Exception::class)
    fun searchTransaction(transactionId: String): SearchTransactionResponse? {
        val apiResponse: Response<SearchTransactionResponse?> =
            endpoints.searchTransaction(headers, transactionId).execute()
        return ResponseConverter(retrofit, apiResponse).convert()
    }
}
