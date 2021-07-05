package org.mifos.core.domain.usecases.customer

import io.ktor.client.statement.*
import org.mifos.core.domain.model.customer.Customer
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class CreateCustomer(private val repository: WalletRepository) {

    suspend fun execute(customerPayload: Customer): Result<HttpResponse> {
        return try {
            val response = repository.createCustomer(customerPayload)
            Result.success(response)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}