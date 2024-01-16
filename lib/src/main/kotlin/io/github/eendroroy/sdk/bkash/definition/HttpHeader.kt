package io.github.eendroroy.sdk.bkash.definition

enum class HttpHeader(private val key: String) {
    Authorization("Authorization"),
    ContentType("Content-Type"),
    Accept("Accept"),
    Username("username"),
    Password("password"),
    XAppKey("X-APP-Key");

    fun key() = key
}