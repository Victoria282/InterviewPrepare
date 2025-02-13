package com.example.interviewprepare.architecture.patterns.bridge

/*
    Разделяет абстракцию и реализацию, позволяя им изменяться независимо.
    Он используется для того, чтобы избежать жесткой привязки между абстракцией
    и ее реализацией, что делает код более гибким и расширяемым.
 */
fun show() {
    val redCircle: Shape = Circle(Red())
    println(redCircle.draw())

    val greenSquare: Shape = Square(Green())
    println(greenSquare.draw())
}