package components.backgrounds

import Design
import Images
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale

@Composable
public fun AddTrainingBackground(
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        Image(
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = Images.addTraining(),
            contentDescription = null
        )

        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5f)
                .background(color = Design.colors.primary)
        )
    }
}