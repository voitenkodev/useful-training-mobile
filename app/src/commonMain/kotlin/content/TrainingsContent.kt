package content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.BarChart
import designsystem.common.DesignComponent
import designsystem.components.AccentLabel
import designsystem.components.Header
import designsystem.components.Root
import designsystem.controls.*
import state.TrainingState

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(DesignComponent.size.space),
            horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
        ) {
            ButtonPrimary(
                modifier = Modifier
                    .background(
                        color = DesignComponent.colors.accent_primary,
                        shape = DesignComponent.shape.circleShape
                    ).weight(1f),
                text = "New Training",
                leadIcon = Icons.Default.Add,
                onClick = add
            )
            IconPrimary(
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        color = DesignComponent.colors.accent_secondary,
                        shape = DesignComponent.shape.maxShape
                    ),
                imageVector = BarChart,
                onClick = {}
            )
        }
    },
    content = {
        state.forEachIndexed { index, item ->
            item(key = item.id) {
                TrainingItem(
                    trainingState = item, get = get, show = show
                )
            }
        }
    }
)

@Composable
private fun TrainingItem(
    trainingState: TrainingState,
    get: (TrainingState) -> Unit,
    show: (TrainingState) -> Unit,
) = Column(
    modifier = Modifier.background(
        color = DesignComponent.colors.secondary,
        shape = DesignComponent.shape.maxShape
    ).padding(12.dp)
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        AccentLabel(
            modifier = Modifier.padding(end = 4.dp),
            text = trainingState.weekDay,
        )

        TextFieldBody2(
            modifier = Modifier.padding(end = 4.dp),
            text = "Started at",
            color = DesignComponent.colors.caption,
        )

        TextFieldBody2(
            text = trainingState.time,
            color = DesignComponent.colors.content,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        IconPrimary(
            modifier = Modifier.height(20.dp),
            imageVector = BarChart,
            color = DesignComponent.colors.caption,
            onClick = { show.invoke(trainingState) }
        )

        Spacer(modifier = Modifier.size(20.dp))

        IconPrimary(
            modifier = Modifier.height(20.dp),
            imageVector = Icons.Default.Edit,
            color = DesignComponent.colors.caption,
            onClick = { get.invoke(trainingState) }
        )
    }

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))

    trainingState.exercises.forEachIndexed { index, item ->

        Row(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            TextFieldBody1(text = "${index + 1}.", fontWeight = FontWeight.Bold)

            Column {

                TextFieldBody1(text = item.name, fontWeight = FontWeight.Bold)

                IterationVerticalGrid(
                    modifier = Modifier.padding(top = 6.dp, bottom = 4.dp),
                    spacing = 4.dp,
                ) {
                    item.iterations.forEach {
                        TextFieldBody1(
                            modifier = Modifier.padding(end = 4.dp),
                            text = it.weight + "x" + it.repeat,
                            color = DesignComponent.colors.caption
                        )
                    }
                }
            }
        }
    }
}