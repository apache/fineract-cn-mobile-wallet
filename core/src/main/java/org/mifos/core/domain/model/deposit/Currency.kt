package org.mifos.core.domain.model.deposit

data class Currency(
    val code: String? = null,
    val name: String? = null,
    val sign: String? = null,
    val scale: Int? = null
)
