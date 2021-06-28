package org.mifos.core.data.network.api.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.mifos.core.data.network.api.APIEndPoints.CONSUMER
import org.mifos.core.data.network.entity.customer.Customer
import org.mifos.core.data.network.entity.customer.CustomerPage
import java.io.File

class CustomerService(private val httpClient: HttpClient) {

    suspend fun fetchCustomers(
        pageIndex: Int?,
        size: Int?
    ): CustomerPage {
        return httpClient.get<CustomerPage>(path = "$CONSUMER/customers") {
            parameter("pageIndex", pageIndex)
            parameter("size", size)
        }
    }

    suspend fun fetchCustomer(identifier: String): Customer {
        return httpClient.get<Customer>(path = "$CONSUMER/customers/$identifier")
    }

    suspend fun createCustomer(customerPayload: Customer): HttpResponse {
        return httpClient.post<HttpResponse>(path = "$CONSUMER/customers") {
            body = customerPayload
        }
    }

    suspend fun updateCustomer(
        identifier: String,
        customer: Customer
    ): HttpResponse {
        return httpClient.put<HttpResponse>(path = "$CONSUMER/customers/$identifier") {
            body = customer
        }
    }

    suspend fun searchCustomer(
        pageIndex: Int?,
        size: Int?,
        term: String?
    ): CustomerPage {
        return httpClient.get<CustomerPage>(path = "$CONSUMER/customers") {
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