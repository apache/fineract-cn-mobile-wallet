package org.mifos.core.data.network.entity.journal

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JournalEntry(
    @SerialName("transactionIdentifier")
    val transactionIdentifier: String? = null,
    @SerialName("transactionDate")
    val transactionDate: String? = null,
    @SerialName("transactionType")
    val transactionType: String? = null,
    @SerialName("clerk")
    val clerk: String? = null,
    @SerialName("note")
    val note: String? = null,
    @SerialName("debtors")
    val debtors: Set<Account>? = null,
    @SerialName("creditors")
    val creditors: Set<Account>? = null,
    @SerialName("state")
    val state: State? = null,
    @SerialName("message")
    val message: String? = null
) {

    enum class State {
        @SerialName("PENDING")
        PENDING,

        @SerialName("PROCESSED")
        PROCESSED
    }
}
