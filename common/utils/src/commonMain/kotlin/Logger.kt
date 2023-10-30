import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue

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
                BasicTextField(
                    value = TextFieldValue(it),
                    onValueChange = {},
                    textStyle = TextStyle.Default.copy(color = Color.Red)
                )
            }
        }
    }

    @Composable
    public fun compose(value: String) {
        BasicTextField(
            value = TextFieldValue(value),
            onValueChange = {},
            textStyle = TextStyle.Default.copy(color = Color.Red)
        )
    }
}