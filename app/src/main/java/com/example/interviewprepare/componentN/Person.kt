package com.example.interviewprepare.delegate.componentN

import androidx.compose.ui.graphics.drawscope.Stroke

data class PersonDataClass(
    val country: String,
    val name: String
)

class PersonClass(private val country: String, private val name: String) {
    operator fun component1() = country
    operator fun component2() = name
}

fun showComponentN() {
    val girl = PersonDataClass("Russia", "Victoria")
    val man = PersonClass("USA", "Dima")
    girl.component1()
    girl.component2()

    man.component1()
    man.component2()
}