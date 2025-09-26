package practice

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.*
import kotlin.coroutines.CoroutineContext

/**
 * Practice File 9: Exception Handling and Error Recovery
 *
 * Learning Objectives:
 * - Exception propagation in coroutines
 * - CoroutineExceptionHandler usage
 * - Graceful error recovery patterns
 * - Supervisor patterns for fault tolerance
 */

// TODO 1: Understand exception propagation
suspend fun exceptionPropagationDemo() {
    // TODO: Create nested coroutines and show how exceptions propagate
    // Case 1: Exception in child cancels parent and siblings
    // Case 2: Exception in parent cancels all children
    // Case 3: Exception handling with try-catch at different levels
    TODO("Demonstrate exception propagation in coroutine hierarchy")
}

// TODO 2: Implement CoroutineExceptionHandler
class GlobalExceptionHandler : CoroutineExceptionHandler {
    override val key: CoroutineContext.Key<*> = CoroutineExceptionHandler

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        // TODO: Implement global exception handling
        // Log exceptions with context information
        // Decide whether to restart, alert, or ignore
        TODO("Handle uncaught exceptions globally")
    }
}

suspend fun exceptionHandlerDemo() {
    // TODO: Use CoroutineExceptionHandler in different scenarios
    // Show when it's called vs when it's not
    // Demonstrate with launch vs async
    TODO("Show CoroutineExceptionHandler usage patterns")
}

// TODO 3: Implement circuit breaker pattern
class CircuitBreaker(
    private val failureThreshold: Int = 5,
    private val recoveryTimeoutMs: Long = 30000,
    private val monitoringPeriodMs: Long = 10000
) {
    enum class State { CLOSED, OPEN, HALF_OPEN }

    // TODO: Implement circuit breaker logic
    // Track failures and success rates
    // Automatically open circuit after threshold failures
    // Allow limited requests in half-open state
    // Close circuit after successful recovery

    suspend fun <T> execute(operation: suspend () -> T): T {
        // TODO: Execute operation through circuit breaker
        TODO("Execute operation with circuit breaker protection")
    }

    private suspend fun recordSuccess() {
        // TODO: Record successful operation
        TODO("Record successful operation")
    }

    private suspend fun recordFailure(exception: Throwable) {
        // TODO: Record failed operation
        TODO("Record failed operation")
    }

    fun getState(): State {
        // TODO: Return current circuit breaker state
        TODO("Get current circuit breaker state")
    }
}

// TODO 4: Implement retry with exponential backoff
suspend fun <T> retryWithBackoff(
    maxRetries: Int = 3,
    initialDelayMs: Long = 1000,
    backoffMultiplier: Double = 2.0,
    maxDelayMs: Long = 30000,
    operation: suspend (attempt: Int) -> T
): T {
    // TODO: Implement retry logic with exponential backoff
    // Include jitter to avoid thundering herd
    // Allow custom retry conditions
    // Track and log retry attempts
    TODO("Implement retry with exponential backoff")
}

// TODO 5: Create fault-tolerant service
class FaultTolerantService {
    private val circuitBreaker = CircuitBreaker()

    // TODO: Implement service that combines multiple error handling strategies:
    // 1. Circuit breaker for external dependencies
    // 2. Retry with backoff for transient failures
    // 3. Fallback values for graceful degradation
    // 4. Bulkhead pattern for resource isolation

    suspend fun fetchUserData(userId: Int): UserData? {
        // TODO: Fetch user data with comprehensive error handling
        TODO("Implement fault-tolerant user data fetching")
    }

    suspend fun fetchWithFallback(userId: Int): UserData {
        // TODO: Implement fallback strategy when primary source fails
        TODO("Implement fetch with fallback data source")
    }

    data class UserData(val id: Int, val name: String, val email: String)
}

// TODO 6: Implement supervisor scope patterns
suspend fun supervisorScopePatterns() {
    // TODO: Show different supervisor patterns:
    // 1. supervisorScope for independent operations
    // 2. SupervisorJob for long-running background tasks
    // 3. Mixing supervised and non-supervised children
    // 4. Error handling in supervisor contexts
    TODO("Demonstrate various supervisor scope usage patterns")
}

// TODO 7: Create error aggregation and reporting
class ErrorReporter {
    // TODO: Implement error aggregation system
    // Collect errors from multiple sources
    // Group similar errors together
    // Provide error statistics and trends
    // Alert when error rates exceed thresholds

    suspend fun reportError(error: Throwable, context: Map<String, Any> = emptyMap()) {
        // TODO: Report and categorize error
        TODO("Report error with context information")
    }

    suspend fun getErrorSummary(timeWindowMs: Long): ErrorSummary {
        // TODO: Get error summary for time window
        TODO("Generate error summary report")
    }

    data class ErrorSummary(
        val totalErrors: Int,
        val errorsByType: Map<String, Int>,
        val errorRate: Double,
        val topErrors: List<String>
    )
}

// TODO 8: Implement graceful degradation
suspend fun gracefulDegradationExample() {
    // TODO: Show how to gracefully degrade service functionality
    // When external service is down, use cached data
    // When database is slow, return partial results
    // When compute is limited, use simpler algorithms
    TODO("Implement graceful service degradation strategies")
}

// Helper functions for error simulation
suspend fun unreliableNetworkCall(data: String, failureRate: Double = 0.3): String {
    delay(kotlin.random.Random.nextLong(100, 500))
    if (kotlin.random.Random.nextDouble() < failureRate) {
        throw RuntimeException("Network call failed for: $data")
    }
    return "Response for: $data"
}

suspend fun slowDatabaseCall(query: String): List<String> {
    delay(kotlin.random.Random.nextLong(200, 2000))
    if (kotlin.random.Random.nextDouble() < 0.1) {
        throw RuntimeException("Database timeout for query: $query")
    }
    return listOf("Result1", "Result2", "Result3")
}

class TransientException(message: String) : RuntimeException(message)
class PermanentException(message: String) : RuntimeException(message)

// QUESTIONS TO ANSWER:
/*
Q1: How do exceptions propagate differently in launch vs async coroutines?
A1: TODO - Write your answer here

Q2: When is CoroutineExceptionHandler called? When is it NOT called?
A2: TODO - Write your answer here

Q3: What's the difference between supervisorScope and SupervisorJob?
A3: TODO - Write your answer here

Q4: How do you decide between fail-fast vs fault-tolerant error handling?
A4: TODO - Write your answer here

Q5: What are the key components of a resilient distributed system using coroutines?
A5: TODO - Write your answer here

Q6: How do you test error handling scenarios in coroutines?
A6: TODO - Write your answer here
*/

// Test function
suspend fun main() = coroutineScope {
    println("=== Exception Handling and Error Recovery Practice ===")

    // Uncomment to test your implementations
//     println("\n1. Exception Propagation:")
//     exceptionPropagationDemo()

//     println("\n2. Exception Handler:")
//     exceptionHandlerDemo()

//     println("\n3. Circuit Breaker:")
//     val circuitBreaker = CircuitBreaker()
//     repeat(10) {
//         try {
//             circuitBreaker.execute { unreliableNetworkCall("data-$it") }
//         } catch (e: Exception) {
//             println("Operation failed: ${e.message}")
//         }
//     }

//     println("\n4. Retry with Backoff:")
//     try {
//         val result = retryWithBackoff { attempt ->
//             unreliableNetworkCall("retry-test", failureRate = 0.7)
//         }
//         println("Success: $result")
//     } catch (e: Exception) {
//         println("All retries exhausted: ${e.message}")
//     }

//     println("\n5. Supervisor Patterns:")
//     supervisorScopePatterns()
}
