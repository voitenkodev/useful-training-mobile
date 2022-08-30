//package com.voitenko.dev.designsystem.modifiers
//
//import android.content.Context
//import android.content.Context.SENSOR_SERVICE
//import android.hardware.Sensor
//import android.hardware.SensorEvent
//import android.hardware.SensorEventListener
//import android.hardware.SensorManager
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.absoluteOffset
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.composed
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.platform.LocalLifecycleOwner
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.round
//import androidx.lifecycle.DefaultLifecycleObserver
//import androidx.lifecycle.LifecycleOwner
//
//@ExperimentalFoundationApi
//@ExperimentalAnimationApi
//@ExperimentalComposeUiApi
//fun Modifier.accelerate(
//    padding: Dp
//): Modifier = composed {
//
//    val paddingPx = with(LocalDensity.current) { padding.toPx() }
//    val context = LocalContext.current
//    val lifecycle = LocalLifecycleOwner.current
//    val offset = remember { mutableStateOf(Offset.Zero) }
//
//    remember {
//        ViewMotionHelper(
//            context = context,
//            lifecycleOwner = lifecycle,
//            coefficient = paddingPx,
//            block = { x, y -> offset.value = Offset(x, y) }
//        )
//    }
//
//    Modifier.absoluteOffset(offset = { offset.value.round() })
//}
//
//private class ViewMotionHelper(
//    context: Context,
//    lifecycleOwner: LifecycleOwner,
//    private val coefficient: Float = 1f,
//    private val block: (Float, Float) -> Unit
//) : SensorEventListener {
//
//    private val sensorManager: SensorManager? =
//        context.getSystemService(SENSOR_SERVICE) as? SensorManager
//
//    init {
//        lifecycleOwner.lifecycle.addObserver(SensorLifecycleObserver())
//    }
//
//    @Volatile
//    private var initialized = false
//    private var initialValues = FloatArray(MATRIX_SIZE)
//    private val angleChange = FloatArray(MATRIX_SIZE)
//    private val rotationMatrix = FloatArray(MATRIX_SIZE)
//    private val truncatedRotationVector = FloatArray(ROTATION_VECTOR_SIZE)
//
//    override fun onSensorChanged(event: SensorEvent?) {
//        if (event == null) return
//        val rotationVector = getRotationVectorFromSensorEvent(event)
//        if (!initialized) {
//            initialized = true
//            SensorManager.getRotationMatrixFromVector(initialValues, rotationVector)
//            return
//        }
//
//        SensorManager.getRotationMatrixFromVector(rotationMatrix, rotationVector)
//        SensorManager.getAngleChange(angleChange, rotationMatrix, initialValues)
//        angleChange.forEachIndexed { index, value -> angleChange[index] = radianToFraction(value) }
//        animate()
//    }
//
//    private fun radianToFraction(value: Float) = (value / Math.PI).coerceIn(-1.0, 1.0).toFloat()
//
//    private fun animate() {
//        val xTranslation = -angleChange[2] * coefficient
//        val yTranslation = angleChange[1] * coefficient
//        block.invoke(xTranslation, yTranslation)
//    }
//
//    override fun onAccuracyChanged(sensor: Sensor, p1: Int) {}
//
//    private fun getRotationVectorFromSensorEvent(event: SensorEvent): FloatArray {
//        return if (event.values.size > ROTATION_VECTOR_SIZE) {
//            System.arraycopy(event.values, 0, truncatedRotationVector, 0, ROTATION_VECTOR_SIZE)
//            truncatedRotationVector
//        } else event.values
//    }
//
//    private fun registerSensorListener() {
//        if (sensorManager == null) return
//        sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)?.also { sensor ->
//            sensorManager.registerListener(this, sensor, DEFAULT_SAMPLING_PERIOD)
//        }
//    }
//
//    private fun unregisterSensorListener() {
//        sensorManager?.unregisterListener(this)
//        initialized = false
//    }
//
//    private inner class SensorLifecycleObserver : DefaultLifecycleObserver {
//        override fun onResume(owner: LifecycleOwner) {
//            registerSensorListener()
//            super.onResume(owner)
//        }
//
//        override fun onPause(owner: LifecycleOwner) {
//            super.onPause(owner)
//            unregisterSensorListener()
//        }
//    }
//
//    companion object {
//        private const val MATRIX_SIZE = 16
//        private const val ROTATION_VECTOR_SIZE = 4
//        private const val DEFAULT_SAMPLING_PERIOD = 100000
//    }
//}