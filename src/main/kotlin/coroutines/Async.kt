package coroutines

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        startAndAwait()

        lazyStart()

    }
}

suspend fun lazyStart() = withContext(Dispatchers.IO) {
    val deferred1 = async(Dispatchers.Default) {
        println("Async Immediate start")
    }

    val deferred2 = async(start = CoroutineStart.LAZY, context = Dispatchers.Default) {
        println("Async Lazy start")
    }

    println("Delay 2 seconds...")
    delay(2000)
    println("deferred1: ${deferred1.await()}")

    println("Delay 1 second...")
    delay(1000)
    println("deferred2: ${deferred2.await()}")
}

private suspend fun startAndAwait() {
    coroutineScope {
        val one: Deferred<Int> = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        two.start()
        println("One: ${one.await()}")
        println("Two: ${two.await()}")
    }
}

fun doSomethingUsefulTwo(): Int {
    println("Two")
    return 2
}

fun doSomethingUsefulOne(): Int {
    println("One")
    return 1
}

