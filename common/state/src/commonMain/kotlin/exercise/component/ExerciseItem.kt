package exercise.component

import AsyncImage
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import atom.Design
import exercise.ExerciseExample
import molecule.Icon
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextBody3
import resources.Icons
import shimmerLoadingAnimation

@Composable
public fun ExerciseItem(
    modifier: Modifier = Modifier,
    exerciseExample: ExerciseExample?,
    viewDetails: () -> Unit,
) {

    Row(
        modifier = modifier
            .clip(Design.shape.default)
            .fillMaxWidth()
            .shimmerLoadingAnimation(visible = exerciseExample == null)
            .height(Design.dp.componentM)
            .clickable(onClick = viewDetails),
        horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            modifier = Modifier
                .clip(Design.shape.default)
                .fillMaxHeight()
                .aspectRatio(1f),
            url = exerciseExample?.imageUrl ?: "",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.weight(1f).fillMaxHeight(),
        ) {

            TextBody1(
                provideText = { exerciseExample?.name ?: "" },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            val description = remember(exerciseExample?.id) {
                exerciseExample?.exerciseExampleBundles
                    ?.sortedByDescending { it.percentage }
                    ?.take(2)
                    ?.joinToString(", ") { it.muscle.name } ?: ""
            }

            PaddingXS()

            TextBody3(
                provideText = { description },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Design.colors.label
            )
        }

        Icon(
            modifier = Modifier.size(Design.dp.iconXS),
            imageVector = Icons.arrowRight,
            color = Design.colors.content
        )
    }
}