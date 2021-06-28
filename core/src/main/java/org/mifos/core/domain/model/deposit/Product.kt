package org.mifos.core.domain.model.deposit

data class Product(
    val type: String? = null,
    val identifier: String? = null,
    val name: String? = null,
    val description: String? = null,
    val currency: Currency? = null,
    val minimumBalance: Double? = null
)
