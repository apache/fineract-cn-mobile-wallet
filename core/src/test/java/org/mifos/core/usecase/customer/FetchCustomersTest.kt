package org.mifos.core.usecase.customer

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.customer.FetchCustomers
import org.mifos.core.utils.Result
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FetchCustomersTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var fetchCustomers: FetchCustomers
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        fetchCustomers = FetchCustomers(repository)
    }

    @Test
    fun whenFetchCustomersSuccess_fetchCustomers() = runBlocking {
        val result = fetchCustomers.execute(1, 2)
        println(
            "resultType = ${result.resultType}\n" +
                    "data = ${result.data}\n" +
                    "error = ${result.error}"
        )
        assertEquals(Result.ResultType.SUCCESS, result.resultType)
        assertEquals(MockData.customerPageModel, result.data)
    }

    @Test
    fun whenFetchCustomersError_throwsException() = runBlocking {
        val result = fetchCustomers.execute(5, 2)
        println(
            "resultType = ${result.resultType}\n" +
                    "data = ${result.data}\n" +
                    "error = ${result.error}"
        )
        assertEquals(Result.ResultType.ERROR, result.resultType)
        assertTrue(result.error != null)
    }
}