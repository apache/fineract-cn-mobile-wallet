package org.mifos.core.domain.usecases.customer

import org.mifos.core.domain.model.customer.Customer
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class CreateCustomer(private val repository: WalletRepository) {

    suspend fun execute(customerPayload: Customer): Result<String> {
        return try {
            val response = repository.createCustomer(customerPayload)
            Result.success(response.status.description)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}