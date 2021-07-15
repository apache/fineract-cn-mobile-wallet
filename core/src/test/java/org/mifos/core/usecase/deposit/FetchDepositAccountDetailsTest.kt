package org.mifos.core.usecase.deposit

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.deposit.FetchDepositAccountDetails
import org.mifos.core.utils.Result
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FetchDepositAccountDetailsTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var fetchDepositAccountDetails: FetchDepositAccountDetails
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        fetchDepositAccountDetails = FetchDepositAccountDetails(repository)
    }

    @Test
    fun whenFetchDepositAccountSuccess_fetchAccount() = runBlocking {
        val result = fetchDepositAccountDetails.execute(MockData.successIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                "data = ${result.data}\n" +
                "error = ${result.error}"
        )
        assertEquals(Result.ResultType.SUCCESS, result.resultType)
        assertEquals(MockData.depositAccountModel, result.data)
    }

    @Test
    fun whenFetchDepositAccountError_throwsException() = runBlocking {
        val result = fetchDepositAccountDetails.execute(MockData.errorIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                "data = ${result.data}\n" +
                "error = ${result.error}"
        )
        assertEquals(Result.ResultType.ERROR, result.resultType)
        assertTrue(result.error != null)
    }
}
