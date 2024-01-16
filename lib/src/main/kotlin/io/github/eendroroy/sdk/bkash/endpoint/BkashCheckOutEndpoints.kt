package io.github.eendroroy.sdk.bkash.endpoint

import io.github.eendroroy.sdk.bkash.request.B2CPaymentRequest
import io.github.eendroroy.sdk.bkash.request.GrantTokenRequest
import io.github.eendroroy.sdk.bkash.request.IntraAccTransferRequest
import io.github.eendroroy.sdk.bkash.request.PaymentAuthorizeRequest
import io.github.eendroroy.sdk.bkash.request.PaymentSaleRequest
import io.github.eendroroy.sdk.bkash.request.RefreshTokenRequest
import io.github.eendroroy.sdk.bkash.response.B2CPaymentResponse
import io.github.eendroroy.sdk.bkash.response.BkashTokenResponse
import io.github.eendroroy.sdk.bkash.response.CapturePaymentResponse
import io.github.eendroroy.sdk.bkash.response.CreatePaymentResponse
import io.github.eendroroy.sdk.bkash.response.ExecutePaymentResponse
import io.github.eendroroy.sdk.bkash.response.IntraAccTransferResponse
import io.github.eendroroy.sdk.bkash.response.OrganizationBalanceResponse
import io.github.eendroroy.sdk.bkash.response.QueryPaymentResponse
import io.github.eendroroy.sdk.bkash.response.SearchTransactionResponse
import io.github.eendroroy.sdk.bkash.response.VoidPaymentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * @author indrajit
 */
interface BkashCheckOutEndpoints {
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

    @POST("/v1.2.0-beta/checkout/payment/create")
    fun createPaymentAuthorize(
        @HeaderMap headers: Map<String, String>,
        @Body request: PaymentAuthorizeRequest
    ): Call<CreatePaymentResponse?>

    @POST("/v1.2.0-beta/checkout/payment/create")
    fun createPaymentSale(
        @HeaderMap headers: Map<String, String>,
        @Body request: PaymentSaleRequest
    ): Call<CreatePaymentResponse?>

    @POST("/v1.2.0-beta/checkout/payment/execute/{paymentId}")
    fun executePayment(
        @HeaderMap headers: Map<String, String>,
        @Path(value = "paymentId") paymentId: String
    ): Call<ExecutePaymentResponse?>

    @POST("/v1.2.0-beta/checkout/payment/capture/{paymentId}")
    fun capturePayment(
        @HeaderMap headers: Map<String, String>,
        @Path(value = "paymentId") paymentId: String
    ): Call<CapturePaymentResponse?>

    @GET("/v1.2.0-beta/checkout/payment/query/{paymentId}")
    fun queryPayment(
        @HeaderMap headers: Map<String, String>,
        @Path(value = "paymentId") paymentId: String
    ): Call<QueryPaymentResponse?>

    @POST("/v1.2.0-beta/checkout/payment/void/{paymentId}")
    fun voidPayment(
        @HeaderMap headers: Map<String, String>,
        @Path(value = "paymentId") paymentId: String
    ): Call<VoidPaymentResponse?>

    @POST("/v1.2.0-beta/checkout/payment/b2cPayment")
    fun b2cPayment(
        @HeaderMap headers: Map<String, String>,
        @Body request: B2CPaymentRequest
    ): Call<B2CPaymentResponse?>

    @GET("/v1.2.0-beta/checkout/payment/organizationBalance")
    fun organizationBalance(
        @HeaderMap headers: Map<String, String>
    ): Call<OrganizationBalanceResponse?>

    @POST("/v1.2.0-beta/checkout/payment/intraAccountTransfer")
    fun intraAccountTransfer(
        @HeaderMap headers: Map<String, String>,
        @Body request: IntraAccTransferRequest
    ): Call<IntraAccTransferResponse?>

    @GET("/v1.2.0-beta/checkout/payment/search/{trxId}")
    fun searchTransaction(
        @HeaderMap headers: Map<String, String>,
        @Path(value = "trxId") transactionId: String
    ): Call<SearchTransactionResponse?>
}
