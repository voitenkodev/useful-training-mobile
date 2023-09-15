package root

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
import controls.ButtonPrimaryBrand
import controls.TextFieldH1

// Expect logic with Jetpack compose IOS (Not canvas)

@Composable
internal fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade()),
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.ScreenOne -> ScreenOne(child.component)
            is RootComponent.Child.ScreenTwo -> ScreenTwo(child.component)
        }
    }
}

@Composable
internal fun ScreenOne(
    component: ScreenOneComponent
) {
    Box(modifier = Modifier.fillMaxSize()) {

        ButtonPrimaryBrand(
            modifier = Modifier.align(Alignment.Center),
            text = "ad",
            onClick = { component.toScreenTwo() }
        )
    }
}

@Composable
internal fun ScreenTwo(
    component: ScreenTwoComponent
) {

    PlatformBackHandler(component::back)

    Box(modifier = Modifier.fillMaxSize()) {
        TextFieldH1(
            modifier = Modifier.align(Alignment.Center),
            provideText = { "name = ${component.name}" }
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
