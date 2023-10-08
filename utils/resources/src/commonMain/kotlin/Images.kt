import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.voitenko.usefultraining.SharedRes
import dev.icerock.moko.resources.compose.painterResource

object Images {
    @Composable
    fun gym(): Painter {
        return painterResource(SharedRes.images.gym)
    }

    @Composable
    fun addTraining(): Painter {
        return painterResource(SharedRes.images.add_training_bg)
    }

    @Composable
    fun dumbbells(): Painter {
        return painterResource(SharedRes.images.dumbbells)
    }
}