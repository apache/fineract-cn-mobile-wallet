package org.mifos.core.data.network.entity.transactions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TransactionEntity(
    @SerialName("payee")
    val payee: PartyIdInfo,
    @SerialName("payer")
    val payer: PartyIdInfo,
    @SerialName("amount")
    val amount: Amount
)