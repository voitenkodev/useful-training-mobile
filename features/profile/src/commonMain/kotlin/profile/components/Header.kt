package profile.components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import molecular.PaddingM
import molecular.Shadow
import molecular.TextH1
import platformTopInset

@Composable
internal fun Header(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
//            .background(Design.colors.secondary)
            .platformTopInset()
    ) {

        PaddingM()

        Box(
            modifier = Modifier
                .height(Design.dp.componentM)
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