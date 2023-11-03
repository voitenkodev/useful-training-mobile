package profile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import molecule.PaddingM
import molecule.Shadow
import molecule.TextH1
import platformTopInset

@Composable
internal fun Header(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .platformTopInset()
    ) {

        PaddingM()

        Box(
            modifier = Modifier
                .height(Design.dp.componentL)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {

            TextH1(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM)
                    .fillMaxWidth(),
                provideText = { "Profile" },
                softWrap = false
            )
        }

        Shadow()
    }
}