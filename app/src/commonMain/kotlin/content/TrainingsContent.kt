package content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import designsystem.components.AccentLabel
import designsystem.components.Title
import designsystem.controls.*
import state.TrainingState

@Composable
fun TrainingsContent(
    modifier: Modifier = Modifier,
    state: List<TrainingState>,
    get: (TrainingState) -> Unit,
    add: () -> Unit,
) = Box {

    val contentPadding = PaddingValues(
        top = DesignComponent.size.rootSpace,
        start = DesignComponent.size.rootSpace,
        end = DesignComponent.size.rootSpace,
        bottom = DesignComponent.size.rootSpace + 56.dp + DesignComponent.size.rootSpace
    )

    TrainingsList(
        modifier = modifier,
        state = state,
        get = get,
        contentPadding = contentPadding
    )

    IconPrimary(
        modifier = Modifier
            .padding(DesignComponent.size.rootSpace)
            .size(56.dp)
            .background(
                color = DesignComponent.colors.accent_primary,
                shape = DesignComponent.shape.circleShape
            )
            .align(Alignment.BottomEnd),
        imageVector = Icons.Default.Add,
        onClick = add
    )
}

@Composable
private fun TrainingsList(
    modifier: Modifier = Modifier,
    state: List<TrainingState>,
    get: (TrainingState) -> Unit,
    contentPadding: PaddingValues
) = LazyColumn(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace),
    contentPadding = contentPadding
) {

    item {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Title(
                text = "Trainings!"
            )

            TextFieldH1(
                modifier = Modifier.padding(top = 44.dp, bottom = 8.dp),
                text = "\uD83D\uDCCA",
            )

        }
    }

    state.forEachIndexed { index, item ->
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
private fun TrainingItem(
    trainingState: TrainingState,
    get: (TrainingState) -> Unit
) = Column(
    modifier = Modifier
        .background(
            color = DesignComponent.colors.secondary,
            shape = DesignComponent.shape.maxShape
        )
        .padding(bottom = 24.dp)
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        AccentLabel(
            modifier = Modifier.padding(start = 12.dp, top = 12.dp, bottom = 12.dp, end = 4.dp),
            text = trainingState.weekDay.name,
        )

        TextFieldBody2(
            text = "Started at:",
            color = DesignComponent.colors.caption,
        )

        TextFieldBody2(
            text = trainingState.date.takeLast(5),
            color = DesignComponent.colors.content,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        IconPrimary(
            modifier = Modifier.height(20.dp),
            imageVector = Icons.Default.Edit,
            color = DesignComponent.colors.accent_secondary,
            onClick = { get.invoke(trainingState) }
        )
    }

    DividerPrimary(modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 4.dp))

    trainingState.exercises.forEachIndexed { index, item ->

        Row(
            modifier = Modifier.padding(horizontal = 12.dp).padding(top = 8.dp),
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

//@Composable
//private fun CycleItem() {
//    Row(
//        modifier = Modifier.background(
//            color = DesignComponent.colors.content,
//            shape = DesignComponent.shape.circleShape
//        ).padding(horizontal = 10.dp, vertical = 4.dp),
//        horizontalArrangement = Arrangement.spacedBy(4.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        TextFieldBody2(
//            text = "Week from:",
//            color = DesignComponent.colors.primary,
//        )
//        TextFieldBody2(
//            text = "16.09.2022",
//            color = DesignComponent.colors.primary,
//        )
//    }
//}

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