package exerciseexamples.edit

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import atom.Design
import components.Error
import components.chips.Chip
import components.chips.ChipState
import components.roots.ScreenRoot
import exerciseexamples.edit.components.Footer
import exerciseexamples.edit.components.Header
import exerciseexamples.edit.state.ExerciseExample
import exerciseexamples.edit.state.MuscleType
import kotlinx.collections.immutable.ImmutableList
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextH4
import percents

@Composable
internal fun ExerciseExampleBuilderContent(
    vm: ExerciseExampleBuilderViewModel,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        loading = state.loading,
        error = { state.error },
        clearError = vm::clearError,

        exerciseExample = state.exerciseExample,
        minimalRange = state.minimalRange,
        sliderRange = state.sliderRange,

        setExerciseExampleName = vm::setExerciseExampleName,

        deleteExercise = {},
        onMuscleBundleChange = vm::onMuscleBundleChange,
        confirm = { vm.setExerciseExample(success = back) },
        selectMuscle = vm::selectMuscle,
        muscleTypes = state.muscleTypes
    )
}

@Composable
private fun Content(
    loading: Boolean,
    error: () -> String?,
    clearError: () -> Unit,

    exerciseExample: ExerciseExample?,

    minimalRange: Int,
    sliderRange: ClosedRange<Int>,

    setExerciseExampleName: (String) -> Unit,
    onMuscleBundleChange: (ImmutableList<MuscleType>) -> Unit,
    deleteExercise: () -> Unit,
    confirm: () -> Unit,

    muscleTypes: ImmutableList<MuscleType>,
    selectMuscle: (id: String) -> Unit
) {

    val unSelectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.colors.caption,
        contentColor = Design.colors.content
    )

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize().animateContentSize()) {

            Header(
                exerciseExample = exerciseExample,
                minimalRange = minimalRange,
                sliderRange = sliderRange,
                setExerciseExampleName = setExerciseExampleName,
                onPercentageChange = onMuscleBundleChange,
                deleteExercise = deleteExercise,
                muscleTypes = muscleTypes
            )

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                itemsIndexed(muscleTypes, key = { _, item -> item.id }) { index, item ->

                    PaddingS()

                    Column(
                        modifier = Modifier.fillMaxWidth().padding(Design.dp.paddingM),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        TextH4(
                            modifier = Modifier.weight(1f),
                            provideText = { item.name },
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        PaddingM()

                        Box(modifier = Modifier.fillMaxWidth()) {

                            Image(
                                modifier = Modifier
                                    .height(180.dp)
                                    .aspectRatio(1f)
                                    .align(Alignment.CenterEnd),
                                imageVector = item.imageVector,
                                contentDescription = null
                            )

                            Column(
                                modifier = Modifier.fillMaxWidth(0.6f),
                                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                            ) {
                                item.muscles.forEach { muscle ->

                                    val selectedChipState = ChipState.Colored(
                                        backgroundColor = muscle.color.copy(alpha = 0.1f),
                                        borderColor = muscle.color,
                                        contentColor = Design.colors.content
                                    )

                                    Chip(
                                        chipState = if (muscle.isSelected) selectedChipState
                                        else unSelectedChipState,
                                        onClick = { selectMuscle.invoke(muscle.id) },
                                        text = buildString {
                                            append(muscle.name)
                                            if (muscle.percentage > 0) append(" ${muscle.percentage.percents()}")
                                        }
                                    )
                                }
                            }
                        }
                    }

                    if (index < muscleTypes.lastIndex) Shadow()
                }
            }

            Footer(
                modifier = Modifier.fillMaxWidth(),
                confirmEnabled = exerciseExample?.name?.isNotBlank() == true,
                confirmClick = confirm,
                loading = loading
            )
        }
    }
}