package components.brand

import AsyncImage
import Images
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.ButtonPrimarySmall
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.PaddingXS
import molecule.TextBody3
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
            .aspectRatio(1.72f)
            .clipToBounds()
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = "https://static.vecteezy.com/system/resources/previews/017/067/906/original/ufo-seamless-background-free-vector.jpg",
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(Design.colors.black30)
        )

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
                TextBody3(
                    provideText = { "Weight:" },
                    color = Design.colors.caption
                )
                TextBody3(
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
                TextBody3(
                    provideText = { "Height:" },
                    color = Design.colors.caption
                )

                TextBody3(
                    provideText = { height },
                    color = Design.colors.content,
                    fontWeight = FontWeight.Bold
                )
            }

            PaddingWeight()

            ButtonPrimarySmall(
                text = btn.first,
                onClick = btn.second
            )
        }
    }
}