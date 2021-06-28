package org.mifos.core.domain.model.customer

data class ContactDetail(
    val type: Type? = null,
    val group: Group? = null,
    val value: String? = null,
    val preferenceLevel: Int? = null,
    val isValidated: Type? = null
) {

    enum class Type {
        EMAIL,

        PHONE,

        MOBILE
    }

    enum class Group {
        BUSINESS,

        PRIVATE
    }
}
