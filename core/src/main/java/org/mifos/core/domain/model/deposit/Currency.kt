package org.mifos.core.domain.model.deposit

import kotlinx.serialization.SerialName

data class Currency(
    val code: String? = null,
    val name: String? = null,
    val sign: String? = null,
    val scale: Int? = null
)
