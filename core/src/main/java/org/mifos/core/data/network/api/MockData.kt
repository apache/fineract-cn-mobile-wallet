package org.mifos.core.data.network.api

import org.mifos.core.domain.model.LoginResponse
import org.mifos.core.domain.model.customer.Address
import org.mifos.core.domain.model.customer.ContactDetail
import org.mifos.core.domain.model.customer.Customer
import org.mifos.core.domain.model.customer.DateOfBirth

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

    val CustomerData = Customer(
        "idOne",
        org.mifos.core.domain.model.customer.Customer.Type.PERSON,
        "Kima",
        "Bessem",
        "Ray",
        DateOfBirth(2000, 6, 6),
        true,
        "Spouse",
        "mate",
        "Oweh ViB",
        "Che Godwin",
        Address("Hospital", "Muyuka", "SWR", "8050", "CM", "Cameroon"),
        listOf(
            ContactDetail(
                ContactDetail.Type.MOBILE,
                ContactDetail.Group.PRIVATE,
                "677777777",
                1,
                false
            ),
            ContactDetail(
                ContactDetail.Type.PHONE,
                ContactDetail.Group.BUSINESS,
                "233363640",
                2,
                false
            )
        ),
        org.mifos.core.domain.model.customer.Customer.State.PENDING,
        "2017-07-19",
        lastModifiedBy = "Nakuve",
        lastModifiedOn = "2018-01-04"
    )

    //url list for handling requests through mock ktor client
    const val authUrl = "http://buffalo.mifos.io:4200/api/identity/v1/token?" +
            "grant_type=grantType&username=userName&password=password"
    const val createCustomerUrl = "http://buffalo.mifos.io:4200/api/api/customer/v1/customers"
}