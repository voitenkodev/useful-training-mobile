package presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import atomic.DesignComponent
import components.Header
import components.Root
import components.items.EditExerciseItem
import controls.ButtonPrimary
import data.mapping.toTraining
import data.repository.TrainingRepositoryImpl
import globalKoin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import presentation.map.toExerciseComponent
import redux.Direction
import redux.GlobalState
import redux.NavigatorAction
import redux.TrainingAction
import redux.TrainingState
import redux.rememberDispatcher
import redux.selectState
import utils.rememberComposeCoroutineContext

@Composable
fun TrainingContent(
    modifier: Modifier = Modifier,
) {
    val dispatcher = rememberDispatcher()
    val state by selectState<GlobalState, TrainingState> { this.trainingState }

    val api = globalKoin().get<TrainingRepositoryImpl>()
    val loader = rememberComposeCoroutineContext()

    Root(
        modifier = modifier.fillMaxSize(),
        header = {
            Header(
                title = "Exercises!",
                save = {
                    dispatcher(TrainingAction.ValidateExercises)
                    dispatcher(TrainingAction.CalculateDuration)
                    dispatcher(TrainingAction.CalculateValues)
                    loader.call {
                        api.setTraining(training = state.toTraining())
                            .onEach { dispatcher(NavigatorAction.NAVIGATE(Direction.Review)) }
                            .catch { }
                            .launchIn(this)
                    }
                }
            )
        },
        footer = {
            NewExerciseItem(
                modifier = Modifier.fillMaxWidth().padding(DesignComponent.size.space),
                onClick = { dispatcher(TrainingAction.AddExerciseAction) }
            )
        },
        content = {
            itemsIndexed(state.exercises, key = { _, exercise -> exercise.id }) { index, exercise ->
                EditExerciseItem(
                    modifier = Modifier.animateItemPlacement(),
                    number = index + 1,
                    exercise = exercise.toExerciseComponent(),
                    updateName = { dispatcher(TrainingAction.SetNameExerciseAction(exerciseId = exercise.id, value = it)) },
                    removeExercise = { dispatcher(TrainingAction.RemoveExerciseAction(exerciseId = exercise.id)) },
                    updateWeight = { num, value ->
                        dispatcher(TrainingAction.SetWeightExerciseIterationAction(exerciseId = exercise.id, number = num, value = value))
                        dispatcher(TrainingAction.ProvideEmptyIteration(exerciseId = exercise.id))
                    },
                    updateRepeat = { num, value ->
                        dispatcher(TrainingAction.SetRepeatExerciseIterationAction(exerciseId = exercise.id, number = num, value = value))
                        dispatcher(TrainingAction.ProvideEmptyIteration(exerciseId = exercise.id))
                    }
                )
            }
        }
    )
}

@Composable
private fun NewExerciseItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) = ButtonPrimary(
    modifier = modifier,
    text = "Add Exercise",
    onClick = { onClick.invoke() }
)