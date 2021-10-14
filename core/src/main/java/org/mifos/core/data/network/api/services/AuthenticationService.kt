package org.mifos.core.data.network.api.services

/* ktlint-disable no-wildcard-imports */
import io.ktor.client.*
import io.ktor.client.request.*
import org.mifos.core.data.network.api.APIEndPoints.AUTHENTICATION
import org.mifos.core.data.network.entity.auth.LoginResponseEntity
/* ktlint-enable no-wildcard-imports */

class AuthenticationService(private val httpClient: HttpClient) {

    suspend fun authenticate(
        userName: String,
        password: String
    ): LoginResponseEntity {
        return httpClient.post<LoginResponseEntity>(path = "$AUTHENTICATION/token") {
            parameter("username", userName)
            parameter("password", password)
        }
    }
}
