package com.example.interviewprepare.architecture.patterns.observer

class WeatherStation {
    private val observers = mutableListOf<Observer>()
    private var temperature: Float = 0f

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    fun setTemperature(newTemperature: Float) {
        temperature = newTemperature
        notifyObservers()
    }

    private fun notifyObservers() {
        for (observer in observers) observer.update(temperature)
    }
}