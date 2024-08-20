package bottommenu.main

import AuthenticationRepository
import DateTimeKtx
import DateTimeKtx.chunkBefore
import ExerciseExamplesRepository
import TrainingsRepository
import UserRepository
import ViewModel
import bottommenu.main.state.TokenStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject

internal class BottomMenuViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    private val authApi by inject<AuthenticationRepository>()
    private val trainingsApi by inject<TrainingsRepository>()
    private val userApi by inject<UserRepository>()
    private val exerciseExamplesApi by inject<ExerciseExamplesRepository>()

    init {
        authApi.getToken()
            .onEach { r ->
                _state.update {
                    if (r == null) it.copy(tokenStatus = TokenStatus.Unavailable)
                    else it.copy(tokenStatus = TokenStatus.Available)
                }
            }.launchIn(this)

        // ************************ Sync Exercises ************************

        exerciseExamplesApi
            .getExerciseExamples(page = 0, size = 10)
            .catch { /* silent sync */ }
            .launchIn(this)

        // ************************ Sync Trainings ************************

        val lastChunk = chunkBefore(
            previousList = listOf(DateTimeKtx.currentDateTimeIso())
        )

        val start = lastChunk.firstOrNull()
        val end = lastChunk.firstOrNull()

        if (start != null && end != null) {
            trainingsApi.syncTrainings(startDate = start, endDate = end)
                .catch { /* silent sync */ }
                .launchIn(this)
        }

        // ************************ Sync User ************************

        userApi.syncUser()
            .catch { /*silent sync*/ }
            .launchIn(this)

        userApi.syncWeightHistory()
            .catch { /*silent sync*/ }
            .launchIn(this)
    }
}