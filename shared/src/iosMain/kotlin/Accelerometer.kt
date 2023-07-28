import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import platform.CoreMotion.CMAcceleration
import platform.CoreMotion.CMMotionManager
import platform.Foundation.NSOperationQueue

actual class Accelerometer actual constructor(nativeContext: NativeContext) : IAccelerometer {

    private val motionManager: CMMotionManager = CMMotionManager()

    private val _accelerator: MutableStateFlow<Triple<Float, Float, Float>> = MutableStateFlow(Triple(0f, 0f, 0f))
    override val accelerator: StateFlow<Triple<Float, Float, Float>> = _accelerator.asStateFlow()

    init {
        if (motionManager.isAccelerometerAvailable()) {
            motionManager.startAccelerometerUpdatesToQueue(NSOperationQueue.mainQueue()) { data, _ ->
                (data?.acceleration as? CMAcceleration)?.let {
                    _accelerator.value = Triple(it.x.toFloat(), it.y.toFloat(), it.z.toFloat())
                }
            }
        }
    }
}