package org.mifos.core

/* ktlint-disable no-wildcard-imports */
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.mifos.core.data.network.api.BaseURL
import org.mifos.core.data.network.api.MockData
/* ktlint-enable no-wildcard-imports */

class KtorMockClient(
    private val accessToken: String,
    private val tenant: String,
    private val user: String
) {

    companion object {
        const val HEADER_X_TENANT_IDENTIFIER = "X-Tenant-Identifier"
        const val USER = "User"
    }

    fun build(): HttpClient =
        HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    val content = when (request.url.toString()) {
                        MockData.authUrl -> MockData.loginResponseData
                        MockData.createCustomerUrl, MockData.createDepositAccountUrl -> {
                            if (request.body.toString() == "TextContent[application/json] \"{}\"") {
                                MockData.dataError
                            } else {
                                MockData.accepted
                            }
                        }
                        MockData.fetchCustomerUrl -> MockData.customerData
                        MockData.fetchCustomersUrl -> MockData.customerPageData
                        MockData.updateCustomerUrl -> "Accepted"
                        MockData.fetchDepositAccountsUrl -> "[ ${MockData.depositAccountListData} ]"
                        MockData.fetchProductUrl -> MockData.productData
                        MockData.fetchDepositAccountUrl -> MockData.depositAccountListData
                        MockData.fetchJournalEntryUrl -> MockData.journalEntryData
                        MockData.fetchJournalEntriesUrl -> "[ ${MockData.journalEntryData} ]"
                        else -> "Unhandled ${request.url}"
                    }
                    if (content == MockData.accepted) {
                        respond(content, status = HttpStatusCode.Accepted)
                    } else if (content == MockData.dataError || content == "Unhandled ${request.url}") {
                        error(content)
                    } else {
                        respond(content, headers = headersOf("Content-Type", ContentType.Application.Json.toString()))
                    }
                }
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(DefaultRequest) {
                url {
                    // TODO: HTTP -> HTTPS
                    protocol = URLProtocol.HTTP
                    host = BaseURL.baseURL
                }

                headers {
                    append(HttpHeaders.Authorization, accessToken)
                    append(USER, user)
                    append(HEADER_X_TENANT_IDENTIFIER, tenant)
                }
            }
        }
}
