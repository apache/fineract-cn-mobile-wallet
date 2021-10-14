package org.mifos.core.domain.usecases.deposit

import org.mifos.core.domain.mappers.Mappers.depositAccountMapper
import org.mifos.core.domain.model.deposit.DepositAccount
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class FetchDepositAccountDetails(private val repository: WalletRepository) {

    suspend fun execute(accountIdentifier: String): Result<DepositAccount> {
        return try {
            val depositAccount = depositAccountMapper(repository.fetchDepositAccountDetails(accountIdentifier))
            Result.success(depositAccount)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
