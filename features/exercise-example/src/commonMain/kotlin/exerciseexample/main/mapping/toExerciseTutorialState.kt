package exerciseexample.main.mapping

import androidx.compose.ui.graphics.vector.ImageVector
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
        imageVector = resourceType.toImageState(),
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

private fun models.ResourceTypeEnum.toImageState(): ImageVector {
    return when (this) {
        models.ResourceTypeEnum.YOUTUBE_VIDEO -> Icons.youtube
        models.ResourceTypeEnum.VIDEO -> Icons.youtube
        models.ResourceTypeEnum.TEXT -> Icons.text
        models.ResourceTypeEnum.UNKNOWN -> Icons.youtube
    }
}