package io.github.eendroroy.sdk.bkash.exception

/**
 * @author indrajit
 */
class ConfigurationPropertyMissingError : RuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
}
