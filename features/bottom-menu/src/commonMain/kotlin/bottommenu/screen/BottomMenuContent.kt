package bottommenu.screen

import Design
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import controls.IconPrimary
import controls.TextFieldBody2
import platformBottomInset

@Composable
internal fun BottomMenuContent(
    items: List<Pair<ImageVector, String>>,
    onClick: (index: Int) -> Unit,
    screen: @Composable () -> Unit
) {
    Content(
        items = items,
        onClick = onClick,
        screen = screen
    )
}

@Composable
private fun Content(
    items: List<Pair<ImageVector, String>>,
    onClick: (index: Int) -> Unit,
    screen: @Composable () -> Unit
) {

    val currentIndex = remember { mutableStateOf(0) }

    LaunchedEffect(currentIndex.value) {
        onClick.invoke(currentIndex.value)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.weight(1f),
            content = { screen.invoke() }
        )

        Row(
            modifier = Modifier
                .background(color = Design.colors.tertiary)
                .padding(Design.dp.paddingS)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(items.size) {
                AddItem(
                    modifier = Modifier.weight(1f),
                    text = items[it].second,
                    icon = items[it].first,
                    isSelected = currentIndex.value == it,
                    onClick = { currentIndex.value = it }
                )
            }
        }

        Spacer(
            modifier = Modifier
                .background(color = Design.colors.tertiary)
                .platformBottomInset()
        )
    }
}

@Composable
public fun AddItem(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {

    val background =
        if (isSelected) Design.colors.primary.copy(alpha = 0.6f)
        else Color.Transparent

    val contentColor =
        if (isSelected) Design.colors.content
        else Design.colors.accent_primary

    Box(
        modifier = modifier
            .height(Design.dp.componentM)
            .clip(shape = Design.shape.circleShape)
            .background(background)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            IconPrimary(
                modifier = Modifier.size(26.dp),
                imageVector = if (isSelected) icon else icon,
                onClick = onClick
            )

            AnimatedVisibility(visible = isSelected) {
                TextFieldBody2(
                    provideText = { text },
                    color = contentColor
                )
            }
        }
    }
}