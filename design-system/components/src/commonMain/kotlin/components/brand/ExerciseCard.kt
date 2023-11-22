package components.brand

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import atom.Design
import molecule.ButtonPrimarySmall
import molecule.ButtonSecondarySmall
import molecule.PaddingWeight
import molecule.TextH3
import molecule.black10DefaultBackground

@Composable
public fun ExerciseCard(
    modifier: Modifier = Modifier,
    name: String,
    btn: Pair<String, () -> Unit>,
    btn2: Pair<String, () -> Unit>,
) {
    Column(
        modifier = modifier
            .black10DefaultBackground()
            .fillMaxWidth()
            .aspectRatio(2.2f)
            .clipToBounds()
            .padding(vertical = Design.dp.paddingL, horizontal = Design.dp.paddingXL)
    ) {

        TextH3(
            provideText = { name },
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