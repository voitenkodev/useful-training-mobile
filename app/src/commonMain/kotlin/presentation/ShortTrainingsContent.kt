package presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.WeekDayLabel
import designsystem.controls.DividerPrimary
import designsystem.controls.Root
import designsystem.controls.TextFieldBody2
import presentation.state.ShortTrainingState
import presentation.state.TrainingState

@Composable
fun ShortTrainingsContent(
    modifier: Modifier = Modifier,
    state: List<ShortTrainingState>,
    get: (TrainingState) -> Unit,
    show: (TrainingState) -> Unit,
) = Root(
    modifier = modifier,
    contentPadding = PaddingValues(
        top = DesignComponent.size.space,
        bottom = DesignComponent.size.space + 56.dp + DesignComponent.size.space,
        start = DesignComponent.size.space,
        end = DesignComponent.size.space
    ),
    content = {

        items(state) {
            Column {
                Row(
                    modifier = modifier,
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    WeekDayLabel(
                        modifier = Modifier.padding(end = 4.dp),
                        weekDay = it.weekDay,
                    )

                    TextFieldBody2(
                        modifier = Modifier.padding(end = 4.dp),
                        text = "At",
                        color = DesignComponent.colors.caption,
                    )

                    TextFieldBody2(
                        text = it.startDate,
                        color = DesignComponent.colors.content,
                        fontWeight = FontWeight.Bold
                    )
                }

                DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))
                it.exercises.forEachIndexed { index, item ->
                    TextFieldBody2(text = "${index + 1}.  $item", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
)