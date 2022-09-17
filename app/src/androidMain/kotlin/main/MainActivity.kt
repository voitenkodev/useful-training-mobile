package main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import designsystem.common.DesignComponent
import designsystem.common.DesignTheme
import ui.navigation.ComposeNavigator

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()
            SideEffect { systemUiController.setSystemBarsColor(color = Color.Transparent, darkIcons = false) }

            DesignTheme {
                Surface(
                    modifier = Modifier.systemBarsPadding().navigationBarsPadding(),
                    color = DesignComponent.colors.primary100
                ) {
                    val navController = rememberAnimatedNavController()
                    ComposeNavigator(navController)
                }
            }
        }
    }
}