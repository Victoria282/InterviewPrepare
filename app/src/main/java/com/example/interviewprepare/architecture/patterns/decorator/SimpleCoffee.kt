package com.example.interviewprepare.architecture.patterns.decorator

class SimpleCoffee : Coffee {
    override fun cost(): Double = 2.0

    override fun ingredients(): String = "Coffee"
}