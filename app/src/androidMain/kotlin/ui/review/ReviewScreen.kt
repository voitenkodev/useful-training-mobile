package ui.review

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldH1
import content.Summary

@Composable
fun ReviewScreen() = LazyColumn(
    modifier = Modifier.fillMaxSize().padding(DesignComponent.size.rootSpace),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    item {
        TextFieldH1(text = "Training Review")
    }
    item {
        LineChart(
            modifier = Modifier.fillMaxWidth().aspectRatio(1.8f).padding(8.dp)
        )
    }

    item {
        TextFieldBody2(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "Summary",
            color = DesignComponent.colors.secondaryInverse.copy(alpha = 0.5f)
        )
    }
    item {
        Summary()
    }
}