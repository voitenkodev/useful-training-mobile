import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.voitenko.usefultraining.SharedRes
import dev.icerock.moko.resources.compose.painterResource


/*
* Source png: https://www.pngegg.com/en/png-evdhq
* */
public object Images {
    @Composable
    public fun gym(): Painter {
        return painterResource(SharedRes.images.gym)
    }

    @Composable
    public fun addTraining(): Painter {
        return painterResource(SharedRes.images.add_training_bg)
    }

    @Composable
    public fun dumbbells(): Painter {
        return painterResource(SharedRes.images.dumbbells)
    }

    @Composable
    public fun person1(): Painter {
        return painterResource(SharedRes.images.person_1)
    }

    @Composable
    public fun person2(): Painter {
        return painterResource(SharedRes.images.person_2)
    }

    @Composable
    public fun person3(): Painter {
        return painterResource(SharedRes.images.person_3)
    }

    @Composable
    public fun person4(): Painter {
        return painterResource(SharedRes.images.person_4)
    }

    @Composable
    public fun person5(): Painter {
        return painterResource(SharedRes.images.person_5)
    }
}