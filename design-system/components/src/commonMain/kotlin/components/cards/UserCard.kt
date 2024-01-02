package components.cards

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonPrimarySmall
import molecule.ButtonSecondarySmall
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.PaddingXS
import molecule.TextBody1
import molecule.TextBody2
import molecule.TextH2
import molecule.TextH3
import molecule.secondaryDefaultBackground

@Composable
public fun UserCard(
    modifier: Modifier = Modifier,
    image: String?,
    name: String,
    height: String?,
    weight: String?,
    buttonPrimary: Pair<String, () -> Unit>? = null,
    buttonSecondary: Pair<String, () -> Unit>? = null
) {

    Box(
        modifier = modifier
            .border(width = 1.dp, shape = Design.shape.default, color = Design.colors.white5)
            .secondaryDefaultBackground()
            .fillMaxWidth()
            .aspectRatio(1.72f)
            .clipToBounds()
    ) {

        if (image != null) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                url = image,
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Design.colors.black30)
            )
        }

        TextH2(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(y = 11.dp),
            provideText = { "Sport Card" },
            color = Design.colors.white5
        )

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
                TextBody1(
                    provideText = { weight ?: "-" },
                    color = if (weight != null) Design.colors.content else Design.colors.caption
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

                TextBody1(
                    provideText = { height ?: "-" },
                    color = if (height != null) Design.colors.content else Design.colors.caption
                )
            }

            PaddingWeight()

            Row(horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)) {

                if (buttonPrimary != null) ButtonPrimarySmall(
                    text = buttonPrimary.first,
                    onClick = buttonPrimary.second
                )

                if (buttonSecondary != null) ButtonSecondarySmall(
                    text = buttonSecondary.first,
                    onClick = buttonSecondary.second
                )
            }
        }
    }
}