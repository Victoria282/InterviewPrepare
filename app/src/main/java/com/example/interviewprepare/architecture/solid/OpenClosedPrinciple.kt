package com.example.interviewprepare.architecture.solid

/*
    Принцип открытости/закрытости говорит нам что классы, модули, функции и
    другие программные сущности должны быть открыты для расширения, но закрыты для изменения.
    Это значит что вы должны иметь возможность добавлять новую функциональности в ваш код,
    не изменяя его, а дополняя. Следуя этому принципу код становится легче поддерживать и
    переиспользовать.
 */

/*
    Нарушение
    Как видно в данном примере, чтобы добавить новую фигуру в наш код -
    нам необходимо переписать реализацию функции calculateArea, что
    может привести к проблемам в будущем.
 */

class Shape(val type: String, val width: Double, val height: Double)

fun calculateArea(shape: Shape): Double {
    if (shape.type == "rectangle") {
        return shape.width * shape.height
    } else if (shape.type == "circle") {
        return Math.PI * shape.width * shape.width
    }
    return 0.0
}

/*
    Корректное использование
 */
interface ShapeI {
    fun area(): Double
}

class Rectangle(val width: Double, val height: Double) : ShapeI {
    override fun area() = width * height
}

class Circle(val radius: Double) : ShapeI {
    override fun area() = Math.PI * radius * radius
}

fun OpenClosedPrinciple() {
    val circle = Circle(4.0)
    val rectangle = Rectangle(1.0, 2.0)

    val list: List<ShapeI> = listOf(circle, rectangle)
    list.forEach { it.area() }
}