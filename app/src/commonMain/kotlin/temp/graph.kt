package temp//package com.voitenko.dev.galleryspace
//
//import androidx.compose.animation.AnimatedContentScope
//import androidx.compose.animation.AnimatedVisibilityScope
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.navigation.*
//import com.google.accompanist.navigation.animation.AnimatedNavHost
//import com.google.accompanist.navigation.animation.composable
//import com.voitenko.dev.galleryspace.gallery.GalleryScreen
//import com.voitenko.dev.galleryspace.newart.NewArtScreen
//import screens.PresentationScreen
//
//@ExperimentalComposeUiApi
//@ExperimentalMaterialApi
//@ExperimentalAnimationApi
//@ExperimentalFoundationApi
//@Composable
//fun NavigationComponent(navController: NavHostController) {
//    AnimatedNavHost(
//        navController = navController,
//        startDestination = Routes.Gallery.route
//    ) {
//
//        screen(
//            route = Routes.NewArt.route,
//            content = { NewArtScreen(navController = navController) }
//        )
//
//        screen(
//            route = Routes.Gallery.route,
//            content = { GalleryScreen(navController = navController) }
//        )
//
//        screen(
//            route = "${Routes.Presentation.route}/{artId}",
//            arguments = listOf(navArgument("artId") { type = NavType.StringType }),
//            content = {
//                it.arguments?.getString("artId")?.let { artId ->
//                    PresentationScreen(navController = navController, artId = artId)
//                }
//            }
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.screen(
//    route: String,
//    arguments: List<NamedNavArgument> = emptyList(),
//    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
//) = composable(
//    route = route,
//    arguments = arguments,
//    enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(400)) },
//    exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(400)) },
//    popEnterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(400)) },
//    popExitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(400)) },
//    content = content
//)
//
//sealed class Routes(val route: String) {
//    object Gallery : Routes("gallery_screen")
//    object Presentation : Routes("presentation_screen")
//    object NewArt : Routes("newart_screen")
//}