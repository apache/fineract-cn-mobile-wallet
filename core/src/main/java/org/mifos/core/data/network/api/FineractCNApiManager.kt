package org.mifos.core.data.network.api

import io.ktor.client.*
import org.mifos.core.data.network.api.services.AccountingService
import org.mifos.core.data.network.api.services.AuthenticationService
import org.mifos.core.data.network.api.services.CustomerService
import org.mifos.core.data.network.api.services.DepositService
import org.mifos.core.utils.Constants

class FineractCNApiManager() {

    companion object {
        private lateinit var httpClient: HttpClient
        private lateinit var customerApi: CustomerService
        private lateinit var authenticationApi: AuthenticationService
        private lateinit var depositApi: DepositService
        private lateinit var accountingApi: AccountingService

        fun createAuthenticatedService(accessToken: String) {
            httpClient = KtorClientFactory(
                accessToken,
                Constants.TENANT, Constants.USER
            )
                .build()
            initialize()
        }

        private fun initialize() {
            customerApi = CustomerService(httpClient)
            authenticationApi = AuthenticationService(httpClient)
            depositApi = DepositService(httpClient)
            accountingApi = AccountingService(httpClient)
        }
    }

    fun getAuthenticationAPI(): AuthenticationService = authenticationApi

    fun getCustomerApi(): CustomerService = customerApi

    fun getDepositApi(): DepositService = depositApi

    fun getAccountingApi(): AccountingService = accountingApi
}