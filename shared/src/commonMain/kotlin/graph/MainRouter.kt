package graph

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import exerciseexample.ExerciseExampleComponent
import exerciseexample.ExerciseExampleController
import exerciseexample.ExerciseExampleGraph
import exerciseexamplebuilder.ExerciseExampleBuilderGraph
import io.github.xxfast.decompose.router.stack.RoutedContent
import io.github.xxfast.decompose.router.stack.Router
import io.github.xxfast.decompose.router.stack.rememberRouter
import kotlinx.serialization.Serializable
import searchexercise.SearchExerciseComponent
import searchexercise.SearchExerciseController
import searchexercise.SearchExerciseGraph
import trainingbuilder.TrainingGraph
import userequipments.UserEquipmentsGraph
import usermuscles.UserMusclesGraph
import weighthistory.WeightHistoryGraph

@Serializable
internal sealed class MainRouter {
    @Serializable
    data class Training(val id: String? = null) : MainRouter()

    @Serializable
    data class ExerciseExample(
        val id: String,
        val primaryAction: Pair<String, (id: String) -> Unit>?
    ) : MainRouter()

    @Serializable
    data class SearchExercise(
        val autoFocus: Boolean,
        val itemAction: Pair<String, (id: String) -> Unit>?
    ) : MainRouter()

    @Serializable
    data object WeightHistory : MainRouter()

    @Serializable
    data object UserMuscles : MainRouter()

    @Serializable
    data object UserEquipments : MainRouter()

    @Serializable
    data object ExerciseExampleBuilder : MainRouter()

    @Serializable
    data object BottomMenu : MainRouter()
}

@Composable
internal fun MainGraph(toAuthentication: () -> Unit) {

    val router: Router<MainRouter> = rememberRouter(MainRouter::class) {
        listOf(MainRouter.BottomMenu)
    }

    ExerciseExampleComponent {

        SearchExerciseComponent {

            RoutedContent(
                router = router,
                animation = stackAnimation(slide(orientation = Orientation.Vertical))
            ) { child ->
                when (child) {
                    is MainRouter.BottomMenu -> BottomMenuGraph(
                        toTrainingBuilder = { trainingId: String? ->
                            router.push(
                                MainRouter.Training(
                                    trainingId
                                )
                            )
                        },
                        toTrainingDetails = {},
                        toAuthentication = toAuthentication,
                        toExerciseExamples = {
                            router.push(
                                MainRouter.SearchExercise(
                                    itemAction = null,
                                    autoFocus = false
                                )
                            )
                        },
                        toWeightHistory = { router.push(MainRouter.WeightHistory) },
                        toMuscles = { router.push(MainRouter.UserMuscles) },
                        toEquipment = { router.push(MainRouter.UserEquipments) },
                        toExerciseExampleBuilder = { router.push(MainRouter.ExerciseExampleBuilder) }
                    )

                    is MainRouter.Training -> {
                        val exerciseSearchApi = SearchExerciseController.api
                        val exerciseDetailsApi = ExerciseExampleController.api

                        TrainingGraph(
                            close = router::pop,
                            searchExerciseExampleId = exerciseDetailsApi.exerciseExampleId
                                ?: exerciseSearchApi.exerciseExampleId,
                            toExerciseExamples = {
                                val action: Pair<String, (String) -> Unit> =
                                    "Select" to { id: String ->
                                        println("TrainingGraph -> toExerciseExamples -> itemClick(id = $id)")
                                        exerciseSearchApi.itemClick(id = id)
                                        router.pop()
                                    }
                                router.push(
                                    MainRouter.SearchExercise(
                                        itemAction = action,
                                        autoFocus = true
                                    )
                                )
                            },
                            toExerciseExampleDetails = { id, isSelectable ->
                                val action: Pair<String, (String) -> Unit>? =
                                    if (isSelectable) "Select" to { idFromAction: String ->
                                        exerciseDetailsApi.primaryActionClick(id = idFromAction)
                                        router.pop()
                                    } else null

                                router.push(
                                    MainRouter.ExerciseExample(
                                        id = id,
                                        primaryAction = action
                                    )
                                )
                            }
                        )

                        SideEffect {
                            exerciseSearchApi.release()
                            exerciseDetailsApi.release()
                        }
                    }

                    is MainRouter.WeightHistory -> WeightHistoryGraph(
                        close = router::pop
                    )

                    is MainRouter.UserMuscles -> UserMusclesGraph(
                        close = router::pop
                    )

                    is MainRouter.UserEquipments -> UserEquipmentsGraph(
                        close = router::pop
                    )

                    is MainRouter.ExerciseExampleBuilder -> ExerciseExampleBuilderGraph(
                        close = router::pop
                    )

                    is MainRouter.SearchExercise -> {
                        val api = ExerciseExampleController.api

                        SearchExerciseGraph(
                            autoFocus = child.autoFocus,
                            itemAction = child.itemAction,
                            close = router::pop,
                            toDetails = {
                                child.itemAction?.let { (parentActionText, parentActionLambda) ->
                                    val action = parentActionText to { id: String ->
                                        api.primaryActionClick(id = id)
                                        router.pop()
                                        parentActionLambda.invoke(id)
                                    }
                                    router.push(
                                        MainRouter.ExerciseExample(
                                            id = it,
                                            primaryAction = action
                                        )
                                    )
                                } ?: router.push(
                                    MainRouter.ExerciseExample(
                                        id = it,
                                        primaryAction = null
                                    )
                                )
                            }
                        )
                    }

                    is MainRouter.ExerciseExample -> ExerciseExampleGraph(
                        id = child.id,
                        primaryAction = child.primaryAction,
                        close = router::pop
                    )
                }
            }
        }
    }
}