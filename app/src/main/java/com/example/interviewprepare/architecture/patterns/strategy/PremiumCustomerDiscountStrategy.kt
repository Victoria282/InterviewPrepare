package com.example.interviewprepare.architecture.patterns.strategy

class PremiumCustomerDiscountStrategy : DiscountStrategy {
    override fun calculateDiscount(book: Book): Double {
        return book.price * 0.2
    }
}