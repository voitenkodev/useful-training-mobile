import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

actual class Accelerometer actual constructor(nativeContext: NativeContext) : IAccelerometer {

    private val sensorManager: SensorManager = nativeContext.context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    private val _accelerator: MutableStateFlow<Triple<Float, Float, Float>> = MutableStateFlow(Triple(0f, 0f, 0f))
    override val accelerator: StateFlow<Triple<Float, Float, Float>> = _accelerator.asStateFlow()

    private val sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        }

        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                if (it.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                    _accelerator.value = Triple(it.values[0], it.values[1], it.values[2])
                }
            }
        }
    }

    init {
        accelerometer?.let {
            sensorManager.registerListener(
                sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }
}