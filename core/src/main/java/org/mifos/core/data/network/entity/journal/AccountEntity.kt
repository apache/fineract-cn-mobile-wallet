package org.mifos.core.data.network.entity.journal

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountEntity(
    @SerialName("accountNumber")
    val accountNumber: String? = null,
    @SerialName("amount")
    val amount: String? = null
)
