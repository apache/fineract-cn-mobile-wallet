package org.mifos.core

import org.mifos.core.domain.model.LoginResponse

object MockData {

    //Mock JSON data
    const val loginData = "{\n" +
            "  \"tokenType\" : \"token_type\",\n" +
            "  \"accessToken\" : \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9\",\n" +
            "  \"accessTokenExpiration\" : \"01-01-2022\",\n" +
            "  \"refreshTokenExpiration\" : \"31-12-2021\",\n" +
            "  \"passwordExpiration\" : \"01-02-2022\"\n" +
            "  }"

    //Mock models for tests
    val loginResponse = LoginResponse(
        "token_type",
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9",
        "01-01-2022", "31-12-2021", "01-02-2022"
    )

    //url list for handling requests through mock ktor client
    const val url1 = "http://buffalo.mifos.io:4200/api/identity/v1/token?" +
            "grant_type=grantType&username=userName&password=password"
}