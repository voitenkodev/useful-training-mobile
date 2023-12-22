package components.inputs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import atom.Design
import conditional
import molecule.ButtonIconSecondary
import molecule.IconSecondary
import molecule.InputField
import resources.Icons

@Composable
public fun InputSearch(
    modifier: Modifier = Modifier,
    provideName: () -> String,
    update: (String) -> Unit,
    onClick: (() -> Unit)? = null
) {
    val focusManager = LocalFocusManager.current

    Box(
        modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = Design.dp.paddingM)
    ) {
        InputField(
            modifier = Modifier.fillMaxWidth().conditional(
                condition = onClick != null,
                onYes = { clickable(onClick = {}, enabled = false) }
            ),
            value = provideName.invoke(),
            placeholder = "Search exercise",
            maxLines = 1,
            backgroundColor = Design.colors.black10,
            keyboardActions = KeyboardActions { focusManager.moveFocus(FocusDirection.Next) },
            onValueChange = update,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences, imeAction = ImeAction.Next),
            fontWeight = FontWeight.Bold,
            leading = {
                IconSecondary(
                    modifier = Modifier.padding(end = Design.dp.paddingS),
                    imageVector = Icons.search,
                    color = Design.colors.caption
                )
            },
            trailing = {
                AnimatedVisibility(
                    visible = provideName().isNotEmpty(),
                    enter = fadeIn() + scaleIn(),
                    exit = scaleOut() + fadeOut(),
                ) {
                    ButtonIconSecondary(
                        modifier = Modifier
                            .wrapContentSize()
                            .height(IntrinsicSize.Min),
                        imageVector = Icons.clear,
                        color = Design.colors.caption,
                        onClick = { update.invoke("") }
                    )
                }
            }
        )

        if (onClick != null) {
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(Design.shape.default)
                    .clickable(onClick = onClick)
            )
        }
    }
}