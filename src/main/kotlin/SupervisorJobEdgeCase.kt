import kotlinx.coroutines.*
import java.text.SimpleDateFormat

private val outerScope = CoroutineScope(Job() + Dispatchers.Default)
private val innerSupervisorScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

fun main() {
    runBlocking {
//        superVisorJobWillNotWork()
        superVisorJobWillWork()
    }
}

private suspend fun superVisorJobWillNotWork() {
    val parentJob = outerScope.launch {

        // Supervisor Job only works if it is coroutines direct parent.
        val childJob = innerSupervisorScope.launch {

            /**
             * We will think that Job1 should complete even if Job2 has exception, since we are using SupervisorJob
             * But the thing is Supervisor Job only works if it is coroutines direct parent.
             */
            val job1 = launch {
                println("Doing Job1")
                delay(4000)
                println("Job1 Complete") // This will not complete even though it is part of Supervisor Job
            }

            val job2 = launch {
                println("Doing Job2")
                delay(1000)
                println("Job2: Throw an exception")
                SimpleDateFormat().parse("")
                println("Job2 Complete")
            }
        }
        childJob.join()
    }
    parentJob.join()
}

private suspend fun superVisorJobWillWork() {
    val parentJob = outerScope.launch {

        supervisorScope {

            val job1 = launch {
                println("Doing Job1")
                delay(3000)
                println("Job1 Complete")
            }

            val job2 = launch {
                println("Doing Job2")
                delay(1000)
                println("Job2: Throw an exception")
                SimpleDateFormat().parse("")
                println("Job2 Complete")
            }
        }
    }
    parentJob.join()
}