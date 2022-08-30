package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import designsystem.GallerySpaceComponent
import designsystem.components.Toolbar
import designsystem.controls.*
import platform.loadImage
import models.Art

@Composable
fun PreviewScreen() {

    val art = Art.MOCK
    val artImage = remember { mutableStateOf<ImageBitmap?>(null) }
    val ownerImage = remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(Unit) {
        artImage.value = loadImage(art.url)
        ownerImage.value = loadImage(art.owner.imageUrl)
    }

    LazyColumn {

        stickyHeader {
            Toolbar(add = {}, back = {}, menu = {})
        }

        item {
            Picture(image = artImage.value)
        }

        item {
            H1Text(modifier = Modifier.padding(top = 8.dp).padding(horizontal = 16.dp), text = art.title)
        }

        item {
            BODY2Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                text = art.creator.name,
                textAlign = TextAlign.End
            )
        }

        item {
            Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = GallerySpaceComponent.colors.primaryInverse)
        }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Rating") {
                RatingBar(
                    modifier = Modifier.height(height = 16.dp),
                    rating = 3.5f,
                )
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Created at") {
                BODY2Text(text = art.createdAt)
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Price") {
                ButtonPrimary(
                    modifier = Modifier,
                    text = art.price,
                    onClick = { /*TODO*/ },
                    textColor = GallerySpaceComponent.colors.primaryInverse,
                    backgroundColor = GallerySpaceComponent.colors.priceUp
                )
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            Info(modifier = Modifier.padding(horizontal = 16.dp), caption = "Owner") {
                artImage.value?.let {
                    Image(
                        bitmap = it, modifier = Modifier.size(36.dp).clip(shape = RoundedCornerShape(50)), contentDescription = null
                    )
                }
                BODY2Text(text = art.owner.name)
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            Info(
                modifier = Modifier.padding(horizontal = 16.dp), caption = "Description", orientation = Orientation.Vertical
            ) {
                BODY1Text(text = art.description)
            }
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }
    }
}

@Composable
fun Picture(image: ImageBitmap?) {
    Box(modifier = Modifier.fillMaxWidth().aspectRatio(1f)) {
        image?.let {
            Image(
                modifier = Modifier.fillMaxSize().alpha(0.5f), bitmap = it, contentScale = ContentScale.Crop, contentDescription = null
            )

            Image(
                modifier = Modifier.align(Alignment.Center).padding(vertical = 16.dp).wrapContentSize(),
                bitmap = it,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun Info(
    modifier: Modifier = Modifier, caption: String, orientation: Orientation = Orientation.Horizontal, content: @Composable () -> Unit
) {
    if (orientation == Orientation.Horizontal) Row(
        modifier = modifier.defaultMinSize(minHeight = 44.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CAPTION1Text(modifier = Modifier.weight(1f), text = caption)
        content.invoke()
    } else Column(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CAPTION1Text(modifier = Modifier.padding(top = 12.dp), text = caption)
        content.invoke()
    }
}