package org.mifos.core.data.repository

/* ktlint-disable no-wildcard-imports */
import io.ktor.client.statement.*
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.repository.Mappers.customerEntityMapper
import org.mifos.core.data.repository.Mappers.customerMapper
import org.mifos.core.data.repository.Mappers.customerPageMapper
import org.mifos.core.data.repository.Mappers.depositAccountListMapper
import org.mifos.core.data.repository.Mappers.depositAccountMapper
import org.mifos.core.data.repository.Mappers.depositAccountPayloadEntityMapper
import org.mifos.core.data.repository.Mappers.journalEntryListMapper
import org.mifos.core.data.repository.Mappers.journalEntryMapper
import org.mifos.core.data.repository.Mappers.loginResponseMapper
import org.mifos.core.data.repository.Mappers.productMapper
import org.mifos.core.domain.model.LoginResponse
import org.mifos.core.domain.model.customer.Customer
import org.mifos.core.domain.model.customer.CustomerPage
import org.mifos.core.domain.model.deposit.DepositAccount
import org.mifos.core.domain.model.deposit.DepositAccountPayload
import org.mifos.core.domain.model.deposit.Product
import org.mifos.core.domain.model.journal.JournalEntry
import org.mifos.core.domain.repository.WalletRepository
/* ktlint-enable no-wildcard-imports */

class WalletRepositoryImpl(private val fineractCNApiManager: FineractCNApiManager) :
    WalletRepository {

    // Repository methods for data transfer starts
    override suspend fun loginUser(
        grantType: String,
        userName: String,
        password: String
    ): LoginResponse {
        return loginResponseMapper(
            fineractCNApiManager.getAuthenticationAPI()
                .authenticate(grantType, userName, password)
        )
    }

    override suspend fun createCustomer(customerPayload: Customer): HttpResponse {
        return fineractCNApiManager.getCustomerApi()
            .createCustomer(customerEntityMapper(customerPayload))
    }

    override suspend fun fetchCustomerDetails(identifier: String): Customer {
        return customerMapper(fineractCNApiManager.getCustomerApi().fetchCustomer(identifier))
    }

    override suspend fun fetchCustomers(
        pageIndex: Int?,
        size: Int?
    ): CustomerPage {
        return customerPageMapper(
            fineractCNApiManager.getCustomerApi().fetchCustomers(pageIndex, size)
        )
    }

    override suspend fun updateCustomer(
        identifier: String,
        customer: Customer
    ): HttpResponse {
        return fineractCNApiManager.getCustomerApi()
            .updateCustomer(identifier, customerEntityMapper(customer))
    }

    override suspend fun searchCustomer(
        pageIndex: Int?,
        size: Int?,
        term: String?
    ): CustomerPage {
        return customerPageMapper(
            fineractCNApiManager.getCustomerApi().searchCustomer(pageIndex, size, term)
        )
    }

    override suspend fun fetchCustomerDepositAccounts(
        customerIdentifier: String
    ): List<DepositAccount> {
        return depositAccountListMapper(
            fineractCNApiManager.getDepositApi().fetchCustomerDeposits(customerIdentifier)
        )
    }

    override suspend fun fetchDepositAccountDetails(accountIdentifier: String): DepositAccount {
        return depositAccountMapper(
            fineractCNApiManager.getDepositApi().fetchDepositAccountDetails(accountIdentifier)
        )
    }

    override suspend fun fetchProductDetails(productIdentifier: String): Product {
        return productMapper(
            fineractCNApiManager.getDepositApi().fetchProductDetails(productIdentifier)
        )
    }

    override suspend fun createDepositAccount(
        depositAccountPayload: DepositAccountPayload
    ): HttpResponse {
        return fineractCNApiManager.getDepositApi()
            .createDepositAccount(depositAccountPayloadEntityMapper(depositAccountPayload))
    }

    override suspend fun fetchJournalEntries(
        dateRange: String,
        accountIdentifier: String
    ): List<JournalEntry> {
        return journalEntryListMapper(
            fineractCNApiManager.getAccountingApi()
                .fetchJournalEntries(dateRange, accountIdentifier)
        )
    }

    override suspend fun fetchJournalEntry(entryIdentifier: String): JournalEntry {
        return journalEntryMapper(
            fineractCNApiManager.getAccountingApi().fetchJournalEntry(entryIdentifier)
        )
    }
}
