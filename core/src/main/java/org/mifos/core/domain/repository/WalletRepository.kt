package org.mifos.core.domain.repository

/* ktlint-disable no-wildcard-imports */
import io.ktor.client.statement.*
import org.mifos.core.data.network.entity.auth.LoginResponseEntity
import org.mifos.core.data.network.entity.customer.CustomerEntity
import org.mifos.core.data.network.entity.customer.CustomerPageEntity
import org.mifos.core.data.network.entity.deposit.DepositAccountEntity
import org.mifos.core.data.network.entity.deposit.DepositAccountPayloadEntity
import org.mifos.core.data.network.entity.deposit.ProductEntity
import org.mifos.core.data.network.entity.journal.JournalEntryEntity
/* ktlint-enable no-wildcard-imports */

interface WalletRepository {

    suspend fun loginUser(
        userName: String,
        password: String
    ): LoginResponseEntity

    suspend fun createCustomer(customerPayload: CustomerEntity): HttpResponse

    suspend fun fetchCustomerDetails(identifier: String): CustomerEntity

    suspend fun fetchCustomers(
        pageIndex: Int?,
        size: Int?
    ): CustomerPageEntity

    suspend fun updateCustomer(
        identifier: String,
        customer: CustomerEntity
    ): HttpResponse

    suspend fun searchCustomer(
        pageIndex: Int?,
        size: Int?,
        term: String?
    ): CustomerPageEntity

    suspend fun fetchCustomerDepositAccounts(customerIdentifier: String): List<DepositAccountEntity>

    suspend fun fetchDepositAccountDetails(accountIdentifier: String): DepositAccountEntity

    suspend fun fetchProductDetails(productIdentifier: String): ProductEntity

    suspend fun createDepositAccount(depositAccountPayload: DepositAccountPayloadEntity): HttpResponse

    suspend fun fetchJournalEntries(
        dateRange: String,
        accountIdentifier: String
    ): List<JournalEntryEntity>

    suspend fun fetchJournalEntry(entryIdentifier: String): JournalEntryEntity
}
