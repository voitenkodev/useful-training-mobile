package trainingbuilder.popups

import Icons
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import molecule.ButtonIconTransparent
import molecule.ButtonPrimary
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextH3
import molecule.TextH4
import molecule.primaryBackground
import molecule.secondaryDefaultBackground
import platformBottomInset
import trainingbuilder.factory.muscleImage
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

    val selectAllMuscleTypeProvider = remember {
        { muscleTypeId: String ->
            innerList.value = innerList.value.map { muscleType ->
                if (muscleTypeId != muscleType.id) return@map muscleType
                val muscles = muscleType.muscles.map {
                    it.copy(isSelected = muscleType.muscles.any { it.isSelected.not() })
                }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )

                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )

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
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )

                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )

            }.toImmutableList()
        }
    }

    val selectAllProvider = remember {
        {
            val newValue = innerList.value.all { it.muscles.all { it.isSelected } }.not()

            innerList.value = innerList.value.map { muscleType ->
                val muscles = muscleType.muscles.map {
                    it.copy(isSelected = newValue)
                }
                val image = muscleImage(
                    muscleTypeEnumState = muscleType.type,
                    muscles = muscles
                )

                muscleType.copy(
                    muscles = muscles,
                    imageVector = image
                )
            }.toImmutableList()
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.85f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextH3(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { "Select Muscles" }
            )

            ButtonIconTransparent(
                imageVector = Icons.close,
                onClick = close
            )
        }

        PaddingS()

        Shadow()

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(Design.dp.paddingM),
            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingL)
        ) {

            item(key = "full_body") {
                val chipState = when {
                    innerList.value.all { it.muscles.all { it.isSelected } } -> ChipState.Selected()

                    innerList.value.all { it.muscles.all { it.isSelected.not() } } -> ChipState.Colored(
                        backgroundColor = Design.colors.green,
                        contentColor = Design.colors.primary
                    )

                    else -> ChipState.Colored(
                        backgroundColor = Design.colors.yellow,
                        contentColor = Design.colors.primary
                    )
                }

                Chip(
                    chipState = chipState,
                    onClick = selectAllProvider,
                    text = "Full Body"
                )
            }

            items(innerList.value, key = { it.id }) {

                val textColor = when {
                    it.muscles.count { c -> c.isSelected } == it.muscles.size -> Design.colors.red
                    it.muscles.count { c -> c.isSelected } > 0 -> Design.colors.yellow
                    else -> Design.colors.green
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .secondaryDefaultBackground()
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
                            text = if (it.muscles.any { it.isSelected.not() }) "ALL" else "CLEAR",
                            onClick = { selectAllMuscleTypeProvider.invoke(it.id) },
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
                                    chipState = if (muscle.isSelected) ChipState.Selected() else ChipState.Default(),
                                    onClick = { selectProvider.invoke(muscle.id) },
                                    text = muscle.name
                                )
                            }
                        }
                    }
                }
            }
        }

        Shadow()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .primaryBackground()
                .padding(Design.dp.paddingM)
                .platformBottomInset(),
            horizontalArrangement = Arrangement.Center
        ) {

            ButtonPrimary(
                text = "Apply",
                onClick = {
                    apply.invoke(innerList.value)
                    close.invoke()
                }
            )
        }
    }
}
