package org.mifos.core.data.network.entity.savingsaccount

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.mifos.core.data.network.entity.common.DateEntity
import org.mifos.core.data.network.entity.common.TimeEntity

@Serializable
data class SavingsAccountEntity(
    @SerialName("id")
    val id: Long? = null,
    @SerialName("accountNo")
    val accountNo: Long? = null,
    @SerialName("value")
    val value: String? = null,
    @SerialName("clientId")
    val clientId: Long? = null,
    @SerialName("clientName")
    val clientName: String? = null,
    @SerialName("savingsProductId")
    val savingsProductId: Long? = null,
    @SerialName("savingsProductName")
    val savingsProductName: String? = null,
    @SerialName("active")
    val active: Boolean? = false,
    @SerialName("availableBalance")
    val availableBalance: Float? = null,
    @SerialName("isBlocked")
    val isBlocked: Boolean? = false,
    @SerialName("transactionDate")
    val transactionDate: DateEntity? = null,
    @SerialName("transactionTime")
    val transactionTime: TimeEntity? = null
)
