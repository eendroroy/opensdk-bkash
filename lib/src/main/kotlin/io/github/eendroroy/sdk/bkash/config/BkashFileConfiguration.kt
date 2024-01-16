package io.github.eendroroy.sdk.bkash.config

import io.github.eendroroy.sdk.bkash.exception.ConfigurationPropertyMissingError
import java.io.File
import java.io.FileReader
import java.util.Properties
import java.util.function.Consumer

/**
 * @author indrajit
 */
class BkashFileConfiguration private constructor(configLocation: String) : BkashConfiguration {
    private val requiredConfigKeys
        get() = listOf("baseUrl", "username", "password", "appKey", "appSecret")

    private val baseUrl: String
    private val username: String
    private val password: String
    private val appKey: String
    private val appSecret: String
    private val contentType: String
    private val accept: String
    private val disableRootCaVerification: Boolean
    private val timeOut: Long
    private val configLocation: String

    fun configLocation(): String {
        return configLocation
    }

    override fun baseUrl(): String {
        return baseUrl
    }

    override fun username(): String {
        return username
    }

    override fun password(): String {
        return password
    }

    override fun appKey(): String {
        return appKey
    }

    override fun appSecret(): String {
        return appSecret
    }

    override fun contentType(): String {
        return contentType
    }

    override fun accept(): String {
        return accept
    }

    override fun disableRootCaVerification(): Boolean {
        return disableRootCaVerification
    }

    override fun timeOut(): Long {
        return timeOut
    }

    companion object {
        @JvmStatic
        @Throws(Exception::class)
        fun withConfig(configLocation: String): BkashFileConfiguration {
            return BkashFileConfiguration(configLocation)
        }
    }

    init {
        val config = File(configLocation)
        this.configLocation = config.absolutePath
        val properties = Properties()
        properties.load(FileReader(config))
        val keys = properties.stringPropertyNames()
        requiredConfigKeys.forEach(
            Consumer { propName: String? ->
                if (!keys.contains(propName)) {
                    throw ConfigurationPropertyMissingError(propName)
                }
            }
        )
        baseUrl = properties.getProperty("baseUrl")
        username = properties.getProperty("username")
        password = properties.getProperty("password")
        appKey = properties.getProperty("appKey")
        appSecret = properties.getProperty("appSecret")
        contentType = properties.getProperty("contentType", "application/json;charset=UTF-8")
        accept = properties.getProperty("accept", "application/json;charset=UTF-8")
        disableRootCaVerification = java.lang.Boolean.parseBoolean(properties.getProperty("disableRootCaVerification", "false"))
        timeOut = properties.getProperty("timeOut", "30").toLong()
    }
}
