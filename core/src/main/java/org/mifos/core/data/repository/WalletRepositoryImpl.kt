package org.mifos.core.data.repository

import io.ktor.client.statement.*
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.entity.LoginResponse
import org.mifos.core.data.network.entity.customer.Customer
import org.mifos.core.data.network.entity.customer.CustomerPage
import org.mifos.core.data.network.entity.deposit.DepositAccount
import org.mifos.core.data.network.entity.deposit.DepositAccountPayload
import org.mifos.core.data.network.entity.deposit.Product
import org.mifos.core.data.network.entity.journal.JournalEntry
import org.mifos.core.domain.repository.WalletRepository

class WalletRepositoryImpl(private val fineractCNApiManager: FineractCNApiManager) :
    WalletRepository {

    override suspend fun loginUser(
        grantType: String,
        userName: String,
        password: String
    ): LoginResponse {
        return fineractCNApiManager.getAuthenticationAPI()
            .authenticate(grantType, userName, password)
    }

    override suspend fun createCustomer(customerPayload: Customer): HttpResponse {
        return fineractCNApiManager.getCustomerApi().createCustomer(customerPayload)
    }

    override suspend fun fetchCustomerDetails(identifier: String): Customer {
        return fineractCNApiManager.getCustomerApi().fetchCustomer(identifier)
    }

    override suspend fun fetchCustomers(
        pageIndex: Int?,
        size: Int?
    ): CustomerPage {
        return fineractCNApiManager.getCustomerApi().fetchCustomers(pageIndex, size)
    }

    override suspend fun updateCustomer(
        identifier: String,
        customer: Customer
    ): HttpResponse {
        return fineractCNApiManager.getCustomerApi().updateCustomer(identifier, customer)
    }

    override suspend fun searchCustomer(
        pageIndex: Int?,
        size: Int?,
        term: String?
    ): CustomerPage {
        return fineractCNApiManager.getCustomerApi().searchCustomer(pageIndex, size, term)
    }

    override suspend fun fetchCustomerDepositAccounts(
        customerIdentifier: String
    ): List<DepositAccount> {
        return fineractCNApiManager.getDepositApi().fetchCustomerDeposits(customerIdentifier)
    }

    override suspend fun fetchDepositAccountDetails(accountIdentifier: String): DepositAccount {
        return fineractCNApiManager.getDepositApi().fetchDepositAccountDetails(accountIdentifier)
    }

    override suspend fun fetchProductDetails(productIdentifier: String): Product {
        return fineractCNApiManager.getDepositApi().fetchProductDetails(productIdentifier)
    }

    override suspend fun createDepositAccount(
        depositAccountPayload: DepositAccountPayload
    ): HttpResponse {
        return fineractCNApiManager.getDepositApi().createDepositAccount(depositAccountPayload)
    }

    override suspend fun fetchJournalEntries(
        dateRange: String,
        accountIdentifier: String
    ): List<JournalEntry> {
        return fineractCNApiManager.getAccountingApi()
            .fetchJournalEntries(dateRange, accountIdentifier)
    }

    override suspend fun fetchJournalEntry(entryIdentifier: String): JournalEntry {
        return fineractCNApiManager.getAccountingApi().fetchJournalEntry(entryIdentifier)
    }
}