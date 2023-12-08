package components.brand

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonPrimarySmall
import molecule.ButtonSecondarySmall
import molecule.ButtonTextLink
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.TextBody3
import molecule.TextH4
import molecule.secondaryDefaultBackground
import percents


@Immutable
private data class MuscleUi(
    val text: String,
    val color: Color
)

@Composable
public fun ExerciseCardSmall(
    name: String,
    imageUrl: String?,
    btn: Pair<String, () -> Unit>,
    musclesWithPercent: List<Pair<String, Int>> = emptyList()
) {

    val muscles = remember(musclesWithPercent) {
        musclesWithPercent
            .sortedByDescending { it.second }
            .take(2)
            .mapIndexed { index, item ->
                MuscleUi(
                    text = "${item.first}: ${item.second.percents()}",
                    color = when (index) {
                        0 -> Design.palette.content
                        1 -> Design.palette.content.copy(0.7f)
                        else -> Design.palette.content.copy(0.5f)
                    }
                )
            }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(116.dp)
            .padding(horizontal = Design.dp.paddingM)
            .background(
                Design.colors.black10,
                shape = Design.shape.default
            ).border(
                width = 1.dp,
                color = Design.colors.toxic,
                shape = Design.shape.default
            ).clip(shape = Design.shape.default)
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = imageUrl,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

        Column(
            modifier = Modifier.padding(Design.dp.paddingM).fillMaxSize()
        ) {
            TextH4(
                provideText = { name },
                maxLines = 2
            )
            PaddingM()

            PaddingWeight()

            muscles.forEach { muscle ->
                TextBody3(
                    provideText = { muscle.text },
                    color = muscle.color,
                    maxLines = 4
                )
            }
        }

        ButtonTextLink(
            modifier = Modifier.padding(Design.dp.paddingM).align(Alignment.BottomEnd),
            text = btn.first,
            onClick = btn.second,
            color = Design.colors.toxic
        )
    }
}

@Composable
public fun ExerciseCardDefault(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String?,
    btn: Pair<String, () -> Unit>,
    musclesWithPercent: List<Pair<String, Int>> = emptyList()
) {

    val muscles = remember(musclesWithPercent) {
        musclesWithPercent
            .sortedByDescending { it.second }
            .take(3)
            .mapIndexed { index, item ->
                MuscleUi(
                    text = "${item.first}: ${item.second.percents()}",
                    color = when (index) {
                        0 -> Design.palette.content
                        1 -> Design.palette.content.copy(0.7f)
                        else -> Design.palette.content.copy(0.5f)
                    }
                )
            }
    }

    Box(
        modifier
            .secondaryDefaultBackground()
            .border(
                width = 1.dp,
                color = Design.colors.toxic.copy(alpha = 0.5f),
                shape = Design.shape.default
            )
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

        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(vertical = Design.dp.paddingL, horizontal = Design.dp.paddingL),
            ) {

                TextH4(
                    provideText = { name },
                    maxLines = 3,
                    color = Design.colors.content
                )

                PaddingM()

                PaddingWeight()

                muscles.forEach { muscle ->
                    TextBody3(
                        provideText = { muscle.text },
                        color = muscle.color,
                        maxLines = 4
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(IntrinsicSize.Min)
                    .background(Design.colors.black30)
                    .padding(vertical = Design.dp.paddingL, horizontal = Design.dp.paddingL),
                horizontalAlignment = Alignment.End,
            ) {

                ButtonSecondarySmall(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Hide",
                    onClick = {}
                )

                PaddingM()

                PaddingWeight()

                ButtonPrimarySmall(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = btn.first,
                    onClick = btn.second
                )
            }
        }
    }
}