package temp.gallery//package com.voitenko.dev.galleryspace.gallery
//
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Modifier
//import androidx.core.net.toUri
//import androidx.navigation.NavController
//import com.voitenko.dev.designsystem.components.PresentationItem
//import com.voitenko.dev.designsystem.components.Toolbar
//import com.voitenko.dev.galleryspace.Routes
//import org.koin.androidx.compose.koinViewModel
//
//@ExperimentalFoundationApi
//@ExperimentalAnimationApi
//@Composable
//fun GalleryScreen(
//    navController: NavController,
//    viewModel: GalleryViewModel = koinViewModel()
//) {
//
//    val arts = viewModel.listOfArts.collectAsState(emptyList())
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
////            .statusBarsPadding()
//    ) {
//        stickyHeader {
//            Toolbar(
//                add = { navController.navigate(Routes.NewArt.route) }
//            )
//        }
//
//        itemsIndexed(arts.value) { index, item ->
//            PresentationItem(
//                uri = item.url.toUri(),
//                title = item.title,
//                description = item.description,
//                creator = item.proprietors.firstOrNull() ?: "",
//                more = {
//                    navController.navigate("${Routes.Presentation.route}/${item.art_id}")
//                }
//            )
//        }
//    }
//}
