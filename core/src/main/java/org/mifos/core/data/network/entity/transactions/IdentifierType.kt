package org.mifos.core.data.network.entity.transactions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class IdentifierType {
    @SerialName("MSISDN")
    MSISDN,
    @SerialName("EMAIL")
    EMAIL,
    @SerialName("PERSONAL_ID")
    PERSONAL_ID,
    @SerialName("BUSINESS")
    BUSINESS,
    @SerialName("DEVICE")
    DEVICE,
    @SerialName("ACCOUNT_ID")
    ACCOUNT_ID,
    @SerialName("IBAN")
    IBAN,
    @SerialName("ALIAS")
    ALIAS
}