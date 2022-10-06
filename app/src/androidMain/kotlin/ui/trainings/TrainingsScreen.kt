package ui.trainings

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.get
import presentation.TrainingsContent
import redux.TrainingsAction
import redux.rememberDispatcher

@Composable
fun TrainingsScreen() {

    val dispatcher = rememberDispatcher()
    val repo = get<TrainingRepository>()

    LaunchedEffect(key1 = Unit) {
        repo
            .getTrainings()
            .map { it.toTrainingStateList() }
            .onEach { dispatcher(TrainingsAction.GetTrainings(it)) }
            .launchIn(this)
    }

    TrainingsContent(
        modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
    )
}