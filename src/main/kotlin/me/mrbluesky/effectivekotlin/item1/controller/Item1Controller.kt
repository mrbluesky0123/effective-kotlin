package me.mrbluesky.effectivekotlin.item1.controller

import me.mrbluesky.effectivekotlin.item1.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.concurrent.thread
import kotlin.properties.Delegates

@RestController
@RequestMapping("/item1")
class Item1Controller {

    @GetMapping("/test")
    fun getTest(): String {

        val list1: MutableList<Int> = mutableListOf()
        var list2: List<Int> = listOf()

        list1.add(1)
        list2 = list2 + 1

        var list = listOf<Int>()
        for(i in 1..1000) {
            thread {
                list = list + i
            }
        }
        Thread.sleep(1000)

        return "${list.size}"
    }

    @GetMapping("/overridedVal")
    fun getOverridedVal(): String {
        val overridedVal: OverridedVal = OverridedValImpl()
        // 읽기 전용 프로퍼티 val의 값은 변경될 수 있기는 하지만 프로퍼티 레퍼런스 자체를 변경할 수는 없으므로 동기화 문제를 줄일 수 있다.
        // overridedVal.active = true
        return overridedVal.active.toString()
    }

    @GetMapping("/readOnlyProperty")
    fun getReadOnlyProperty(): String {
        val person: Person = Person()
        val test1 = person.fullName
        person.firstName = "Zakk"
        person.lastName = "Wylde"
        person.counter = -1
        val test2 = person.fullName
        return "$test1 // $test2"
    }

    @GetMapping("/withFunction")
    fun getWithFunction(): String {
        var user: User = User("Randy", "Randall")
        user = user.withSurname("Randy")
        return "${user.name} / ${user.surname}"
    }

    @GetMapping("/copy")
    fun getCopy(): String {
        var user: DataUser = DataUser("Randy", "Randall")
        user = user.copy(name = "Zakk", surname = "Wylde")
        return "${user.name} / ${user.surname}"
    }

    @GetMapping("/delegate")
    fun getDelegate(): String {
        var names by Delegates.observable(listOf<String>()) {
            _, old, new -> println("Names changed from $old to $new")
        }
        names += "Fabio"
        names += "Bill"
        return "${names.toString()}"
    }

    @GetMapping("/backingProperties")
    fun getBackingProperty(): String {
        val person: Person = Person()
        val name1 = person.familyName
        return "$name1"
    }

}