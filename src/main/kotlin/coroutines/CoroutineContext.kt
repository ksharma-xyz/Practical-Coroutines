package coroutines

import kotlinx.coroutines.*
import java.text.SimpleDateFormat

/**
 *
 * A CoroutineContext defines the behavior of a coroutine using the following set of elements:
 *
 * - Job: Controls the lifecycle of the coroutine.
 * - CoroutineDispatcher: Dispatches work to the appropriate thread.
 * - CoroutineName: The name of the coroutine, useful for debugging.
 * - CoroutineExceptionHandler: Handles uncaught exceptions.
 */
fun main() {
    runBlocking {
        println("Example of CoroutineContext with Job()")
        delay(2000)
        coroutineContextExample()

        delay(2000)
        println("Example of CoroutineContext with SupervisorJob()")
        delay(1000)
        supervisorJobCoroutineContextExample()

    }
}

val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)
val coroutineScopeSupervisorJob = CoroutineScope(SupervisorJob() + Dispatchers.IO)

suspend fun coroutineContextExample() {
    // Starts a new coroutine on Dispatchers.IO as it's the scope's default
    val job1 = coroutineScope.launch {
        // New coroutine with CoroutineName = "coroutine" (default)
        println("Job1 - CoroutineScope: $this - Thread:${Thread.currentThread().name}  is running..")
        delay(5000)
        println("Job1 Complete")
    }

    // Starts a new coroutine on Dispatchers.Default
    val job2 = coroutineScope.launch(Dispatchers.Default + CoroutineName("BackgroundCoroutine")) {
        // New coroutine with CoroutineName = "BackgroundCoroutine" (overridden)
        println("Job2 - CoroutineScope: $this: CoroutineName:${coroutineContext[CoroutineName]?.name} - ${Thread.currentThread().name} is running..")
        delay(2000)

        // Make an exception
        SimpleDateFormat().parse("")

        println("Job2 Complete")
    }


    job1.join()
    job2.join()
    println("Both Jobs failed to complete because of an exception in Job2 coroutine")
}

suspend fun supervisorJobCoroutineContextExample() {
    // Starts a new coroutine on Dispatchers.IO as it's the scope's default
    val job1 = coroutineScopeSupervisorJob.launch {
        // New coroutine with CoroutineName = "coroutine" (default)
        println("Job 1 - CoroutineScope: $this - Thread:${Thread.currentThread().name}  is running..")
        delay(5000)
        println("Job1 Complete")
    }

    // Starts a new coroutine on Dispatchers.Default
    val job2 = coroutineScopeSupervisorJob.launch(Dispatchers.Default + CoroutineName("BackgroundCoroutine")) {
        // New coroutine with CoroutineName = "BackgroundCoroutine" (overridden)
        println("Job 2 - CoroutineScope: $this: CoroutineName:${coroutineContext[CoroutineName]?.name} - ${Thread.currentThread().name} is running..")
        delay(2000)

        // Make an exception
        SimpleDateFormat().parse("")

        println("Job2 Complete")
    }


    job1.join()
    job2.join()
    println("Even though Job2 had an exception, Job1 still completed even though it was launched using same coroutineScope")
}
