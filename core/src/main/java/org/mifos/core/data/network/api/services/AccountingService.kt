package org.mifos.core.data.network.api.services

import io.ktor.client.*
import io.ktor.client.request.*
import org.mifos.core.data.network.api.APIEndPoints.ACCOUNTING
import org.mifos.core.data.network.entity.journal.JournalEntry

class AccountingService(private val httpClient: HttpClient) {

    suspend fun fetchJournalEntries(
        dateRange: String,
        accountIdentifier: String
    ): List<JournalEntry> {
        return httpClient.get<List<JournalEntry>>(path = "$ACCOUNTING/journal") {
            parameter("dateRange", dateRange)
            parameter("account", accountIdentifier)
        }
    }

    suspend fun fetchJournalEntry(entryIdentifier: String): JournalEntry {
        return httpClient.get<JournalEntry>(path = "$ACCOUNTING/journal/$entryIdentifier")
    }
}