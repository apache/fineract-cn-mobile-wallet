package org.mifos.core.data.network.entity.customer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DateOfBirth(
    @SerialName("year")
    val year: Int? = null,
    @SerialName("month")
    val month: Int? = null,
    @SerialName("day")
    val day: Int? = null
)
