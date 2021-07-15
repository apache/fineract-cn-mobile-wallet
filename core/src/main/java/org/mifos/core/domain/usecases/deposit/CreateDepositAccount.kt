package org.mifos.core.domain.usecases.deposit

import org.mifos.core.domain.model.deposit.DepositAccountPayload
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class CreateDepositAccount(private val repository: WalletRepository) {

    suspend fun execute(depositAccountPayload: DepositAccountPayload): Result<String> {
        return try {
            val response = repository.createDepositAccount(depositAccountPayload)
            Result.success(response.status.description)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
