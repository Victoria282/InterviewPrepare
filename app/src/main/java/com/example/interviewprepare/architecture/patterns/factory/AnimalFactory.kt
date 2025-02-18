package com.example.interviewprepare.architecture.patterns.factory

/*
    Паттерн "Фабрика" используется для создания объектов.
    Этот паттерн помогает отделить создание объектов от их использования, что
    позволяет сделать код более гибким и удобным для расширения.

    ▎Плюсы паттерна "Фабрика":

    1. Инкапсуляция создания объектов:
    Фабрика скрывает детали создания объектов, что позволяет изменять логику
    создания без изменения кода, который использует эти объекты.

    2. Упрощение кода:
    Код становится чище и проще для понимания, так как логика создания объектов
    вынесена в отдельное место.

    3. Гибкость и расширяемость:
    Легко добавлять новые классы без изменения существующего кода.
    Например, если нужно добавить новый тип продукта, можно просто создать новый класс и обновить фабрику.

    4. Поддержка различных типов объектов:
    Фабрика может создавать объекты разных типов, что позволяет использовать один
    интерфейс для работы с различными реализациями.

    ▎Минусы паттерна "Фабрика":

    1. Сложность:
    Введение фабрики может добавить дополнительный уровень сложности,
    особенно для небольших проектов, где простое создание объектов было бы более уместным.

    4. Зависимость от интерфейсов:
    Для использования фабрики часто необходимо создавать интерфейсы или
    абстрактные классы, что может увеличить количество классов в проекте.


    Паттерн "Фабрика" нужен для:
    • Разделения ответственности между созданием и использованием объектов.
    • Упрощения управления зависимостями в приложении.
    • Позволяет легко изменять и расширять функциональность приложения без значительных изменений в существующем коде.
    • Улучшения читаемости и поддержки кода за счет четкой структуры.
 */
class AnimalFactory {
    fun createAnimal(type: Animals): Animal = when (type) {
        Animals.DOG -> Dog()
        Animals.CAT -> Cat()
        Animals.BIRD -> Bird()
        Animals.FISH -> Fish()
    }
}