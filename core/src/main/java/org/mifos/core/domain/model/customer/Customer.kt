package org.mifos.core.domain.model.customer

data class Customer(
    val customerIdentifier: String? = null,
    val type: Type? = null,
    val firstName: String? = null,
    val middleName: String? = null,
    val LastName: String? = null,
    val dateOfBirth: DateOfBirth? = null,
    val isMember: Boolean? = null,
    val accountBeneficiary: String? = null,
    val referenceCustomer: String? = null,
    val assignedOffice: String? = null,
    val assignedEmployee: String? = null,
    val address: Address? = null,
    val contactDetails: List<ContactDetail>? = null,
    val currentState: State? = null,
    val createdBy: String? = null,
    val createdOn: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedOn: String? = null
) {

    enum class Type {
        PERSON,

        BUSINESS
    }

    enum class State {
        PENDING,

        ACTIVE,

        LOCKED,

        CLOSED
    }
}
