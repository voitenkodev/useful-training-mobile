package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.atomic.BarChart
import designsystem.atomic.DesignComponent
import designsystem.components.ExerciseItem
import designsystem.components.labels.WeekDayLabel
import designsystem.controls.ButtonPrimary
import designsystem.controls.DividerPrimary
import designsystem.controls.Header
import designsystem.controls.IconPrimary
import designsystem.controls.Root
import designsystem.controls.TextFieldBody2
import redux.Direction
import redux.GlobalState
import redux.NavigatorAction
import redux.ReviewAction
import redux.TrainingAction
import redux.TrainingState
import redux.TrainingsState
import redux.rememberDispatcher
import redux.selectState

@Composable
fun TrainingsContent(
    modifier: Modifier = Modifier,
) {
    val dispatcher = rememberDispatcher()
    val state by selectState<GlobalState, TrainingsState> { this.trainingsState }

    Root(
        modifier = modifier,
        contentPadding = PaddingValues(
            top = DesignComponent.size.space,
            bottom = DesignComponent.size.space + 56.dp + DesignComponent.size.space,
            start = DesignComponent.size.space,
            end = DesignComponent.size.space
        ),
        header = {
            Header(title = "Trainings!")
        },
        floating = {
            FloatingMenu(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(DesignComponent.size.space),
                add = {
                    dispatcher(TrainingAction.PutTrainingAction(TrainingState()))
                    dispatcher(NavigatorAction.NAVIGATE(Direction.Training))
                }
            )
        },
        content = {

            state.trainings.groupBy { it.endOfWeek }.onEach {

                item(key = "week_by_${it.key}") {
                    WeekItem(startOfWeek = it.key)
                }

                items(it.value) { training ->
                    TrainingItem(
                        trainingState = training,
                        edit = {
                            dispatcher(TrainingAction.PutTrainingAction(it))
                            dispatcher(TrainingAction.ProvideEmptyIterations)
                            dispatcher(NavigatorAction.NAVIGATE(Direction.Training))
                        },
                        review = {
                            dispatcher(ReviewAction.GetTrainings(selected = it, all = state.trainings))
                            dispatcher(NavigatorAction.NAVIGATE(Direction.Review))
                        }
                    )
                }
            }
        }
    )
}

@Composable
private fun WeekItem(startOfWeek: String) = Row(
    modifier = Modifier.padding(DesignComponent.size.space),
    horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterHorizontally),
    verticalAlignment = Alignment.CenterVertically,
) {

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Week at",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = startOfWeek,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun FloatingMenu(
    modifier: Modifier = Modifier,
    add: () -> Unit
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
) {
    ButtonPrimary(
        modifier = Modifier.background(
            color = DesignComponent.colors.accent_primary,
            shape = DesignComponent.shape.circleShape
        ).weight(1f),
        text = "New Training",
        onClick = add
    )
    IconPrimary(
        modifier = Modifier.size(56.dp).background(
            color = DesignComponent.colors.accent_secondary,
            shape = DesignComponent.shape.default
        ),
        imageVector = BarChart,
        onClick = {}
    )
}

@Composable
private fun TrainingItem(
    trainingState: TrainingState,
    edit: (TrainingState) -> Unit,
    review: (TrainingState) -> Unit,
) = Column(
    modifier = Modifier.background(
        color = DesignComponent.colors.secondary,
        shape = DesignComponent.shape.default
    ).padding(12.dp)
) {

    TrainingHeader(
        modifier = Modifier.fillMaxWidth(),
        trainingState = trainingState,
        review = review,
        edit = edit
    )

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))

    trainingState.exercises.forEachIndexed { index, item ->
        ExerciseItem(
            number = index + 1,
            exercise = item
        )
    }

    DividerPrimary(modifier = Modifier.padding(vertical = 12.dp))

    TrainingFooter(
        modifier = Modifier.fillMaxWidth(),
        trainingState = trainingState
    )
}

@Composable
private fun TrainingHeader(
    modifier: Modifier = Modifier,
    trainingState: TrainingState,
    review: (TrainingState) -> Unit,
    edit: (TrainingState) -> Unit
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDay = trainingState.weekDay,
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Start Time",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = trainingState.startTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.weight(1f))

    IconPrimary(
        modifier = Modifier.height(20.dp),
        imageVector = BarChart,
        color = DesignComponent.colors.caption,
        onClick = { review.invoke(trainingState) }
    )

    Spacer(modifier = Modifier.size(20.dp))

    IconPrimary(
        modifier = Modifier.height(20.dp),
        imageVector = Icons.Default.Edit,
        color = DesignComponent.colors.caption,
        onClick = { edit.invoke(trainingState) }
    )
}

@Composable
private fun TrainingFooter(
    modifier: Modifier = Modifier,
    trainingState: TrainingState,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Duration",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = trainingState.durationTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.weight(1f))

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Tonnage",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = "${trainingState.tonnage}kg",
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )
}
