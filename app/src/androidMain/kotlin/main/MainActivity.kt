package main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import designsystem.atomic.DesignTheme
import navigation.GlobalGraph
import navigation.NavigatorState
import redux.StoreProvider
import redux.store

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()

            SideEffect { systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = false) }

            DesignTheme {
                StoreProvider(store) {
                    NavigatorState {
                        GlobalGraph(it)
                    }
                }
            }
        }
    }
}