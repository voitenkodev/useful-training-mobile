package exerciseexample.main

import VideoPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import components.Error
import components.roots.ScreenRoot
import exerciseexample.main.models.ExerciseExample
import molecule.PaddingM
import molecule.PaddingS
import molecule.PaddingXL
import molecule.Shadow
import molecule.TextBody1
import molecule.TextH2
import molecule.TextLabel
import molecule.secondaryBackground
import molecule.secondaryDefaultBackground

@Composable
internal fun ExerciseExampleContent(
    vm: ExerciseExampleViewModel,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        loading = state.loading,
        clearError = vm::clearError,
        exerciseExample = state.exerciseExample,
        fullFrontImage = state.fullFrontImageVector,
        fullBackImage = state.fullBackImageVector,
        close = close
    )
}

@Composable
private fun Content(
    error: () -> String?,
    loading: Boolean,
    clearError: () -> Unit,
    exerciseExample: ExerciseExample?,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .statusBarsPadding()
        ) {

            PaddingXL()

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM).align(Alignment.CenterHorizontally),
                provideText = { exerciseExample?.name },
            )

            PaddingM()

            TextBody1(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM).align(Alignment.CenterHorizontally),
                provideText = {
                    "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                            "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum"
                },
                textAlign = TextAlign.Center
            )

            PaddingXL()

            TextLabel(modifier = Modifier.padding(horizontal = Design.dp.paddingM), provideText = { "Video tutorial" })

            PaddingS()

            VideoPlayer(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
                    .padding(horizontal = Design.dp.paddingM)
                    .secondaryDefaultBackground(),
                url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            )

            PaddingXL()

            TextLabel(modifier = Modifier.padding(horizontal = Design.dp.paddingM), provideText = { "Heap Map" })

            PaddingS()

            Column(modifier = Modifier.secondaryBackground()) {

                Shadow()

                PaddingM()

                Row(
                    modifier = Modifier.padding(horizontal = Design.dp.paddingXL),
                    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
                ) {
                    Image(
                        modifier = Modifier.weight(1f).fillMaxHeight(),
                        contentDescription = null,
                        imageVector = fullFrontImage
                    )

                    Image(
                        modifier = Modifier.weight(1f).fillMaxHeight(),
                        contentDescription = null,
                        imageVector = fullBackImage
                    )
                }

                PaddingM()

                Shadow()
            }
        }
    }
}