package org.mifos.core.data.network.entity.deposit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductEntity(
    @SerialName("type")
    val type: String? = null,
    @SerialName("identifier")
    val identifier: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("currency")
    val currency: CurrencyEntity? = null,
    @SerialName("minimumBalance")
    val minimumBalance: Double? = null
)
