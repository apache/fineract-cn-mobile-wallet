package org.mifos.core

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.mifos.core.data.network.api.BaseURL

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
                    when(request.url.toString()) {
                        MockData.url1 -> {
                            respond(MockData.loginData, headers = headersOf("Content-Type", ContentType.Application.Json.toString()))
                        }
                        else -> error("Unhandled ${request.url.toString()}")
                    }
                }
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    })
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