package me.mrbluesky.effectivekotlin.item5

class RestrictByException {
}

fun factorial(n: Int): Long {
    require(n >= 0) {"Fuck you"}    // n은 0보다 크거나 같아야 한다. -> required 조건을 명시
    return if(n <= 1) 1 else factorial(n - 1) * n
}

fun speak(isInitialized: Boolean): String {
    check(isInitialized) {"Be prepared."}
    return "Go to hell!"
}

fun say(something: String?): String {
//    requireNotNull(something) {"Nothing to say."}
    checkNotNull(something) {"Nothing to say2."}
    return "Say what?"
}