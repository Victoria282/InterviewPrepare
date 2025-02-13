package com.example.interviewprepare.scope

import android.content.Context
import android.util.Log
import android.widget.Button
import com.example.interviewprepare.R

fun scopeExample(context: Context) {

    val name: String? = null

    name?.let { Log.e("Interview", "$it not null") }

    val result: Int = run {
        val a = 5
        val b = 10
        a + b
    }
    Log.e("Interview", "$result")

    val button = Button(context)
    button.apply {
        this.text = "Применить"
        this.setTextColor(context.getColor(R.color.purple_700))
    }

    val person = object {
        val personName = "Виктория"
        val age = "24"
    }
    with(person) {
        Log.e("Interview", "Имя $personName, возраст - $age;")
    }

    val number = mutableListOf(1, 2, 3).also {
        it.add(4)
    }
    Log.e("Interview", "$number")
}