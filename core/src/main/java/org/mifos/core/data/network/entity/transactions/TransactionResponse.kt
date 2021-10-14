package org.mifos.core.data.network.entity.transactions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TransactionResponse(
    @SerialName("clientRefId")
    val clientRefId: String? = null,
    @SerialName("completedTimestamp")
    val completedTimestamp: String? = null,
    @SerialName("transactionId")
    val transactionId: String? = null,
    @SerialName("transferState")
    val transferState: State? = null,
    @SerialName("transferId")
    val transferId: String? = null
) {
    enum class State {
        @SerialName("RECEIVED")
        RECEIVED,

        @SerialName("PENDING")
        PENDING
    }
}
