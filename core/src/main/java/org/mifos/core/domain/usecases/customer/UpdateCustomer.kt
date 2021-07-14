package org.mifos.core.domain.usecases.customer

import org.mifos.core.domain.model.customer.Customer
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class UpdateCustomer(private val repository: WalletRepository) {

    suspend fun execute(identifier: String, customer: Customer): Result<String> {
        return try {
            val response = repository.updateCustomer(identifier, customer)
            Result.success(response.status.description)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}