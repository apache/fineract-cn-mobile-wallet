package org.mifos.core.domain.usecases.customer

import org.mifos.core.domain.mappers.Mappers.customerMapper
import org.mifos.core.domain.model.customer.Customer
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class FetchCustomerDetails(private val repository: WalletRepository) {

    suspend fun execute(identifier: String): Result<Customer> {
        return try {
            val customer = customerMapper(repository.fetchCustomerDetails(identifier))
            Result.success(customer)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
