package org.mifos.core.usecase.deposit

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.deposit.FetchCustomerDepositAccounts
import org.mifos.core.utils.Result
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FetchCustomerDepositAccountsTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var fetchCustomerDepositAccounts: FetchCustomerDepositAccounts
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        fetchCustomerDepositAccounts = FetchCustomerDepositAccounts(repository)
    }

    @Test
    fun whenFetchDepositAccountsSuccess_fetchAccounts() = runBlocking {
        val result = fetchCustomerDepositAccounts.execute(MockData.successIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                "data = ${result.data}\n" +
                "error = ${result.error}"
        )
        assertEquals(Result.ResultType.SUCCESS, result.resultType)
        assertEquals(listOf(MockData.depositAccountModel), result.data)
    }

    @Test
    fun whenFetchDepositAccountsError_throwsException() = runBlocking {
        val result = fetchCustomerDepositAccounts.execute(MockData.errorIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                "data = ${result.data}\n" +
                "error = ${result.error}"
        )
        assertEquals(Result.ResultType.ERROR, result.resultType)
        assertTrue(result.error != null)
    }
}
