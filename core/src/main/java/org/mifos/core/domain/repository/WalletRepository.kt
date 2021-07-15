package org.mifos.core.domain.repository

/* ktlint-disable no-wildcard-imports */
import io.ktor.client.statement.*
import org.mifos.core.domain.model.LoginResponse
import org.mifos.core.domain.model.customer.Customer
import org.mifos.core.domain.model.customer.CustomerPage
import org.mifos.core.domain.model.deposit.DepositAccount
import org.mifos.core.domain.model.deposit.DepositAccountPayload
import org.mifos.core.domain.model.deposit.Product
import org.mifos.core.domain.model.journal.JournalEntry
/* ktlint-enable no-wildcard-imports */

interface WalletRepository {

    suspend fun loginUser(
        grantType: String,
        userName: String,
        password: String
    ): LoginResponse

    suspend fun createCustomer(customerPayload: Customer): HttpResponse

    suspend fun fetchCustomerDetails(identifier: String): Customer

    suspend fun fetchCustomers(
        pageIndex: Int?,
        size: Int?
    ): CustomerPage

    suspend fun updateCustomer(
        identifier: String,
        customer: Customer
    ): HttpResponse

    suspend fun searchCustomer(
        pageIndex: Int?,
        size: Int?,
        term: String?
    ): CustomerPage

    suspend fun fetchCustomerDepositAccounts(customerIdentifier: String): List<DepositAccount>

    suspend fun fetchDepositAccountDetails(accountIdentifier: String): DepositAccount

    suspend fun fetchProductDetails(productIdentifier: String): Product

    suspend fun createDepositAccount(depositAccountPayload: DepositAccountPayload): HttpResponse

    suspend fun fetchJournalEntries(
        dateRange: String,
        accountIdentifier: String
    ): List<JournalEntry>

    suspend fun fetchJournalEntry(entryIdentifier: String): JournalEntry
}
