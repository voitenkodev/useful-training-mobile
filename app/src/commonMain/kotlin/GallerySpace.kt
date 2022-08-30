import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi
import designsystem.GallerySpaceComponent
import designsystem.common.GallerySpaceTheme
import screens.GalleryScreen
import screens.PreviewScreen

@Composable
fun GallerySpace() {
    GallerySpaceTheme {
        Surface(color = GallerySpaceComponent.colors.primary) {
//            GalleryScreen()
            PreviewScreen()
        }
    }
}