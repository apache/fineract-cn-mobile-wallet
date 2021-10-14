package org.mifos.core.data.network.entity.transactions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Amount(
    @SerialName("currency")
    val currency: String? = null,
    @SerialName("amount")
    val amount: String? = null
)
