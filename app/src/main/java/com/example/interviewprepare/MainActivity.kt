package com.example.interviewprepare

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.interviewprepare.app.screens.ListScreen
import com.example.interviewprepare.app.vm.ActivityViewModel
import com.example.interviewprepare.architecture.patterns.builder.CarBuilder
import com.example.interviewprepare.architecture.patterns.decorator.MilkDecorator
import com.example.interviewprepare.architecture.patterns.decorator.SimpleCoffee
import com.example.interviewprepare.architecture.patterns.factory.AnimalFactory
import com.example.interviewprepare.architecture.patterns.factory.Animals
import com.example.interviewprepare.architecture.patterns.observer.Display
import com.example.interviewprepare.architecture.patterns.observer.WeatherStation
import com.example.interviewprepare.architecture.patterns.singleton.Singleton
import com.example.interviewprepare.architecture.patterns.strategy.Customer
import com.example.interviewprepare.architecture.patterns.strategy.DiscountCalculator
import com.example.interviewprepare.architecture.patterns.strategy.MembershipType
import com.example.interviewprepare.architecture.patterns.strategy.PremiumCustomerDiscountStrategy
import com.example.interviewprepare.architecture.patterns.strategy.RegularCustomerDiscountStrategy
import com.example.interviewprepare.ui.theme.InterviewPrepareTheme

class MainActivity : ComponentActivity() {

    /*
        https://clouddevs.com/kotlin/design-patterns/
     */

    /*
        https://carrion.dev/en/posts/design-patterns-1/
     */

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
                Content()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content() {
        val viewModel: ActivityViewModel = viewModel(factory = ActivityViewModel.factory)
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = {
                    Text(text = stringResource(R.string.app_name))
                })
            }
        ) {
            Surface(modifier = Modifier
                .fillMaxSize()
                .padding(it)) {
                ListScreen(
                    viewModel.booksUiState, retryAction = {
                        viewModel.getBooks("book")
                    },
                    Modifier
                )
            }
        }
    }

    fun showBuilder() {
        val car = CarBuilder()
            .setColor("Black")
            .setBrand("audi")
            .setYear("2025")
            .setModel("Q7")
            .build()
        Log.e("Interview", "$car")
    }

    fun showFactory() = AnimalFactory().createAnimal(Animals.DOG).voice()

    fun showStrategy() {
        val customer = Customer(
            name = "Victoria",
            membershipType = MembershipType.PREMIUM
        )
        val book = com.example.interviewprepare.architecture.patterns.strategy.Book(
            "War and Peace",
            1000.0
        )
        val discountStrategy = createDiscountCalculator(customer)
        val discountOfBook = discountStrategy.calculateDiscount(book)
        Log.e("Interview", "discountOfBook= ${discountOfBook}")
    }

    private fun createDiscountCalculator(customer: Customer): DiscountCalculator {
        val discountStrategy = when (customer.membershipType) {
            MembershipType.REGULAR -> RegularCustomerDiscountStrategy()
            MembershipType.PREMIUM -> PremiumCustomerDiscountStrategy()
        }

        return DiscountCalculator(discountStrategy)
    }

    private fun showSingleton() {
        Log.e("Interview", Singleton.someProperty)
        Singleton.doSomething()
        Singleton.someProperty = "Updated Value"
        Singleton.doSomething()
    }

    private fun showDecorator() {
        val coffee = SimpleCoffee()
        Log.e("Interview", "coffee= ${coffee.cost()}; ${coffee.ingredients()}")

        val coffeeWithMilk = MilkDecorator(coffee)
        Log.e(
            "Interview",
            "coffeeWithMilk= ${coffeeWithMilk.cost()}; ${coffeeWithMilk.ingredients()}"
        )
    }

    private fun showObserver() {
        val weatherStation = WeatherStation()

        val display1 = Display("Дисплей 1")
        val display2 = Display("Дисплей 2")

        weatherStation.addObserver(display1)
        weatherStation.addObserver(display2)

        weatherStation.setTemperature(25.0f)
        weatherStation.setTemperature(30.5f)

        weatherStation.removeObserver(display1)

        weatherStation.setTemperature(28.0f)
    }
}