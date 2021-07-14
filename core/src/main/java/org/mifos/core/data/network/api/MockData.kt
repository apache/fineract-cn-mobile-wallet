package org.mifos.core.data.network.api

import org.mifos.core.domain.model.LoginResponse
import org.mifos.core.domain.model.customer.*
import org.mifos.core.domain.model.deposit.Currency
import org.mifos.core.domain.model.deposit.DepositAccount
import org.mifos.core.domain.model.deposit.DepositAccountPayload
import org.mifos.core.domain.model.deposit.Product
import org.mifos.core.domain.model.journal.Account
import org.mifos.core.domain.model.journal.JournalEntry

object MockData {

    //Mock JSON data
    const val loginResponseData = "{\n" +
            "  \"tokenType\" : \"token_type\",\n" +
            "  \"accessToken\" : \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9\",\n" +
            "  \"accessTokenExpiration\" : \"01-01-2022\",\n" +
            "  \"refreshTokenExpiration\" : \"31-12-2021\",\n" +
            "  \"passwordExpiration\" : \"01-02-2022\"\n" +
            "  }"

    const val customerData = "{\n" +
            "  \"identifier\" : \"idOne\",\n" +
            "  \"type\" : \"PERSON\",\n" +
            "  \"givenName\" : \"Kima\",\n" +
            "  \"middleName\" : \"Bessem\",\n" +
            "  \"surname\" : \"Ray\",\n" +
            "  \"dateOfBirth\" : {\n" +
            "    \"year\" : 2000,\n" +
            "    \"month\" : 6,\n" +
            "    \"day\" : 6\n" +
            "  },\n" +
            "  \"member\" : true,\n" +
            "  \"accountBeneficiary\" : \"Spouse\",\n" +
            "  \"referenceCustomer\" : \"mate\",\n" +
            "  \"assignedOffice\" : \"Oweh ViB\",\n" +
            "  \"assignedEmployee\" : \"Che Godwin\",\n" +
            "  \"address\" : {\n" +
            "    \"street\" : \"Hospital\",\n" +
            "    \"city\" : \"Muyuka\",\n" +
            "    \"region\" : \"SWR\",\n" +
            "    \"postalCode\" : \"8050\",\n" +
            "    \"countryCode\" : \"CM\",\n" +
            "    \"country\" : \"Cameroon\"\n" +
            "  },\n" +
            "  \"contactDetails\" : [ {\n" +
            "    \"type\" : \"MOBILE\",\n" +
            "    \"group\" : \"PRIVATE\",\n" +
            "    \"value\" : \"677777777\",\n" +
            "    \"preferenceLevel\" : 1,\n" +
            "    \"validated\" : false\n" +
            "  }, {\n" +
            "    \"type\" : \"PHONE\",\n" +
            "    \"group\" : \"BUSINESS\",\n" +
            "    \"value\" : \"233363640\",\n" +
            "    \"preferenceLevel\" : 2,\n" +
            "    \"validated\" : false\n" +
            "  } ],\n" +
            "  \"currentState\" : \"PENDING\",\n" +
            "  \"applicationDate\" : \"2017-07-19\",\n" +
            "  \"lastModifiedBy\" : \"Nakuve\",\n" +
            "  \"lastModifiedOn\" : \"2018-01-04\"\n" +
            "}"

    const val customerPageData = "{\n" +
            "  \"customers\" : [ {\n" +
            "    \"identifier\" : \"bencho\",\n" +
            "    \"type\" : \"PERSON\",\n" +
            "    \"givenName\" : \"Bencho\",\n" +
            "    \"middleName\" : \"Etah\",\n" +
            "    \"surname\" : \"Obi\",\n" +
            "    \"dateOfBirth\" : {\n" +
            "      \"year\" : 2000,\n" +
            "      \"month\" : 6,\n" +
            "      \"day\" : 6\n" +
            "    },\n" +
            "    \"member\" : true,\n" +
            "    \"accountBeneficiary\" : \"Spouse\",\n" +
            "    \"referenceCustomer\" : \"mate\",\n" +
            "    \"assignedOffice\" : \"Kah ViB\",\n" +
            "    \"assignedEmployee\" : \"Ebot Tabi\",\n" +
            "    \"address\" : null,\n" +
            "    \"contactDetails\" : null,\n" +
            "    \"currentState\" : \"PENDING\",\n" +
            "    \"applicationDate\" : \"2017-04-10\",\n" +
            "    \"customValues\" : null,\n" +
            "    \"createdBy\" : \"maatkare\",\n" +
            "    \"createdOn\" : \"2018-06-11T03:19:40.833Z\",\n" +
            "    \"lastModifiedBy\" : null,\n" +
            "    \"lastModifiedOn\" : null\n" +
            "  }, {\n" +
            "    \"identifier\" : \"meni\",\n" +
            "    \"type\" : \"PERSON\",\n" +
            "    \"givenName\" : \"Meni\",\n" +
            "    \"middleName\" : \"Richmond\",\n" +
            "    \"surname\" : \"Akom\",\n" +
            "    \"dateOfBirth\" : {\n" +
            "      \"year\" : 1997,\n" +
            "      \"month\" : 6,\n" +
            "      \"day\" : 5\n" +
            "    },\n" +
            "    \"member\" : true,\n" +
            "    \"accountBeneficiary\" : \"Spouse\",\n" +
            "    \"referenceCustomer\" : \"friend\",\n" +
            "    \"assignedOffice\" : \"Buea ViB\",\n" +
            "    \"assignedEmployee\" : \"Itoh Mih\",\n" +
            "    \"address\" : null,\n" +
            "    \"contactDetails\" : null,\n" +
            "    \"currentState\" : \"PENDING\",\n" +
            "    \"applicationDate\" : \"2018-02-18\",\n" +
            "    \"customValues\" : null,\n" +
            "    \"createdBy\" : \"maatkare\",\n" +
            "    \"createdOn\" : \"2018-06-11T03:19:40.732Z\",\n" +
            "    \"lastModifiedBy\" : null,\n" +
            "    \"lastModifiedOn\" : null\n" +
            "  } ],\n" +
            "  \"totalPages\" : 1,\n" +
            "  \"totalElements\" : 2\n" +
            "}"

    const val depositAccountListData = "{\n" +
            "  \"customerIdentifier\" : \"Customerg2h\",\n" +
            "  \"productIdentifier\" : \"pdtDefvoxw\",\n" +
            "  \"accountIdentifier\" : \"Customerg2h.91xx.00001\",\n" +
            "  \"beneficiaries\" : [ \"BenefiaryqTR\", \"Benefiary7F8\" ],\n" +
            "  \"state\" : \"PENDING\",\n" +
            "  \"balance\" : null\n" +
            "}"

    const val productData = "{\n" +
            "  \"type\" : \"SAVINGS\",\n" +
            "  \"identifier\" : \"pdtDeflpjB\",\n" +
            "  \"name\" : \"PdtName cEJcHN\",\n" +
            "  \"description\" : \"PdtName cEJcHN\",\n" +
            "  \"currency\" : {\n" +
            "    \"code\" : \"USD\",\n" +
            "    \"name\" : \"US Dollar\",\n" +
            "    \"sign\" : \"\$\",\n" +
            "    \"scale\" : 3\n" +
            "  },\n" +
            "  \"minimumBalance\" : 50.0\n" +
            "}"

    const val journalEntryData = "{\n" +
            "  \"transactionIdentifier\" : \"F14062018\",\n" +
            "  \"transactionDate\" : \"2018-06-14\",\n" +
            "  \"transactionType\" : \"ADBT\",\n" +
            "  \"clerk\" : \"Boring Clerk\",\n" +
            "  \"note\" : \"Account Db\",\n" +
            "  \"debtors\" : [ {\n" +
            "    \"accountNumber\" : \"7100\",\n" +
            "    \"amount\" : \"100.0\"\n" +
            "  } ],\n" +
            "  \"creditors\" : [ {\n" +
            "    \"accountNumber\" : \"Uhiquy7GGFvuMTDxHTfp6oOEuMEBQCFt\",\n" +
            "    \"amount\" : \"100.0\"\n" +
            "  } ],\n" +
            "  \"message\" : \"Account Has Been Debited\"\n" +
            "}"

    //Mock models for tests
    val loginResponseModel = LoginResponse(
        "token_type",
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9",
        "01-01-2022", "31-12-2021", "01-02-2022"
    )

    val customerModel = Customer(
        "idOne",
        Customer.Type.PERSON,
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
        Customer.State.PENDING,
        "2017-07-19",
        lastModifiedBy = "Nakuve",
        lastModifiedOn = "2018-01-04"
    )

    val customerPageModel = CustomerPage(
        listOf(
            Customer(
                "bencho",
                Customer.Type.PERSON,
                "Bencho",
                "Etah",
                "Obi",
                DateOfBirth(2000, 6, 6),
                true,
                "Spouse",
                "mate",
                "Kah ViB",
                "Ebot Tabi",
                currentState = Customer.State.PENDING,
                applicationDate = "2017-04-10",
                createdBy = "maatkare",
                createdOn = "2018-06-11T03:19:40.833Z"
            ), Customer(
                "meni",
                Customer.Type.PERSON,
                "Meni",
                "Richmond",
                "Akom",
                DateOfBirth(year = 1997, month = 6, day = 5),
                true,
                "Spouse",
                "friend",
                "Buea ViB",
                "Itoh Mih",
                currentState = Customer.State.PENDING,
                applicationDate = "2018-02-18",
                createdBy = "maatkare",
                createdOn = "2018-06-11T03:19:40.732Z"
            )
        ),
        totalPages = 1,
        totalElements = 2
    )

    val depositAccountPayloadModel = DepositAccountPayload(
        "Customerg2h",
        "pdtDefvoxw",
        listOf("BenefiaryqTR", "Benefiary7F8")
    )

    val depositAccountModel = DepositAccount(
        "Customerg2h",
        "pdtDefvoxw",
        "Customerg2h.91xx.00001",
        listOf("BenefiaryqTR", "Benefiary7F8"),
        DepositAccount.State.PENDING
    )

    val productModel = Product(
        "SAVINGS",
        "pdtDeflpjB",
        "PdtName cEJcHN",
        "PdtName cEJcHN",
        Currency("USD", "US Dollar", "$", 3),
        50.0
    )

    val journalEntryModel = JournalEntry(
        "F14062018",
        "2018-06-14",
        "ADBT",
        "Boring Clerk",
        "Account Db",
        listOf(Account("7100", "100.0")),
        listOf(Account("Uhiquy7GGFvuMTDxHTfp6oOEuMEBQCFt", "100.0")),
        message = "Account Has Been Debited"
    )

    //Mock values for tests
    const val successIdentifier = "successIdentifier"
    const val errorIdentifier = "errorIdentifier"
    const val accepted = "Accepted"
    const val dataError = "Data is not valid"
    const val testDateRange = "2018-06-14_2018-12-14"

    //url list for handling requests through mock ktor client
    const val authUrl = "http://buffalo.mifos.io:4200/api/identity/v1/token?" +
            "grant_type=grantType&username=userName&password=password"
    const val createCustomerUrl = "http://buffalo.mifos.io:4200/api/api/customer/v1/customers"
    const val fetchCustomerUrl =
        "http://buffalo.mifos.io:4200/api/api/customer/v1/customers/successIdentifier"
    const val fetchCustomersUrl =
        "http://buffalo.mifos.io:4200/api/api/customer/v1/customers?pageIndex=1&size=2"
    const val updateCustomerUrl = "http://buffalo.mifos.io:4200/api/api/customer/v1/customers/idOne"
    const val createDepositAccountUrl = "http://buffalo.mifos.io:4200/api/api/deposit/v1/instances"
    const val fetchDepositAccountsUrl =
        "http://buffalo.mifos.io:4200/api/api/deposit/v1/instances?customer=successIdentifier"
    const val fetchDepositAccountUrl =
        "http://buffalo.mifos.io:4200/api/api/deposit/v1/instances/successIdentifier"
    const val fetchProductUrl =
        "http://buffalo.mifos.io:4200/api/api/deposit/v1/definitions/successIdentifier"
    const val fetchJournalEntryUrl =
        "http://buffalo.mifos.io:4200/api/api/accounting/v1/journal/successIdentifier"
    const val fetchJournalEntriesUrl =
        "http://buffalo.mifos.io:4200/api/api/accounting/v1/journal?" +
                "dateRange=2018-06-14_2018-12-14&account=successIdentifier"
}