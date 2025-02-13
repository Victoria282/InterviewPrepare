package com.example.interviewprepare.architecture.solid

/*
    Принцип подстановки Барбары Лисков является очень важным в ООП.
    Он говорит нам что если наша программа работает с некоторым объектом,
    то мы должны быть способны использовать любой его подтип без каких-либо проблем.
    Это значит что все методы и свойство основного класса должны также работать
    для всех его под-классов без необходимости что-либо изменять.
 */

/*
    Нарушение
 */
open class Bird {
    open fun fly() {}
}

class Penguin : Bird() {
    override fun fly() {
        print("Penguins can't fly!")
    }
}

open class Animal

interface AbleToFly {
    fun fly()
}

class Qiwi : Animal() {

}

class Pigeon : Animal(), AbleToFly {
    override fun fly() {

    }
}

fun LiskovSubstitutions() {
    val bird: AbleToFly = Pigeon()
    bird.fly()
}