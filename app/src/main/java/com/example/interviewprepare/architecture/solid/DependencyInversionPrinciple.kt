package com.example.interviewprepare.architecture.solid

/*
    Принцип инверсии зависимостей говорит нам о том, что модули верхних уровней
    не должны зависеть от модулей нижних уровней, оба типа модулей должны зависеть
    от абстракций, а не конкретных реализаций.
 */
/*
    Нарушение
 */
class PaymentService {
    private val paymentProcessorPaypal = PaypalPaymentProcessor()
    private val paymentProcessorStripe = StripePaymentProcessor()

    fun processPaymentWithPaypal(amount: Double): Boolean {
        return paymentProcessorPaypal.processPayment(amount)
    }

    fun processPaymentWithStripe(amount: Double): Boolean {
        return paymentProcessorStripe.processPayment(amount)
    }
}

class PaypalPaymentProcessor {
    fun processPayment(amount: Double): Boolean {
        // Process payment via Paypal API
        return true
    }
}

class StripePaymentProcessor {
    fun processPayment(amount: Double): Boolean {
        // Process payment via Stripe API
        return true
    }
}

/*
    Решение
 */
interface PaymentProcessor {
    fun processPayment(amount: Double): Boolean
}
class PaypalProcessor: PaymentProcessor {
    override fun processPayment(amount: Double): Boolean {
        return true
    }
}

class StripeProcessor: PaymentProcessor {
    override fun processPayment(amount: Double): Boolean {
        return true
    }
}

class PayService(val paymentProcessor: PaymentProcessor) {
    fun makePay(amount: Double) = paymentProcessor.processPayment(amount)
}

/*
    Как итог мы можем сказать, что SOLID принципы являются необходимыми для
    создания поддерживаемого, масштабируемого и эффективного кода на Kotlin.
 */
fun DependencyInversionPrinciple() {
    val paymentService = PaymentService()
    val t1 = paymentService.processPaymentWithPaypal(50.0)
    // Process payment via Paypal API
    val t2 = paymentService.processPaymentWithStripe(50.0)
    // Process payment via Stripe API

    val paypalProcessor = PaypalProcessor()
    val stripeProcessor = StripeProcessor()

    val service = PayService(paypalProcessor)
    service.makePay(282.0)
}