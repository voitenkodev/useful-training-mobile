package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.inputs.InputExerciseName
import designsystem.components.inputs.InputRepeat
import designsystem.components.inputs.InputWeight
import designsystem.components.labels.AccentLabel
import designsystem.controls.*
import redux.GlobalState
import redux.TrainingAction
import redux.TrainingState
import redux.rememberDispatcher
import redux.selectState

@Composable
fun TrainingContent(
    modifier: Modifier = Modifier,
    save: (TrainingState) -> Unit,
) {
    val dispatcher = rememberDispatcher()
    val state by selectState<GlobalState, TrainingState> { this.trainingState }

    Root(
        modifier = modifier,
        header = {
            Header(
                title = "Exercises!",
                save = {
                    dispatcher(TrainingAction.ValidateExercises)
                    dispatcher(TrainingAction.CalculateDuration)
                    dispatcher(TrainingAction.CalculateValues)
                    save.invoke(state)
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
            itemsIndexed(state.exercises, key = { index, exercise -> exercise.id }) { index, exercise ->
                Column(
                    modifier = Modifier
                        .animateItemPlacement()
                        .background(
                            color = DesignComponent.colors.secondary,
                            shape = DesignComponent.shape.default
                        )
                ) {
                    InputNameItem(
                        number = index + 1,
                        showHelp = mutableStateOf(value = false),
                        name = exercise.name,
                        update = { dispatcher(TrainingAction.SetNameExerciseAction(exerciseId = exercise.id, value = it)) },
                        remove = { dispatcher(TrainingAction.RemoveExerciseAction(exerciseId = exercise.id)) }
                    )

                    DividerPrimary(modifier = Modifier.padding(horizontal = 12.dp))

                    IterationVerticalGrid(
                        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp, start = 4.dp, end = 4.dp),
                        spacing = 4.dp
                    ) {

                        IterationCaptionItem()

                        exercise.iterations.forEachIndexed { index, iteration ->
                            IterationInputItem(
                                iteration = iteration,
                                updateWeight = { value ->
                                    dispatcher(
                                        TrainingAction.SetWeightExerciseIterationAction(
                                            exerciseId = exercise.id,
                                            number = index,
                                            value = value
                                        )
                                    )
                                    dispatcher(TrainingAction.ProvideEmptyIteration(exerciseId = exercise.id))
                                },
                                updateRepeat = { value ->
                                    dispatcher(
                                        TrainingAction.SetRepeatExerciseIterationAction(
                                            exerciseId = exercise.id,
                                            number = index,
                                            value = value
                                        )
                                    )
                                    dispatcher(TrainingAction.ProvideEmptyIteration(exerciseId = exercise.id))
                                }
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
private fun InputNameItem(
    number: Int,
    showHelp: MutableState<Boolean>,
    name: String,
    update: (String) -> Unit,
    remove: () -> Unit
) = Row(
    modifier = Modifier.padding(start = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp)
) {

    AccentLabel(
        modifier = Modifier.padding(bottom = 8.dp, top = 8.dp, end = 4.dp),
        text = "$number",
    )

    InputExerciseName(
        modifier = Modifier.onFocusChanged { showHelp.value = it.hasFocus }.weight(1f),
        value = name,
        onValueChange = { update.invoke(it) },
    )

    IconPrimary(
        modifier = Modifier.height(20.dp).width(50.dp),
        imageVector = Icons.Filled.Delete,
        color = DesignComponent.colors.caption,
        onClick = { remove.invoke() },
    )
}

@Composable
private fun IterationCaptionItem() = Column(modifier = Modifier.padding(vertical = 4.dp)) {
    TextFieldBody2(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 10.dp),
        text = "• Weight",
        textAlign = TextAlign.Center,
        color = DesignComponent.colors.caption,
        maxLines = 1,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentWidth()
            .padding(top = 10.dp, start = 8.dp, end = 8.dp, bottom = 8.dp),
        text = "• Repeat",
        color = DesignComponent.colors.caption,
        textAlign = TextAlign.Center,
        maxLines = 1,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun LazyItemScope.IterationInputItem(
    modifier: Modifier = Modifier,
    iteration: TrainingState.Exercise.Iteration,
    updateWeight: (value: String) -> Unit,
    updateRepeat: (value: String) -> Unit
) = Column(modifier = modifier.width(60.dp).animateItemPlacement().padding(vertical = 4.dp)) {

    InputWeight(
        value = iteration.weight,
        onValueChange = updateWeight
    )

    DividerPrimary(
        modifier = Modifier.padding(horizontal = 8.dp)
    )

    InputRepeat(
        value = iteration.repeat,
        onValueChange = updateRepeat
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