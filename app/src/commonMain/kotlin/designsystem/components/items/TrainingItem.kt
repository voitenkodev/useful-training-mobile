package designsystem.components.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.atomic.BarChart
import designsystem.atomic.DesignComponent
import designsystem.components.labels.WeekDayLabel
import designsystem.controls.DividerPrimary
import designsystem.controls.IconPrimary
import designsystem.controls.TextFieldBody2
import redux.TrainingState

@Composable
fun TrainingItem(
    state: TrainingState,
    edit: (TrainingState) -> Unit,
    review: (TrainingState) -> Unit,
) = Column(
    modifier = Modifier.background(
        color = DesignComponent.colors.secondary,
        shape = DesignComponent.shape.default
    ).padding(12.dp)
) {

    TrainingHeader(
        modifier = Modifier.fillMaxWidth(),
        trainingState = state,
        review = review,
        edit = edit
    )

    DividerPrimary(modifier = Modifier.padding(bottom = 4.dp, top = 12.dp))

    state.exercises.forEachIndexed { index, item ->
        ExerciseItem(
            number = index + 1,
            exercise = item
        )
    }

    DividerPrimary(modifier = Modifier.padding(vertical = 12.dp))

    TrainingFooter(
        modifier = Modifier.fillMaxWidth(),
        trainingState = state
    )
}

@Composable
private fun TrainingHeader(
    modifier: Modifier = Modifier,
    trainingState: TrainingState,
    review: (TrainingState) -> Unit,
    edit: (TrainingState) -> Unit
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDay = trainingState.weekDay,
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Start Time",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = trainingState.startTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.weight(1f))

    IconPrimary(
        modifier = Modifier.height(20.dp),
        imageVector = BarChart,
        color = DesignComponent.colors.caption,
        onClick = { review.invoke(trainingState) }
    )

    Spacer(modifier = Modifier.size(20.dp))

    IconPrimary(
        modifier = Modifier.height(20.dp),
        imageVector = Icons.Default.Edit,
        color = DesignComponent.colors.caption,
        onClick = { edit.invoke(trainingState) }
    )
}

@Composable
private fun TrainingFooter(
    modifier: Modifier = Modifier,
    trainingState: TrainingState,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Duration",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = trainingState.durationTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.weight(1f))

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Tonnage",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        text = "${trainingState.tonnage}kg",
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )
}

//@Composable
//@Preview(
//    showBackground = true,
//    backgroundColor = 0xFF121311,
//    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
//)
//@Preview(
//    showBackground = true,
//    backgroundColor = 0xFFFFFFFF,
//    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
//)
//fun PresentationItem_Preview() {
//    PresentationItem(
//        url = "https://collectionapi.metmuseum.org/api/collection/v1/iiif/591860/1229664/restricted",
//        title = "The Treatyse of Fysshynge wyth an Angle from the book of Saint Albans\n1903",
//        description = "In 1878 William Loring Andrews became a trustee of The Metropolitan Museum of Art and served as its first librarian. He was a prominent collector of rare books of English and American literature and a founding member of the Grolier Club and the Society of Iconophiles. In 1865 Andrews began to self-publish books in which he was also the author or editor. These works were published in his own taste, through his own direction, and are marked by exquisite taste in type, paper, illustration, and binding. In their production, he engaged the services of engravers Edwin Davis French and S. L. Smith, who designed and engraved bookplates for the Metropolitan Museum, and printers Walter Gillias and Theodore De Vinne. From 1865 to 1908 Andrews issued thirty-six volumes, twenty-six authored by himself. \"The Treatyse of Fysshynge\" was printed on hand-made paper in an edition of 160, at the Gilliss Press; the type, caste specially for the book, was patterned after the traditional Old English characters first used by Wynkyn de Worde. The volume is bound in full limpvellum, with the title gold-tooled on the front cover, and has two green silk ties.",
//        creator = "Juliana Berners",
//        more = {}
//    )
//}