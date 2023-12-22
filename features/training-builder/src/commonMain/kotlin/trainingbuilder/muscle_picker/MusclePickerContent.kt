package trainingbuilder.muscle_picker

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import molecule.ButtonTextLink
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextH4
import molecule.primaryBackground
import trainingbuilder.muscle_picker.components.Footer
import trainingbuilder.muscle_picker.components.Header
import trainingbuilder.muscle_picker.components.MuscleChip
import trainingbuilder.muscle_picker.models.MuscleType
import trainingbuilder.muscle_picker.models.MuscleTypeEnum

@Composable
internal fun MusclePickerContent(
    vm: MusclePickerViewModel,
    apply: (List<String>) -> Unit,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = state.error,
        list = state.muscleTypes,
        clearError = vm::clearError,
        selectMuscleType = vm::selectMuscleType,
        selectMuscle = vm::selectMuscle,
        selectFullBody = vm::selectFullBody,
        selectUpperBody = vm::selectUpperBody,
        selectLowerBody = vm::selectLowerBody,
        apply = apply,
        close = close
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,

    list: ImmutableList<MuscleType>,

    selectMuscleType: (id: String) -> Unit,
    selectMuscle: (id: String) -> Unit,
    selectFullBody: () -> Unit,
    selectUpperBody: () -> Unit,
    selectLowerBody: () -> Unit,
    apply: (List<String>) -> Unit,
    close: () -> Unit,
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth().primaryBackground()) {

            Header(close = close)

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

                item(key = "packs") {

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

                    val fullBodyState = when {
                        list.all { it.muscles.all { m -> m.isSelected } } -> selectedChipState
                        else -> unSelectedChipState
                    }

                    val lowerBodyState = when {
                        list
                            .filter { it.type == MuscleTypeEnum.LEGS }
                            .all { it.muscles.all { m -> m.isSelected } } -> selectedChipState

                        else -> unSelectedChipState
                    }

                    val topBodyState = when {
                        list
                            .filterNot { it.type == MuscleTypeEnum.LEGS }
                            .all { it.muscles.all { m -> m.isSelected } } -> selectedChipState

                        else -> unSelectedChipState
                    }

                    PaddingXL()

                    Row(
                        modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                    ) {

                        Chip(
                            chipState = fullBodyState,
                            onClick = selectFullBody,
                            text = "Full Body"
                        )

                        Chip(
                            chipState = topBodyState,
                            onClick = selectUpperBody,
                            text = "Upper Body"
                        )

                        Chip(
                            chipState = lowerBodyState,
                            onClick = selectLowerBody,
                            text = "Lower Body"
                        )
                    }

                    PaddingL()

                    Shadow()
                }

                itemsIndexed(list, key = { _, item -> item.id }) { index, item ->

                    val textColor = when (item.muscles.size) {
                        item.muscles.count { c -> c.isSelected } -> Design.colors.caption
                        else -> Design.colors.toxic
                    }

                    PaddingS()

                    Column(
                        modifier = Modifier.fillMaxWidth().padding(Design.dp.paddingM),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            TextH4(
                                modifier = Modifier.weight(1f),
                                provideText = { item.name },
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )

                            PaddingS()

                            ButtonTextLink(
                                modifier = Modifier.padding(bottom = 4.dp),
                                text = if (item.muscles.any { m -> m.isSelected.not() }) "ALL" else "CLEAR",
                                onClick = { selectMuscleType.invoke(item.id) },
                                color = textColor
                            )
                        }

                        PaddingM()

                        Box(modifier = Modifier.fillMaxWidth()) {

                            Image(
                                modifier = Modifier
                                    .height(180.dp)
                                    .aspectRatio(1f)
                                    .align(Alignment.CenterEnd),
                                imageVector = item.bodyImageVector,
                                contentDescription = null
                            )

                            Column(
                                modifier = Modifier.fillMaxWidth(0.6f),
                                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                            ) {
                                item.muscles.forEach { muscle ->
                                    MuscleChip(
                                        muscle = muscle,
                                        selectMuscle = selectMuscle
                                    )
                                }
                            }
                        }
                    }

                    if (index < list.lastIndex) Shadow()
                }
            }

            Footer(
                list = list,
                skip = { apply.invoke(persistentListOf()) },
                apply = {
                    val selectedMuscles = list
                        .flatMap { it.muscles }
                        .filter { it.isSelected }
                        .map { it.id }
                    apply.invoke(selectedMuscles)
                }
            )
        }
    }
}