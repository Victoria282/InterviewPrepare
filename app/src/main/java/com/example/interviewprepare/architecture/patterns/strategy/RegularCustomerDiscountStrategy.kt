package com.example.interviewprepare.architecture.patterns.strategy

class RegularCustomerDiscountStrategy : DiscountStrategy {
    override fun calculateDiscount(book: Book): Double {
        return book.price * 0.1
    }
}