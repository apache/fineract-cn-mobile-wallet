package org.mifos.core

import org.mifos.core.data.network.api.FineractCNApiManager
import org.mifos.core.utils.Constants

class MockFineractCNApiManager : FineractCNApiManager() {
    override fun createAuthenticatedService(accessToken: String) {
        httpClient = KtorMockClient(
            accessToken,
            Constants.TENANT, Constants.USER
        )
            .build()
        initialize()
    }
}
