package presentation.trainings

import BackHandler
import DesignComponent
import GlobalState
import Graph
import Navigator
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atomic.icons.BarChart
import components.Error
import components.Header
import components.Loading
import components.Root
import components.items.TrainingItem
import controls.ButtonPrimary
import controls.IconPrimary
import controls.TextFieldBody2
import presentation.map.toTrainingComponent
import presentation.review.ReviewAction
import presentation.training.Training
import presentation.training.TrainingAction
import rememberDispatcher
import selectState

@Composable
fun TrainingsContent(
    navigator: Navigator
) {

    val state by selectState<GlobalState, TrainingsState> { this.trainingsState }
    val dispatcher = rememberDispatcher()

    val presenter = remember { TrainingsPresenter(dispatcher) }

    LaunchedEffect(Unit) {
        presenter.fetchTrainings()
    }

    Root(
        modifier = Modifier.fillMaxSize(),
        loading = {
            Loading(state.loading)
        },
        error = {
            Error(message = state.error, close = { dispatcher(TrainingsAction.Error(null)) })
        },
        back = {
            BackHandler(action = { navigator.back() })
        },
        header = {
            Header(title = "Trainings!")
        },
        footer = {
            ButtonPrimary(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = DesignComponent.colors.accent_primary,
                        shape = DesignComponent.shape.default
                    ),
                text = "New Training",
                onClick = {
                    dispatcher(TrainingAction.PutTrainingAction(Training()))
                    navigator.direct(Graph.Training)

                }
            )
        },
        scrollableContent = {

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
                            navigator.direct(Graph.Training)
                        },
                        review = {
                            dispatcher(ReviewAction.FetchTrainings(selected = training))
                            navigator.direct(Graph.Review)
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