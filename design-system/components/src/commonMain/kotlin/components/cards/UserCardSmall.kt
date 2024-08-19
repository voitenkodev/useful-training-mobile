package components.cards

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Fill
import atom.Design
import molecule.ButtonIconS
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.PaddingXS
import molecule.TextBody4
import molecule.TextH3
import resources.Icons

@Composable
public fun UserCardSmall(
    modifier: Modifier = Modifier,
    name: String,
    email: String,
    edit: () -> Unit
) {

    Box(
        modifier = modifier
            .clip(Design.shape.large)
            .background(
                color = Design.colors.secondary,
                shape = Design.shape.large,
            )
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Min)
            .clipToBounds()
    ) {

        val first = Design.colors.tertiary
        val second = Design.colors.white5

        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = 100f
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

        Row(
            modifier = Modifier.padding(
                vertical = Design.dp.paddingL,
                horizontal = Design.dp.paddingL
            ),
            horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
        ) {
            Column {

                TextBody4(
                    provideText = { "Username" },
                    color = Design.colors.label
                )

                TextH3(
                    provideText = { name.uppercase() },
                    color = Design.colors.yellow
                )

                PaddingS()

                Row {
                    TextBody4(
                        provideText = { "Email -" },
                        color = Design.colors.content
                    )

                    PaddingXS()

                    TextBody4(
                        provideText = { email },
                        color = Design.colors.label
                    )
                }
            }

            PaddingWeight()

            ButtonIconS(
                imageVector = Icons.edit,
                onClick = edit
            )
        }
    }
}