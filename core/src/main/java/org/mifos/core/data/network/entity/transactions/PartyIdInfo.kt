package org.mifos.core.data.network.entity.transactions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PartyIdInfo(
    @SerialName("partyIdType")
    val partyIdType: IdentifierType? = null,
    @SerialName("partyIdentifier")
    val partyIdentifier: String? = null
)
