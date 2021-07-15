package org.mifos.core.usecase.jornal

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.journal.FetchJournalEntries
import org.mifos.core.utils.Result
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FetchJournalEntriesTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var fetchJournalEntries: FetchJournalEntries
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        fetchJournalEntries = FetchJournalEntries(repository)
    }

    @Test
    fun whenFetchJournalEntrySuccess_fetchJournalEntry() = runBlocking {
        val result = fetchJournalEntries.execute(MockData.testDateRange, MockData.successIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                "data = ${result.data}\n" +
                "error = ${result.error}"
        )
        assertEquals(Result.ResultType.SUCCESS, result.resultType)
        assertEquals(listOf(MockData.journalEntryModel), result.data)
    }

    @Test
    fun whenFetchJournalEntryError_throwsException() = runBlocking {
        val result = fetchJournalEntries.execute(MockData.testDateRange, MockData.errorIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                "data = ${result.data}\n" +
                "error = ${result.error}"
        )
        assertEquals(Result.ResultType.ERROR, result.resultType)
        assertTrue(result.error != null)
    }
}
