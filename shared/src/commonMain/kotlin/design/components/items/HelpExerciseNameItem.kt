package design.components.items

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import design.Design
import design.components.labels.ChipLabel

@Composable
fun HelpExerciseNameItem(
    querySort: () -> String,
    visibility: () -> Boolean,
    select: (String) -> Unit
) {
    // TODO ADD API
    val opts by remember(querySort()) {
        mutableStateOf(
            listOf(
                "Жим лежа",
                "Жим 45",
                "Бабочка",

                "Бицепс в скотте узким хватом",
                "Бицепс в скотте широким хватом",
                "Бицепс стоя обратным хватом",
                "Молотки",

                "Присед",
                "Присед фронтальный",
                "Выпады",
                "Жим ногами",

                "Становая на прямых",
                "Тяга штанги в наклоне к животу",
                "Тяга штанги в наклоне к животу узким обратным хватом",
                "Тяга вертикального блока на спину",
                "Тяга горизонтального блока на спину",
                "Тяга вертикального блока к животу на спину",

                "Жим узким",
                "Французский жим",
                "Тяга вертикального блока на трицепс",
                "Брусья в блоке",

                "Скручивание",
                "Махи ног на пресс",

            ).sortedByDescending { it.contains(querySort()) }
        )
    }

    AnimatedVisibility(
        visible = visibility(),
        enter = fadeIn() + expandVertically(),
        exit = shrinkVertically() + fadeOut(),
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Design.dp.padding)
        ) {
            items(opts) {
                ChipLabel(
                    provideText = { it },
                    onClick = select,
                )
            }
        }
    }
}