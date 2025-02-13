package com.example.interviewprepare.architecture.oop
/*
    Переиспользование, расширяемость, гибкость
    Ответственность принадлежит классам, отвечающим за какую-то логику;
 */

/*
    Инкапсуляция - скрытие деталей реализации.
    Предоставление те методы / данные, которым будет пользоваться пользователем.
    Остальное под капотом.
    Помогают модификаторы доступа;
    Скрытие реализации, и предоставление простого интерфейса для работы с объектом
    Помогает реализовать безопасность кода - нет вмешательства из вне;
 */

/*
    Наследование помогает создавать классы, на основе существующих.
    Не забываем ключевое слово open, делая возможность унаследоваться.
    Расширяется поведение родителей.
    С наследованием становится возможным полиморфизм, когда объекты дочерних классов
    считаются объектами родительского класса. Можем использовать generics;

 */

/*
    Полиморфизм, наследники одного класса, могут использовать методы родителя;
    Во время выполнения действия, выполняется соответствующая реализация;

    * одна функция определяется для различных типов данных.
    В классе прописывается несколько функций, которые принимают разные параметры

    * реализация через принцип подстановки Барбары Лисков
    Объект более узкого типа всегда может использоваться там, где
    может использоваться объект более широкого типа

    * программа может быть реализована через обобщенные типы.
    То есть без ориентации на конкретный тип

     Это означает, что один и тот же метод может вести себя по-разному в зависимости от
     объекта, который его вызывает. В Kotlin полиморфизм реализуется через наследование
     и интерфейсы.
 */
/*
    Абстракция
    В ООП абстракция достигается применением абстрактных классов и интерфейсов.
    Абстракция  это упрощенное представление сложных систем или идей с целью
    акцентирования внимания на существенных характеристиках объекта или системы за
    счет скрытия излишней сложности и деталей.
 */
fun oopExample() {
    val victoriaOrder = Order(BankTransfer())
    victoriaOrder.processPayment(282.0)

    val kotOrder = Order(CreditCard())
    kotOrder.processPayment(5.0)
}

interface PaymentMethod {
    val type: String
    fun pay(amount: Double)
}

class CreditCard : PaymentMethod {
    override val type: String = "CreditCard"
    override fun pay(amount: Double) {
        println("Payment completed with credit card.")
    }
}

class BankTransfer : PaymentMethod {
    override val type: String = "BankTransfer"
    override fun pay(amount: Double) {
        println("Payment completed with bank transfer")
    }
}

class Order(private val paymentMethod: PaymentMethod) {
    fun processPayment(amount: Double) {
        paymentMethod.pay(amount)
    }
}