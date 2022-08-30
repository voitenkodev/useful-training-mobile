package temp.presentation//package com.voitenko.dev.galleryspace.presentation
//
//import androidx.compose.animation.*
//import androidx.compose.animation.core.Spring
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.spring
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyListState
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.core.net.toUri
//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter
//import coil.request.ImageRequest
//import com.voitenko.dev.designsystem.designsystem.GallerySpaceComponent
//import com.voitenko.dev.designsystem.designsystem.components.Owner
//import com.voitenko.dev.designsystem.designsystem.components.PresentationDashboard
//import com.voitenko.dev.designsystem.components.Toolbar
//import designsystem.controls.H2Text
//import com.voitenko.dev.designsystem.modifiers.rolling
//import com.voitenko.dev.galleryspace.mock
//import org.koin.androidx.compose.koinViewModel
//
//@ExperimentalMaterialApi
//@ExperimentalFoundationApi
//@ExperimentalComposeUiApi
//@ExperimentalAnimationApi
//@Composable
//fun PresentationScreen(
//    navController: NavController,
//    viewModel: PresentationViewModel = koinViewModel(),
//    artId: String,
//) {
//
//    val art = mock(artId)!! // todo mock
//
//    val title = art.title
//    val creator = art.creator
//    val createdAt = art.createdAt
//    val price = art.price
//    val description = art.description
//    val image = art.url
//
//    val owners = listOf(
//        Owner(
//            name = "Philip K. Howard",
//            uri = "https://upload.wikimedia.org/wikipedia/commons/a/ad/Philip_K._Howard.jpg".toUri(),
//            purchase = "1.2224 BTC",
//            purchaseColor = designsystem.GallerySpaceComponent.colors.priceUp,
//            date = "10.11.2022"
//        ), Owner(
//            name = "Alfredo Peters",
//            uri = "https://miro.medium.com/max/1400/0*E-e0EHOU1Fvxtuis.jpg".toUri(),
//            purchase = "0.0054 BTC",
//            purchaseColor = designsystem.GallerySpaceComponent.colors.priceUp,
//            date = "16.09.2019"
//        ), Owner(
//            name = "Michiel Vernandos",
//            uri = "https://globalmsk.ru/usr/person/big-person-15642469881.jpg".toUri(),
//            purchase = "127 $",
//            purchaseColor = designsystem.GallerySpaceComponent.colors.priceDown,
//            date = "26.08.2016"
//        ), Owner(
//            name = "Van Gogh",
//            uri = "https://upload.wikimedia.org/wikipedia/commons/7/76/Vincent_van_Gogh_photo_cropped.jpg".toUri(),
//            purchase = "142 $",
//            purchaseColor = designsystem.GallerySpaceComponent.colors.priceUp,
//            date = "01.01.2008"
//        )
//    )
//
//    val painter = rememberAsyncImagePainter(
//        model = ImageRequest.Builder(LocalContext.current).data(image.toUri()).size(coil.size.Size.ORIGINAL).build()
//    )
//
//    val scaffoldState = rememberBottomSheetScaffoldState(
//        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
//    )
//
//    val listState: LazyListState = rememberLazyListState()
//
//    val fraction = animateFloatAsState(
//        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1.0f else 0.5f,
//        animationSpec = spring(stiffness = Spring.StiffnessLow)
//    )
//
//    val background = animateColorAsState(
//        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) designsystem.GallerySpaceComponent.colors.primary else designsystem.GallerySpaceComponent.colors.secondary,
//        animationSpec = spring(stiffness = Spring.StiffnessLow)
//    )
//
//    val thicknessCoefficient = animateFloatAsState(
//        targetValue = if (scaffoldState.bottomSheetState.targetValue == BottomSheetValue.Collapsed) 1f else 0.5f,
//        animationSpec = spring(stiffness = Spring.StiffnessLow)
//    )
//
//    val titleVisible = (listState.firstVisibleItemIndex == 0).not()
//
//    BoxWithConstraints(
//        modifier = Modifier
//            .background(background.value)
//            .fillMaxSize()
//    ) {
//
//        val status = 0.dp //WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
//        val space = 8.dp
//        val toolbar = 44.dp
//        val collapsedBottomSheetHeight = this.maxHeight - this.maxWidth - toolbar - space - status
//        val expandedBottomSheetHeight = this.maxHeight - (this.maxWidth / 2) - toolbar - status
//
//        Image(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(this.maxHeight - collapsedBottomSheetHeight)
//                .alpha(0.3f),
//            painter = painter,
//            contentScale = ContentScale.Crop,
//            contentDescription = null
//        )
//
//        BottomSheetScaffold(
//            scaffoldState = scaffoldState,
//            backgroundColor = Color.Transparent,
//            sheetBackgroundColor = designsystem.GallerySpaceComponent.colors.primary,
//            sheetPeekHeight = collapsedBottomSheetHeight,
//            sheetElevation = 0.dp,
//            content = {
//                Header(fraction = fraction.value,
//                    thicknessCoefficient = thicknessCoefficient.value,
//                    titleVisible = titleVisible,
//                    image = painter,
//                    title = title,
//                    back = { navController.popBackStack() })
//            },
//            sheetContent = {
//                PresentationDashboard(
//                    state = listState,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(height = expandedBottomSheetHeight),
//                    title = title,
//                    description = description,
//                    creator = creator,
//                    price = price,
//                    createdAt = createdAt,
//                    owners = owners
//                )
//            })
//    }
//}
//
//@ExperimentalComposeUiApi
//@ExperimentalAnimationApi
//@ExperimentalFoundationApi
//@Composable
//fun Header(
//    fraction: Float, thicknessCoefficient: Float, titleVisible: Boolean, image: Painter, title: String, back: () -> Unit
//) {
//
//    Column(
////        Modifier.statusBarsPadding() // TODO ??
//    ) {
//
//        Toolbar(back = back)
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(fraction = fraction)
//                    .aspectRatio(1f),
//                contentAlignment = Alignment.Center,
//            ) {
//
//                Image(
//                    modifier = Modifier
//                        .padding(vertical = 16.dp)
//                        .wrapContentSize()
//                        .rolling(
//                            sideColor1 = Color.LightGray,
//                            sideColor2 = Color.LightGray,
//                            thicknessCoefficient = thicknessCoefficient
//                        ),
//                    painter = image,
//                    contentDescription = null
//                )
//            }
//
//            AnimatedVisibility(visible = titleVisible,
//                enter = fadeIn() + expandHorizontally(expandFrom = Alignment.Start),
//                exit = shrinkHorizontally() + fadeOut(),
//                content = { H2Text(modifier = Modifier.padding(start = 16.dp), text = title, maxLines = 3) })
//        }
//    }
//}