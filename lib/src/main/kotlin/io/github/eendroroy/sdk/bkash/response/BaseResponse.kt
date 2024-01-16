package io.github.eendroroy.sdk.bkash.response

/**
 * @author indrajit
 */
abstract class BaseResponse {
    var httpResponseCode: Int = 200
    var httpResponseMessage: String = "OK"
    abstract fun httpResponseCode(httpResponseCode: Int): BaseResponse
    abstract fun httpResponseMessage(httpResponseMessage: String): BaseResponse
}
