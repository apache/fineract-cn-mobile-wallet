package org.mifos.core.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mifos.core.MockFineractCNApiManager
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.api.MockData
import org.mifos.core.data.repository.WalletRepositoryImpl
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.domain.usecases.auth.AuthenticateUser
import org.mifos.core.utils.Result
import kotlin.test.assertEquals

class AuthenticationTest {

    private lateinit var apiManager: FineractCNApiManager
    private lateinit var repository: WalletRepository
    private lateinit var authUseCase: AuthenticateUser
    @Before
    fun initialize() {
        apiManager = MockFineractCNApiManager()
        repository = WalletRepositoryImpl(apiManager)
        authUseCase = AuthenticateUser(repository)
    }

    @Test
    fun whenAuthenticatedServiceSuccess_fetchLoginResponse() = runBlocking {
        val result = authUseCase.execute("grantType", "userName", "password")
        if (result.resultType == Result.ResultType.SUCCESS) {
            println(result.data)
        } else {
            println(result.error)
        }
        assertEquals(MockData.loginResponse, result.data, "Test Successful")
    }
}