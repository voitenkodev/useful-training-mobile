package trainingbuilder.training.pages.exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import components.cards.ExerciseCardSmall
import components.inputs.InputExerciseName
import exercise.ExerciseExample
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextBody1
import molecule.TextBody2
import molecule.TextLabel
import molecule.Toolbar
import molecule.primaryBackground
import molecule.secondaryBackground
import molecule.secondaryDefaultBackground
import resources.Icons
import trainingbuilder.training.models.BuildExercise
import trainingbuilder.training.models.BuildIteration
import trainingbuilder.training.pages.iteration.SetIterationContent
import trainingbuilder.training.pages.iteration.SetIterationStateHolder

@Composable
internal fun SetExerciseContent(
    exerciseExample: ExerciseExample?,
    selectedBuildExercise: BuildExercise? = null,
    close: () -> Unit,
    save: (buildExercise: BuildExercise) -> Unit,
    toExerciseExampleDetails: (id: String) -> Unit
) {

    val focus = LocalFocusManager.current

    val setExerciseStateHolder = remember {
        SetExerciseStateHolder(
            exerciseExample = exerciseExample,
            selectedBuildExercise = selectedBuildExercise
        )
    }

    val state by setExerciseStateHolder.state.collectAsState()

    val innerClose = remember {
        {
            focus.clearFocus()
            close.invoke()
        }
    }

    val innerSave = remember {
        {
            focus.clearFocus()
            save.invoke(state.buildExercise)
            close.invoke()
        }
    }

    Box(modifier = Modifier.fillMaxSize().secondaryBackground()) {

        Column(modifier = Modifier.statusBarsPadding()) {

            PaddingS()

            Toolbar(title = "Exercise", icon = Icons.close to innerClose)

            PaddingS()

            state.buildExercise.exerciseExample?.let { ex ->
                ExerciseCardSmall(
                    name = ex.name,
                    imageUrl = ex.imageUrl,
                    viewDetails = { toExerciseExampleDetails.invoke(ex.id) },
                    musclesWithPercent = ex.exerciseExampleBundles.map { it.muscle.name to it.percentage }
                )
            } ?: InputExerciseName(
                value = { state.buildExercise.name },
                onValueChange = setExerciseStateHolder::updateName
            )

            PaddingM()

            Shadow()

            EditExercise(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .primaryBackground()
                    .verticalScroll(rememberScrollState()),
                buildIterations = state.buildExercise.buildIterations,
                selectIterationWeight = setExerciseStateHolder::selectIterationTargetWeight,
                selectIterationRepetition = setExerciseStateHolder::selectIterationTargetRepetition,
                addIteration = setExerciseStateHolder::addIteration
            )

            Footer(
                cancel = innerClose,
                saveEnabled = state.buildExercise.name.isNotBlank() && state.buildExercise.buildIterations.isNotEmpty(),
                save = innerSave
            )
        }

        val setIterationStateHolder =
            remember(state.focusTarget, state.buildExercise.buildIterations) {
                SetIterationStateHolder(
                    selectedBuildIteration = state.buildExercise.buildIterations.getOrNull(state.focusTarget.first),
                    targetFocus = state.focusTarget.second,
                    iterationIndex = state.focusTarget.first
                )
            }

        SetIterationContent(
            stateHolder = setIterationStateHolder,
            remove = setExerciseStateHolder::removeSelectedIteration,
            save = setExerciseStateHolder::saveIteration,
            close = setExerciseStateHolder::clearSelectedIteration
        )
    }
}

@Composable
private fun Footer(
    cancel: () -> Unit,
    save: () -> Unit,
    saveEnabled: Boolean
) {
    Column(modifier = Modifier.fillMaxWidth().navigationBarsPadding()) {

        Shadow()

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = "cancel",
                onClick = cancel
            )

            ButtonPrimary(
                modifier = Modifier.weight(1f),
                enabled = saveEnabled,
                text = "Save",
                onClick = save
            )
        }
    }
}

@Composable
private fun EditExercise(
    modifier: Modifier = Modifier,
    buildIterations: ImmutableList<BuildIteration>,
    addIteration: () -> Unit,
    selectIterationWeight: (index: Int) -> Unit,
    selectIterationRepetition: (index: Int) -> Unit
) {
    Column(modifier = modifier) {

        PaddingM()

        TextLabel(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Sets" }
        )

        PaddingS()

        Row(
            modifier = Modifier
                .padding(horizontal = Design.dp.paddingM, vertical = Design.dp.paddingS)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextBody1(
                modifier = Modifier
                    .background(
                        color = Design.colors.black10,
                        shape = Design.shape.default
                    ).clip(shape = Design.shape.default)
                    .alpha(alpha = 0.5f)
                    .width(46.dp)
                    .padding(vertical = Design.dp.paddingM),
                provideText = { "N" },
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            TextBody1(
                modifier = Modifier
                    .background(
                        color = Design.colors.black10,
                        shape = Design.shape.default
                    ).clip(shape = Design.shape.default)
                    .alpha(alpha = 0.5f)
                    .padding(Design.dp.paddingM)
                    .weight(0.65f),
                textAlign = TextAlign.Center,
                provideText = { "Weight" },
                maxLines = 1
            )

            TextBody1(
                modifier = Modifier
                    .background(
                        color = Design.colors.black10,
                        shape = Design.shape.default
                    ).clip(shape = Design.shape.default)
                    .alpha(alpha = 0.5f)
                    .padding(Design.dp.paddingM)
                    .weight(0.35f),
                textAlign = TextAlign.Center,
                provideText = { "Reps" },
                maxLines = 1
            )
        }

        buildIterations.forEachIndexed { index, item ->

            Row(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM, vertical = Design.dp.paddingS)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextBody2(
                    modifier = Modifier.width(46.dp),
                    provideText = { "${index + 1}" },
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )

                TextBody1(
                    modifier = Modifier
                        .secondaryDefaultBackground()
                        .clip(shape = Design.shape.default)
                        .clickable { selectIterationWeight.invoke(index) }
                        .padding(Design.dp.paddingM)
                        .weight(0.65f),
                    textAlign = TextAlign.Center,
                    provideText = { item.weight },
                    maxLines = 1
                )

                TextBody1(
                    modifier = Modifier
                        .secondaryDefaultBackground()
                        .clip(shape = Design.shape.default)
                        .clickable { selectIterationRepetition.invoke(index) }
                        .padding(Design.dp.paddingM)
                        .weight(0.35f),
                    textAlign = TextAlign.Center,
                    provideText = { item.repetitions },
                    maxLines = 1
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(horizontal = Design.dp.paddingM, vertical = Design.dp.paddingS)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextBody2(
                modifier = Modifier.width(46.dp),
                provideText = { "${buildIterations.size + 1}" },
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            TextBody1(
                modifier = Modifier
                    .background(
                        color = Design.colors.orange,
                        shape = Design.shape.default
                    ).clip(shape = Design.shape.default)
                    .clickable(onClick = addIteration)
                    .padding(vertical = Design.dp.paddingM)
                    .weight(1f),
                textAlign = TextAlign.Center,
                provideText = { "New set" },
                maxLines = 1
            )
        }

        PaddingM()
    }
}