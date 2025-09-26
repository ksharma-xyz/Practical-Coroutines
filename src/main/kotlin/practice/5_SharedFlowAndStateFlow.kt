package practice

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Duration.Companion.milliseconds

/**
 * Practice File 5: SharedFlow and StateFlow
 *
 * Learning Objectives:
 * - Hot flows vs Cold flows
 * - SharedFlow configuration and behavior
 * - StateFlow for state management
 * - Flow sharing strategies
 */

// TODO 1: Create and configure SharedFlow
class EventBus {
    // TODO: Create a SharedFlow for events
    // Configure with replay = 1, extraBufferCapacity = 10
    // Create both mutable and read-only versions
    // Emit events and observe subscriber behavior

    fun emitEvent(event: String) {
        // TODO: Implement event emission
        TODO("Implement event emission to SharedFlow")
    }

    fun getEvents(): Flow<String> {
        // TODO: Return read-only flow
        TODO("Return read-only SharedFlow")
    }
}

// TODO 2: Implement StateFlow for state management
class UserViewModel {
    // TODO: Create StateFlow for user state
    // Initial state should be "Loading"
    // Provide methods to update state: setUser, setError, setLoading

    data class UserState(
        val isLoading: Boolean = false,
        val user: String? = null,
        val error: String? = null
    )

    fun loadUser(userId: Int) {
        // TODO: Simulate user loading with state updates
        // Start with loading state, then either success or error
        TODO("Implement user loading with StateFlow updates")
    }

    fun getState(): StateFlow<UserState> {
        // TODO: Return read-only StateFlow
        TODO("Return StateFlow for UI observation")
    }
}

// TODO 3: Compare SharedFlow vs StateFlow behavior
suspend fun compareSharedFlowAndStateFlow() {
    // TODO: Create both SharedFlow and StateFlow
    // Emit the same values to both
    // Start collecting from each at different times
    // Observe the difference in behavior for late subscribers
    TODO("Compare SharedFlow vs StateFlow subscription behavior")
}

// TODO 4: Implement flow sharing strategies
suspend fun flowSharingStrategies() {
    // TODO: Create a cold flow that simulates expensive operations
    // Convert it to hot flow using different sharing strategies:
    // 1. shareIn with SharingStarted.Eagerly
    // 2. shareIn with SharingStarted.Lazily
    // 3. shareIn with SharingStarted.WhileSubscribed()
    // Show how each strategy affects when the upstream starts/stops
    TODO("Demonstrate different flow sharing strategies")
}

// TODO 5: Create a reactive data source
class ReactiveRepository {
    // TODO: Implement a repository that:
    // 1. Uses StateFlow to track current data
    // 2. Uses SharedFlow for one-time events (errors, success messages)
    // 3. Provides methods to refresh data
    // 4. Handles loading states properly

    suspend fun fetchData() {
        // TODO: Simulate data fetching with proper state management
        TODO("Implement data fetching with StateFlow/SharedFlow")
    }

    fun getData(): StateFlow<String?> {
        // TODO: Return current data state
        TODO("Return data StateFlow")
    }

    fun getEvents(): SharedFlow<String> {
        // TODO: Return events SharedFlow
        TODO("Return events SharedFlow")
    }
}

// TODO 6: Handle buffer overflow in SharedFlow
suspend fun sharedFlowBufferOverflow() {
    // TODO: Create SharedFlow with small buffer
    // Emit items faster than they can be consumed
    // Show different buffer overflow strategies:
    // - BufferOverflow.SUSPEND
    // - BufferOverflow.DROP_OLDEST
    // - BufferOverflow.DROP_LATEST
    TODO("Demonstrate SharedFlow buffer overflow handling")
}

// TODO 7: Implement StateFlow derived values
class DerivedStateExample {
    // TODO: Create multiple StateFlows and combine them
    // Example: firstName and lastName StateFlows
    // Create derived fullName StateFlow that combines both
    // Show how derived state updates when source states change

    fun updateFirstName(name: String) {
        // TODO: Update first name
        TODO("Update first name StateFlow")
    }

    fun updateLastName(name: String) {
        // TODO: Update last name
        TODO("Update last name StateFlow")
    }

    fun getFullName(): StateFlow<String> {
        // TODO: Return derived full name
        TODO("Return derived StateFlow for full name")
    }
}

// Helper function to simulate expensive operation
fun createExpensiveFlow(): Flow<Int> = flow {
    println("Starting expensive operation...")
    repeat(5) {
        delay(1000)
        println("Emitting expensive value: $it")
        emit(it)
    }
    println("Expensive operation completed")
}

// QUESTIONS TO ANSWER:
/*
Q1: What's the key difference between SharedFlow and StateFlow? When to use each?
A1: TODO - Write your answer here

Q2: What happens when a SharedFlow buffer overflows? How can you handle it?
A2: TODO - Write your answer here

Q3: How does replay behavior work in SharedFlow? What are the implications?
A3: TODO - Write your answer here

Q4: When should you use SharingStarted.WhileSubscribed() vs other sharing strategies?
A4: TODO - Write your answer here

Q5: How do StateFlow and SharedFlow handle backpressure differently?
A5: TODO - Write your answer here

Q6: What's the relationship between StateFlow and LiveData in Android?
A6: TODO - Write your answer here
*/

// Test function
suspend fun main() = coroutineScope {
    println("=== SharedFlow and StateFlow Practice ===")

    // Uncomment to test your implementations
//     println("\n1. EventBus with SharedFlow:")
//     val eventBus = EventBus()
//     launch { eventBus.getEvents().collect { println("Received event: $it") } }
//     eventBus.emitEvent("Event 1")
//     eventBus.emitEvent("Event 2")

//     println("\n2. UserViewModel with StateFlow:")
//     val viewModel = UserViewModel()
//     launch { viewModel.getState().collect { println("State: $it") } }
//     viewModel.loadUser(123)

//     println("\n3. SharedFlow vs StateFlow:")
//     compareSharedFlowAndStateFlow()

//     println("\n4. Flow Sharing Strategies:")
//     flowSharingStrategies()

//     println("\n5. Buffer Overflow:")
//     sharedFlowBufferOverflow()
}
