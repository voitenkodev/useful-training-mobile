package content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldBody3
import designsystem.controls.TextFieldH1
import state.TrainingState

@Composable
fun TrainingsContent(
    trainings: List<TrainingState>
) = LazyColumn(
    modifier = Modifier
        .fillMaxSize()
        .background(DesignComponent.colors.primary50),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace),
    contentPadding = PaddingValues(DesignComponent.size.rootSpace)
) {

    item {
        TextFieldH1(
            modifier = Modifier.padding(top = 44.dp, bottom = 8.dp),
            text = "Trainings!",
        )
    }

    trainings.forEachIndexed { index, item ->
        if (index % 3 == 0) {
            item {
                CycleItem()
            }
        }
        item(item) {
            TrainingItem(item)
        }
    }
}

@Composable
fun TrainingItem(trainingState: TrainingState) = Column(
    modifier = Modifier
        .background(DesignComponent.colors.primary100, DesignComponent.shape.maxShape)
        .border(BorderStroke(2.dp, DesignComponent.colors.primary70), DesignComponent.shape.maxShape)
        .padding(12.dp)
) {

    Row(
        modifier = Modifier.fillMaxSize().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        TextFieldBody2(
            text = trainingState.weekDay.name,
            color = DesignComponent.colors.secondary100,
            fontWeight = FontWeight.Bold
        )
        TextFieldBody2(
            text = trainingState.date,
            color = DesignComponent.colors.primaryInverse50,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier.size(30.dp).padding(4.dp),
            imageVector = Icons.Default.ArrowForward,
            tint = DesignComponent.colors.tertiary100,
            contentDescription = null
        )
    }

    trainingState.exercises.forEachIndexed { index, item ->

        TextFieldBody2(
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp),
            text = "${index + 1}. ${item.name}",
            fontWeight = FontWeight.Bold
        )

        Divider()

        IterationVerticalGrid(
            modifier = Modifier.padding(top = 4.dp),
            spacing = 4.dp,
        ) {
            item.iterations.forEach {
                TextFieldBody3(
                    modifier = Modifier
                        .background(
                            color = DesignComponent.colors.primary70,
                            shape = CircleShape
                        ).padding(horizontal = 8.dp, vertical = 4.dp),
                    text = it.weight + " x " + it.repeat
                )
            }
        }
    }
    Spacer(modifier = Modifier.size(12.dp))
}

@Composable
private fun CycleItem() {
    Row(
        modifier = Modifier.background(
            color = DesignComponent.colors.tertiary100,
            shape = CircleShape
        ).padding(horizontal = 10.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextFieldBody2(
            text = "Week from:",
            color = DesignComponent.colors.tertiaryInverse,
        )
        TextFieldBody2(
            text = "16.09.2022",
            color = DesignComponent.colors.tertiaryInverse,
        )
    }
}

@Composable
fun IterationVerticalGrid(
    modifier: Modifier = Modifier,
    spacing: Dp,
    content: @Composable () -> Unit
) = Layout(
    content = content,
    modifier = modifier
) { measurables, constraints ->
    var currentRow = 0
    var currentOrigin = IntOffset.Zero
    val spacingValue = spacing.toPx().toInt()
    val placeables = measurables.map { measurable ->
        val placeable = measurable.measure(constraints)

        if (currentOrigin.x > 0f && currentOrigin.x + placeable.width > constraints.maxWidth) {
            currentRow += 1
            currentOrigin = currentOrigin.copy(x = 0, y = currentOrigin.y + placeable.height + spacingValue)
        }

        placeable to currentOrigin.also {
            currentOrigin = it.copy(x = it.x + placeable.width + spacingValue)
        }
    }

    layout(
        width = constraints.maxWidth,
        height = placeables.lastOrNull()?.run { first.height + second.y } ?: 0
    ) {
        placeables.forEach {
            val (placeable, origin) = it
            placeable.place(origin.x, origin.y)
        }
    }
}