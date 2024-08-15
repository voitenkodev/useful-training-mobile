package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import conditional


@Composable
public fun ShadowFooterSpace(
    contentPadding: PaddingValues = PaddingValues(
        start = Design.dp.paddingL,
        end = Design.dp.paddingL,
        bottom = Design.dp.paddingXL
    ),
    navigationBarsPadding: Boolean = true,
) {
    Spacer(
        modifier = Modifier
            .conditional(
                condition = navigationBarsPadding,
                onYes = { this.navigationBarsPadding() }
            )
            .padding(contentPadding)
            .height(
                Design.dp.componentM
            )
    )
}

@Composable
public fun BottomButtons(
    modifier: Modifier = Modifier,
    first: (@Composable RowScope.() -> Unit)? = null,
    second: (@Composable RowScope.() -> Unit)? = null,
) {

    Box(modifier = modifier.height(IntrinsicSize.Min)) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .padding(
                        start = Design.dp.paddingL,
                        bottom = Design.dp.paddingL,
                        end = Design.dp.paddingL
                    )
                    .fillMaxWidth()
//                    .background(
//                        color = Design.colors.secondary,
//                        shape = Design.shape.default
//                    ).padding(Design.dp.paddingS)
                    .height(Design.dp.componentM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {

                first?.invoke(this)

                second?.invoke(this)

            }

            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}