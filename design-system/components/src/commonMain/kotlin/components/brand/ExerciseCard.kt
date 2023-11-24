package components.brand

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import atom.Design
import molecule.ButtonPrimarySmall
import molecule.ButtonSecondarySmall
import molecule.PaddingWeight
import molecule.TextH4
import molecule.secondaryDefaultBackground

@Composable
public fun ExerciseCard(
    modifier: Modifier = Modifier,
    name: String,
    btn: Pair<String, () -> Unit>,
    btn2: Pair<String, () -> Unit>
) {
    Box(
        modifier
            .secondaryDefaultBackground()
            .fillMaxWidth()
            .aspectRatio(2.2f)
            .clipToBounds()
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = "https://barbend.com/wp-content/uploads/2023/01/Barbend-Featured-Image-1200x675-A-person-doing-bench-press-exercises.jpg",
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(Design.colors.black10)
        )

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = Design.dp.paddingL, horizontal = Design.dp.paddingXL)
        ) {

            TextH4(
                provideText = { name },
                maxLines = 2,
                color = Design.colors.content
            )

            PaddingWeight()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {
                ButtonPrimarySmall(
                    text = btn.first,
                    onClick = btn.second
                )

                ButtonSecondarySmall(
                    text = btn2.first,
                    onClick = btn2.second
                )
            }
        }
    }
}