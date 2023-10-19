package bottommenu.screen

import Design
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import controls.IconPrimary
import controls.TextFieldBody2

@Composable
internal fun BottomMenuContent(
    vm: BottomMenuViewModel,
) {

    Content(

    )
}

@Composable
private fun Content() {
    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
//        repeat(3) {
//            AddItem(
//                screen = {
//
//                },
//                currentDestination = currentDestination,
//                navController = navController
//            )
//        }
    }
}

@Composable
public fun RowScope.AddItem(
    text: String,
    isSelected: Boolean = false,
    click: () -> Unit
) {

    val background = if (isSelected) Design.colors.primary.copy(alpha = 0.6f) else Color.Transparent

    val contentColor =
        if (isSelected) Design.colors.content else Design.colors.accent_primary

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = click)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            IconPrimary(
                imageVector = if (isSelected) Icons.Default.Search else Icons.Default.ArrowBack,
                onClick = click
            )

            AnimatedVisibility(visible = isSelected) {
                TextFieldBody2(
                    provideText = {text},
                    color = contentColor
                )
            }
        }
    }
}