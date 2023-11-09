package components.brand

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonSmall
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXS
import molecule.TextBody2
import molecule.TextH2
import molecule.TextH3
import molecule.secondaryDefaultBackground

@Composable
public fun UserCard(
    modifier: Modifier = Modifier,
    name: String,
    height: String,
    weight: String,
    btn: Pair<String, () -> Unit>
) {
    Box(
        modifier = modifier
            .secondaryDefaultBackground()
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clipToBounds()
    ) {

        TextH2(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(y = 11.dp),
            provideText = { "Sport Card" },
            color = Design.colors.white5
        )

        UserCardBackground(modifier = Modifier.fillMaxSize())

        Column(modifier = Modifier.padding(vertical = Design.dp.paddingL, horizontal = Design.dp.paddingXL)) {

            TextH3(
                provideText = { name },
                color = Design.colors.content
            )

            PaddingS()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                TextBody2(
                    provideText = { "Weight:" },
                    color = Design.colors.caption
                )
                TextBody2(
                    provideText = { weight },
                    color = Design.colors.content,
                    fontWeight = FontWeight.Bold
                )
            }

            PaddingXS()

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS)
            ) {
                TextBody2(
                    provideText = { "Height:" },
                    color = Design.colors.caption
                )

                TextBody2(
                    provideText = { height },
                    color = Design.colors.content,
                    fontWeight = FontWeight.Bold
                )
            }

            PaddingM()

            ButtonSmall(
                text = btn.first,
                onClick = btn.second,
            )
        }
    }
}

@Composable
private fun UserCardBackground(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Spacer(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(120.dp)
                .offset(x = 60.dp, y = 60.dp)
                .background(
                    color = Design.colors.black30.copy(alpha = 0.15f),
                    shape = Design.shape.circleShape
                )
        )

        Spacer(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(120.dp)
                .offset(x = 45.dp, y = (-36).dp)
                .background(
                    color = Design.colors.black30.copy(alpha = 0.15f),
                    shape = Design.shape.circleShape
                )
        )

        Spacer(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(140.dp)
                .offset(x = (-45).dp, y = (30).dp)
                .background(
                    color = Design.colors.black30.copy(alpha = 0.15f),
                    shape = Design.shape.circleShape
                )
        )
    }
}