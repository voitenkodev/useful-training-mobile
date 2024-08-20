package exercise.component

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import atom.Design
import exercise.ExerciseExample
import molecule.ButtonText
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.TextH5
import resources.Icons
import shimmerLoadingAnimation

@Composable
public fun ExerciseCardSmall(
    exerciseExample: ExerciseExample?,
    viewDetails: () -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shimmerLoadingAnimation(visible = exerciseExample == null)
            .height(Design.dp.componentL)
            .background(
                Design.colors.black30,
                shape = Design.shape.large
            ).border(
                width = 1.dp,
                color = Design.colors.tertiary,
                shape = Design.shape.large
            ).clip(shape = Design.shape.large)
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = exerciseExample?.imageUrl ?: "",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

        Column(
            modifier = Modifier.padding(Design.dp.paddingM).fillMaxSize()
        ) {
            TextH5(
                provideText = { exerciseExample?.name ?: "" },
                maxLines = 2
            )
            PaddingM()

            PaddingWeight()
        }

        ButtonText(
            modifier = Modifier.padding(Design.dp.paddingM).align(Alignment.BottomEnd),
            text = "OVERVIEW",
            trailingIcon = Icons.arrowRight,
            onClick = viewDetails,
            color = Design.colors.yellow
        )
    }
}