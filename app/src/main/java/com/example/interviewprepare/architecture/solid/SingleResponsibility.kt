package com.example.interviewprepare.architecture.solid


data class User(
    val name: String
)
/*
    Нарушение
    В этом примере класс пытается выполнять различные по своей сути операции.
    Такой подход может привести к серьезным проблемам в будущем.
 */

class SystemManager {
    fun addUser(user: User) { }
    fun deleteUser(user: User) { }
    fun sendNotification(notification:String) {}
    fun sendEmail(user: User, email: String) {}
}
/*
    Верное решение
 */
class MailManager() {
    fun sendEmail(user: User, email: String) {}
}

class NotificationManager() {
    fun sendNotification(notification: String) {}
}

class UserManager {
    fun addUser(user: User) {}
    fun deleteUser(user: User) {}
}

class SingleResponsibility {
}