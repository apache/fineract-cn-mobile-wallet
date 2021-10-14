package org.mifos.core.domain.model.deposit

data class DepositAccountPayload(
    val customerIdentifier: String? = null,
    val productIdentifier: String? = null,
    val beneficiaries: List<String> = ArrayList()
)
