package org.mifos.core.domain.usecases.customer

import org.mifos.core.domain.mappers.Mappers.customerPageMapper
import org.mifos.core.domain.model.customer.CustomerPage
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class FetchCustomers(private val repository: WalletRepository) {

    suspend fun execute(pageIndex: Int?, size: Int?): Result<CustomerPage> {
        return try {
            val customers = customerPageMapper(repository.fetchCustomers(pageIndex, size))
            Result.success(customers)
        } catch (e: Exception) {
            Result.error(e)
        }
    }

    suspend fun execute(pageIndex: Int?, size: Int?, term: String?): Result<CustomerPage> {
        return try {
            val customers = customerPageMapper(repository.searchCustomer(pageIndex, size, term))
            Result.success(customers)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
