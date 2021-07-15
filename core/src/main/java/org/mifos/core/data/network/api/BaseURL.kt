package org.mifos.core.data.network.api

object BaseURL {
    private const val API_ENDPOINT = "buffalo.mifos.io"
    private const val PORT = "4200"
    private const val API_PATH = "/api"

    val baseURL: String
        get() = "$API_ENDPOINT:$PORT$API_PATH"
}
