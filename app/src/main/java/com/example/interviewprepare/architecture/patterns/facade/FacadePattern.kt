package com.example.interviewprepare.architecture.patterns.facade

/*
    Предоставляет упрощённый интерфейс к сложной системе классов, библиотеке
    или фреймворку. Он позволяет скрыть сложность системы и облегчить взаимодействие
    с ней.

    Объединяет все компоненты и предоставляет простой интерфейс для пользователя
 */

class CPU {
    fun jump(position: Long) = println("CPU переходит к $position")
    fun execute() = println("CPU выполняет инструкции")
}

class Memory {
    fun load(position: Long, data: String) =
        println("Память загружает данные '$data' на позицию $position")
}

class HardDrive {
    fun read(lba: Long, size: Int): String {
        println("Жесткий диск читает $size байт с позиции $lba")
        return "данные"
    }
}

class ComputerFacade {
    private val cpu = CPU()
    private val memory = Memory()
    private val hardDrive = HardDrive()

    fun start() {
        val bootData = hardDrive.read(0, 1024)
        memory.load(0, bootData)
        cpu.jump(0)
        cpu.execute()
    }
}

fun show() {
    val computer = ComputerFacade()
    computer.start()
}