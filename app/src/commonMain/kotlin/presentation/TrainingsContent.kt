package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.BarChart
import designsystem.common.DesignComponent
import designsystem.components.ExerciseItem
import designsystem.components.WeekDayLabel
import designsystem.controls.*
import presentation.state.TrainingState
import utils.DateTimeKtx

@Composable
fun TrainingsContent(
    modifier: Modifier = Modifier,
    state: List<TrainingState>,
    get: (TrainingState) -> Unit,
    show: (TrainingState) -> Unit,
    add: () -> Unit,
) = Root(
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
            add = add
        )
    },
    content = {

        var lastDate: String? = null

        state.forEach { item ->
            lastDate?.let {
                if (DateTimeKtx().isPreviousWeek(item.startDateTime, it)) {
                    item(key = "week_by_${item.shortStartDate}") {
                        WeekItem(state = item)
                    }
                }
            }
            lastDate = item.startDateTime

            item(key = item.id) {
                TrainingItem(
                    trainingState = item,
                    get = get,
                    show = show
                )
            }
        }
    }
)

@Composable
private fun WeekItem(state: TrainingState) = Row(
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
        text = state.longStartDate,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun FloatingMenu(
    modifier: Modifier = Modifier, add: () -> Unit
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
    get: (TrainingState) -> Unit,
    show: (TrainingState) -> Unit,
) = Column(
    modifier = Modifier.background(
        color = DesignComponent.colors.secondary,
        shape = DesignComponent.shape.default
    ).padding(12.dp)
) {
    TrainingHeader(
        modifier = Modifier.fillMaxWidth(),
        trainingState = trainingState,
        show = show,
        get = get
    )

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))

    trainingState.exercises.forEachIndexed { index, item ->
        ExerciseItem(
            number = index + 1, exercise = item
        )
    }
    DividerPrimary(modifier = Modifier.padding(bottom = 12.dp))

    TrainingFooter(
        modifier = Modifier.fillMaxWidth(),
        trainingState = trainingState
    )
}

@Composable
private fun TrainingHeader(
    modifier: Modifier = Modifier, trainingState: TrainingState, show: (TrainingState) -> Unit, get: (TrainingState) -> Unit
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

    IconPrimary(modifier = Modifier.height(20.dp),
        imageVector = BarChart,
        color = DesignComponent.colors.caption,
        onClick = { show.invoke(trainingState) }
    )

    Spacer(modifier = Modifier.size(20.dp))

    IconPrimary(modifier = Modifier.height(20.dp),
        imageVector = Icons.Default.Edit,
        color = DesignComponent.colors.caption,
        onClick = { get.invoke(trainingState) }
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
