package org.mifos.core.data.network.entity.deposit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DepositAccountEntity(
    @SerialName("customerIdentifier")
    val customerIdentifier: String? = null,
    @SerialName("productIdentifier")
    val productIdentifier: String? = null,
    @SerialName("accountIdentifier")
    val accountIdentifier: String? = null,
    @SerialName("beneficiaries")
    val beneficiaries: List<String> = ArrayList(),
    @SerialName("state")
    val state: State? = null,
    @SerialName("balance")
    val balance: Double? = null
) {

    enum class State {
        @SerialName("CREATED")
        CREATED,

        @SerialName("PENDING")
        PENDING,

        @SerialName("APPROVED")
        APPROVED,

        @SerialName("ACTIVE")
        ACTIVE,

        @SerialName("LOCKED")
        LOCKED,

        @SerialName("CLOSED")
        CLOSED
    }
}
