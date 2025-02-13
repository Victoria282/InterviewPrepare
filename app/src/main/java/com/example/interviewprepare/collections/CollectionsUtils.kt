package com.example.interviewprepare.collections

import android.util.Log
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue
import java.util.Stack
import java.util.TreeMap
import java.util.TreeSet

fun CollectionsUtils() {
    /*
    * Содержит методы (правила) для обхода списочных данных
    */
    val iterable: Iterable<String>
    val mutableIterable: MutableIterable<String>

    /*
    * Collection, он содержит базовые методы (правила) для неизменяемой
    * коллекции. Например: чтение данных, получение размера;
    */

    /* -------------------Наследники--------------------------*/

    val collection: Collection<String>
    val mutableCollection: MutableCollection<String>

    val list: List<String>
    val mutableList: MutableList<String>

    /*
        Linked list производительнее работает с частыми вставками, и удалениями
     */
    val arrayList: ArrayList<String>
    val linkedList: LinkedList<String>

    /* --------------------------------------------------------*/

    val map: Map<String, String>
    val mutableMap: MutableMap<String, String>

    val hashMap: HashMap<String, String>
    val treeMap: TreeMap<String, String>
    val linkedHashMap: LinkedHashMap<String, String>

    /*
        HashMap является наиболее распространенной реализацией интерфейса Map.
        Он хранит элементы в виде пар «ключ-значение». HashMap создает хэш-таблицу,
        которая позволяет выполнить любую операцию (добавление, удаление, поиск) за постоянное время.
        Однако элементы в HashMap не упорядочены
     */

    /*
        LinkedHashMap — это специальный вид HashMap, который сохраняет порядок добавления элементов.
        Это достигается за счет поддержки двусвязного списка элементов. Поэтому, при выводе элементов
        на экран, порядок их следования будет соответствовать порядку добавления.
     */

    /*
        TreeMap — это реализация Map, которая хранит элементы в отсортированном порядке.
        Сортировка элементов происходит автоматически при добавлении на основе значений их ключей.
        TreeMap использует красно-черное дерево для хранения элементов, что обеспечивает быстрые
        операции добавления, удаления и поиска. Однако скорость этих операций зависит от количества
        элементов
     */
    /* --------------------------------------------------------*/

    val set: Set<String>
    val mutableSet: MutableSet<String>

    val hashSet: HashSet<String>
    val treeSet: TreeSet<String>
    val linkedHashSet: LinkedHashSet<String>

    /*
        HashSet используется, если нужен быстрый доступ к элементам и порядок не имеет значения.
        Элементы в HashSet не упорядочены и могут храниться в произвольном порядке.
     */

    /*
        LinkedHashSet применяется, если нужно сохранять порядок вставки элементов и быстрый доступ
        к ним. Класс расширяет функциональность HashSet, добавляя ссылки на предыдущий и следующий
        элементы
     */

    /*
        TreeSet используется, если нужно сохранять элементы в отсортированном порядке.
        TreeSet использует красно-чёрное дерево для хранения элементов, что обеспечивает быстрое время доступа к ним.
     */

    /* ----------Специализированные коллекции -----------------*/
    val stack: Stack<String>
    val queue: Queue<String>
    val priorityQueue: PriorityQueue<String>

    /* ---------------Фиксированный размер---------------------*/
    val array: Array<String>
    /*
         ByteArray, ShortArray, LongArray, CharArray, FloatArray, DoubleArray, BooleanArray
    */

    /* --------------------------------------------------------*/
    val sequences: Sequence<String>

    /* Сложность при работе с коллекциями */
    /* Зачем нужны hash-и */

    /*
        Хеши (или хеш-функции) в коллекциях Kotlin играют важную роль в обеспечении быстрого
        доступа к элементам. Они используются в таких коллекциях, как HashMap, HashSet и других,
        которые основаны на хешировании.

        Хеши помогают определить уникальность объектов.
     */
    example()
    examplePractise()
}

fun example() {
    val fruits: List<String> = listOf("apple", "banana", "orange", "banana")
    val uniqueFruits: Set<String> = setOf("apple", "banana", "orange", "banana")
    val fruitPrices: Map<String, Double> = mapOf("apple" to 0.5, "banana" to 0.3, "orange" to 0.7)
}

fun examplePractise() {
    val elements = listOf(1, 2, 3, 3, 4, 5, 282)
    val elementsToo = listOf(1, 8, 9)

    val names = listOf("Alice", "Bob")
    val ages = listOf(25, 30)

    val filter = elements.filter { it  > 5 }

    Log.e("Interview", "filter= ${filter}")

    val reduce = elements.reduce { acc, i -> acc + i }
    Log.e("Interview", "reduce= ${reduce}")

    val flatMap = listOf(elements, elementsToo).flatMap { it }
    Log.e("Interview", "flatMap= ${flatMap}")

    val distinct = elementsToo.distinct()
    Log.e("Interview", "distinct= ${distinct}")

    val sorted = elements.sorted()
    Log.e("Interview", "sorted= ${sorted}")

    val groupBy = elements.groupBy { it < 282 }
    groupBy.onEach {
        Log.e("Interview", "key= ${it.key}, value = ${it.value}")
    }

    val zip = names.zip(ages)
    zip.forEach {
        Log.e("Interview", "${it.first} ${it.second}")
    }

    val nums = listOf(1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 5)
    val countOfNumsInList = nums.associateBy { number -> nums.count { it ==  number } }
    countOfNumsInList.forEach {
        Log.e("Interview", "number ${it.key} in list can be seen ${it.value} times")
    }

    val found = nums.find { it >= 5 }
    Log.e("Interview", "found= $found")

    val toSet = nums.toSet()
    Log.e("Interview", "toSet= $toSet")

    val set = setOf(1, 1, 1, 1, 1)
    Log.e("Interview", "set= ${set}")

    val setToList = set.toList()
    Log.e("Interview", "setToList= ${setToList}")

    val namesList = listOf("Victoria", "Ilya", "Lena", "Eva")
    val slice = namesList.slice(listOf(1, 3))
    Log.e("Interview", "slice= ${slice}")

    val allElements = listOf(1, 2, "3", "Victoria", 10.0, '4', true)
    val partition = allElements.partition { it is String }
    Log.e("Interview", "partition 1= ${partition.first}")
    Log.e("Interview", "partition 2= ${partition.second}")
}