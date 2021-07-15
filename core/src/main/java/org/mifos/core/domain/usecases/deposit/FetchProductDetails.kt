package org.mifos.core.domain.usecases.deposit

import org.mifos.core.domain.model.deposit.Product
import org.mifos.core.domain.repository.WalletRepository
import org.mifos.core.utils.Result

class FetchProductDetails(private val repository: WalletRepository) {

    suspend fun execute(productIdentifier: String): Result<Product> {
        return try {
            val product = repository.fetchProductDetails(productIdentifier)
            Result.success(product)
        } catch (e: Exception) {
            Result.error(e)
        }
    }
}
