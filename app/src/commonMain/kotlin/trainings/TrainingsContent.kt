package trainings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import designsystem.controls.TextFieldBody1
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldBody3
import designsystem.controls.TextFieldH1
import training.MOCK
import training.TrainingState

@Composable
fun TrainingsContent(
) = LazyColumn(
    modifier = Modifier.fillMaxSize().padding(DesignComponent.size.rootSpace),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace)
) {

    stickyHeader {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextFieldH1(
                text = "•",
                color = DesignComponent.colors.special
            )

            TextFieldBody2(
                text = "cycle from",
                color = DesignComponent.colors.primaryInverse.copy(alpha = 0.5f)
            )

            TextFieldBody1(text = "16.09.2022")
        }
    }
    item {
        TrainingItem(MOCK)
    }
}

@Composable
fun TrainingItem(trainingState: TrainingState) = Column(
    modifier = Modifier.background(DesignComponent.colors.primary, RoundedCornerShape(8.dp))
        .border(BorderStroke(2.dp, DesignComponent.colors.special), RoundedCornerShape(8.dp))
        .padding(12.dp)
) {

    Row(
        modifier = Modifier.fillMaxSize().padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextFieldBody2(
            modifier = Modifier.weight(1f),
            text = "Monday",
            color = DesignComponent.colors.special,
            fontWeight = FontWeight.Bold
        )
        Icon(
            modifier = Modifier.size(30.dp).padding(4.dp),
            imageVector = Icons.Default.ArrowForward,
            tint = DesignComponent.colors.special,
            contentDescription = null
        )
    }

    trainingState.exercises.forEachIndexed { index, item ->

        TextFieldBody2(
            modifier = Modifier.padding(top = 8.dp, bottom = 2.dp),
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
                    modifier = Modifier.background(
                        color = DesignComponent.colors.special.copy(alpha = DesignComponent.colors.alphaPrimary),
                        shape = CircleShape
                    ).padding(horizontal = 8.dp, vertical = 3.dp),
                    text = it.weight + " x " + it.repeat
                )
            }
        }
    }
    Spacer(modifier = Modifier.size(12.dp))
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