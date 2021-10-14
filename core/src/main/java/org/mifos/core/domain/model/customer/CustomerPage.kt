package org.mifos.core.domain.model.customer

data class CustomerPage(
    val customers: List<Customer>? = null,
    val totalPages: Int? = null,
    val totalElements: Long? = null
)
