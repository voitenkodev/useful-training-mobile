package bottommenu.main

import AuthenticationRepository
import DateTimeKtx
import DateTimeKtx.chunkBefore
import EquipmentsRepository
import ExerciseExamplesRepository
import MusclesRepository
import TrainingsRepository
import UserRepository
import ViewModel
import bottommenu.main.state.TokenStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import org.koin.core.component.inject

internal class BottomMenuViewModel : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    private val authApi by inject<AuthenticationRepository>()
    private val userApi by inject<UserRepository>()
    private val musclesApi by inject<MusclesRepository>()
    private val equipmentApi by inject<EquipmentsRepository>()
    private val trainingsApi by inject<TrainingsRepository>()
    private val exerciseExamplesApi by inject<ExerciseExamplesRepository>()

    init {
        authApi.getToken()
            .onEach { r ->
                _state.update {
                    if (r == null) it.copy(tokenStatus = TokenStatus.Unavailable)
                    else it.copy(tokenStatus = TokenStatus.Available)
                }
            }.launchIn(this)

        // ************************ Sync Backend ************************

        val lastChunk = chunkBefore(previousList = listOf(DateTimeKtx.currentDateTimeIso()))

        val start = lastChunk.firstOrNull() ?: DateTimeKtx.currentDateTimeIso()
        val end = lastChunk.lastOrNull() ?: DateTimeKtx.currentDateTimeIso()

        userApi.syncUser()
            .flatMapConcat { userApi.syncWeightHistory() }
            .flatMapConcat { musclesApi.syncUserMuscles() }
            .flatMapConcat { equipmentApi.syncUserEquipments() }
            .flatMapConcat { exerciseExamplesApi.getExerciseExamples(page = 1, size = 10) }
            .flatMapConcat { trainingsApi.syncTrainings(startDate = end, endDate = start) }
            .catch { /*silent sync*/ }
            .launchIn(this)
    }
}