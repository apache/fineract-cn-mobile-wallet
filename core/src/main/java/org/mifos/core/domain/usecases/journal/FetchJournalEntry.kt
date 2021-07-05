package org.mifos.core.domain.usecases.journal

import org.mifos.core.domain.model.journal.JournalEntry
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class FetchJournalEntry(private val repository: WalletRepository) {

    suspend fun execute(entryIdentifier: String): Result<JournalEntry> {
        return try {
            val journalEntry = repository.fetchJournalEntry(entryIdentifier)
            Result.success(journalEntry)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}