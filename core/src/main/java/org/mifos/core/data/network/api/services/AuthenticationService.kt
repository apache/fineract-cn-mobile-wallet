package org.mifos.core.data.network.api.services

import io.ktor.client.*
import io.ktor.client.request.*
import org.mifos.core.data.network.api.APIEndPoints.IDENTITY
import org.mifos.core.data.network.entity.LoginResponseEntity

class AuthenticationService(private val httpClient: HttpClient) {

    suspend fun authenticate(
        grantType: String,
        userName: String,
        password: String
    ): LoginResponseEntity {
        return httpClient.post<LoginResponseEntity>(path = "$IDENTITY/token") {
            parameter("grant_type", grantType)
            parameter("username", userName)
            parameter("password", password)
        }
    }
}