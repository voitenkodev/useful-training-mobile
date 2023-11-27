package components.brand

import AsyncImage
import ColorUtils
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import atom.Design
import molecule.ButtonPrimarySmall
import molecule.ButtonSecondarySmall
import molecule.PaddingM
import molecule.TextH4
import molecule.secondaryDefaultBackground
import pie.ChartData

@Composable
public fun ExerciseCard(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String?,
    btn: Pair<String, () -> Unit>,
    btn2: Pair<String, () -> Unit>? = null,
    musclesWithPercent: List<Pair<String, Float>> = emptyList()
) {

    val list = remember(musclesWithPercent) {
        musclesWithPercent.map {
            ChartData(
                color = ColorUtils.randomColor(),
                data = it.second
            )
        }
    }

    Box(
        modifier
            .secondaryDefaultBackground()
            .fillMaxWidth()
            .aspectRatio(1.72f)
            .clipToBounds()
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = imageUrl,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

        Column(
            modifier = modifier
                .padding(vertical = Design.dp.paddingL, horizontal = Design.dp.paddingL)
        ) {
            Row(modifier = Modifier.weight(1f)) {

                TextH4(
                    modifier = Modifier.weight(1f),
                    provideText = { name },
                    maxLines = 2,
                    color = Design.colors.content
                )
            }

            PaddingM()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {
                ButtonPrimarySmall(
                    text = btn.first,
                    onClick = btn.second
                )

                if (btn2 != null) {
                    ButtonSecondarySmall(
                        text = btn2.first,
                        onClick = btn2.second
                    )
                }
            }
        }
    }
}