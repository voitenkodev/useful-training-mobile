package exerciseexample.main.components

import AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import atom.Design
import exerciseexample.main.models.ExerciseExample
import molecule.PaddingM
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextBody1
import molecule.TextH2

@Composable
internal fun Header(exerciseExample: ExerciseExample?) {
    Box(modifier = Modifier.height(IntrinsicSize.Min)) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = exerciseExample?.imageUrl,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxSize().background(Design.colors.black30))

        Column(modifier = Modifier.statusBarsPadding()) {

            PaddingXL()

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { exerciseExample?.name },
            )

            PaddingM()

            TextBody1(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = {
                    "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                            "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum"
                }
            )

            PaddingXL()
        }

        Shadow(modifier = Modifier.align(Alignment.BottomCenter))
    }

}