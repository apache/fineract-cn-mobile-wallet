package org.mifos.core.data.network.entity.register

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.mifos.core.data.network.entity.common.DateEntity

@Serializable
data class RegistrationEntity(
    @SerialName("firstName")
    val firstName: String? = null,
    @SerialName("lastName")
    val lastName: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("mobileNumber")
    val mobileNumber: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("dateOfBirth")
    val dateOfBirth: DateEntity? = null,
    @SerialName("password")
    val password: String? = null,
    @SerialName("accountNumber")
    val accountNumber: Long? = null
)
