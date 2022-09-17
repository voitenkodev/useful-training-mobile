package content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.controls.*
import state.TrainingState

@Composable
fun TrainingsContent(
    trainings: List<TrainingState>,
    get: (TrainingState) -> Unit
) = LazyColumn(
    modifier = Modifier
        .fillMaxSize()
        .background(DesignComponent.colors.primary50),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace),
    contentPadding = PaddingValues(DesignComponent.size.rootSpace)
) {

    item {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextFieldH1(
                modifier = Modifier.padding(top = 44.dp, bottom = 8.dp),
                text = "Trainings!",
            )
            TextFieldH1(
                modifier = Modifier.padding(top = 44.dp, bottom = 8.dp),
                text = "\uD83D\uDCCA",
            )

        }
    }

    trainings.forEachIndexed { index, item ->
//        if (index % 3 == 0) {
//            item {
//                CycleItem()
//            }
//        }
        item(item) {
            TrainingItem(
                trainingState = item,
                get = get
            )
        }
    }
}

@Composable
fun TrainingItem(
    trainingState: TrainingState,
    get: (TrainingState) -> Unit
) = Column(
    modifier = Modifier
        .background(DesignComponent.colors.primary100, DesignComponent.shape.minShape)
        .padding(bottom = 24.dp)
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextFieldBody1(
            modifier = Modifier.padding(vertical = 12.dp),
            text = trainingState.weekDay.name,
            color = DesignComponent.colors.secondary100,
            fontWeight = FontWeight.Bold
        )
        TextFieldBody1(
            modifier = Modifier.padding(vertical = 12.dp),
            text = trainingState.date.takeLast(5), // todo update to format date
            color = DesignComponent.colors.primaryInverse50,
        )

        Spacer(modifier = Modifier.weight(1f))

        IconPrimary(
            modifier = Modifier.height(20.dp),
            imageVector = Icons.Default.Edit,
            color = DesignComponent.colors.tertiary100,
            onClick = { get.invoke(trainingState) }
        )
    }

    DividerPrimary(modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 4.dp))

    trainingState.exercises.forEachIndexed { index, item ->

        Row(modifier = Modifier.padding(horizontal = 12.dp).padding(top = 8.dp)) {

            TextFieldBody2(text = "${index + 1}.", fontWeight = FontWeight.Bold)

            Column {

                TextFieldBody2(text = " ${item.name}", fontWeight = FontWeight.Bold)

                IterationVerticalGrid(
                    modifier = Modifier.padding(top = 6.dp, bottom = 2.dp),
                    spacing = 4.dp,
                ) {
                    item.iterations.forEach {
                        TextFieldBody2(
                            modifier = Modifier
                                .background(
                                    color = DesignComponent.colors.primary70,
                                    shape = DesignComponent.shape.minShape
                                )
                                .padding(horizontal = 6.dp, vertical = 4.dp),
                            text = it.weight + "x" + it.repeat
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CycleItem() {
    Row(
        modifier = Modifier.background(
            color = DesignComponent.colors.tertiary50,
            shape = DesignComponent.shape.minShape
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
private fun IterationVerticalGrid(
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