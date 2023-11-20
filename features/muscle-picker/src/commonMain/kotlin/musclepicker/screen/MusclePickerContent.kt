package musclepicker.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import components.overlay.TopShadow
import components.roots.Root
import kotlinx.collections.immutable.ImmutableList
import molecule.ButtonPrimary
import molecule.ButtonTextLink
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextH2
import molecule.TextH4
import molecule.secondaryRoundBackground
import musclepicker.state.MuscleType
import musclepicker.state.MuscleTypeEnum
import platformBottomInset
import platformTopInset

@Composable
internal fun MusclePickerContent(
    vm: MusclePickerViewModel,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = state.error,
        back = back,
        list = state.muscleTypes,
        clearError = vm::clearError,
        selectMuscleType = vm::selectMuscleType,
        selectMuscle = vm::selectMuscle,
        selectFullBody = vm::selectFullBody,
        upperBodyState = vm::selectUpperBody,
        selectLowerBody = vm::selectLowerBody
    )
}

@Composable
private fun Content(
    error: String?,
    back: () -> Unit,
    clearError: () -> Unit,

    list: ImmutableList<MuscleType>,

    selectMuscleType: (id: String) -> Unit,
    selectMuscle: (id: String) -> Unit,
    selectFullBody: () -> Unit,
    upperBodyState: () -> Unit,
    selectLowerBody: () -> Unit
) {

    val selectedChipState = ChipState.Colored(
        backgroundColor = Design.colors.black30,
        borderColor = Design.colors.green,
        contentColor = Design.colors.content
    )

    val unSelectedChipState = ChipState.Colored(
        backgroundColor = Color.Transparent,
        borderColor = Design.colors.caption,
        contentColor = Design.colors.content
    )

    Root(error = { Error(message = { error }, close = clearError) }) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item(key = "bottom_spacer") {
                Spacer(
                    modifier = Modifier.platformTopInset()
                        .height(Design.dp.componentM)
                )
            }

            item(key = "packs") {

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


                PaddingL()

                TextH4(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                    provideText = { "Packs" },
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                PaddingM()

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
                        onClick = upperBodyState,
                        text = "Upper Body"
                    )

                    Chip(
                        chipState = lowerBodyState,
                        onClick = selectLowerBody,
                        text = "Lower Body"
                    )
                }

                PaddingM()

                Shadow()
            }

            items(list, key = { it.id }) {

                val textColor = when (it.muscles.size) {
                    it.muscles.count { c -> c.isSelected } -> Design.colors.caption
                    else -> Design.colors.green
                }

                PaddingS()

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Design.dp.paddingM),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        TextH4(
                            modifier = Modifier.weight(1f),
                            provideText = { it.name },
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )

                        PaddingS()

                        ButtonTextLink(
                            modifier = Modifier.padding(bottom = 4.dp),
                            text = if (it.muscles.any { m -> m.isSelected.not() }) "ALL" else "CLEAR",
                            onClick = { selectMuscleType.invoke(it.id) },
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
                            imageVector = it.imageVector,
                            contentDescription = null
                        )

                        Column(
                            modifier = Modifier.fillMaxWidth(0.6f),
                            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                        ) {
                            it.muscles.forEach { muscle ->
                                Chip(
                                    chipState =
                                    if (muscle.isSelected) selectedChipState
                                    else unSelectedChipState,
                                    onClick = { selectMuscle.invoke(muscle.id) },
                                    text = muscle.name
                                )
                            }
                        }
                    }
                }

                Shadow()
            }

            item(key = "top_space") {
                Spacer(
                    modifier = Modifier
                        .platformTopInset()
                        .height(Design.dp.componentL)
                )
            }
        }

        TopShadow(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .platformTopInset()
                .size(Design.dp.componentL + Design.dp.paddingM)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .platformTopInset()
                .height(Design.dp.componentL),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Muscles" },
                softWrap = false
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .secondaryRoundBackground()
                .platformBottomInset()
                .padding(Design.dp.paddingM),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            ButtonPrimary(
                text = "Apply",
                onClick = {}
            )
        }
    }
}