package org.mifos.core.data.network.entity.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimeEntity(
    @SerialName("hour")
    val hour: Int? = null,
    @SerialName("minute")
    val minute: Int? = null,
    @SerialName("second")
    val second: Int? = null
)
