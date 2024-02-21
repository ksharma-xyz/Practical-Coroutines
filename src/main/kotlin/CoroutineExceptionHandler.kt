import kotlinx.coroutines.*
import java.text.SimpleDateFormat

val supervisorScope = CoroutineScope(SupervisorJob() + Dispatchers.IO + CoroutineExceptionHandler { coroutineContext, throwable ->
    println("Exception happened: $coroutineContext : ${throwable.message}")
} )
fun main() {
    runBlocking {

        val job1 = supervisorScope.launch {
            println("Let's throw an exception in Coroutine $this")
            delay(1000)
            SimpleDateFormat().parse("")
            println("Complete - this will never print")
        }

        val job2 = supervisorScope.launch {
            println("Let's throw an exception in Coroutine $this which we will also handle..")
            delay(3000)
            try {
                SimpleDateFormat().parse("")
            } catch (e: Exception) {
                println("error: " + e.message)
            }
            println("Complete - handled exception")

        }
        job1.join()
        job2.join()
    }
    print("Finish")
}
