package com.example.interviewprepare.architecture.patterns.strategy

class DiscountCalculator(private val discountStrategy: DiscountStrategy) {
    fun calculateDiscount(book: Book): Double = discountStrategy.calculateDiscount(book)
}