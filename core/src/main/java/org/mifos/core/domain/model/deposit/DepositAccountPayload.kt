package org.mifos.core.domain.model.deposit

import kotlinx.serialization.SerialName

data class DepositAccountPayload(
    val customerIdentifier: String? = null,
    val productIdentifier: String? = null,
    val beneficiaries: List<String> = ArrayList()
)