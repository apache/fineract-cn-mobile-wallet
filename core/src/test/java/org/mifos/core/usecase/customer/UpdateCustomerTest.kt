package org.mifos.core.usecase.customer

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.customer.UpdateCustomer
import org.mifos.core.utils.Result
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UpdateCustomerTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var updateCustomer: UpdateCustomer
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        updateCustomer = UpdateCustomer(repository)
    }

    @Test
    fun whenUpdateCustomerSuccess_fetchAcceptedResponse() = runBlocking {
        val result = updateCustomer.execute("idOne", MockData.customerModel)
        println(
            "resultType = ${result.resultType}\n" +
                "data = ${result.data}\n" +
                "error = ${result.error}"
        )
        assertEquals(Result.ResultType.SUCCESS, result.resultType)
        assertEquals("Accepted", result.data)
    }

    @Test
    fun whenUpdateCustomerError_throwsException() = runBlocking {
        val result = updateCustomer.execute("wrongId", MockData.customerModel)
        println(
            "resultType = ${result.resultType}\n" +
                "data = ${result.data}\n" +
                "error = ${result.error}"
        )
        assertEquals(Result.ResultType.ERROR, result.resultType)
        assertTrue(result.error != null)
    }
}
