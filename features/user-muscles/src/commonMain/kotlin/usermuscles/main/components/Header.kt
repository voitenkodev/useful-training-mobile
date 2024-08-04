package usermuscles.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import components.chips.Chip
import components.chips.ChipState
import molecule.PaddingL
import molecule.PaddingS
import molecule.Shadow
import molecule.TextBody2
import molecule.Toolbar
import resources.Icons

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    close: () -> Unit
) {
    Column(
        modifier = modifier
            .statusBarsPadding()
    ) {

        PaddingS()

        Toolbar(title = "Muscles", icon = Icons.close to close)

        Column(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .width(intrinsicSize = IntrinsicSize.Max)
                .defaultMinSize(minHeight = Design.dp.componentS),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextBody2(
                provideText = { "Would you like to exclude some muscles\nfrom your workouts?" },
                textAlign = TextAlign.Center,
                color = Design.colors.caption
            )

            PaddingL()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    Design.dp.paddingM,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Chip(
                    chipState = ChipState.Colored(
                        backgroundColor = Color.Transparent,
                        borderColor = Design.palette.white10,
                        contentColor = Design.palette.content
                    ),
                    text = "Included",
                    iconStart = Icons.checkOn
                )

                Chip(
                    chipState = ChipState.Colored(
                        backgroundColor = Color.Transparent,
                        borderColor = Design.palette.white10,
                        contentColor = Design.palette.content.copy(alpha = 0.3f)
                    ),
                    text = "Excluded",
                    iconStart = Icons.checkOff
                )
            }
        }

        PaddingL()

        Shadow()
    }
}