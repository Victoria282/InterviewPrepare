package com.example.interviewprepare

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.example.interviewprepare.collections.CollectionsUtils
import com.example.interviewprepare.strings.StringUtils
import com.example.interviewprepare.ui.theme.InterviewPrepareTheme

class MainActivity : ComponentActivity() {

    /*
        https://clouddevs.com/kotlin/design-patterns/
     */

    /*
        https://carrion.dev/en/posts/design-patterns-1/
     */

    private var girl: String = ""
        get() = field.toUpperCase(Locale.current)
        set(value) {
            field = "Имя - $value"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        showBuilder()
        showFactory()
        showStrategy()
        showSingleton()
        showDecorator()
        showObserver()
        setContent {
            InterviewPrepareTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        val woman = User("Victoria", 24)
        val woman2 = User("Victoria", 24)
        val man = User("Ilya", 30)

        Log.e("Interview", "woman == is ${woman == woman2}")
        Log.e("Interview", "woman equals is ${woman.equals(woman2)}")
        Log.e("Interview", "woman === is ${woman === woman2}")

        Log.e("Interview", "woman == man is ${woman == man}")
        Log.e("Interview", "woman equals man is ${woman.equals(man)}")
        Log.e("Interview", "woman === man is ${woman === man}")

        StringUtils()
        CollectionsUtils()
    }
}
data class User(
    val name: String,
    val age: Int
)

fun showBuilder() {
    val car = com.example.interviewprepare.architecture.patterns.builder.CarBuilder()
        .setColor("Black")
        .setBrand("audi")
        .setYear("2025")
        .setModel("Q7")
        .build()
    Log.e("Interview", "$car")
}

fun showFactory() {
    val dog = com.example.interviewprepare.architecture.patterns.factory.AnimalFactory()
        .createAnimal(com.example.interviewprepare.architecture.patterns.factory.Animals.DOG)
    dog.voice()
}

fun showStrategy() {
    val customer = com.example.interviewprepare.architecture.patterns.strategy.Customer(
        name = "Victoria",
        membershipType = com.example.interviewprepare.architecture.patterns.strategy.MembershipType.PREMIUM
    )
    val book = com.example.interviewprepare.architecture.patterns.strategy.Book(
        "War and Peace",
        1000.0
    )
    val discountStrategy = createDiscountCalculator(customer)
    val discountOfBook = discountStrategy.calculateDiscount(book)
    Log.e("Interview", "discountOfBook= ${discountOfBook}")
}

private fun createDiscountCalculator(customer: com.example.interviewprepare.architecture.patterns.strategy.Customer): com.example.interviewprepare.architecture.patterns.strategy.DiscountCalculator {
    val discountStrategy = when (customer.membershipType) {
        com.example.interviewprepare.architecture.patterns.strategy.MembershipType.REGULAR -> com.example.interviewprepare.architecture.patterns.strategy.RegularCustomerDiscountStrategy()
        com.example.interviewprepare.architecture.patterns.strategy.MembershipType.PREMIUM -> com.example.interviewprepare.architecture.patterns.strategy.PremiumCustomerDiscountStrategy()
    }

    return com.example.interviewprepare.architecture.patterns.strategy.DiscountCalculator(
        discountStrategy
    )
}

private fun showSingleton() {
    Log.e(
        "Interview",
        com.example.interviewprepare.architecture.patterns.singleton.Singleton.someProperty
    )
    com.example.interviewprepare.architecture.patterns.singleton.Singleton.doSomething()

    com.example.interviewprepare.architecture.patterns.singleton.Singleton.someProperty =
        "Updated Value"
    com.example.interviewprepare.architecture.patterns.singleton.Singleton.doSomething()
}

private fun showDecorator() {
    val coffee = com.example.interviewprepare.architecture.patterns.decorator.SimpleCoffee()
    Log.e("Interview", "coffee= ${coffee.cost()}; ${coffee.ingredients()}")

    val coffeeWithMilk =
        com.example.interviewprepare.architecture.patterns.decorator.MilkDecorator(coffee)
    Log.e("Interview", "coffeeWithMilk= ${coffeeWithMilk.cost()}; ${coffeeWithMilk.ingredients()}")
}

private fun showObserver() {
    val weatherStation =
        com.example.interviewprepare.architecture.patterns.observer.WeatherStation()

    val display1 = com.example.interviewprepare.architecture.patterns.observer.Display("Дисплей 1")
    val display2 = com.example.interviewprepare.architecture.patterns.observer.Display("Дисплей 2")

    weatherStation.addObserver(display1)
    weatherStation.addObserver(display2)

    weatherStation.setTemperature(25.0f)
    weatherStation.setTemperature(30.5f)

    weatherStation.removeObserver(display1)

    weatherStation.setTemperature(28.0f)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InterviewPrepareTheme {
        Greeting("Android")
    }
}