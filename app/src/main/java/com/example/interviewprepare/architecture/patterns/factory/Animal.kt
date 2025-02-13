package com.example.interviewprepare.architecture.patterns.factory

interface Animal {
    fun voice()
}

enum class Animals {
    CAT, DOG, FISH, BIRD
}