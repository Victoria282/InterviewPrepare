package com.example.interviewprepare.architecture.patterns.abstractFactory

fun show() {
    val factory: GUIFactory = WindowsFactory()
    val button = factory.createButton()
    val checkbox = factory.createCheckbox()
    button.render()
    checkbox.render()
}