package trainingbuilder.popups

import Icons
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import molecule.ButtonIconPrimary
import molecule.ButtonPrimary
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextBody1
import molecule.TextH3
import platformBottomInset
import trainingbuilder.state.MuscleType

@Composable
internal fun MusclePickerPopup(
    muscleTypes: ImmutableList<MuscleType>,
    apply: (ImmutableList<MuscleType>) -> Unit,
    close: () -> Unit
) {

    val innerList = remember(muscleTypes) {
        mutableStateOf(muscleTypes)
    }

    val selectAllProvider = remember {
        { muscleTypeId: String ->
            innerList.value = innerList.value.map { muscleType ->
                if (muscleTypeId != muscleType.id) return@map muscleType
                val muscles = muscleType.muscles.map {
                    it.copy(isSelected = muscleType.muscles.any { it.isSelected.not() })
                }
                muscleType.copy(muscles = muscles)
            }.toImmutableList()
        }
    }

    val selectProvider = remember {
        { muscleId: String ->
            innerList.value = innerList.value.map { muscleType ->
                val muscles = muscleType.muscles.map { muscle ->
                    if (muscleId == muscle.id) muscle.copy(isSelected = muscle.isSelected.not())
                    else muscle
                }
                muscleType.copy(muscles = muscles)
            }.toImmutableList()
        }
    }

    Column(modifier = Modifier.fillMaxHeight(0.8f)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextH3(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Select Muscles" }
            )

            ButtonIconPrimary(
                imageVector = Icons.close,
                onClick = close,
                backgroundColor = Color.Transparent
            )
        }

        PaddingS()

        Shadow()

        Box(modifier = Modifier.weight(1f)) {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(Design.dp.paddingM),
                verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {
                items(innerList.value, key = { it.id }) {

                    val borderColor = when {
                        it.muscles.count { c -> c.isSelected } == it.muscles.size -> Design.colors.toxic
                        it.muscles.count { c -> c.isSelected } > 0 -> Design.colors.toxic.copy(alpha = 0.5f)
                        else -> Design.colors.caption
                    }

                    Column(
                        modifier = Modifier
                            .border(
                                color = borderColor,
                                width = 1.dp,
                                shape = Design.shape.default
                            ).padding(Design.dp.paddingM)
                    ) {


                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            TextBody1(provideText = { it.name })

                            ButtonTextLink(
                                text = if (it.muscles.any { it.isSelected.not() }) "ALL" else "CLEAR",
                                onClick = { selectAllProvider.invoke(it.id) },
                                color = Design.colors.caption
                            )

                        }

                        PaddingM()

                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
                            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
                        ) {

                            it.muscles.forEach { muscle ->
                                Chip(
                                    chipState = if (muscle.isSelected) ChipState.Selected() else ChipState.Default(),
                                    onClick = { selectProvider.invoke(muscle.id) },
                                    text = muscle.name
                                )
                            }
                        }
                    }
                }

                item {
                    Spacer(
                        modifier = Modifier
                            .platformBottomInset()
                            .size(Design.dp.paddingM + Design.dp.componentM)
                    )
                }
            }

            ButtonPrimary(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(Design.dp.paddingM)
                    .platformBottomInset(),
                text = "Apply",
                onClick = {
                    apply.invoke(innerList.value)
                    close.invoke()
                }
            )
        }
    }
}