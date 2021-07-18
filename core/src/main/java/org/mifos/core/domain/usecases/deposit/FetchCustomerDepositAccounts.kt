package org.mifos.core.domain.usecases.deposit

import org.mifos.core.domain.mappers.Mappers.depositAccountListMapper
import org.mifos.core.domain.model.deposit.DepositAccount
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class FetchCustomerDepositAccounts(private val repository: WalletRepository) {

    suspend fun execute(customerIdentifier: String): Result<List<DepositAccount>> {
        return try {
            val depositAccounts = depositAccountListMapper(repository.fetchCustomerDepositAccounts(customerIdentifier))
            Result.success(depositAccounts)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
