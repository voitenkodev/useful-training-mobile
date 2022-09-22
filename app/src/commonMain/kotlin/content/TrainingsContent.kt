package content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.AccentLabel
import designsystem.controls.*
import state.TrainingState

@Composable
fun TrainingsContent(
    modifier: Modifier = Modifier,
    state: List<TrainingState>,
    get: (TrainingState) -> Unit,
    add: () -> Unit,
) = Box(modifier = modifier) {

    val contentPadding = PaddingValues(
        top = DesignComponent.size.rootSpace,
        start = DesignComponent.size.rootSpace,
        end = DesignComponent.size.rootSpace,
        bottom = DesignComponent.size.rootSpace + 56.dp + DesignComponent.size.rootSpace
    )

    TrainingsList(
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

    item(key = "header_spacer") {
        Spacer(modifier = Modifier.size(44.dp))
    }

    stickyHeader(key = "header") {
        Row(
            modifier = Modifier.fillMaxWidth().background(DesignComponent.colors.primary),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextFieldH1(
                text = "Trainings!",
            )

            IconPrimary(
                modifier = Modifier.size(56.dp),
                imageVector = Icons.Default.ArrowForward,
                color = DesignComponent.colors.accent_secondary
            ) {

            }
        }
    }

    state.forEachIndexed { index, item ->
        item(key = item.id) {
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