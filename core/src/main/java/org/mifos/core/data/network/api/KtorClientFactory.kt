package org.mifos.core.data.network.api

/* ktlint-disable no-wildcard-imports */
import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.mifos.core.data.network.api.BaseURL.baseURL
/* ktlint-enable no-wildcard-imports */

private const val TIME_OUT = 60_000

class KtorClientFactory(
    private val accessToken: String,
    private val tenant: String,
    private val user: String
) {

    companion object {
        const val HEADER_X_TENANT_IDENTIFIER = "X-Tenant-Identifier"
        const val USER = "User"
    }

    fun build(): HttpClient =
        HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )

                engine {
                    connectTimeout = TIME_OUT
                    socketTimeout = TIME_OUT
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("Logger Ktor =>", message)
                    }
                }

                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("HTTP Status:", "${response.status.value}")
                }
            }

            install(DefaultRequest) {
                url {
                    // TODO: HTTP -> HTTPS
                    protocol = URLProtocol.HTTP
                    host = baseURL
                }

                headers {
                    append(HttpHeaders.Authorization, accessToken)
                    append(USER, user)
                    append(HEADER_X_TENANT_IDENTIFIER, tenant)
                }
            }
        }
}
