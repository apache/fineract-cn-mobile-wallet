package org.mifos.core.usecase.deposit

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.deposit.FetchProductDetails

import org.mifos.core.utils.Result
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FetchProductDetailsTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var fetchProductDetails: FetchProductDetails
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        fetchProductDetails = FetchProductDetails(repository)
    }

    @Test
    fun whenFetchProductSuccess_fetchProduct() = runBlocking {
        val result = fetchProductDetails.execute(MockData.successIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                    "data = ${result.data}\n" +
                    "error = ${result.error}"
        )
        assertEquals(Result.ResultType.SUCCESS, result.resultType)
        assertEquals(MockData.productModel, result.data)
    }

    @Test
    fun whenFetchProductError_throwsException() = runBlocking {
        val result = fetchProductDetails.execute(MockData.errorIdentifier)
        println(
            "resultType = ${result.resultType}\n" +
                    "data = ${result.data}\n" +
                    "error = ${result.error}"
        )
        assertEquals(Result.ResultType.ERROR, result.resultType)
        assertTrue(result.error != null)
    }
}