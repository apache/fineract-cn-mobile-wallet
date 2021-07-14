package org.mifos.core.usecase.customer

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.customer.FetchCustomerDetails
import org.mifos.core.utils.Result
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FetchCustomerDetailsTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var fetchCustomer: FetchCustomerDetails
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        fetchCustomer = FetchCustomerDetails(repository)
    }

    @Test
    fun whenFetchCustomerDetailsSuccess_fetchCustomer() = runBlocking {
        val result = fetchCustomer.execute(MockData.successIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                    "data = ${result.data}\n" +
                    "error = ${result.error}"
        )
        assertEquals(Result.ResultType.SUCCESS, result.resultType)
        assertEquals(MockData.customerModel, result.data)
    }

    @Test
    fun whenFetchCustomerDetailsError_throwsException() = runBlocking {
        val result = fetchCustomer.execute(MockData.errorIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                    "data = ${result.data}\n" +
                    "error = ${result.error}"
        )
        assertEquals(Result.ResultType.ERROR, result.resultType)
        assertTrue(result.error != null)
    }
}