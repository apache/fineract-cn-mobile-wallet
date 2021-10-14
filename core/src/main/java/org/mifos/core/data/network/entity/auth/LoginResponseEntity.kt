package org.mifos.core.data.network.entity.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseEntity(
    @SerialName("username")
    val username: String? = null,
    @SerialName("accessToken")
    val accessToken: String? = null,
    @SerialName("userId")
    val userId: Long? = null,
    @SerialName("clientId")
    val clientId: Long? = null
)
