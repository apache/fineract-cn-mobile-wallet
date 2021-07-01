package org.mifos.core.data.repository

import org.mifos.core.data.network.entity.LoginResponseEntity
import org.mifos.core.data.network.entity.customer.*
import org.mifos.core.data.network.entity.deposit.DepositAccountEntity
import org.mifos.core.data.network.entity.deposit.DepositAccountPayloadEntity
import org.mifos.core.data.network.entity.deposit.ProductEntity
import org.mifos.core.data.network.entity.journal.AccountEntity
import org.mifos.core.data.network.entity.journal.JournalEntryEntity
import org.mifos.core.domain.model.LoginResponse
import org.mifos.core.domain.model.customer.*
import org.mifos.core.domain.model.deposit.Currency
import org.mifos.core.domain.model.deposit.DepositAccount
import org.mifos.core.domain.model.deposit.DepositAccountPayload
import org.mifos.core.domain.model.deposit.Product
import org.mifos.core.domain.model.journal.Account
import org.mifos.core.domain.model.journal.JournalEntry
import org.mifos.core.utils.EntityModelMapper

object Mappers {

    // Model<->Entity mappers starts
    val loginResponseMapper by lazy {
        EntityModelMapper<LoginResponseEntity, LoginResponse>()
    }

    private val addressEntityMapper by lazy { EntityModelMapper<Address, AddressEntity>() }
    private val contactDetailTypeEntityMapper by lazy {
        EntityModelMapper<ContactDetail.Type, ContactDetailEntity.Type>()
    }
    private val contactDetailGroupEntityMapper by lazy {
        EntityModelMapper<ContactDetail.Group, ContactDetailEntity.Group>()
    }
    private val contactDetailEntityMapper by lazy {
        EntityModelMapper<ContactDetail, ContactDetailEntity>()
            .register("type", contactDetailTypeEntityMapper)
            .register("group", contactDetailGroupEntityMapper)
    }
    private val dateOfBirthEntityMapper by lazy {
        EntityModelMapper<DateOfBirth, DateOfBirthEntity>()
    }
    private val customerTypeEntityMapper by lazy {
        EntityModelMapper<Customer.Type, CustomerEntity.Type>()
    }
    private val customerStateEntityMapper by lazy {
        EntityModelMapper<Customer.State, CustomerEntity.State>()
    }
    val customerEntityMapper by lazy {
        EntityModelMapper<Customer, CustomerEntity>()
            .register("type", customerTypeEntityMapper)
            .register("currentState", customerStateEntityMapper)
            .register("dateOfBirth", dateOfBirthEntityMapper)
            .register("address", addressEntityMapper)
            .register(
                "contactDetails", EntityModelMapper
                    .listMapper(contactDetailEntityMapper)
            )
    }

    private val addressMapper by lazy { EntityModelMapper<AddressEntity, Address>() }
    private val contactDetailTypeMapper by lazy {
        EntityModelMapper<ContactDetailEntity.Type, ContactDetail.Type>()
    }
    private val contactDetailGroupMapper by lazy {
        EntityModelMapper<ContactDetailEntity.Group, ContactDetail.Group>()
    }
    private val contactDetailMapper by lazy {
        EntityModelMapper<ContactDetailEntity, ContactDetail>()
            .register("type", contactDetailTypeMapper)
            .register("group", contactDetailGroupMapper)
    }
    private val dateOfBirthMapper by lazy {
        EntityModelMapper<DateOfBirthEntity, DateOfBirth>()
    }
    private val customerTypeMapper by lazy {
        EntityModelMapper<CustomerEntity.Type, Customer.Type>()
    }
    private val customerStateMapper by lazy {
        EntityModelMapper<CustomerEntity.State, Customer.State>()
    }
    val customerMapper by lazy {
        EntityModelMapper<CustomerEntity, Customer>()
            .register("type", customerTypeMapper)
            .register("currentState", customerStateMapper)
            .register("dateOfBirth", dateOfBirthMapper)
            .register("address", addressMapper)
            .register(
                "contactDetails", EntityModelMapper
                    .listMapper(contactDetailMapper)
            )
    }
    val customerPageMapper by lazy {
        EntityModelMapper<CustomerPageEntity, CustomerPage>().register(
            "customers", EntityModelMapper.listMapper(customerMapper)
        )
    }

    private val depositAccountStateMapper by lazy {
        EntityModelMapper<DepositAccountEntity.State, DepositAccount.State>()
    }
    val depositAccountMapper by lazy {
        EntityModelMapper<DepositAccountEntity, DepositAccount>()
            .register("state", depositAccountStateMapper)
    }
    val depositAccountListMapper by lazy {
        EntityModelMapper.listMapper(depositAccountMapper)
    }
    val depositAccountPayloadEntityMapper by lazy {
        EntityModelMapper<DepositAccountPayload, DepositAccountPayloadEntity>()
    }
    private val currencyMapper by lazy { EntityModelMapper<CustomerEntity, Currency>() }
    val productMapper by lazy {
        EntityModelMapper<ProductEntity, Product>().register(
            "currency",
            currencyMapper
        )
    }

    private val accountMapper by lazy { EntityModelMapper<AccountEntity, Account>() }
    private val journalEntryStateMapper by lazy {
        EntityModelMapper<JournalEntryEntity.State, JournalEntry.State>()
    }
    val journalEntryMapper by lazy {
        EntityModelMapper<JournalEntryEntity, JournalEntry>()
            .register("debtors", EntityModelMapper.listMapper(accountMapper))
            .register("creditors", EntityModelMapper.listMapper(accountMapper))
            .register("state", journalEntryStateMapper)
    }
    val journalEntryListMapper by lazy { EntityModelMapper.listMapper(journalEntryMapper) }
    // Model<->Entity mappers ends
}