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
import androidx.compose.ui.graphics.Color
import atom.Design
import icons.Filters
import molecule.ButtonIconPrimary
import molecule.IconPrimary
import molecule.PaddingS
import molecule.PaddingWeight
import molecule.TextH2
import platformTopInset

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    filterClick: ()-> Unit
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

            ButtonIconPrimary(
                imageVector = Filters,
                onClick = filterClick,
                backgroundColor = Color.Transparent
            )
        }

        PaddingS()
    }
}