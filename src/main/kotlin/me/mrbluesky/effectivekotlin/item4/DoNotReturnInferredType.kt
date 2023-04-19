package me.mrbluesky.effectivekotlin.item4
class DoNotReturnInferredType {
}


open class Animal
class Zebra: Animal()

fun animal() {
    // 이렇게 하면 type mismatch 오류
    var animal = Zebra()
//    animal = Animal()

    // 이렇게 타입을 명시적으로 써줘야함
    var animal2: Animal = Zebra()
    animal2 = Animal()
}