package com.example.interviewprepare.architecture.patterns.abstractFactory

/*
    Паттерн Factory Method позволяет создавать объекты, не указывая конкретный класс
    создаваемого объекта. Вместо этого используется интерфейс или абстрактный класс для
    создания объектов.
 */

/*
    Паттерн Abstract Factory предоставляет интерфейс для создания семейств связанных
    или зависимых объектов без указания их конкретных классов. Он позволяет создавать
    более сложные структуры, которые могут включать несколько продуктов.
 */
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

class WindowsFactory : GUIFactory {
    override fun createButton(): Button = WindowsButton()
    override fun createCheckbox(): Checkbox = WindowsCheckbox()
}

class MacOSFactory : GUIFactory {
    override fun createButton(): Button = MacOSButton()
    override fun createCheckbox(): Checkbox = MacOSCheckbox()
}