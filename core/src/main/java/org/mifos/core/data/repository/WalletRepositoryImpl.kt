package org.mifos.core.data.repository

/* ktlint-disable no-wildcard-imports */
import io.ktor.client.statement.*
import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.data.network.entity.auth.LoginResponseEntity
import org.mifos.core.data.network.entity.customer.CustomerEntity
import org.mifos.core.data.network.entity.customer.CustomerPageEntity
import org.mifos.core.data.network.entity.deposit.DepositAccountEntity
import org.mifos.core.data.network.entity.deposit.DepositAccountPayloadEntity
import org.mifos.core.data.network.entity.deposit.ProductEntity
import org.mifos.core.data.network.entity.journal.JournalEntryEntity
import org.mifos.core.domain.repository.WalletRepository
/* ktlint-enable no-wildcard-imports */

class WalletRepositoryImpl(private val fineractCNApiManager: FineractCNApiManager) :
    WalletRepository {

    // Repository methods for data transfer starts
    override suspend fun loginUser(
        userName: String,
        password: String
    ): LoginResponseEntity {
        return fineractCNApiManager.getAuthenticationAPI()
            .authenticate(userName, password)
    }

    override suspend fun createCustomer(customerPayload: CustomerEntity): HttpResponse {
        return fineractCNApiManager.getCustomerApi()
            .createCustomer(customerPayload)
    }

    override suspend fun fetchCustomerDetails(identifier: String): CustomerEntity {
        return fineractCNApiManager.getCustomerApi().fetchCustomer(identifier)
    }

    override suspend fun fetchCustomers(
        pageIndex: Int?,
        size: Int?
    ): CustomerPageEntity {
        return fineractCNApiManager.getCustomerApi().fetchCustomers(pageIndex, size)
    }

    override suspend fun updateCustomer(
        identifier: String,
        customer: CustomerEntity
    ): HttpResponse {
        return fineractCNApiManager.getCustomerApi()
            .updateCustomer(identifier, customer)
    }

    override suspend fun searchCustomer(
        pageIndex: Int?,
        size: Int?,
        term: String?
    ): CustomerPageEntity {
        return fineractCNApiManager.getCustomerApi().searchCustomer(pageIndex, size, term)
    }

    override suspend fun fetchCustomerDepositAccounts(
        customerIdentifier: String
    ): List<DepositAccountEntity> {
        return fineractCNApiManager.getDepositApi().fetchCustomerDeposits(customerIdentifier)
    }

    override suspend fun fetchDepositAccountDetails(accountIdentifier: String): DepositAccountEntity {
        return fineractCNApiManager.getDepositApi().fetchDepositAccountDetails(accountIdentifier)
    }

    override suspend fun fetchProductDetails(productIdentifier: String): ProductEntity {
        return fineractCNApiManager.getDepositApi().fetchProductDetails(productIdentifier)
    }

    override suspend fun createDepositAccount(
        depositAccountPayload: DepositAccountPayloadEntity
    ): HttpResponse {
        return fineractCNApiManager.getDepositApi()
            .createDepositAccount(depositAccountPayload)
    }

    override suspend fun fetchJournalEntries(
        dateRange: String,
        accountIdentifier: String
    ): List<JournalEntryEntity> {
        return fineractCNApiManager.getAccountingApi()
            .fetchJournalEntries(dateRange, accountIdentifier)
    }

    override suspend fun fetchJournalEntry(entryIdentifier: String): JournalEntryEntity {
        return fineractCNApiManager.getAccountingApi().fetchJournalEntry(entryIdentifier)
    }
}
