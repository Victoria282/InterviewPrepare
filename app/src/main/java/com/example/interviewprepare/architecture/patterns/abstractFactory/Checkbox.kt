package com.example.interviewprepare.architecture.patterns.abstractFactory

interface Checkbox {
    fun render()
}

class WindowsCheckbox : Checkbox {
    override fun render() {
        println("Рендеринг чекбокса в стиле Windows")
    }
}

class MacOSCheckbox : Checkbox {
    override fun render() {
        println("Рендеринг чекбокса в стиле MacOS")
    }
}