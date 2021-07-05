package org.mifos.core.domain.usecases.deposit

import io.ktor.client.statement.*
import org.mifos.core.domain.model.deposit.DepositAccountPayload
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class CreateDepositAccount(private val repository: WalletRepository) {

    suspend fun execute(depositAccountPayload: DepositAccountPayload): Result<HttpResponse> {
        return try {
            val response = repository.createDepositAccount(depositAccountPayload)
            Result.success(response)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}