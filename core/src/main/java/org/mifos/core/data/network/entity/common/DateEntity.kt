package org.mifos.core.data.network.entity.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DateEntity(
    @SerialName("year")
    val year: Int? = null,
    @SerialName("month")
    val month: Int? = null,
    @SerialName("day")
    val day: Int? = null
)
