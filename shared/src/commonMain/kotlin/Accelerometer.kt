import kotlinx.coroutines.flow.StateFlow

expect class Accelerometer(nativeContext: NativeContext) : IAccelerometer

interface IAccelerometer {

    val accelerator: StateFlow<Triple<Float, Float, Float>>
}
