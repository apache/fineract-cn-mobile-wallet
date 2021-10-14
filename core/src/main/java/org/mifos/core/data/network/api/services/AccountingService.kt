package org.mifos.core.data.network.api.services

/* ktlint-disable no-wildcard-imports */
import io.ktor.client.*
import io.ktor.client.request.*
import org.mifos.core.data.network.api.APIEndPoints.ACCOUNTING
import org.mifos.core.data.network.entity.journal.JournalEntryEntity
/* ktlint-enable no-wildcard-imports */

class AccountingService(private val httpClient: HttpClient) {

    suspend fun fetchJournalEntries(
        dateRange: String,
        accountIdentifier: String
    ): List<JournalEntryEntity> {
        return httpClient.get<List<JournalEntryEntity>>(path = "$ACCOUNTING/journal") {
            parameter("dateRange", dateRange)
            parameter("account", accountIdentifier)
        }
    }

    suspend fun fetchJournalEntry(entryIdentifier: String): JournalEntryEntity {
        return httpClient.get<JournalEntryEntity>(path = "$ACCOUNTING/journal/$entryIdentifier")
    }
}
