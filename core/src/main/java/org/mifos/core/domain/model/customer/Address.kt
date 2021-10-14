package org.mifos.core.domain.model.customer

data class Address(
    val street: String? = null,
    val city: String? = null,
    val region: String? = null,
    val postalCode: String? = null,
    val countryCode: String? = null,
    val country: String? = null
)
