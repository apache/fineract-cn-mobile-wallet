package org.mifos.core.domain.usecases.journal

import org.mifos.core.domain.mappers.Mappers.journalEntryListMapper
import org.mifos.core.domain.model.journal.JournalEntry
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class FetchJournalEntries(private val repository: WalletRepository) {

    suspend fun execute(dateRange: String, accountIdentifier: String): Result<List<JournalEntry>> {
        return try {
            val journalEntries = journalEntryListMapper(repository.fetchJournalEntries(dateRange, accountIdentifier))
            Result.success(journalEntries)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
