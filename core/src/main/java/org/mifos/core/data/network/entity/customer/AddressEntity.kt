package org.mifos.core.data.network.entity.customer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressEntity(
    @SerialName("street")
    val street: String? = null,
    @SerialName("city")
    val city: String? = null,
    @SerialName("region")
    val region: String? = null,
    @SerialName("postalCode")
    val postalCode: String? = null,
    @SerialName("countryCode")
    val countryCode: String? = null,
    @SerialName("country")
    val country: String? = null
)
