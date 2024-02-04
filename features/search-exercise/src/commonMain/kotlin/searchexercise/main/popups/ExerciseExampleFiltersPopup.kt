package searchexercise.main.popups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import components.roots.PopupRoot
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import molecule.ButtonPrimary
import molecule.POPUP_ANIM_DURATION_MS
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.SmallToolbar
import molecule.TextBody1
import resources.Icons
import searchexercise.main.models.FilterEquipment
import searchexercise.main.models.FilterMuscleGroup
import searchexercise.main.models.FilterPack
import searchexercise.main.popups.components.EquipmentGroups
import searchexercise.main.popups.components.MuscleGroup

@Composable
internal fun ExerciseExampleFiltersPopup(
    close: () -> Unit,

    muscles: ImmutableList<FilterMuscleGroup>,
    selectMuscle: (id: String) -> Unit,

    filterPack: FilterPack,
    selectCategory: (value: String) -> Unit,
    selectExperience: (value: String) -> Unit,
    selectForceType: (value: String) -> Unit,
    selectWeightType: (value: String) -> Unit,

    equipments: ImmutableList<FilterEquipment>,
    selectEquipment: (id: String) -> Unit,

    applyFilters: () -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

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

    PopupRoot(modifier = Modifier.fillMaxHeight(0.9f)) {

        PaddingS()

        SmallToolbar(
            title = "Filters",
            icon = Icons.close to close
        )

        Shadow()

        Column(modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())) {
            PaddingM()

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(muscles, key = { it.id }) {
                    MuscleGroup(
                        item = it,
                        selectMuscle = selectMuscle
                    )
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

            EquipmentGroups(
                items = equipments,
                selectEquipment = selectEquipment
            )
        }

        Shadow()

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            ButtonPrimary(
                modifier = Modifier.weight(1f),
                text = "Apply",
                onClick = {
                    coroutineScope.launch {
                        close.invoke()
                        delay(POPUP_ANIM_DURATION_MS)
                        applyFilters.invoke()
                    }
                }
            )
        }
    }
}