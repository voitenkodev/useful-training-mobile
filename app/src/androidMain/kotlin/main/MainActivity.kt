package main

import Action
import DesignComponent
import DesignTheme
import GlobalState
import Graph
import Main
import ReduxStoreProvider
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import co.touchlab.kermit.Logger
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import generateGraph
import globalReducer
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.setupNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setupThemedNavigation(
            modifier = Modifier.statusBarsPadding().navigationBarsPadding(),
            startScreen = Graph.Auth.link,
            navigationGraph = { generateGraph() }
        )
    }
}

fun ComponentActivity.setupThemedNavigation(
    modifier: Modifier = Modifier,
    startScreen: String,
    vararg providers: ProvidedValue<*>,
    navigationGraph: RootComposeBuilder.() -> Unit
) {
    setContent {

        DesignTheme(modifier = modifier) {

            val rootController = RootComposeBuilder().apply(navigationGraph).build()
            rootController.backgroundColor = DesignComponent.colors.primary
            rootController.setupWithActivity(this)

            ReduxStoreProvider(
                globalReducer = globalReducer,
                globalState = GlobalState(),
                logging = { if (it is Action) Logger.i { "reduxLogger::DISPATCHED => \"${it.group}/${it.action}\"" } }
            ) {

                CompositionLocalProvider(*providers, LocalRootController provides rootController) {
                    Navigator(startScreen)
                }
            }
        }
    }
}