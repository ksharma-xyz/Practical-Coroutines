package flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest

fun main() {
    runBlocking {
        stateFlowExample()

        //stateFlowExampleColdToHot()

    }
}

suspend fun stateFlowExampleColdToHot() {
    coroutineScope {
        coldFlow().collectLatest {

        }
    }
}

private suspend fun stateFlowExample() {
    coroutineScope {
        val mStateFlow: MutableStateFlow<Int> = MutableStateFlow(value = 0)
        val job = launch {
            for (i in 1..5) {
                mStateFlow.emit(i)
                delay(200)
            }
        }
        val job2 = launch {

            /**
             * The crucial difference from collect is that when the original flow emits a new value then
             * the action block for the previous value is cancelled.
             */
            mStateFlow.collectLatest {
                println("Collected: $it")
            }
        }
        job.join()
        job2.join()
    }
}
