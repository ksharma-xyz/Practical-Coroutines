package practice

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Practice File 6: Jobs and Coroutine Context
 *
 * Learning Objectives:
 * - Understanding Job lifecycle and hierarchy
 * - CoroutineContext composition and inheritance
 * - Structured concurrency principles
 * - Job cancellation propagation
 */

// TODO 1: Explore Job hierarchy and lifecycle
suspend fun jobHierarchyExample() {
    // TODO: Create parent coroutine with multiple child coroutines
    // Show how job hierarchy affects cancellation
    // Print job states at different points
    // Cancel parent and observe child behavior
    TODO("Demonstrate job hierarchy and lifecycle")
}

// TODO 2: Implement custom CoroutineContext
class CustomCoroutineElement(val name: String) : CoroutineContext.Element {
    override val key: CoroutineContext.Key<*> = Key

    companion object Key : CoroutineContext.Key<CustomCoroutineElement>

    override fun toString() = "CustomElement($name)"
}

suspend fun customCoroutineContextExample() {
    // TODO: Create coroutines with custom context elements
    // Show how context is inherited and can be modified
    // Access custom elements from within coroutines
    // Demonstrate context composition with + operator
    TODO("Work with custom CoroutineContext elements")
}

// TODO 3: Job states and transitions
suspend fun jobStatesDemo() {
    // TODO: Create a job and observe its states:
    // New -> Active -> Completing -> Completed (or Cancelled)
    // Show how different operations affect job state
    // Use job.children, job.isActive, job.isCompleted, job.isCancelled
    TODO("Observe and log job state transitions")
}

// TODO 4: SupervisorJob vs regular Job
suspend fun supervisorJobComparison() {
    // TODO: Create two scenarios:
    // 1. Regular Job with children - one child fails, observe others
    // 2. SupervisorJob with children - one child fails, observe others
    // Show the difference in exception propagation
    TODO("Compare SupervisorJob vs regular Job exception handling")
}

// TODO 5: Job cancellation patterns
suspend fun jobCancellationPatterns() {
    // TODO: Demonstrate different cancellation patterns:
    // 1. Immediate cancellation
    // 2. Graceful cancellation with cleanup
    // 3. Cancellation with timeout
    // 4. Non-cancellable cleanup operations
    TODO("Implement various job cancellation patterns")
}

// TODO 6: CoroutineContext inheritance and modification
suspend fun contextInheritanceExample() {
    // TODO: Create nested coroutines and show how context is inherited
    // Modify context at different levels (dispatcher, job, name, etc.)
    // Access parent context from child coroutines
    // Show context element precedence rules
    TODO("Explore context inheritance and modification in nested coroutines")
}

// TODO 7: Implement structured concurrency violation detection
suspend fun structuredConcurrencyViolations() {
    // TODO: Create examples that would violate structured concurrency
    // Show why GlobalScope usage can be problematic
    // Demonstrate proper alternatives using coroutineScope
    // Handle cases where you need to break structured concurrency safely
    TODO("Identify and fix structured concurrency violations")
}

// Helper class for demonstrating job relationships
class JobManager {
    private val jobs = mutableListOf<Job>()

    fun launchJob(scope: CoroutineScope, name: String, work: suspend () -> Unit): Job {
        // TODO: Launch job with proper naming and tracking
        // Add to jobs list for management
        TODO("Launch and track jobs")
    }

    suspend fun cancelAllJobs() {
        // TODO: Cancel all tracked jobs gracefully
        TODO("Cancel all managed jobs")
    }

    fun printJobStatus() {
        // TODO: Print status of all tracked jobs
        TODO("Print status of all jobs")
    }
}

// Helper functions for job demonstration
suspend fun simulateWork(name: String, duration: Long, shouldFail: Boolean = false) {
    try {
        println("[$name] Starting work")
        delay(duration)
        if (shouldFail) throw RuntimeException("$name failed!")
        println("[$name] Work completed")
    } catch (e: CancellationException) {
        println("[$name] Work was cancelled")
        throw e
    } catch (e: Exception) {
        println("[$name] Work failed: ${e.message}")
        throw e
    }
}

suspend fun nonCancellableCleanup(name: String) {
    withContext(NonCancellable) {
        println("[$name] Performing non-cancellable cleanup")
        delay(100) // This won't be cancelled
        println("[$name] Cleanup completed")
    }
}

// QUESTIONS TO ANSWER:
/*
Q1: What's the relationship between Job, CoroutineScope, and CoroutineContext?
A1: TODO - Write your answer here

Q2: How does job cancellation propagate through the hierarchy? What about exceptions?
A2: TODO - Write your answer here

Q3: When would you use SupervisorJob instead of regular Job?
A3: TODO - Write your answer here

Q4: What are the principles of structured concurrency? Why are they important?
A4: TODO - Write your answer here

Q5: How can you access and modify CoroutineContext within a coroutine?
A5: TODO - Write your answer here

Q6: What happens when you use GlobalScope? Why is it generally discouraged?
A6: TODO - Write your answer here
*/

// Test function
suspend fun main() = coroutineScope {
    println("=== Jobs and Coroutine Context Practice ===")

    // Uncomment to test your implementations
//     println("\n1. Job Hierarchy:")
//     jobHierarchyExample()

//     println("\n2. Custom CoroutineContext:")
//     customCoroutineContextExample()

//     println("\n3. Job States:")
//     jobStatesDemo()

//     println("\n4. SupervisorJob vs Job:")
//     supervisorJobComparison()

//     println("\n5. Cancellation Patterns:")
//     jobCancellationPatterns()

//     println("\n6. Context Inheritance:")
//     contextInheritanceExample()

//     println("\n7. Structured Concurrency:")
//     structuredConcurrencyViolations()
}
