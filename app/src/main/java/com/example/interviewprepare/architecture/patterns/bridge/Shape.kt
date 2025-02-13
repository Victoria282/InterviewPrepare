package com.example.interviewprepare.architecture.patterns.bridge

abstract class Shape(protected val color: Color) {
    abstract fun draw(): String
}

class Circle(color: Color) : Shape(color) {
    override fun draw(): String {
        return "Drawing a Circle with ${color.fill()}"
    }
}

class Square(color: Color) : Shape(color) {
    override fun draw(): String {
        return "Drawing a Square with ${color.fill()}"
    }
}