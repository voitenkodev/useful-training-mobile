import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import atom.darkPalette
import atom.dp
import atom.shape
import atom.typography
import molecular.primaryBackground

@Composable
public fun DesignTheme(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
): Unit = CompositionLocalProvider(

    LocalColor provides when (darkTheme) {
        true -> darkPalette()
        false -> darkPalette()
    },

    LocalTypography provides typography(),

    LocalDp provides dp(),

    LocalShape provides shape(),

    content = {
        Surface(
            modifier = Modifier.primaryBackground().then(modifier),
            color = Design.colors.primary,
            content = content
        )
    }
)
