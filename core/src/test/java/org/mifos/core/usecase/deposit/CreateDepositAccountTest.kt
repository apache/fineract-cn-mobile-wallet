package org.mifos.core.usecase.deposit

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.model.deposit.DepositAccountPayload
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.deposit.CreateDepositAccount
import org.mifos.core.utils.Result
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CreateDepositAccountTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var createDepositAccount: CreateDepositAccount
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        createDepositAccount = CreateDepositAccount(repository)
    }

    @Test
    fun whenCreateDepositAccSuccess_fetchAcceptedResponse() = runBlocking {
        val result = createDepositAccount.execute(MockData.depositAccountPayloadModel)
        println(
            "resultType = ${result.resultType}\n" +
                    "data = ${result.data}\n" +
                    "error = ${result.error}"
        )
        assertEquals(Result.ResultType.SUCCESS, result.resultType)
        assertEquals("Accepted", result.data)
    }

    @Test
    fun whenCreateDepositAccError_throwsException() = runBlocking {
        val result = createDepositAccount.execute(DepositAccountPayload())
        println(
            "resultType = ${result.resultType}\n" +
                    "data = ${result.data}\n" +
                    "error = ${result.error}"
        )
        assertEquals(Result.ResultType.ERROR, result.resultType)
        assertTrue(result.error != null)
    }
}