package org.mifos.core.utils

import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

typealias Mapper<I, O> = (I) -> O

class EntityModelMapper<I : Any, O : Any>(
    private val inType: KClass<I>,
    private val outType: KClass<O>
) : Mapper<I, O> {

    private val inPropertiesByName by lazy { inType.memberProperties.associateBy { it.name } }
    private val outConstructor = outType.primaryConstructor!!
    val fieldMappers = mutableMapOf<String, Mapper<Any, Any>>()

    companion object {
        inline operator fun <reified I : Any, reified O : Any> invoke() =
            EntityModelMapper(I::class, O::class)

        fun <I : Any, O : Any> listMapper(mapper: Mapper<I, O>) =
            object : Mapper<List<I>, List<O>> {
                override fun invoke(data: List<I>): List<O> = data.map(mapper)
            }
    }

    inline fun <reified K : Any, reified V : Any> register(
        parameterName: String,
        crossinline mapper: Mapper<K, V>
    ): EntityModelMapper<I, O> = apply {
        this.fieldMappers[parameterName] = object : Mapper<Any, Any> {
            override fun invoke(data: Any): Any = mapper.invoke(data as K)
        }
    }

    private fun map(parameter: KParameter, data: I): Any? {
        val value = inPropertiesByName[parameter.name]?.get(data) ?: return null

        return fieldMappers[parameter.name]?.invoke(value) ?: value
    }

    override fun invoke(data: I): O = with(outConstructor) {
        callBy(parameters.associateWith { map(it, data) })
    }
}

data class DateOfBirth(
    val year: Int? = null,
    val month: Int? = null,
    val day: Int? = null,
    val acc: List<Account>? = null
)

data class Account(
    val accountNumber: String? = null,
    val amount: String? = null
)

data class DateOfBirthModel(
    val year: Int? = null,
    val month: Int? = null,
    val day: Int? = null,
    val acc: List<AccountModel>? = null
)

data class AccountModel(
    val accountNumber: String? = null,
    val amount: String? = null
)

fun main() {
    val accMapper = EntityModelMapper<Account, AccountModel>()
    val mapper = EntityModelMapper<DateOfBirth, DateOfBirthModel>().register(
        "acc",
        EntityModelMapper.listMapper(accMapper)
    )
    val model =
        mapper(DateOfBirth(2021, 5, 21, listOf(Account("1234", "400"), Account("5678", "500"))))
    println(model)
    println(model.year)
    println(model.month)
    println(model.acc?.get(1)?.accountNumber)
}