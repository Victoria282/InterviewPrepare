package com.example.interviewprepare.strings

import android.util.Log

fun StringUtils() {
    val word = "Victoria"
    val wordWithSpaces = "Vic to ri a"
    val languages = "kotlin, java, python, c++, javaScript, pascal"
    val text = "Victoria - Android developer, with 3 years experience, and 1 course"

    val repeat = word.repeat(4)
    Log.e("Interview", "repeat= $repeat")

    val subText = text.substring(0, 8)
    Log.e("Interview", "subText= $subText")

    val trimmed = wordWithSpaces.replace(" ", "")
    Log.e("Interview", "trimmed= $trimmed")

    val massive = languages.split(",")
    Log.e("Interview", "massive= $massive")

    val language = languages.filter { it.isLetter() }
    Log.e("Interview", "filter= $language")

    val find = languages.find { it == 'j' }
    Log.e("Interview", "find= $find")

    val regex = "\\d+".toRegex()
    val numbers = regex.findAll(text).map { it.value }.toList()
    numbers.forEach { Log.e("Interview", "number= $it") }
}