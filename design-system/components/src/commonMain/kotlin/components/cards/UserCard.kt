package components.cards

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.Icon
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.TextBody3
import molecule.TextH3
import molecule.TextH4
import molecule.secondaryDefaultBackground

@Composable
public fun UserCard(
    modifier: Modifier = Modifier,
    name: String,
    height: String,
    weight: String,
    email: String,
    experienceIcon: ImageVector,
) {

    Box(
        modifier = modifier
            .border(width = 1.dp, shape = Design.shape.default, color = Design.colors.white5)
            .secondaryDefaultBackground()
            .fillMaxWidth()
            .aspectRatio(1.72f)
            .clipToBounds()
    ) {

        val first = Design.colors.white50
        val second = Design.colors.white5

        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 4f
            val centerY = size.height / 4f
            val radius = size.minDimension / 2f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(first, second),
                    center = Offset(centerX / 2, centerY),
                    radius = radius,
                    tileMode = TileMode.Clamp
                ),
                center = Offset(centerX, centerY),
                radius = radius,
                style = Fill
            )
        }

        TextBody3(
            modifier = Modifier
                .padding(Design.dp.paddingM)
                .align(Alignment.BottomEnd),
            provideText = { email },
            fontWeight = FontWeight.Medium,
            color = Design.colors.white30
        )

        Column(
            modifier = Modifier.padding(
                vertical = Design.dp.paddingM,
                horizontal = Design.dp.paddingM
            )
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {
                Column {
                    TextBody3(
                        provideText = { "Username" },
                        color = Design.colors.caption
                    )

                    PaddingS()

                    TextH3(
                        provideText = { name },
                        color = Design.colors.yellow
                    )
                }

                PaddingWeight()

                Icon(
                    modifier = Modifier
                        .size(Design.dp.componentS),
                    imageVector = experienceIcon,
                    color = Design.colors.content
                )
            }

            PaddingWeight()

            TextBody3(
                provideText = { "Weight" },
                color = Design.colors.caption
            )

            PaddingS()

            TextH4(
                provideText = { weight }
            )

            PaddingS()

            TextBody3(
                provideText = { "Height" },
                color = Design.colors.caption
            )

            PaddingS()

            TextH4(
                provideText = { height }
            )
        }
    }
}