package main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import designsystem.common.DesignComponent
import designsystem.common.DesignTheme
import ui.navigation.ComposeNavigator

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DesignTheme {
                Surface(color = DesignComponent.colors.primary) {
                    val navController = rememberAnimatedNavController()
                    ComposeNavigator(navController)
                }
            }
        }
    }
}