package utils

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object Logger {

    fun l(msg: () -> String?) {
        print(msg.invoke())
        println(msg.invoke())
    }

    @Composable
    fun compose(vararg values: Any?) {
        Column {
            values.map { it.hashCode().toString() }.forEach {
                Text(text = it ?: "null", color = Color.Red)
            }
        }
    }
}