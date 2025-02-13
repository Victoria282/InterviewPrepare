package com.example.interviewprepare.architecture.patterns.decorator

class MilkDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun cost(): Double = super.cost() + 0.5

    override fun ingredients(): String = super.ingredients() + ", Milk"
}