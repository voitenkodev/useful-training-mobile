import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.voitenko.usefultraining.SharedRes
import dev.icerock.moko.resources.compose.painterResource


/*
* Source png: https://www.pngegg.com/en/png-evdhq
* */
object Images {
    @Composable
    fun gym(): Painter {
        return painterResource(SharedRes.images.gym)
    }

    @Composable
    fun addTraining(): Painter {
        return painterResource(SharedRes.images.add_training_bg)
    }

    @Composable
    fun dumbbells(): Painter {
        return painterResource(SharedRes.images.dumbbells)
    }

    @Composable
    fun person1(): Painter {
        return painterResource(SharedRes.images.person_1)
    }

    @Composable
    fun person2(): Painter {
        return painterResource(SharedRes.images.person_2)
    }

    @Composable
    fun person3(): Painter {
        return painterResource(SharedRes.images.person_3)
    }

    @Composable
    fun person4(): Painter {
        return painterResource(SharedRes.images.person_4)
    }

    @Composable
    fun person5(): Painter {
        return painterResource(SharedRes.images.person_5)
    }
}