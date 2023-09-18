package decompose

import PlatformBackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import controls.ButtonBrand
import controls.TextFieldH1

// TODO Expect logic with Jetpack compose IOS (Not canvas)

@Composable
internal fun ScreenOne(
    click: ()-> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        ButtonBrand(
            modifier = Modifier.align(Alignment.Center),
            text = "ad",
            onClick = click
        )
    }
}

@Composable
internal fun ScreenTwo(
    name: String,
    click: ()-> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        TextFieldH1(
            modifier = Modifier.align(Alignment.Center),
            provideText = { "name = ${name}" }
        )
    }
}

class ScreenOneComponent(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit
) : ComponentContext by componentContext {

    fun toScreenTwo() {
        output(Output.ToScreenTwo("LOX"))
    }

    sealed class Output {
        object Back : Output()
        data class ToScreenTwo(val name: String) : Output()
    }
}


class ScreenTwoComponent(
    componentContext: ComponentContext,
    val name: String,
    private val output: (ScreenTwoComponent.Output) -> Unit
) : ComponentContext by componentContext {

    fun back() {
        output(Output.Back)
    }

    sealed class Output {
        object Back : Output()
        data class ToScreenOne(val name: String) : Output()
    }
}
