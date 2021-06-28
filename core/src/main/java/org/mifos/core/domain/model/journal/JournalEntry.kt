package org.mifos.core.domain.model.journal

data class JournalEntry(
    val transactionIdentifier: String? = null,
    val transactionDate: String? = null,
    val transactionType: String? = null,
    val clerk: String? = null,
    val note: String? = null,
    val debtors: Set<Account>? = null,
    val creditors: Set<Account>? = null,
    val state: State? = null,
    val message: String? = null
) {

    enum class State {
        PENDING,

        PROCESSED
    }
}