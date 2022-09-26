package content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.ExerciseItem
import designsystem.components.WeekDayLabel
import designsystem.controls.DividerPrimary
import designsystem.controls.IconPrimary
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldH1
import state.TrainingState

@Composable
fun ReviewContent(
    modifier: Modifier = Modifier,
    state: TrainingState,
    tonnage: @Composable (TrainingState) -> Unit,
    intensity: @Composable (TrainingState) -> Unit,
    ok: () -> Unit
) = LazyColumn(
    modifier = modifier
        .fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
    contentPadding = PaddingValues(DesignComponent.size.space)
) {

    item(key = "header_spacer") {
        Spacer(modifier = Modifier.size(44.dp))
    }

    stickyHeader(key = "header") {
        Row(
            modifier = Modifier.fillMaxWidth().background(DesignComponent.colors.primary),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextFieldH1(text = "Review!")

            IconPrimary(
                modifier = Modifier.size(56.dp),
                imageVector = Icons.Default.Send,
                color = DesignComponent.colors.accent_secondary,
                onClick = { ok.invoke() }
            )
        }
    }

    item(key = "weekday") {
        WeekDayLabel(weekDay = state.weekDay)
    }

    item(key = "tonnage_chart") {
        tonnage.invoke(state)
    }

    item(key = "intensity_chart") {
        intensity.invoke(state)
    }

    item(key = "summary_title") {
        TextFieldBody2(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "Summary",
            color = DesignComponent.colors.content.copy(alpha = 0.5f)
        )
    }

    item(key = "summary_info") {
        Summary()
    }

    item(key = "exercises") {
        state.exercises.forEachIndexed { index, item ->
            ExerciseItem(
                number = index + 1,
                exercise = item
            )
        }
    }
}

@Composable
private fun Summary() = Column(
    modifier = Modifier.background(
        color = DesignComponent.colors.secondary,
        shape = DesignComponent.shape.maxShape
    )
) {
    Section(
        label = "Tonnage",
        value = "30 000"
    )

    DividerPrimary()

    Section(
        label = "Repeats",
        value = "120"
    )

    DividerPrimary()

    Section(
        label = "Intensity",
        value = "54%"
    )
}

@Composable
private fun Section(
    label: String, value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextFieldBody2(
            modifier = Modifier.padding(8.dp),
            text = label,
            fontWeight = FontWeight.Bold
        )
        TextFieldBody2(
            modifier = Modifier.padding(8.dp),
            text = value
        )
    }
}