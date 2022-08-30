package temp.newart//package com.voitenko.dev.galleryspace.newart
//
//import android.graphics.Bitmap
//import android.graphics.ImageDecoder
//import android.net.Uri
//import android.os.Build
//import android.provider.MediaStore
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.Icon
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.voitenko.dev.designsystem.designsystem.GallerySpaceComponent
//import com.voitenko.dev.designsystem.components.Toolbar
//import designsystem.controls.BODY1EditText
//import designsystem.controls.BODY1Text
//import com.voitenko.dev.designsystem.controls.Divider
//import org.koin.androidx.compose.koinViewModel
//
//@ExperimentalFoundationApi
//@Composable
//fun NewArtScreen(
//    navController: NavController,
//    viewModel: NewArtViewModel = koinViewModel()
//) {
//    val art = viewModel.state.collectAsState()
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
////            .statusBarsPadding()
//    ) {
//
//        stickyHeader {
//            Toolbar(
//                ok = {
//                    viewModel.save(
//                        success = {navController.popBackStack()},
//                        error = {}
//                    )
//                }
//            )
//        }
//
//        item {
//            val context = LocalContext.current
//            val imageUri = remember { mutableStateOf<Uri?>(null) }
//            val bitmap = remember { mutableStateOf<Bitmap?>(null) }
//            val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(),
//                onResult = { uri: Uri? -> imageUri.value = uri })
//            Box(
//                modifier = Modifier
//                    .aspectRatio(1f)
//                    .background(designsystem.GallerySpaceComponent.colors.secondary)
//                    .clickable { launcher.launch("image/*") },
//                contentAlignment = Alignment.Center,
//            ) {
//
//                imageUri.value?.let {
//                    if (Build.VERSION.SDK_INT < 28) {
//                        bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
//                    } else {
//                        val source = ImageDecoder.createSource(context.contentResolver, it)
//                        bitmap.value = ImageDecoder.decodeBitmap(source)
//                    }
//                    viewModel.set(image = bitmap.value)
//
//                    bitmap.value?.let { btm ->
//                        Image(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .background(designsystem.GallerySpaceComponent.colors.secondary)
//                                .alpha(0.3f),
//                            bitmap = btm.asImageBitmap(),
//                            contentScale = ContentScale.Crop,
//                            contentDescription = null
//                        )
//
//                        Image(
//                            modifier = Modifier
//                                .wrapContentSize()
////                                .statusBarsPadding()
//                                .padding(16.dp),
//                            bitmap = btm.asImageBitmap(),
//                            contentDescription = null
//                        )
//                    }
//                }
//                if (bitmap.value == null)
//                    Icon(
//                        painterResource(id = com.voitenko.dev.designsystem.R.drawable.ic_gallery),
//                        tint = designsystem.GallerySpaceComponent.colors.primaryInverse,
//                        modifier = Modifier
//                            .fillMaxSize(0.5f)
////                            .statusBarsPadding()
//                            .padding(16.dp),
//                        contentDescription = null
//                    )
//            }
//        }
//
//        item {
//            BODY1EditText(
//                text = art.value.title,
//                onValueChange = { viewModel.set(title = it) },
//                label = "Put a Title",
//            )
//        }
//
//        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }
//
//        item {
//            Info(
//                modifier = Modifier.padding(horizontal = 16.dp),
//                caption = "Put a date",
//                placeholder = "00, Jan, 0000",
//                value = art.value.createAt,
//                onClick = { viewModel.set(date = "2010-06-01T22:19:44") })
//        }
//
//        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }
//
//        item {
//            Info(
//                modifier = Modifier.padding(horizontal = 16.dp),
//                caption = "Put a price",
//                placeholder = "--- $",
//                value = art.value.price,
//                onClick = { viewModel.set(price = "200 $") }
//            )
//        }
//
//        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }
//
//        item {
//            BODY1EditText(
//                text = art.value.description,
//                onValueChange = { viewModel.set(description = it) },
//                label = "Put a description",
//            )
//        }
//    }
//}
//
//@Composable
//private fun Info(
//    modifier: Modifier = Modifier,
//    caption: String,
//    placeholder: String?,
//    value: String?,
//    onClick: () -> Unit,
//) {
//    Row(
//        modifier = modifier
//            .defaultMinSize(minHeight = 44.dp)
//            .padding(vertical = 8.dp)
//            .fillMaxWidth()
//            .clickable { onClick.invoke() },
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        BODY1Text(modifier = Modifier.weight(1f), text = caption)
//        BODY1Text(placeholder = placeholder, text = value)
//        Icon(
//            imageVector = Icons.Default.ArrowForward,
//            tint = designsystem.GallerySpaceComponent.colors.primaryInverse.copy(alpha = 0.7f),
//            contentDescription = null
//        )
//    }
//}