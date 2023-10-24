package configurations.components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import components.ShadowDivider
import controls.TextFieldH1
import platformTopInset

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(Design.colors.secondary)
            .platformTopInset(),
    ) {

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        Box(
            modifier = Modifier
                .height(Design.dp.componentM)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            TextFieldH1(
                modifier = Modifier
                    .padding(horizontal = Design.dp.paddingM)
                    .fillMaxWidth(),
                provideText = { "Configurations" },
                softWrap = false
            )
        }

        Spacer(
            modifier = Modifier.size(Design.dp.paddingM)
        )

        ShadowDivider()
    }
}