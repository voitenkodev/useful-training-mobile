import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

public object Logger {

    // System.out
    public fun l(msg: () -> String?) {
        print(msg.invoke())
        println(msg.invoke())
    }

    @Composable
    public fun compose(vararg values: Any?) {
        Column {
            values.map { it.hashCode().toString() }.forEach {
                Text(text = it, color = Color.Red)
            }
        }
    }

    @Composable
    public fun compose(value: String) {
        Text(text = value, color = Color.Red)
    }
}