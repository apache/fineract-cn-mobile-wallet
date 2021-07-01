package org.mifos.core.data.network.entity.journal

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JournalEntryEntity(
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
    val debtors: List<AccountEntity>? = null,
    @SerialName("creditors")
    val creditors: List<AccountEntity>? = null,
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
