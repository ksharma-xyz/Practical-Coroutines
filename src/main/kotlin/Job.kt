import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        jobExample()
    }
}

suspend fun jobExample() {
    // Handle to the coroutine, you can control its lifecycle
    val job1 = scope.launch {
        println("Print numbers from 1 to 100, one number every second...")
        for (number in 1..100) {
            delay(1000)
            println(number)
        }
    }

    delay(3000)
    println("Cancel the job for some reason after 3 seconds")
    // Cancel the coroutine started above, this doesn't affect the scope
    // this coroutine was launched in
    job1.cancel()

    val job2 = scope.launch {
        delay(1500)
        print("A new coroutine cn be launched with same scope..")
    }

    job2.join()
    println("finish")
}

