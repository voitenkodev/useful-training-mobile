package molecule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun BottomSheet(
    sheetContent: @Composable ColumnScope.() -> Unit,
    content: @Composable PaddingValues.() -> Unit
) {

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp
        ),
        backgroundColor = Color.Transparent,
        contentColor = Color.Transparent,
        sheetContentColor = Color.Transparent,
        sheetBackgroundColor = Design.colors.secondary,
        sheetContent = {
            Column(
                modifier = Modifier.padding(
                    vertical = Design.dp.paddingXL,
                    horizontal = Design.dp.paddingM
                ),
                content = {
                    sheetContent.invoke(this)
                }
            )
        },
        content = content
    )
}