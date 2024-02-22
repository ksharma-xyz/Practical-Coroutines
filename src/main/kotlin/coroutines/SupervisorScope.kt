package coroutines

import kotlinx.coroutines.*
import java.text.SimpleDateFormat

fun main() {
    runBlocking {
        val coroutineScopeValue = coroutineScopeExample()
        println("coroutineScopeValue: $coroutineScopeValue")

//        val supervisorScopeValue = supervisorScopeExample()
//        println("supervisorScopeValue: $supervisorScopeValue")
    }
}

private suspend fun supervisorScopeExample(): Int? = supervisorScope {
    launch {
        delay(2000)
        println("Complete Job1")
    }

    launch {
        delay(2000)
        SimpleDateFormat().parse("") // will throw exception
        println("Complete Job2")
    }

    return@supervisorScope null
}

private suspend fun coroutineScopeExample(): Int = coroutineScope {
    launch {
        delay(2000)
        println("Complete Job1")
    }

    launch {
        delay(2000)
        SimpleDateFormat().parse("") // will throw exception
        println("Complete Job2")
    }

    return@coroutineScope 10
}
