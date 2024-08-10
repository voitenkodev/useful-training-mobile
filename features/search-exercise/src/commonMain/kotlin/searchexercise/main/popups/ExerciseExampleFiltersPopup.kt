package searchexercise.main.popups

import IncludedStatusEnum
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import components.roots.PopupRoot
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import molecule.ButtonPrimary
import molecule.ButtonSecondary
import molecule.POPUP_ANIM_DURATION_MS
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.SmallToolbar
import molecule.TextLabel
import muscles.component.MuscleGroup
import resources.Icons
import searchexercise.main.popups.components.EquipmentGroups

@Composable
internal fun ExerciseExampleFiltersPopup(
    close: () -> Unit,
    stateHolder: ExerciseExampleFiltersStateHolder,
    applyFilters: (ExerciseExampleFiltersState) -> Unit
) {


    val state by stateHolder.state.collectAsState()

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

            PaddingL()

            if (state.filterPack.categories.isNotEmpty()) {

                TextLabel(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Categories" })

                PaddingS()

                LazyRow(
                    contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                ) {
                    state.filterPack.categories.forEach {
                        item {
                            Chip(
                                chipState = if (it.isSelected) selectedChipState else unSelectedChipState,
                                text = it.value.capitalize(Locale.current),
                                onClick = { stateHolder.selectCategory(it.value) }
                            )
                        }
                    }
                }

                PaddingL()
            }

            if (state.filterPack.weightTypes.isNotEmpty()) {

                TextLabel(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Weight Type" })

                PaddingS()

                LazyRow(
                    contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                ) {
                    state.filterPack.weightTypes.forEach {
                        item {
                            Chip(
                                chipState = if (it.isSelected) selectedChipState else unSelectedChipState,
                                text = it.value.capitalize(Locale.current),
                                onClick = { stateHolder.selectWeightType(it.value) }
                            )
                        }
                    }
                }

                PaddingL()
            }

            if (state.filterPack.forceTypes.isNotEmpty()) {

                TextLabel(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Force Type" })

                PaddingS()

                LazyRow(
                    contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                ) {
                    state.filterPack.forceTypes.forEach {
                        item {
                            Chip(
                                chipState = if (it.isSelected) selectedChipState else unSelectedChipState,
                                text = it.value.capitalize(Locale.current),
                                onClick = { stateHolder.selectForceType(it.value) }
                            )
                        }
                    }
                }

                PaddingL()
            }

            if (state.filterPack.experiences.isNotEmpty()) {

                TextLabel(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Experience" })

                PaddingS()

                LazyRow(
                    contentPadding = PaddingValues(horizontal = Design.dp.paddingM),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                ) {
                    state.filterPack.experiences.forEach {
                        item {
                            Chip(
                                chipState = if (it.isSelected) selectedChipState else unSelectedChipState,
                                text = it.value.capitalize(Locale.current),
                                onClick = { stateHolder.selectExperience(it.value) }
                            )
                        }
                    }
                }

                PaddingL()
            }

            if (state.muscles.isNotEmpty()) {
                TextLabel(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Muscles" }
                )

                LazyRow(modifier = Modifier.defaultMinSize(minHeight = 240.dp).fillMaxWidth()) {
                    items(state.muscles, key = { it.id }) {
                        MuscleGroup(
                            modifier = Modifier.width(340.dp),
                            item = it,
                            selectMuscle = stateHolder::selectMuscle
                        )
                    }
                }

                PaddingM()
            }

            if (state.equipments.isNotEmpty()) {

                TextLabel(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Equipments" }
                )

                PaddingS()

                EquipmentGroups(
                    items = state.equipments,
                    selectEquipment = stateHolder::selectEquipment
                )
            }
        }

        Shadow()

        Row(
            modifier = Modifier.padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            val countFilters = remember(state) {
                val muscles = state.muscles.flatMap { it.muscles }.count { it.isSelected }
                val equipments = state.equipments.count { it.status == IncludedStatusEnum.INCLUDED }
                val categories = state.filterPack.categories.count { it.isSelected }
                val experience = state.filterPack.experiences.count { it.isSelected }
                val forceType = state.filterPack.forceTypes.count { it.isSelected }
                val weightType = state.filterPack.weightTypes.count { it.isSelected }
                muscles + categories + experience + forceType + weightType + equipments
            }

            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = "Clear",
                onClick = {
                    coroutineScope.launch {
                        stateHolder.clearFilters()
                        close.invoke()
                        delay(POPUP_ANIM_DURATION_MS)
                        applyFilters.invoke(state)
                    }
                }
            )
            ButtonPrimary(
                modifier = Modifier.weight(1f),
                enabled = countFilters > 0,
                text = buildString {
                    append("Apply")
                    if (countFilters > 0) append(" ($countFilters)")
                },
                onClick = {
                    coroutineScope.launch {
                        close.invoke()
                        delay(POPUP_ANIM_DURATION_MS)
                        applyFilters.invoke(state)
                    }
                }
            )
        }
    }
}