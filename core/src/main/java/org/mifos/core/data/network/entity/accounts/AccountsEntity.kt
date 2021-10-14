package org.mifos.core.data.network.entity.accounts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountsEntity(
    @SerialName("id")
    val id: Long? = null,
    @SerialName("accountNo")
    val accountNo: Long? = null,
    @SerialName("productId")
    val productId: String? = null,
    @SerialName("productName")
    val productName: String? = null,
    @SerialName("active")
    val active: Boolean? = false,
    @SerialName("accountBalance ")
    val accountBalance: Float? = null
)