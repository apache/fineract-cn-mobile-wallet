package org.mifos.core.data.network.entity.customer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContactDetailEntity(
    @SerialName("type")
    val type: Type? = null,
    @SerialName("group")
    val group: Group? = null,
    @SerialName("value")
    val value: String? = null,
    @SerialName("preferenceLevel")
    val preferenceLevel: Int? = null,
    @SerialName("validated")
    val isValidated: Boolean? = null
) {

    enum class Type {
        @SerialName("EMAIL")
        EMAIL,

        @SerialName("PHONE")
        PHONE,

        @SerialName("MOBILE")
        MOBILE
    }

    enum class Group {
        @SerialName("BUSINESS")
        BUSINESS,

        @SerialName("PRIVATE")
        PRIVATE
    }
}
