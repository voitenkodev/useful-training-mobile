package designsystem.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    back: (() -> Unit)? = null,
    menu: (() -> Unit)? = null,
    add: (() -> Unit)? = null,
    ok: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .shadow(elevation = 8.dp)
            .fillMaxWidth()
            .background(DesignComponent.colors.primary)
            .height(44.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        back?.let {
            Dot(onClick = it)
        }

        Spacer(modifier = Modifier.weight(1f))

        add?.let {
            Add(onClick = it)
        }

        ok?.let {
            Ok(onClick = it)
        }

        menu?.let {
            Menu(onClick = it)
        }
    }
}

@Composable
fun Dot(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Spacer(
        modifier = modifier
            .size(42.dp)
            .clip(shape = RoundedCornerShape(50))
            .clickable { onClick.invoke() }
            .padding(16.dp)
            .background(
                shape = RoundedCornerShape(50),
                color = DesignComponent.colors.primaryInverse
            )
    )
}

@Composable
fun Menu(onClick: () -> Unit) {
    IconPrimary(
        imageVector = Icons.Default.Menu,
        onClick = onClick
    )
}

@Composable
fun Add(onClick: () -> Unit) {
    IconPrimary(
        imageVector = Icons.Default.Add,
        onClick = onClick
    )
}

@Composable
fun Ok(onClick: () -> Unit) {
    IconPrimary(
        imageVector = Icons.Default.Done,
        onClick = onClick
    )
}