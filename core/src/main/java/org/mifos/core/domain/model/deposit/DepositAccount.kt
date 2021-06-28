package org.mifos.core.domain.model.deposit

import kotlinx.serialization.SerialName

data class DepositAccount(
    val customerIdentifier: String? = null,
    val productIdentifier: String? = null,
    val accountIdentifier: String? = null,
    val beneficiaries: List<String> = ArrayList(),
    val state: State? = null,
    val balance: Double? = null
) {

    enum class State {
        CREATED,

        PENDING,

        APPROVED,

        ACTIVE,

        LOCKED,

        CLOSED
    }
}
