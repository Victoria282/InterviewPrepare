package com.example.interviewprepare.architecture.patterns.factory

import android.util.Log

class Dog: Animal {
    override fun voice() {
        Log.e("Interview", "woof")
    }
}

class Cat: Animal {
    override fun voice() {
        Log.e("Interview", "meow")
    }
}

class Bird: Animal {
    override fun voice() {
        Log.e("Interview", "tweet")
    }
}

class Fish: Animal {
    override fun voice() {
        Log.e("Interview", "blub")
    }
}