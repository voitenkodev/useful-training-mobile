package exerciseexample.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import components.Error
import components.roots.ScreenRoot
import exerciseexample.main.models.ExerciseExample
import molecule.PaddingM
import molecule.PaddingXL
import molecule.TextBody2
import molecule.TextH2
import musclepickerpicker.fullBack
import musclepickerpicker.fullFront

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
        close = close
    )
}

@Composable
private fun Content(
    error: () -> String?,
    loading: Boolean,
    clearError: () -> Unit,
    exerciseExample: ExerciseExample?,
    close: () -> Unit
) {

    ScreenRoot(error = { Error(message = error, close = clearError) }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PaddingXL()

            TextH2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = { exerciseExample?.name },
                textAlign = TextAlign.Center
            )

            PaddingM()

            TextBody2(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                provideText = {
                    "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                            "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum\n" +
                            "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium\n" +
                            "optio, eaque rerum!"
                }, textAlign = TextAlign.Center
            )

            PaddingXL()

            Row(
                modifier = Modifier.padding(horizontal = Design.dp.paddingM),
                horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
            ) {
                Image(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentDescription = null,
                    imageVector = fullFront()
                )

                Image(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentDescription = null,
                    imageVector = fullBack()
                )
            }
        }
    }
}