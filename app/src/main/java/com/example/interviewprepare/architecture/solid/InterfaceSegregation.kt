package com.example.interviewprepare.architecture.solid

/*
    Принцип разделения интерфейсов говорит нам о том, что когда мы разрабатываем
    разные части программы, нам не следует их все помещать в одно место.
    Наоборот, лучшим подходом будет сделать их небольшими и более подходящими под
     конкретную задачу, чтобы избавиться от лишней связанности между частями приложения
 */

/*
    Нарушение
 */

interface AnimalInterface {
    fun swim()
    fun fly()
}

class Duck : AnimalInterface {
    override fun swim() {
        println("Duck swimming")
    }

    override fun fly() {
        println("Duck flying")
    }
}

class Pinguin : AnimalInterface {
    override fun swim() {
        println("Penguin swimming")
    }

    override fun fly() {
        throw UnsupportedOperationException("Penguin cannot fly")
    }
}

/*
    Решение
 */

interface CanSwim {
    fun swim()
}

interface CanFly {
    fun fly()
}

class InterfaceSegregation {
}