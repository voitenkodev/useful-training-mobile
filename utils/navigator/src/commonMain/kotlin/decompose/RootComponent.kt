//package decompose
//
//import com.arkivanov.decompose.ComponentContext
//import com.arkivanov.decompose.router.stack.ChildStack
//import com.arkivanov.decompose.router.stack.StackNavigation
//import com.arkivanov.decompose.router.stack.childStack
//import com.arkivanov.decompose.router.stack.pop
//import com.arkivanov.decompose.router.stack.push
//import com.arkivanov.decompose.value.Value
//import com.arkivanov.essenty.parcelable.Parcelable
//import com.arkivanov.essenty.parcelable.Parcelize
//
//// https://github.com/MohamedRejeb/Pokedex/blob/main/shared/src/commonMain/kotlin/com/mocoding/pokedex/ui/root/RootComponent.kt
//
//// TODO Expect logic with Jetpack compose IOS (Not canvas)
//class RootComponent internal constructor(
//    componentContext: ComponentContext,
//    private val screenOne: (ComponentContext, (ScreenOneComponent.Output) -> Unit) -> ScreenOneComponent,
//    private val screenTwo: (ComponentContext, name: String, (ScreenTwoComponent.Output) -> Unit) -> ScreenTwoComponent,
//) : ComponentContext by componentContext {
//
//    constructor(componentContext: ComponentContext) : this(
//        componentContext = componentContext,
//        screenOne = { cC, output ->
//            ScreenOneComponent(cC, output)
//        },
//        screenTwo = { cC, name, output ->
//            ScreenTwoComponent(cC, name, output)
//        },
//    )
//
//    private val navigation = StackNavigation<Configuration>()
//
//    private val stack = childStack(
//        source = navigation,
//        initialConfiguration = Configuration.ScreenOne,
//        handleBackButton = false,
//        childFactory = ::createChild
//    )
//
//    val childStack: Value<ChildStack<*, Child>> = stack
//
//    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child =
//        when (configuration) {
//            is Configuration.ScreenOne -> Child.ScreenOne(screenOne(componentContext, ::onScreenOneOutput))
//            is Configuration.ScreenTwo -> Child.ScreenTwo(screenTwo(componentContext, configuration.name, ::onScreenTwoOutput))
//        }
//
//    private fun onScreenOneOutput(output: ScreenOneComponent.Output): Unit = when (output) {
//        ScreenOneComponent.Output.Back -> navigation.pop()
//        is ScreenOneComponent.Output.ToScreenTwo -> navigation.push(Configuration.ScreenTwo(output.name))
//    }
//
//    private fun onScreenTwoOutput(output: ScreenTwoComponent.Output): Unit = when (output) {
//        ScreenTwoComponent.Output.Back -> navigation.pop()
//        is ScreenTwoComponent.Output.ToScreenOne -> TODO()
//    }
//
//    private sealed class Configuration : Parcelable {
//        @Parcelize
//        object ScreenOne : Configuration()
//
//        @Parcelize
//        data class ScreenTwo(val name: String) : Configuration()
//    }
//
//    sealed class Child {
//        data class ScreenOne(val component: ScreenOneComponent) : Child()
//        data class ScreenTwo(val component: ScreenTwoComponent) : Child()
//    }
//}