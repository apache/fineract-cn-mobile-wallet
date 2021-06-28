package org.mifos.core.domain.model

data class LoginResponse(
    val tokenType: String? = null,
    val accessToken: String,
    val accessTokenExpiration: String,
    val refreshTokenExpiration: String,
    val passwordExpiration: String
)
