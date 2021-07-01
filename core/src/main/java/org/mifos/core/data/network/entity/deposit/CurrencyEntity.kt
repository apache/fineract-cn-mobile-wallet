package org.mifos.core.data.network.entity.deposit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyEntity(
    @SerialName("code")
    val code: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("sign")
    val sign: String? = null,
    @SerialName("scale")
    val scale: Int? = null
)
