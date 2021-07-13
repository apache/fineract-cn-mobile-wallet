package org.mifos.core.data.network.api.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.mifos.core.data.network.api.APIEndPoints.DEPOSIT
import org.mifos.core.data.network.entity.deposit.DepositAccountEntity
import org.mifos.core.data.network.entity.deposit.DepositAccountPayloadEntity
import org.mifos.core.data.network.entity.deposit.ProductEntity

class DepositService(private val httpClient: HttpClient) {

    suspend fun fetchCustomerDeposits(customerIdentifier: String): List<DepositAccountEntity> {
        return httpClient.get<List<DepositAccountEntity>>(path = "$DEPOSIT/instances") {
            parameter("customer", customerIdentifier)
        }
    }

    suspend fun fetchDepositAccountDetails(accountIdentifier: String): DepositAccountEntity {
        return httpClient.get<DepositAccountEntity>(path = "$DEPOSIT/instances/$accountIdentifier")
    }

    suspend fun fetchProductDetails(productIdentifier: String): ProductEntity {
        return httpClient.get<ProductEntity>(path = "$DEPOSIT/definitions/$productIdentifier")
    }

    suspend fun createDepositAccount(depositAccountPayload: DepositAccountPayloadEntity): HttpResponse {
        return httpClient.post<HttpResponse>(path = "$DEPOSIT/instances") {
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
            }
            body = depositAccountPayload
        }
    }
}