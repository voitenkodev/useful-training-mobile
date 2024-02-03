package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import atom.Design
import components.overlay.BottomShadow
import molecule.ButtonIconPrimary
import molecule.ButtonPrimary
import resources.Icons


@Composable
public fun ShadowFooterSpace() {
    Spacer(modifier = Modifier.navigationBarsPadding().height(Design.dp.paddingXL + Design.dp.componentM))
}

@Composable
public fun ShadowFooter(
    modifier: Modifier = Modifier,
    // Name / Enabled / Action
    primary: Triple<String, Boolean, () -> Unit>? = null,
    close: (() -> Unit)? = null
) {

    Box(modifier = modifier.height(IntrinsicSize.Min)) {

        BottomShadow(modifier = Modifier.fillMaxSize())

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM, Alignment.End)
            ) {

                if (primary != null) {
                    ButtonPrimary(
                        modifier = Modifier.width(Design.dp.componentXXL),
                        text = primary.first,
                        onClick = primary.third,
                        enabled = primary.second
                    )
                }

                if (close != null) {
                    ButtonIconPrimary(
                        backgroundColor = Design.colors.secondary,
                        imageVector = Icons.close,
                        onClick = close
                    )
                }
            }

            Spacer(modifier = Modifier.navigationBarsPadding().height(Design.dp.paddingXL))
        }
    }
}