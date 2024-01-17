# BKash SDK

![Java CI with Gradle](https://github.com/eendroroy/opensdk-bkash/workflows/Tests/badge.svg)
[![GitHub tag](https://img.shields.io/github/tag/eendroroy/opensdk-bkash.svg)](https://github.com/eendroroy/opensdk-bkash/tags)

[![Contributors](https://img.shields.io/github/contributors/eendroroy/opensdk-bkash.svg)](https://github.com/eendroroy/opensdk-bkash/graphs/contributors)
[![GitHub last commit (branch)](https://img.shields.io/github/last-commit/eendroroy/opensdk-bkash/master.svg)](https://github.com/eendroroy/opensdk-bkash)
[![license](https://img.shields.io/github/license/eendroroy/opensdk-bkash.svg)](https://github.com/eendroroy/opensdk-bkash/blob/master/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/eendroroy/opensdk-bkash.svg)](https://github.com/eendroroy/opensdk-bkash/issues)
[![GitHub closed issues](https://img.shields.io/github/issues-closed/eendroroy/opensdk-bkash.svg)](https://github.com/eendroroy/opensdk-bkash/issues?q=is%3Aissue+is%3Aclosed)
[![GitHub pull requests](https://img.shields.io/github/issues-pr/eendroroy/opensdk-bkash.svg)](https://github.com/eendroroy/opensdk-bkash/pulls)
[![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/eendroroy/opensdk-bkash.svg)](https://github.com/eendroroy/opensdk-bkash/pulls?q=is%3Apr+is%3Aclosed)


Implementation of [BKash PaymentGateway Developer API v1.2.0-beta](https://developer.bka.sh/reference)

*TOKEN API*
- Grant Token [#Documentation](https://developer.bka.sh/reference/gettokenusingpost)
- Refresh Token [#Documentation](https://developer.bka.sh/reference/refreshtokenusingpost)

*CHECKOUT API*
- Create Payment (Sale or Authorize) [#Documentation](https://developer.bka.sh/reference/createpaymentusingpost)
- Execute Payment [#Documentation](https://developer.bka.sh/reference/executepaymentusingpost)
- Query Payment [#Documentation](https://developer.bka.sh/reference/querypaymentusingget)
- Capture [#Documentation](https://developer.bka.sh/reference/capturepaymentusingpost)
- Void [#Documentation](https://developer.bka.sh/reference/voidpaymentusingpost)
- B2C Payment [#Documentation](https://developer.bka.sh/reference/b2cpaymentusingpost)
- Query Organization Balance [#Documentation](https://developer.bka.sh/reference/queryorganizationbalanceusingget)
- Intra-Account Transfer [#Documentation](https://developer.bka.sh/reference/intraaccounttransferusingpost)
- Search Transaction Details [#Documentation](https://developer.bka.sh/reference/searchtransactionusingget)

### Installation

*Maven*

```xml
<dependency>
    <groupId>io.github.eendroroy</groupId>
    <artifactId>opensdk-bkash</artifactId>
    <version>0.0.1-beta2</version>
</dependency>
```

*Gradle*

```groovy
dependencies {
    implementation("io.github.eendroroy:opensdk-bkash:0.0.1-beta2")
}
```

### Usage

#### **Configuration**

**Loading from properties file**
Create a file `/path/to/bkash-sdk.properties` and load the configuration using :

```
BkashConfiguration configuration = BkashFileConfiguration.withConfig("/path/to/bkash-sdk.properties");
```

`bkash-sdk.properties` example:

```
baseUrl=https://checkout.sandbox.bka.sh
username=testUser
password=testPass
appKey=123123123
appSecret=456456456
disableRootCaVerification=false # Optional, default value is 'false'
timeOut=30 # Optional, default value is '30'
```


**Implementing the `BkashConfiguration` class**
Create a class `Configuration` to put the configurations:

```java
public class Configuration extends AbstractBkashConfiguration {
    @Override public String baseUrl() { return "BASE-URL"; }
    @Override public String username() { return "USERNAME"; }
    @Override public String password() { return "PASSWORD"; }
    @Override public String appKey() { return "APP-KEY"; }
    @Override public String appSecret() { return "APP-SECRET"; }
}
```

#### **Logging** (__Optional__)

Create a class `LoggingInterceptor` to add the logging mechanism:

```java
public class LoggingInterceptor extends AbstractBkashInterceptor {

    @Override
    public Request interceptRequest(Request request) {
        System.out.println();
        System.out.println();
        System.out.println(request.headers());
        System.out.println(request.url());
        System.out.println(rawRequestBody(request));
        return request;
    }

    @Override
    public Response interceptResponse(Response response) {
        System.out.println();
        System.out.println();
        System.out.println(response.code());
        System.out.println(response.message());
        System.out.println(response.headers());
        System.out.println(rawResponseBody(response));
        return response;
    }
}

```

#### **AuthProvider**

Bkash access token expires every 60 minutes.

The implementation of `AuthProvider` should handle all the necessary logic
to store the token in local storage and refresh the token before it expires.

```java
public class AuthProvider implements BkashAuthProvider {
    private static final Configuration configuration = new Configuration();

    private static final BkashAuthClient client = new BkashClientFactory(configuration).bkashAuthClient();

    public String getAccessToken() {
        GrantTokenRequest request = GrantTokenRequest.builder()
                .appKey(configuration.appKey())
                .appSecret(configuration.appSecret())
                .build();
        try {
            BkashTokenResponse response = client.grantToken(request);
            return response.getIdToken();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

### Using the client

**Example**

```java
public class BkashAuthClientTest {
    private static BkashCheckoutClient client;

    public static void main(String[] args) throws Exception {
        client = new BkashClientFactory(new Configuration(), new LoggingInterceptor())
                .bkashCheckoutPaymentClient(new AuthProvider());

        OrganizationBalanceResponse response = client.organizationBalance();
        System.out.println(response);
    }
}
```
