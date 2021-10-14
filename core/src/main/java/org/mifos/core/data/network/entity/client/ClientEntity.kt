package org.mifos.core.data.network.entity.client

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.mifos.core.data.network.entity.common.DateEntity

@Serializable
data class ClientEntity(
    @SerialName("id")
    val id: Long? = null,
    @SerialName("accountNumber")
    val accountNumber: Long? = null,
    @SerialName("active")
    val active: Boolean? = null,
    @SerialName("firstName")
    val firstName: String? = null,
    @SerialName("lastName")
    val lastName: String? = null,
    @SerialName("displayName")
    val displayName: String? = null,
    @SerialName("mobileNumber")
    val mobileNumber: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("dateOfBirth")
    val dateOfBirth: DateEntity? = null
)
