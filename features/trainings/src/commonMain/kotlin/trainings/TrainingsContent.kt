package trainings

import Design
import Images
import PlatformBackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import components.Error
import components.ExerciseItem
import components.Loading
import components.backgrounds.BrandGradientCenterEnd
import components.backgrounds.BrandGradientCenterStart
import components.items.TrainingFooter
import components.overlay.shadowBottomFrame
import components.overlay.shadowTopFrame
import components.roots.Root
import controls.ButtonIcon
import controls.TextFieldBody1
import controls.TextFieldH1
import platformInsets
import recomposeHighlighter
import training.Training

@Composable
fun TrainingsContent(
    vm: TrainingsViewModel,
    toTrainingReview: (trainingId: String) -> Unit,
    toTrainingById: (trainingId: String) -> Unit,
    toNewTraining: () -> Unit,
    toSummary: () -> Unit,
    back: () -> Unit,
) {

    val state by vm.state.collectAsState()

    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        vm.getTrainings()
    }

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        back = back,

        weekDay = { state.weekDay },
        date = { state.date },
        moveToSummary = toSummary,
        newTraining = toNewTraining,
        logout = vm::logout,

        trainings = { state.trainings },
        editTraining = toTrainingById,
        reviewTraining = toTrainingReview
    )
}

@Composable
private fun Content(

    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // HEADER
    weekDay: () -> String,
    date: () -> String,
    moveToSummary: () -> Unit,
    newTraining: () -> Unit,
    logout: () -> Unit,

    // CONTENT
    trainings: () -> List<Training>,
    editTraining: (trainingId: String) -> Unit,
    reviewTraining: (trainingId: String) -> Unit,
) {

    val moveToSummaryProvider by rememberUpdatedState(moveToSummary)
    val addTrainingProvider by rememberUpdatedState(newTraining)
    val backProvider by rememberUpdatedState(back)

    Root(
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(backProvider) },
    ) {

        val pagerState = rememberPagerState { trainings().size }

        VerticalPager(state = pagerState) {
            TrainingPage(
                training = trainings()[it],
                editTraining = editTraining,
                reviewTraining = reviewTraining
            )
        }

        ButtonIcon(
            modifier = Modifier
                .platformInsets()
                .padding(Design.dp.padding),
            imageVector = Icons.Default.ArrowBack,
            onClick = {}
        )
    }
}

@Composable
private fun PagerScope.TrainingPage(
    training: Training,
    editTraining: (trainingId: String) -> Unit,
    reviewTraining: (trainingId: String) -> Unit,
) {

    val trainingProvider by rememberUpdatedState(training)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        BackgroundImage()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .platformInsets()
                .padding(
                    top = Design.dp.padding + Design.dp.padding + Design.dp.component,
                    bottom = Design.dp.padding ,
                    end = Design.dp.padding,
                    start = Design.dp.padding
                ),
        ) {

            Title(
                weekDay = { training.weekDay },
                date = { training.shortStartDate },
            )

            Spacer(modifier = Modifier.size(32.dp))

            TrainingContent(
                modifier = Modifier
                    .recomposeHighlighter(),
                training = training,
                edit = {
                    val id = trainingProvider.id ?: return@TrainingContent
                    editTraining(id)
                },
                review = {
                    val id = trainingProvider.id ?: return@TrainingContent
                    reviewTraining(id)
                }
            )

            Spacer(modifier = Modifier.weight(1f))
        }

        BrandGradientCenterEnd()

        BrandGradientCenterStart()
    }
}

@Composable
private fun BackgroundImage() {

    val height = 250.dp

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        painter = Images.gym(),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .shadowBottomFrame()
    )

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .shadowTopFrame()
    )
}

@Composable
internal fun TrainingContent(
    modifier: Modifier = Modifier,
    training: Training,
    edit: (() -> Unit)? = null,
    review: (() -> Unit)? = null,
) = Column(
    modifier = modifier
        .padding(horizontal = Design.dp.padding)
        .recomposeHighlighter()
) {

    training.exercises.forEachIndexed { index, item ->

        val number by rememberUpdatedState(index + 1)
        ExerciseItem(
            modifier = Modifier.recomposeHighlighter(),
            provideNumber = { number },
            exercise = { item }
        )
    }

    TrainingFooter(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter(),
        tonnage = training.tonnage.toString(),
        durationTime = training.durationTime
    )
}

@Composable
private fun Title(
    modifier: Modifier = Modifier,
    weekDay: () -> String,
    date: () -> String,
) = Column(
    modifier = modifier
        .padding(start = Design.dp.padding)
        .recomposeHighlighter()
) {

    TextFieldH1(
        modifier = Modifier
            .wrapContentHeight()
            .recomposeHighlighter(),
        provideText = weekDay,
    )

    TextFieldBody1(
        modifier = Modifier
            .recomposeHighlighter(),
        provideText = date,
    )
}