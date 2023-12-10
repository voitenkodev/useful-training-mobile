package statistics.components

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
import molecule.ButtonIconTransparent
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.TextH2
import platformTopInset
import resources.Icons

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    filterClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = Design.dp.paddingM)
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
                provideText = { "Statistics" },
                softWrap = false
            )

            PaddingWeight()

            ButtonIconTransparent(
                imageVector = Icons.filters,
                onClick = filterClick
            )
        }

        PaddingM()
    }
}