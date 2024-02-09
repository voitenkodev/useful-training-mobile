package exerciseexample.main.mapping

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import atom.Design
import exerciseexample.main.models.ResourceTypeEnum
import exerciseexample.main.models.Tutorial
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import resources.Icons

internal fun List<models.Tutorial>.toState(): ImmutableList<Tutorial> {
    return map { it.toState() }
        .toPersistentList()
}

internal fun models.Tutorial.toState(): Tutorial {
    return Tutorial(
        id = id,
        resource = resource,
        language = language,
        title = title,
        value = value,
        resourceType = resourceType.toState(),
        icon = resourceType.toImageState()
    )
}

private fun models.ResourceTypeEnum.toState(): ResourceTypeEnum {
    return when (this) {
        models.ResourceTypeEnum.YOUTUBE_VIDEO -> ResourceTypeEnum.YOUTUBE_VIDEO
        models.ResourceTypeEnum.VIDEO -> ResourceTypeEnum.VIDEO
        models.ResourceTypeEnum.TEXT -> ResourceTypeEnum.TEXT
        models.ResourceTypeEnum.UNKNOWN -> ResourceTypeEnum.UNKNOWN
    }
}

private fun models.ResourceTypeEnum.toImageState(): Pair<ImageVector, Color> {
    return when (this) {
        models.ResourceTypeEnum.YOUTUBE_VIDEO -> Icons.youtube to Color(0xffff0100)
        models.ResourceTypeEnum.VIDEO -> Icons.youtube to Design.palette.white10
        models.ResourceTypeEnum.TEXT -> Icons.text to Design.palette.white10
        models.ResourceTypeEnum.UNKNOWN -> Icons.add to Design.palette.white10
    }
}