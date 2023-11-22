package profile.components

import Icons
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import conditional
import molecule.ButtonIconTransparent
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.TextH2
import molecule.black30RoundBackground
import platformTopInset

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    showBackground: Boolean
) {
    Column(
        modifier = modifier
            .conditional(
                condition = showBackground,
                onYes = { black30RoundBackground() },
                onNot = { this }
            ).padding(horizontal = Design.dp.paddingM)
            .platformTopInset()
    ) {

        PaddingS()

        Row(
            modifier = Modifier
                .height(Design.dp.componentM)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TextH2(
                modifier = Modifier,
                provideText = { "Profile" },
                softWrap = false
            )

            PaddingWeight()

            ButtonIconTransparent(
                imageVector = Icons.notifications,
                contentColor = Design.colors.content,
                onClick = {}
            )

        }

        PaddingM()
    }
}