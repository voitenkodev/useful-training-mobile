package trainingbuilder.training_builder.components.timer

import DateTimeKtx
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class Timer(
    private val scope: CoroutineScope,
    private val initial: Long
) {

    private var timerJob: Job? = null

    fun startTimer(onTick: (Long) -> Unit) {
        timerJob?.cancel()
        timerJob = scope.launch {
            while (true) {
                val remaining = calculateTime(initial)
                onTick.invoke(remaining)
                delay(1000)
            }
        }
    }

    fun stopTimer() {
        timerJob?.cancel()
    }

    fun leftSeconds(millis: Long): Long {
        return millis % 3600000 % 60000 / 1000
    }

    fun leftMinutes(millis: Long): Long {
        return (millis % 3600000) / 60000
    }

    fun leftHours(millis: Long): Long {
        return millis / 3600000
    }

    private fun calculateTime(updatedAtMillis: Long): Long {
        if (updatedAtMillis == 0L) return 0
        val currentTimeMillis = DateTimeKtx.currentDateTimeMillis()
        val elapsedTimeMillis = currentTimeMillis - updatedAtMillis
        return elapsedTimeMillis
    }
}