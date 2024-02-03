package exerciseexamplebuilder.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import components.Error
import components.ShadowFooter
import components.ShadowFooterSpace
import components.ShadowHeader
import components.ShadowHeaderSpace
import components.inputs.InputExerciseName
import components.inputs.InputUrl
import components.roots.ScreenRoot
import exerciseexamplebuilder.main.components.MuscleGroup
import exerciseexamplebuilder.main.models.EquipmentGroup
import exerciseexamplebuilder.main.models.MuscleGroup
import exerciseexamplebuilder.main.models.StatusEnum
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import molecule.PaddingM
import molecule.PaddingS
import percentagepicker.RangeSlider
import percentagepicker.ThumbRangeState

@Composable
internal fun ExerciseExampleBuilderContent(
    vm: ExerciseExampleBuilderViewModel,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        close = close,
        error = { state.error },
        clearError = vm::clearError,
        updateName = vm::updateName,
        name = state.name,
        updateImageUrl = vm::updateImageUrl,
        imageUrl = state.imageUrl,

        muscles = state.muscleGroups,
        selectMuscle = vm::selectMuscle,
        onMuscleBundleChange = vm::onMuscleBundleChange,
        minimalRange = state.minimalRange,
        sliderRange = state.sliderRange,

        equipments = state.equipmentGroups,
    )
}

@Composable
private fun Content(
    close: () -> Unit,
    error: () -> String?,
    clearError: () -> Unit,

    name: String,
    updateName: (String) -> Unit,
    imageUrl: String,
    updateImageUrl: (String) -> Unit,

    minimalRange: Int,
    sliderRange: ClosedRange<Int>,
    muscles: ImmutableList<MuscleGroup>,
    onMuscleBundleChange: (ImmutableList<MuscleGroup>) -> Unit,
    selectMuscle: (id: String) -> Unit,

    equipments: ImmutableList<EquipmentGroup>,
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

            ShadowHeaderSpace()

            PaddingM()

            InputExerciseName(
                value = { name },
                onValueChange = updateName
            )

            PaddingM()

            InputUrl(
                value = { imageUrl },
                onValueChange = updateImageUrl
            )

            PaddingM()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Design.colors.black10)
                    .height(320.dp)
            ) {

                PaddingM()

                val thumbs = remember(muscles) {
                    muscles
                        .flatMap { it.muscles }
                        .filter { it.status == StatusEnum.SELECTED }
                        .map {
                            ThumbRangeState(
                                id = it.id,
                                positionInRange = it.percentage,
                                color = it.color
                            )
                        }.toPersistentList()
                }

                RangeSlider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Design.dp.paddingL)
                        .height(46.dp),
                    range = sliderRange,
                    minimalRange = minimalRange,
                    thumbs = thumbs,
                    requiredFilledRange = false,
                    lineColor = Design.colors.caption,
                    onValueChange = { updatedThumbs ->
                        val newList = muscles.map {
                            val innerMuscles = it.muscles.map { m ->
                                val newPercentage = updatedThumbs.find { it.id == m.id }?.positionInRange ?: m.percentage
                                m.copy(percentage = newPercentage)
                            }.toPersistentList()
                            it.copy(muscles = innerMuscles)
                        }.toPersistentList()
                        onMuscleBundleChange(newList)
                    }
                )
                PaddingS()

                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(muscles, key = { it.id }) {
                        MuscleGroup(
                            item = it,
                            selectMuscle = selectMuscle
                        )
                    }
                }
            }

            ShadowFooterSpace()
        }

        ShadowHeader(
            title = "Exercise Builder"
        )

        ShadowFooter(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
//            primary = primary,
            close = close
        )
    }
}
