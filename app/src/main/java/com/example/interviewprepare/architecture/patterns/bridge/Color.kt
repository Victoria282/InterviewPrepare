package com.example.interviewprepare.architecture.patterns.bridge

interface Color {
    fun fill(): String
}

class Red : Color {
    override fun fill(): String {
        return "Red color"
    }
}

class Green : Color {
    override fun fill(): String {
        return "Green color"
    }
}