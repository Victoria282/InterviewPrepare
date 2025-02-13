package com.example.interviewprepare.architecture.patterns.prototype

/*
    Паттерн "Прототип" (Prototype) используется для создания новых объектов путем копирования
    существующих. Этот паттерн полезен, когда создание нового объекта является более затратным,
     чем копирование уже существующего.

    В Kotlin мы можем реализовать паттерн "Прототип" с помощью интерфейса, который
    будет определять метод для клонирования объектов.
 */
interface Prototype {
    fun clone(): Prototype
}

data class ConcretePrototype(var value: String) : Prototype {
    override fun clone(): Prototype = ConcretePrototype(value)
}

fun show() {
    val original = ConcretePrototype("Original Value")
    val cloned = original.clone() as ConcretePrototype

    cloned.value = "Cloned Value"
}