package exerciseexamplebuilder.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import atom.Design
import components.Error
import components.ShadowFooter
import components.ShadowFooterSpace
import components.ShadowHeader
import components.ShadowHeaderSpace
import components.chips.Chip
import components.chips.ChipState
import components.inputs.InputExerciseName
import components.inputs.InputUrl
import components.roots.ScreenRoot
import exerciseexamplebuilder.main.components.MuscleGroup
import exerciseexamplebuilder.main.models.EquipmentGroup
import exerciseexamplebuilder.main.models.FilterPack
import exerciseexamplebuilder.main.models.MuscleGroup
import exerciseexamplebuilder.main.models.StatusEnum
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import molecule.PaddingM
import molecule.PaddingS
import molecule.TextBody1
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

        filterPack = state.filterPack,
        selectCategory = vm::selectCategory,
        selectForceType = vm::selectForceType,
        selectExperience = vm::selectExperience,
        selectWeightType = vm::selectWeightType,

        equipments = state.equipmentGroups
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

    filterPack: FilterPack,
    selectCategory: (value: String) -> Unit,
    selectExperience: (value: String) -> Unit,
    selectForceType: (value: String) -> Unit,
    selectWeightType: (value: String) -> Unit,

    equipments: ImmutableList<EquipmentGroup>
) {

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.toxic.copy(alpha = 0.2f),
        borderColor = Design.colors.toxic,
        contentColor = Design.colors.content
    )

    val unSelectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.colors.caption,
        contentColor = Design.colors.content
    )

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
                    .defaultMinSize(minHeight = 320.dp)
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

            PaddingM()

            TextBody1(modifier = Modifier.padding(horizontal = Design.dp.paddingM), provideText = { "Categories" })

            PaddingS()

            LazyRow(
                contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                filterPack.categories.forEach {
                    item {
                        Chip(
                            chipState = if (it.isSelected) selectedChipState else unSelectedChipState,
                            text = it.value.capitalize(Locale.current),
                            onClick = { selectCategory.invoke(it.value) }
                        )
                    }
                }
            }

            PaddingM()

            TextBody1(modifier = Modifier.padding(horizontal = Design.dp.paddingM), provideText = { "Weight Type" })

            PaddingS()

            LazyRow(
                contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                filterPack.weightTypes.forEach {
                    item {
                        Chip(
                            chipState = if (it.isSelected) selectedChipState else unSelectedChipState,
                            text = it.value.capitalize(Locale.current),
                            onClick = { selectWeightType.invoke(it.value) }
                        )
                    }
                }
            }

            PaddingM()

            TextBody1(modifier = Modifier.padding(horizontal = Design.dp.paddingM), provideText = { "Force Type" })

            PaddingS()

            LazyRow(
                contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                filterPack.forceTypes.forEach {
                    item {
                        Chip(
                            chipState = if (it.isSelected) selectedChipState else unSelectedChipState,
                            text = it.value.capitalize(Locale.current),
                            onClick = { selectForceType.invoke(it.value) }
                        )
                    }
                }
            }

            PaddingM()

            TextBody1(modifier = Modifier.padding(horizontal = Design.dp.paddingM), provideText = { "Experience" })

            PaddingS()

            LazyRow(
                contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                filterPack.experiences.forEach {
                    item {
                        Chip(
                            chipState = if (it.isSelected) selectedChipState else unSelectedChipState,
                            text = it.value.capitalize(Locale.current),
                            onClick = { selectExperience.invoke(it.value) }
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
