package trainingbuilder.builder.popups

import Icons
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import atom.Design
import components.inputs.InputExerciseName
import components.overlay.ShadowBackground
import components.roots.PopupScreenRoot
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextBody1
import molecule.TextBody2
import molecule.TextH4
import molecule.primaryBackground
import molecule.secondaryDefaultBackground
import trainingbuilder.builder.popups.components.SetIteration
import trainingbuilder.builder.state.Exercise
import trainingbuilder.builder.state.ExerciseExample
import trainingbuilder.builder.state.Iteration

@Composable
internal fun SetExercisePopup(
    exerciseExample: ExerciseExample?,
    index: Int,
    selectedExercise: Exercise? = null,
    close: () -> Unit,
    save: (index: Int, exercise: Exercise) -> Unit
) {

    val exercise = remember(selectedExercise) {
        mutableStateOf(selectedExercise ?: Exercise())
    }

    val selectedIterationIndex: MutableState<Int> = remember {
        mutableStateOf(-1)
    }

    val updateName = remember {
        { value: String -> exercise.value = exercise.value.copy(name = value) }
    }

    val saveIteration = remember {
        { index: Int, iteration: Iteration ->
            val iterations = if (index in 0..exercise.value.iterations.lastIndex)
                exercise.value.iterations.set(index, iteration)
            else buildList {
                addAll(exercise.value.iterations)
                add(iteration)
            }.toPersistentList()
            exercise.value = exercise.value.copy(iterations = iterations.toPersistentList())
            selectedIterationIndex.value = -1
        }
    }

    val removeSelectedIteration = remember {
        {
            val list = exercise.value.iterations
                .mapIndexedNotNull { index, iteration ->
                    if (index == selectedIterationIndex.value) return@mapIndexedNotNull null
                    iteration
                }.toPersistentList()
            exercise.value = exercise.value.copy(iterations = list)
            selectedIterationIndex.value = -1
        }
    }

    val selectIteration = remember {
        { index: Int -> selectedIterationIndex.value = index }
    }

    val clearSelectedIteration = remember {
        { selectedIterationIndex.value = -1 }
    }

    PopupScreenRoot(title = "Exercise", icon = Icons.close to close) {

        Box(modifier = Modifier.weight(1f).imePadding()) {

            Column(Modifier.fillMaxSize()) {
                EditExercise(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .primaryBackground()
                        .verticalScroll(rememberScrollState()),
                    name = { exercise.value.name },
                    updateName = updateName,
                    iterations = exercise.value.iterations,
                    addIteration = { selectedIterationIndex.value = exercise.value.iterations.lastIndex + 1 },
                    selectIteration = selectIteration
                )

                Footer(
                    cancel = close,
                    saveEnabled = exercise.value.name.isNotBlank() && exercise.value.iterations.isNotEmpty(),
                    save = { save.invoke(index, exercise.value); close.invoke() }
                )
            }

            val selectedIteration = remember(
                selectedIterationIndex.value,
                exercise.value.iterations
            ) { exercise.value.iterations.getOrNull(selectedIterationIndex.value) }

            ShadowBackground(
                modifier = Modifier.fillMaxSize(),
                condition = selectedIterationIndex.value != -1,
                onClick = clearSelectedIteration
            )

            if (selectedIterationIndex.value != -1) {
                SetIteration(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    index = selectedIterationIndex.value,
                    iteration = selectedIteration,
                    remove = removeSelectedIteration,
                    save = saveIteration,
                    close = clearSelectedIteration
                )
            }
        }
    }
}

@Composable
private fun Footer(
    cancel: () -> Unit,
    save: () -> Unit,
    saveEnabled: Boolean
) {
    Column(modifier = Modifier.fillMaxWidth()) {

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
    iterations: ImmutableList<Iteration>,
    name: () -> String,
    updateName: (String) -> Unit,
    addIteration: () -> Unit,
    selectIteration: (index: Int) -> Unit
) {

    Column(modifier = modifier) {

        PaddingM()

        InputExerciseName(
            provideName = name,
            update = updateName
        )

        PaddingM()

        TextH4(
            modifier = Modifier.padding(horizontal = Design.dp.paddingM),
            provideText = { "Iterations" }
        )

        PaddingS()

        Column {

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

            iterations.forEachIndexed { index, item ->

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
                            .clickable { selectIteration.invoke(index) }
                            .secondaryDefaultBackground()
                            .clip(shape = Design.shape.default)
                            .alpha(alpha = 0.5f)
                            .padding(Design.dp.paddingM)
                            .weight(0.65f),
                        textAlign = TextAlign.Center,
                        provideText = { item.weight },
                        maxLines = 1
                    )

                    TextBody1(
                        modifier = Modifier
                            .clickable { selectIteration.invoke(index) }
                            .secondaryDefaultBackground()
                            .clip(shape = Design.shape.default)
                            .alpha(alpha = 0.5f)
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
                    provideText = { "${iterations.size + 1}" },
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
                    provideText = { "Add new" },
                    maxLines = 1
                )
            }
        }

        PaddingM()
    }
}