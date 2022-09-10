package main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import designsystem.common.DesignComponent
import designsystem.common.DesignTheme
import ui.Navigator

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DesignTheme {
                Surface(color = DesignComponent.colors.primary) {
                    val navController = rememberAnimatedNavController()
                    Navigator(navController)
                }
            }
        }
    }
}

/*
  authSource.registration(email, password)
.onEach { navController.navigate("training") }
.catch { Toast.makeText(context, "registration - $it", Toast.LENGTH_LONG).show() }
.launchIn(scope)
* */