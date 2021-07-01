package org.mifos.core.data.network.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseEntity(
    @SerialName("tokenType")
    val tokenType: String? = null,
    @SerialName("accessToken")
    val accessToken: String,
    @SerialName("accessTokenExpiration")
    val accessTokenExpiration: String,
    @SerialName("refreshTokenExpiration")
    val refreshTokenExpiration: String,
    @SerialName("passwordExpiration")
    val passwordExpiration: String
)
