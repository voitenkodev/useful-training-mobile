package trainings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.controls.TextFieldBody1
import designsystem.controls.TextFieldBody2
import designsystem.controls.TextFieldBody3
import designsystem.controls.TextFieldH1
import training.MOCK
import training.TrainingState

@Composable
fun TrainingsContent(
) = LazyColumn(
    modifier = Modifier.fillMaxSize().padding(DesignComponent.size.rootSpace),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.itemSpace)
) {

    stickyHeader {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextFieldH1(
                text = "•",
                color = DesignComponent.colors.special
            )

            TextFieldBody2(
                text = "cycle from",
                color = DesignComponent.colors.primaryInverse.copy(alpha = 0.5f)
            )

            TextFieldBody1(text = "16.09.2022")
        }
    }
    item {
        TrainingItem(MOCK)
    }
}

@Composable
fun TrainingItem(trainingState: TrainingState) {
    Column(
        modifier = Modifier.background(DesignComponent.colors.primary, RoundedCornerShape(8.dp))
            .border(BorderStroke(2.dp, DesignComponent.colors.special), RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {

        TextFieldBody2(
            modifier = Modifier.padding(vertical = 4.dp),
            text = "Monday",
            color = DesignComponent.colors.special
        )


        trainingState.exercises.forEach {

            TextFieldBody2(
                modifier = Modifier.padding(vertical = 4.dp),
                text = it.name,
                fontWeight = FontWeight.Bold
            )

            Divider()

            it.iterations.chunked(4).forEach { iterations ->
                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    iterations.forEach { iteration ->
                        Column(
                            modifier = Modifier.background(
                                color = DesignComponent.colors.special.copy(alpha = DesignComponent.colors.alphaPrimary),
                                shape = CircleShape
                            ).padding(horizontal = 12.dp, vertical = 4.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            TextFieldBody3(text = iteration.weight + " x " + iteration.repeat)
                        }
                    }
                }
            }
        }
    }
}