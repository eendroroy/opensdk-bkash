package io.github.eendroroy.sdk.bkash.definition

/**
 * @author indrajit
 */
enum class ErrorCode(private val code: Int, private val message: String) {
    ERROR_2001(2001, "Invalid App Key"),
    ERROR_2002(2002, "Invalid Payment ID"),
    ERROR_2003(2003, "Process failed"),
    ERROR_2004(2004, "Invalid firstPaymentDate"),
    ERROR_2005(2005, "Invalid frequency"),
    ERROR_2006(2006, "Invalid amount"),
    ERROR_2007(2007, "Invalid currency"),
    ERROR_2008(2008, "Invalid intent"),
    ERROR_2009(2009, "Invalid Wallet"),
    ERROR_2010(2010, "Invalid OTP"),
    ERROR_2011(2011, "Invalid PIN"),
    ERROR_2012(2012, "Invalid Receiver MSISDN"),
    ERROR_2013(2013, "Resend Limit Exceeded"),
    ERROR_2014(2014, "Wrong PIN"),
    ERROR_2015(2015, "Wrong PIN count exceeded"),
    ERROR_2016(2016, "Wrong verification code"),
    ERROR_2017(2017, "Wrong verification limit exceeded"),
    ERROR_2018(2018, "OTP verification time expired"),
    ERROR_2019(2019, "PIN verification time expired"),
    ERROR_2020(2020, "Exception Occurred"),
    ERROR_2021(2021, "Invalid Mandate ID"),
    ERROR_2022(2022, "The mandate does not exist"),
    ERROR_2023(2023, "Insufficient Balance"),
    ERROR_2024(2024, "Exception occurred"),
    ERROR_2025(2025, "Invalid request body"),
    ERROR_2026(2026, "The reversal amount cannot be greater than the original transaction amount"),
    ERROR_2027(2027, "The mandate corresponding to the payer reference number already exists and cannot be created again"),
    ERROR_2028(2028, "Reverse failed because the transaction serial number does not exist"),
    ERROR_2029(2029, "Duplicate for all transactions"),
    ERROR_2030(2030, "Invalid mandate request type"),
    ERROR_2031(2031, "Invalid merchant invoice number"),
    ERROR_2032(2032, "Invalid transfer type"),
    ERROR_2033(2033, "Transaction not found"),
    ERROR_2034(2034, "The transaction cannot be reversed because the original transaction has been reversed"),
    ERROR_2035(2035, "Reverse failed because the initiator has no permission to reverse the transaction"),
    ERROR_2036(2036, "The direct debit mandate is not in Active state"),
    ERROR_2037(2037, "The account of the debit party is in a state which prohibits execution of this transaction"),
    ERROR_2038(2038, "Debit party identity tag prohibits execution of this transaction"),
    ERROR_2039(2039, "The account of the credit party is in a state which prohibits execution of this transaction"),
    ERROR_2040(2040, "Credit party identity tag prohibits execution of this transaction"),
    ERROR_2041(2041, "Credit party identity is in a state which does not support the current service"),
    ERROR_2042(2042, "Reverse failed because the initiator has no permission to reverse the transaction."),
    ERROR_2043(2043, "The security credential of the subscriber is incorrect."),
    ERROR_2044(2044, "Identity has not subscribed to a product that contains the expected service or the identity is not in Active status."),
    ERROR_2045(2045, "The MSISDN of the customer does not exist."),
    ERROR_2046(2046, "Identity has not subscribed to a product that contains requested service."),
    ERROR_2047(2047, "TLV Data Format Error"),
    ERROR_2048(2048, "Invalid Payer Reference"),
    ERROR_2049(2049, "Invalid Merchant Callback URL"),
    ERROR_2050(2050, "Agreement already exists between payer and merchant"),
    ERROR_2051(2051, "Invalid Agreement ID"),
    ERROR_2052(2052, "Agreement is in incomplete state"),
    ERROR_2053(2053, "Agreement has already been cancelled"),
    ERROR_2054(2054, "Agreement execution pre-requisite hasn't been met"),
    ERROR_2055(2055, "Invalid Agreement State"),
    ERROR_2056(2056, "Invalid Payment State"),
    ERROR_2057(2057, "Not a bKash Account"),
    ERROR_2058(2058, "Not a Customer Wallet"),
    ERROR_2059(2059, "Multiple OTP request for a single session denied"),
    ERROR_2060(2060, "Payment execution pre-requisite hasn't been met"),
    ERROR_2061(2061, "This action can only be performed by the agreement or payment initiator party"),
    ERROR_2062(2062, "The payment has already been completed"),
    ERROR_2063(2063, "Mode is not valid as per request data"),
    ERROR_2064(2064, "This product mode currently unavailable"),
    ERROR_2065(2065, "Mandatory field missing"),
    ERROR_2066(2066, "Agreement is not shared with other merchant"),
    ERROR_2067(2067, "Invalid permission"),
    ERROR_2068(2068, "Transaction has already been completed"),
    ERROR_2069(2069, "Transaction has already been cancelled"),

    ERROR_2071(2071, "Refund after %s days not allowed"),
    ERROR_2072(2072, "Refund amount not valid"),
    ERROR_2073(2073, "Invalid SKU"),
    ERROR_2074(2074, "The transaction cannot be reversed"),
    ERROR_2075(2075, "SKU Character Limit Exceeded"),
    ERROR_2076(2076, "Reason Character Limit Exceeded"),
    ERROR_2077(2077, "Invalid TrxID"),
    ERROR_2078(2078, "Invalid Reason"),
    ERROR_2079(2079, "Invalid app Token"),
    ERROR_2080(2080, "The identity is not permitted to initiate this transaction"),
    ERROR_2081(2081, "The identity of the debit or credit party is in a state which prohibits the execution of this transaction"),
    ERROR_2082(2082, "The merchant is not permitted to initiate this transaction"),

    ERROR_503(503, "System is undergoing maintenance. Please try again later");

    fun code(): Int {
        return code
    }

    fun message(): String {
        return message
    }
}