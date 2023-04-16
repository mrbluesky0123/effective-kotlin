package me.mrbluesky.effectivekotlin.item1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Item1Controller {

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
        val test2 = person.fullName
        return "$test1 // $test2"
    }

}