package com.example.interviewprepare.architecture.patterns.strategy

/*
"Стратегия"-
    один из поведенческих паттернов проектирования, который позволяет
    определять семейство алгоритмов, инкапсулировать каждый из них и делать их взаимозаменяемыми.

    Плюсы паттерна "Стратегия":
    1. Инкапсуляция алгоритмов:
    Позволяет выделить различные алгоритмы в отдельные классы,
    что улучшает читаемость и поддерживаемость кода.

    2. Легкость в изменении:
     добавлять новые стратегии без изменения существующего кода.
     Это особенно полезно в ситуациях, когда алгоритмы могут меняться.

    3. Изоляция кода:
    Изменение одного алгоритма не влияет на другие, так как они инкапсулированы в
    отдельных классах.

    4. Упрощение условий:
    Убирает необходимость в сложных условных операторах (например, if-else или switch),
    так как выбор стратегии осуществляется через объект.

    ▎Минусы паттерна "Стратегия":

    1. Увеличение числа классов:
    Для каждой стратегии требуется создать отдельный класс,
    что может привести к увеличению количества классов в проекте.

    2. Сложность:
    В некоторых случаях использование этого паттерна может усложнить структуру кода,
    особенно если количество стратегий невелико.

    3. Необходимость управления стратегиями:
    Иногда требуется дополнительная логика для управления и выбора стратегии,
    что может добавить сложности.

▎   Зачем нужен паттерн "Стратегия"?

    Паттерн "Стратегия" нужен для того, чтобы:
    • Обеспечить гибкость в выборе алгоритмов на этапе выполнения
    • Упростить поддержку и расширение кода за счет отделения алгоритмов от их использования
    • Улучшить читаемость и структуру кода, избавляя от громоздких условных операторов
 */
interface DiscountStrategy {
    fun calculateDiscount(book: Book): Double
}