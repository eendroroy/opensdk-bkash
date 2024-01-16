package io.github.eendroroy.sdk.bkash.config

/**
 * @author indrajit
 */
abstract class AbstractBkashConfiguration : BkashConfiguration {
    override fun contentType(): String {
        return "application/json"
    }

    override fun accept(): String {
        return "application/json"
    }

    override fun disableRootCaVerification(): Boolean {
        return false
    }

    override fun timeOut(): Long {
        return 30L
    }
}
