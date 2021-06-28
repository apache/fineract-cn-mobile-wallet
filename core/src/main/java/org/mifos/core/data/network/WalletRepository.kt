package org.mifos.core.data.network

import io.ktor.client.statement.*
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.entity.LoginResponse
import org.mifos.core.data.network.entity.customer.Customer
import org.mifos.core.data.network.entity.customer.CustomerPage
import org.mifos.core.data.network.entity.deposit.DepositAccount
import org.mifos.core.data.network.entity.deposit.DepositAccountPayload
import org.mifos.core.data.network.entity.deposit.Product
import org.mifos.core.data.network.entity.journal.JournalEntry


class WalletRepository(private val fineractCNApiManager: FineractCNApiManager) {

    suspend fun loginUser(
        grantType: String,
        userName: String,
        password: String
    ): LoginResponse {
        return fineractCNApiManager.getAuthenticationAPI()
            .authenticate(grantType, userName, password)
    }

    suspend fun createCustomer(customerPayload: Customer): HttpResponse {
        return fineractCNApiManager.getCustomerApi().createCustomer(customerPayload)
    }

    suspend fun fetchCustomerDetails(identifier: String): Customer {
        return fineractCNApiManager.getCustomerApi().fetchCustomer(identifier)
    }

    suspend fun fetchCustomers(
        pageIndex: Int?,
        size: Int?
    ): CustomerPage {
        return fineractCNApiManager.getCustomerApi().fetchCustomers(pageIndex, size)
    }

    suspend fun updateCustomer(
        identifier: String,
        customer: Customer
    ): HttpResponse {
        return fineractCNApiManager.getCustomerApi().updateCustomer(identifier, customer)
    }

    suspend fun searchCustomer(
        pageIndex: Int?,
        size: Int?,
        term: String?
    ): CustomerPage {
        return fineractCNApiManager.getCustomerApi().searchCustomer(pageIndex, size, term)
    }

    suspend fun fetchCustomerDepositAccounts(customerIdentifier: String): List<DepositAccount> {
        return fineractCNApiManager.getDepositApi().fetchCustomerDeposits(customerIdentifier)
    }

    suspend fun fetchDepositAccountDetails(accountIdentifier: String): DepositAccount {
        return fineractCNApiManager.getDepositApi().fetchDepositAccountDetails(accountIdentifier)
    }

    suspend fun fetchProductDetails(productIdentifier: String): Product {
        return fineractCNApiManager.getDepositApi().fetchProductDetails(productIdentifier)
    }

    suspend fun createDepositAccount(depositAccountPayload: DepositAccountPayload): HttpResponse {
        return fineractCNApiManager.getDepositApi().createDepositAccount(depositAccountPayload)
    }

    suspend fun fetchJournalEntries(
        dateRange: String,
        accountIdentifier: String
    ): List<JournalEntry> {
        return fineractCNApiManager.getAccountingApi()
            .fetchJournalEntries(dateRange, accountIdentifier)
    }

    suspend fun fetchJournalEntry(entryIdentifier: String): JournalEntry {
        return fineractCNApiManager.getAccountingApi().fetchJournalEntry(entryIdentifier)
    }
}