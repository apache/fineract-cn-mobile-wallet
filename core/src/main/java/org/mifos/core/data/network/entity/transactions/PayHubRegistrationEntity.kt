package org.mifos.core.data.network.entity.transactions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PayHubRegistrationEntity(
    @SerialName("accountId")
    val accountNumber: String?= null,
    @SerialName("idType")
    val idType: IdentifierType?= null,
    @SerialName("idValue")
    val idValue: String?= null
)
