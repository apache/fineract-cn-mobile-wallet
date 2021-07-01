package org.mifos.core.data.network.entity.deposit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DepositAccountPayloadEntity(
    @SerialName("customerIdentifier")
    val customerIdentifier: String? = null,
    @SerialName("productIdentifier")
    val productIdentifier: String? = null,
    @SerialName("beneficiaries")
    val beneficiaries: List<String> = ArrayList()
)
