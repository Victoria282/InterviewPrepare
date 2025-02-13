package com.example.interviewprepare.architecture.patterns.abstractFactory

interface Button {
    fun render()
}

class WindowsButton : Button {
    override fun render() {
        println("Рендеринг кнопки в стиле Windows")
    }
}

class MacOSButton : Button {
    override fun render() {
        println("Рендеринг кнопки в стиле MacOS")
    }
}