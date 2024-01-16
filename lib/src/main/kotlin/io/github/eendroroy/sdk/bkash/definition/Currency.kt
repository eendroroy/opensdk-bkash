package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class Currency {
    BDT;

    fun value(): String {
        return name
    }
}
