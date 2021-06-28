package org.mifos.core.data.network.entity.customer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomerPage(
    @SerialName("customers")
    val customers: List<Customer>? = null,
    @SerialName("totalPages")
    val totalPages: Int? = null,
    @SerialName("totalElements")
    val totalElements: Long? = null
)
