package io.github.eendroroy.sdk.bkash.converter

import io.github.eendroroy.sdk.bkash.response.BaseResponse
import retrofit2.Response
import retrofit2.Retrofit

/**
 * @author indrajit
 */

class ResponseConverter<T>(var retrofit: Retrofit, var apiResponse: Response<T>) {

    @Throws(Exception::class)
    inline fun <reified T> convert(): T? {
        val response: T? = when {
            apiResponse.isSuccessful -> {
                apiResponse.body() as T?
            }
            null == apiResponse.errorBody() -> {
                throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
            }
            0L == apiResponse.errorBody()!!.contentLength() -> {
                throw Exception(apiResponse.code().toString() + " : " + apiResponse.message())
            }
            else -> {
                val errorConverter = retrofit.responseBodyConverter<T>(T::class.java, arrayOfNulls(0))
                errorConverter.convert(apiResponse.errorBody()!!)
            }
        }

        if (response is BaseResponse) {
            (response as BaseResponse)
                .httpResponseCode(apiResponse.code())
                .httpResponseMessage(apiResponse.message())
        }

        return response
    }
}
