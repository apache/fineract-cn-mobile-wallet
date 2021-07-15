package org.mifos.core.data.network.api.services

/* ktlint-disable no-wildcard-imports */
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.mifos.core.data.network.api.APIEndPoints.CONSUMER
import org.mifos.core.data.network.entity.customer.CustomerEntity
import org.mifos.core.data.network.entity.customer.CustomerPageEntity
import java.io.File
/* ktlint-enable no-wildcard-imports */

class CustomerService(private val httpClient: HttpClient) {

    suspend fun fetchCustomers(
        pageIndex: Int?,
        size: Int?
    ): CustomerPageEntity {
        return httpClient.get<CustomerPageEntity>(path = "$CONSUMER/customers") {
            parameter("pageIndex", pageIndex)
            parameter("size", size)
        }
    }

    suspend fun fetchCustomer(identifier: String): CustomerEntity {
        return httpClient.get<CustomerEntity>(path = "$CONSUMER/customers/$identifier")
    }

    suspend fun createCustomer(customerPayload: CustomerEntity): HttpResponse {
        return httpClient.post<HttpResponse>(path = "$CONSUMER/customers") {
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
            }
            body = customerPayload
        }
    }

    suspend fun updateCustomer(
        identifier: String,
        customer: CustomerEntity
    ): HttpResponse {
        return httpClient.put<HttpResponse>(path = "$CONSUMER/customers/$identifier") {
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
            }
            body = customer
        }
    }

    suspend fun searchCustomer(
        pageIndex: Int?,
        size: Int?,
        term: String?
    ): CustomerPageEntity {
        return httpClient.get<CustomerPageEntity>(path = "$CONSUMER/customers") {
            parameter("pageIndex", pageIndex)
            parameter("size", size)
            parameter("term", term)
        }
    }

    suspend fun uploadCustomerPortrait(
        identifier: String,
        file: File
    ): HttpResponse {
        return httpClient.post<HttpResponse>(path = "$CONSUMER/customers/$identifier/portrait") {
            body = file.readBytes()
        }
    }
}
