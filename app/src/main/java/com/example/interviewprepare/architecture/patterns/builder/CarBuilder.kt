package com.example.interviewprepare.architecture.patterns.builder

/*
    "Строитель" (Builder) — это один из порождающих паттернов проектирования,
    который используется для создания сложных объектов. Он позволяет создавать объекты
    поэтапно, разделяя процесс их создания и представление.

    ▎Плюсы паттерна "Строитель":

    1. Читаемость кода:
    Использование паттерна "Строитель" делает код более понятным и читаемым,
    так как создание объекта происходит поэтапно с явным указанием параметров.

    2. Гибкость:
    Позволяет создавать различные представления одного и того же объекта,
    изменяя только параметры строителя.

    3. Изоляция сложной логики создания:
    Логика создания объекта изолирована в классе строителя, что позволяет
     избежать громоздкости в конструкторе самого объекта.

▎   Минусы паттерна "Строитель":

    1. Увеличение количества классов:
    Паттерн может привести к созданию множества дополнительных классов (строителей),
    что увеличивает сложность структуры кода.

    2. Избыточность:
    Если объект простой и не требует сложной логики создания,
    использование строителя может быть излишним и усложнить код.

    Паттерн "Строитель" нужен для:

    • Упрощения процесса создания сложных объектов.
    • Повышения читаемости и поддерживаемости кода.
    • Изоляции логики создания объектов от их представления.
    • Обеспечения гибкости при создании различных конфигураций одного и того же объекта.

 */
class CarBuilder {
    private var model: String = ""
    private var brand: String = ""
    private var color: String = ""
    private var year: String = ""

    public fun setModel(model: String): com.example.interviewprepare.architecture.patterns.builder.CarBuilder {
        this.model = model
        return this
    }

    public fun setBrand(brand: String): com.example.interviewprepare.architecture.patterns.builder.CarBuilder {
        this.brand = brand
        return this
    }

    public fun setColor(color: String): com.example.interviewprepare.architecture.patterns.builder.CarBuilder {
        this.color = color
        return this
    }

    public fun setYear(year: String): com.example.interviewprepare.architecture.patterns.builder.CarBuilder {
        this.year = year
        return this
    }

    public fun build(): Car = Car(
        model = model,
        brand = brand,
        color = color,
        year = year
    )
}