package presentation.trainings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import DesignComponent
import atomic.icons.BarChart
import components.Header
import components.Root
import components.items.TrainingItem
import controls.ButtonPrimary
import controls.IconPrimary
import controls.TextFieldBody2
import data.mapping.toTrainingStateList
import data.repository.TrainingRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import org.koin.mp.KoinPlatformTools
import presentation.map.toTrainingComponent
import Direction
import GlobalState
import NavigatorAction
import androidx.compose.runtime.remember
import presentation.review.ReviewAction
import presentation.training.TrainingAction
import presentation.training.TrainingState
import rememberDispatcher
import selectState

@Composable
fun TrainingsContent() {

    val state by selectState<GlobalState, TrainingsState> { this.trainingsState }
    val dispatcher = rememberDispatcher()

    val presenter = remember { TrainingsPresenter(dispatcher) }
    LaunchedEffect(Unit) { presenter.fetchTrainings() }

    Root(
        modifier = Modifier.fillMaxSize(),
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
                },
                statistic = {}
            )
        },
        content = {

            state.trainings.groupBy { it.endOfWeek }.onEach {

                item(key = "week_by_${it.key}") {
                    WeekItem(startOfWeek = it.key)
                }

                items(it.value) { training ->
                    TrainingItem(
                        training = training.toTrainingComponent(),
                        edit = {
                            dispatcher(TrainingAction.PutTrainingAction(training))
                            dispatcher(TrainingAction.ProvideEmptyIterations)
                            dispatcher(NavigatorAction.NAVIGATE(Direction.Training))
                        },
                        review = {
                            dispatcher(ReviewAction.FetchTrainings(selected = training))
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
    add: () -> Unit,
    statistic: () -> Unit
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
        modifier = Modifier
            .size(56.dp)
            .background(
                color = DesignComponent.colors.accent_secondary,
                shape = DesignComponent.shape.default
            ),
        imageVector = BarChart,
        onClick = statistic
    )
}