package trainingbuilder.popups

import Icons
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import molecule.PaddingL
import molecule.PaddingM
import molecule.PaddingS
import molecule.Shadow
import molecule.TextBody1
import molecule.TextH4
import platformBottomInset
import trainingbuilder.factory.muscleImage
import trainingbuilder.state.MuscleType
import trainingbuilder.state.MuscleTypeEnum

@Composable
internal fun MusclePickerPopup(
    muscleTypes: ImmutableList<MuscleType>,
    apply: (ImmutableList<MuscleType>) -> Unit,
    close: () -> Unit
) {

    val innerList = remember(muscleTypes) {
        mutableStateOf(muscleTypes)
    }

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

    val selectTopProvider = remember {
        {
            val newValue = innerList
                .value
                .filterNot { it.type == MuscleTypeEnum.LEGS }
                .all { it.muscles.all { it.isSelected } }.not()

            innerList.value = innerList.value.map { muscleType ->
                val muscles = muscleType.muscles.map {
                    it.copy(isSelected = if (muscleType.type == MuscleTypeEnum.LEGS) it.isSelected else newValue)
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

    val selectBottomProvider = remember {
        {
            val newValue = innerList.value
                .filter { it.type == MuscleTypeEnum.LEGS }
                .all { it.muscles.all { it.isSelected } }.not()

            innerList.value = innerList.value.map { muscleType ->
                val muscles = muscleType.muscles.map {
                    it.copy(isSelected = if (muscleType.type != MuscleTypeEnum.LEGS) it.isSelected else newValue)
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
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Design.colors.secondary,
                shape = RoundedCornerShape(26.dp)
            ).fillMaxHeight(0.90f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.padding(Design.dp.paddingM).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextBody1(
                provideText = { "Target Muscles" }
            )

            ButtonIconTransparent(
                imageVector = Icons.close,
                onClick = close
            )
        }

        Shadow()

        LazyColumn(
            modifier = Modifier.weight(1f),
//            verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {

            item(key = "packs") {

                val fullBodyState = when {
                    innerList.value.all { it.muscles.all { it.isSelected } } -> selectedChipState
                    else -> unSelectedChipState
                }

                val bottomBodyState = when {
                    innerList.value
                        .filter { it.type == MuscleTypeEnum.LEGS }
                        .all { it.muscles.all { it.isSelected } } -> selectedChipState

                    else -> unSelectedChipState
                }

                val topBodyState = when {
                    innerList.value
                        .filterNot { it.type == MuscleTypeEnum.LEGS }
                        .all { it.muscles.all { it.isSelected } } -> selectedChipState

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
                        onClick = selectAllProvider,
                        text = "Full Body"
                    )

                    Chip(
                        chipState = topBodyState,
                        onClick = selectTopProvider,
                        text = "Upper Body"
                    )

                    Chip(
                        chipState = bottomBodyState,
                        onClick = selectBottomProvider,
                        text = "Lower Body"
                    )
                }

                PaddingM()

                Shadow()
            }

            items(innerList.value, key = { it.id }) {

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
                                    chipState =
                                    if (muscle.isSelected) selectedChipState
                                    else unSelectedChipState,
                                    onClick = { selectProvider.invoke(muscle.id) },
                                    text = muscle.name
                                )
                            }
                        }
                    }
                }
                Shadow()
            }
        }

        Shadow()

        Row(
            modifier = Modifier
                .fillMaxWidth()
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
