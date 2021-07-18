package org.mifos.core.domain.usecases.auth

import org.mifos.core.domain.mappers.Mappers.loginResponseMapper
import org.mifos.core.domain.model.LoginResponse
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class AuthenticateUser(private val repository: WalletRepository) {

    suspend fun execute(
        grantType: String,
        userName: String,
        password: String
    ): Result<LoginResponse> {
        return try {
            val loginResponse =
                loginResponseMapper(repository.loginUser(grantType, userName, password))
            Result.success(loginResponse)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
