package exerciseexample.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import components.Error
import components.overlay.TopShadow
import components.roots.ScreenRoot
import exerciseexample.main.components.Achievements
import exerciseexample.main.components.Header
import exerciseexample.main.components.HeapMap
import exerciseexample.main.components.MusclePack
import exerciseexample.main.components.ResentVolume
import exerciseexample.main.models.ExerciseExample
import molecule.ButtonPrimary
import molecule.PaddingXL

@Composable
internal fun ExerciseExampleContent(
    vm: ExerciseExampleViewModel,
    primaryAction: (Pair<String, (id: String) -> Unit>)?,
    close: () -> Unit
) {

    val state by vm.state.collectAsState()

    Content(
        error = { state.error },
        clearError = vm::clearError,
        primaryAction = primaryAction,
        exerciseExample = state.exerciseExample,
        fullFrontImage = state.fullFrontImageVector,
        fullBackImage = state.fullBackImageVector
    )
}

@Composable
private fun Content(
    error: () -> String?,
    clearError: () -> Unit,
    primaryAction: (Pair<String, (id: String) -> Unit>)?,
    exerciseExample: ExerciseExample?,
    fullFrontImage: ImageVector,
    fullBackImage: ImageVector
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

            Header(exerciseExample = exerciseExample)

            PaddingXL()

//            Tutorial(url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", onClick = {})
//
//            PaddingXL()

            MusclePack(exerciseExample = exerciseExample)

            PaddingXL()

            HeapMap(fullFrontImage = fullFrontImage, fullBackImage = fullBackImage)

            PaddingXL()

            Achievements()

            PaddingXL()

            ResentVolume()

            if (primaryAction != null) {
                Spacer(modifier = Modifier.size(Design.dp.componentM))
            }

            PaddingXL()
        }

        Box(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
            TopShadow(modifier = Modifier.fillMaxSize())

            Column {
                if (primaryAction != null) {
                    ButtonPrimary(
                        modifier = Modifier.statusBarsPadding().fillMaxWidth(0.5f),
                        text = primaryAction.first,
                        onClick = { primaryAction.second.invoke(exerciseExample?.id ?: return@ButtonPrimary) }
                    )
                }

                Spacer(modifier = Modifier.statusBarsPadding().height(Design.dp.paddingXL))
            }
        }
    }
}