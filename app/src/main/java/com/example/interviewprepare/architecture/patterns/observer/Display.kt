package com.example.interviewprepare.architecture.patterns.observer

import android.util.Log

class Display(private val name: String) : Observer {
    override fun update(temperature: Float) {
        Log.e("Interview", "$name: Температура обновлена до $temperature°C")
    }
}