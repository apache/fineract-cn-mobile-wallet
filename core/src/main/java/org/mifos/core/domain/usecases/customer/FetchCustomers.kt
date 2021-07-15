package org.mifos.core.domain.usecases.customer

import org.mifos.core.domain.model.customer.CustomerPage
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class FetchCustomers(private val repository: WalletRepository) {

    suspend fun execute(pageIndex: Int?, size: Int?): Result<CustomerPage> {
        return try {
            val customers = repository.fetchCustomers(pageIndex, size)
            Result.success(customers)
        } catch (e: Exception) {
            Result.error(e)
        }
    }

    suspend fun execute(pageIndex: Int?, size: Int?, term: String?): Result<CustomerPage> {
        return try {
            val customers = repository.searchCustomer(pageIndex, size, term)
            Result.success(customers)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
