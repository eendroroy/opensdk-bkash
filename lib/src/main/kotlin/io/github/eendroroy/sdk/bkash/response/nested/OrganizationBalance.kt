package io.github.eendroroy.sdk.bkash.response.nested

import com.fasterxml.jackson.annotation.JsonRootName

/**
 * @author indrajit
 */
@JsonRootName("organizationBalance")
data class OrganizationBalance(
    var accountTypeName: String? = null,
    var accountStatus: String? = null,
    var accountHolderName: String? = null,
    var currency: String? = null,
    var currentBalance: String? = null,
    var availableBalance: String? = null,
    var updateTime: String? = null
)
