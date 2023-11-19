package trainingbuilder.screen

import Icons
import PlatformBackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import com.arkivanov.essenty.backhandler.BackCallback
import components.Error
import components.Loading
import components.Popup
import components.indication.SlideIndicator
import components.overlay.TopShadow
import components.roots.Root
import components.roots.ScrollableRoot
import io.github.xxfast.decompose.router.LocalRouterContext
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import molecule.ButtonIconSecondary
import molecule.PaddingM
import molecule.PaddingXL
import molecule.PopupSheet
import molecule.TextH4
import platformTopInset
import recomposeHighlighter
import trainingbuilder.components.ConfigurationPage
import trainingbuilder.components.EditExercise
import trainingbuilder.components.ExercisesPage
import trainingbuilder.components.SummaryPage
import trainingbuilder.popups.EditExercisePopup
import trainingbuilder.popups.MusclePickerPopup
import trainingbuilder.popups.WeightPickerPopup
import trainingbuilder.state.Exercise
import trainingbuilder.state.MuscleType
import trainingbuilder.state.TrainingBuilderSteps

@Composable
internal fun TrainingContent(
    vm: TrainingViewModel,
    trainingId: String?,
    toReview: (trainingId: String) -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    LaunchedEffect(trainingId) {
        if (trainingId != null) {
            delay(500)
            vm.getTraining(trainingId)
        }
    }

    if (state.musclePickerPopupVisible) PopupSheet(
        onDismiss = vm::closePopups,
        content = { hideLambda ->
            MusclePickerPopup(
                muscleTypes = state.muscleTypes,
                apply = vm::applyMuscles,
                close = hideLambda
            )
        }
    )

    if (state.weightPickerPopupVisible) PopupSheet(
        onDismiss = vm::closePopups,
        content = { hideLambda ->
            WeightPickerPopup(
                initialWeight = state.changedUserWeight,
                close = hideLambda,
                apply = vm::applyNewWeight
            )
        }
    )

    if (state.editExercisePopupIsVisible) PopupSheet(
        onDismiss = vm::closePopups,
        content = { EditExercisePopup() }
    )

    Content(
        error = state.error,
        nextStep = vm::nextStep,
        previousStep = vm::previousStep,
        back = back,
        clearError = vm::clearError,
        selectedStep = state.selectedStep,
        steps = state.steps,
        selectedMuscles = state.muscleTypes,
        addMuscle = vm::openMusclePicker,
        unselectMuscle = vm::unselectMuscle,
        changePreferredDuration = vm::changePreferredDuration,
        preferredDuration = state.preferredDuration,
        initialUserWeight = state.profileUserWeight,
        changedUserWeight = state.changedUserWeight,
        changeUserWeight = vm::openWeightPicker
    )
}

@Composable
private fun Content(
    error: String?,

    // Steps
    steps: ImmutableList<TrainingBuilderSteps>,
    selectedStep: TrainingBuilderSteps,

    // Muscles
    selectedMuscles: ImmutableList<MuscleType>,
    addMuscle: () -> Unit,
    unselectMuscle: (id: String) -> Unit,

    // Preferred Duration
    preferredDuration: Int,
    changePreferredDuration: (Int) -> Unit,

    // User Weight
    initialUserWeight: Int,
    changedUserWeight: Int,
    changeUserWeight: () -> Unit,

    nextStep: () -> Unit,
    previousStep: (onEmpty: () -> Unit) -> Unit,

    back: () -> Unit,
    clearError: () -> Unit,
) {

    val backProvider by rememberUpdatedState(back)
    val backHandler = LocalRouterContext.current.backHandler
    backHandler.register(BackCallback { previousStep.invoke(backProvider) })
    val pagerState = rememberPagerState(pageCount = { steps.size })

    LaunchedEffect(selectedStep) {
        pagerState.animateScrollToPage(steps.indexOf(selectedStep))
    }

    Root(error = { Error(message = { error }, close = clearError) }) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box(modifier = Modifier.height(IntrinsicSize.Min)) {
                TopShadow(
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    modifier = Modifier.fillMaxWidth().platformTopInset(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {
                        PaddingXL()
                        SlideIndicator(pagerState)
                        PaddingM()
                    }
                )
            }

            PaddingM()

            HorizontalPager(
                modifier = Modifier.weight(1f),
                state = pagerState,
                userScrollEnabled = false
            ) {
                when (it) {
                    0 -> ConfigurationPage(
                        selectedMuscles = selectedMuscles,
                        addMuscle = addMuscle,
                        unselectMuscle = unselectMuscle,
                        duration = preferredDuration,
                        changeDuration = changePreferredDuration,
                        initialWeight = initialUserWeight,
                        changedWeight = changedUserWeight,
                        changeWeight = changeUserWeight
                    )

                    1 -> ExercisesPage()
                    2 -> SummaryPage()
                }
            }
        }
    }
}

@Deprecated("use Content")
@Composable
private fun Content2(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    tryBack: () -> Unit,
    back: () -> Unit,

    exitWarningVisibility: Boolean,
    closeExitScreenPopup: () -> Unit,

    removeExerciseIndex: () -> Int?,
    removeExercise: (index: Int?) -> Unit,
    closeRemoveExercisePopup: () -> Unit,

    openExitScreenPopup: () -> Unit,
    saveTraining: () -> Unit,

    exerciseNames: () -> List<String>,
    removeExerciseNameOption: (String) -> Unit,

    exercises: State<List<Exercise>>,
    updateName: (exerciseNumber: Int, value: String) -> Unit,
    updateWeight: (exerciseNumber: Int, iterationNumber: Int, value: String) -> Unit,
    updateRepeat: (exerciseNumber: Int, iterationNumber: Int, value: String) -> Unit,
    openRemoveExercisePopup: (index: Int) -> Unit,
    addExercise: () -> Unit,
) {

    val tryBackProvider by rememberUpdatedState(tryBack)
    val saveTrainingProvider by rememberUpdatedState(saveTraining)
    val openExitScreenPopupProvider by rememberUpdatedState(openExitScreenPopup)
    val addExerciseProvider by rememberUpdatedState(addExercise)
    val exerciseNamesProvider by rememberUpdatedState(exerciseNames)
    val removeExerciseNameOptionProvider by rememberUpdatedState(removeExerciseNameOption)

    ScrollableRoot(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter(),
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(tryBackProvider) },
        popups = {
            Popup(
                visibility = exitWarningVisibility,
                title = "Warning",
                message = "Are you sure to exit from training?",
                button = "Back",
                click = back,
                back = closeExitScreenPopup
            )
            Popup(
                visibility = removeExerciseIndex() != null,
                title = "Warning",
                message = "Are you sure to remove exercise?",
                button = "Yes",
                click = {
                    removeExercise(removeExerciseIndex())
                    closeRemoveExercisePopup()
                },
                back = closeRemoveExercisePopup
            )
        },
        header = {
            Row {
                ButtonIconSecondary(
                    modifier = Modifier.size(Design.dp.componentL),
                    imageVector = Icons.arrowLeft,
                    onClick = openExitScreenPopupProvider
                )

                Spacer(Modifier.weight(1f))

                ButtonIconSecondary(
                    modifier = Modifier.size(Design.dp.componentL),
                    imageVector = Icons.done,
                    onClick = saveTrainingProvider
                )
            }
        },
        content = {

            itemsIndexed(exercises.value) { index, exercise ->
                val indexProvider by rememberUpdatedState(index)
                val name by rememberUpdatedState(exercise.name)
                val number by rememberUpdatedState(index + 1)
                val iterations by rememberUpdatedState(exercise.iterations)

                EditExercise(
                    modifier = Modifier.recomposeHighlighter(),
                    number = { number },
                    nameOptions = exerciseNamesProvider,
                    name = { name },
                    updateName = { updateName(indexProvider, it) },
                    updateWeight = { num, value -> updateWeight(indexProvider, num, value) },
                    updateRepeat = { num, value -> updateRepeat(indexProvider, num, value) },
                    iterations = { iterations },
                    remove = { openRemoveExercisePopup(indexProvider) },
                    removeNameOption = removeExerciseNameOptionProvider
                )
            }

            item(key = "new_exercise_btn") {
                NewExercise(
                    modifier = Modifier
                        .animateItemPlacement()
                        .recomposeHighlighter(),
                    onClick = addExerciseProvider
                )
            }
        }
    )
}

@Composable
private fun NewExercise(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
            .border(
                width = 1.dp,
                shape = Design.shape.default, color = Design.colors.orange
            )
            .clickable(onClick = onClick)
            .recomposeHighlighter(),
        content = {
            TextH4(
                modifier = Modifier
                    .align(Alignment.Center)
                    .recomposeHighlighter(),
                provideText = { "Add Exercise" },
                color = Design.colors.orange
            )
        }
    )
}