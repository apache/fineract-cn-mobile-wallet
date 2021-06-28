package org.mifos.core.data.network.api.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.mifos.core.data.network.api.APIEndPoints.DEPOSIT
import org.mifos.core.data.network.entity.deposit.DepositAccount
import org.mifos.core.data.network.entity.deposit.DepositAccountPayload
import org.mifos.core.data.network.entity.deposit.Product

class DepositService(private val httpClient: HttpClient) {

    suspend fun fetchCustomerDeposits(customerIdentifier: String): List<DepositAccount> {
        return httpClient.get<List<DepositAccount>>(path = "$DEPOSIT/instances") {
            parameter("customer", customerIdentifier)
        }
    }

    suspend fun fetchDepositAccountDetails(accountIdentifier: String): DepositAccount {
        return httpClient.get<DepositAccount>(path = "$DEPOSIT/instances/$accountIdentifier")
    }

    suspend fun fetchProductDetails(productIdentifier: String): Product {
        return httpClient.get<Product>(path = "$DEPOSIT/definitions/$productIdentifier")
    }

    suspend fun createDepositAccount(depositAccountPayload: DepositAccountPayload): HttpResponse {
        return httpClient.post<HttpResponse>(path = "$DEPOSIT/instances") {
            body = depositAccountPayload
        }
    }
}