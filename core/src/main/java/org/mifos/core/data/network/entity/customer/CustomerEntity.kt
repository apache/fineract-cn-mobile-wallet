package org.mifos.core.data.network.entity.customer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomerEntity(
    @SerialName("identifier")
    val customerIdentifier: String? = null,
    @SerialName("type")
    val type: Type? = null,
    @SerialName("givenName")
    val firstName: String? = null,
    @SerialName("middleName")
    val middleName: String? = null,
    @SerialName("surName")
    val LastName: String? = null,
    @SerialName("dateOfBirth")
    val dateOfBirth: DateOfBirthEntity? = null,
    @SerialName("member")
    val isMember: Boolean? = null,
    @SerialName("accountBeneficiary")
    val accountBeneficiary: String? = null,
    @SerialName("referenceCustomer")
    val referenceCustomer: String? = null,
    @SerialName("assignedOffice")
    val assignedOffice: String? = null,
    @SerialName("assignedEmployee")
    val assignedEmployee: String? = null,
    @SerialName("address")
    val address: AddressEntity? = null,
    @SerialName("contactDetails")
    val contactDetails: List<ContactDetailEntity>? = null,
    @SerialName("currentState")
    val currentState: State? = null,
    @SerialName("applicationDate")
    val applicationDate: String? = null,
    @SerialName("customValues")
    val customValues: List<String>? = null,
    @SerialName("createdBy")
    val createdBy: String? = null,
    @SerialName("CreatedOn")
    val createdOn: String? = null,
    @SerialName("lastModifiedBy")
    val lastModifiedBy: String? = null,
    @SerialName("lastModifiedOn")
    val lastModifiedOn: String? = null
) {

    enum class Type {
        @SerialName("PERSON")
        PERSON,

        @SerialName("BUSINESS")
        BUSINESS
    }

    enum class State {
        @SerialName("PENDING")
        PENDING,

        @SerialName("ACTIVE")
        ACTIVE,

        @SerialName("LOCKED")
        LOCKED,

        @SerialName("CLOSED")
        CLOSED
    }
}
