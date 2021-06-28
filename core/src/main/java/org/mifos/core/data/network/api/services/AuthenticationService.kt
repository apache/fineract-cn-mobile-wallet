package org.mifos.core.data.network.api.services

import io.ktor.client.*
import io.ktor.client.request.*
import org.mifos.core.data.network.api.APIEndPoints.IDENTITY
import org.mifos.core.data.network.entity.LoginResponse

class AuthenticationService(private val httpClient: HttpClient) {

    suspend fun authenticate(
        grantType: String,
        userName: String,
        password: String
    ): LoginResponse {
        return httpClient.post<LoginResponse>(path = "$IDENTITY/token") {
            parameter("grant_type", grantType)
            parameter("username", userName)
            parameter("password", password)
        }
    }
}