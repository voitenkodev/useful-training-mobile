package user.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.font.FontWeight
import atom.Design
import molecule.PaddingM
import molecule.PaddingWeight
import molecule.TextBody4
import molecule.TextH4
import molecule.TextH5
import user.User

@Composable
public fun UserCardLarge(
    modifier: Modifier = Modifier,
    user: User
) {

    Box(
        modifier = modifier
            .clip(Design.shape.large)
            .background(
                color = Design.colors.secondary,
                shape = Design.shape.large,
            )
            .fillMaxWidth()
            .aspectRatio(1.72f)
            .clipToBounds()
    ) {

        val first = Design.colors.tertiary
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

        TextBody4(
            modifier = Modifier
                .padding(Design.dp.paddingL)
                .align(Alignment.BottomEnd),
            provideText = { user.email },
            fontWeight = FontWeight.Medium,
            color = Design.colors.white30
        )

        Column(
            modifier = Modifier.padding(
                vertical = Design.dp.paddingL,
                horizontal = Design.dp.paddingL
            )
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {
                Column {
                    TextBody4(
                        provideText = { "Username" },
                        color = Design.colors.label
                    )

                    TextH4(
                        provideText = { user.name.uppercase() },
                        color = Design.colors.yellow
                    )
                }

                PaddingWeight()
            }

            PaddingWeight()

            TextBody4(
                provideText = { "Weight" },
                color = Design.colors.label
            )

            TextH5(
                provideText = { user.weight }
            )

            PaddingM()

            TextBody4(
                provideText = { "Height" },
                color = Design.colors.label
            )

            TextH5(
                provideText = { user.height }
            )
        }
    }
}