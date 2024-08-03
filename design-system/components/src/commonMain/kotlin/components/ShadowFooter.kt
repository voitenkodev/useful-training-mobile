package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.overlay.BottomShadow


@Composable
public fun ShadowFooterSpace() {
    Spacer(
        modifier = Modifier
            .navigationBarsPadding()
            .height(Design.dp.paddingXL + Design.dp.componentM)
    )
}

@Composable
public fun ShadowBottomButtons(
    modifier: Modifier = Modifier,
    first: @Composable RowScope.() -> Unit,
    second: @Composable RowScope.() -> Unit
) {

    Box(modifier = modifier.height(IntrinsicSize.Min)) {

        BottomShadow(modifier = Modifier.fillMaxSize())

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = Design.dp.paddingL),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                first.invoke(this)
                second.invoke(this)

            }

            Spacer(modifier = Modifier.navigationBarsPadding().height(Design.dp.paddingXL))
        }
    }
}