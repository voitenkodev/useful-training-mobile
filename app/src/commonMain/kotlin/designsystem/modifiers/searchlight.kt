//package com.voitenko.dev.designsystem.modifiers
//
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.DrawModifier
//import androidx.compose.ui.geometry.Rect
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Path
//import androidx.compose.ui.graphics.drawscope.ContentDrawScope
//
//fun Modifier.searchlight() = this.then(object : DrawModifier {
//
//    override fun ContentDrawScope.draw() {
//        drawContent()
//        val path = Path().apply {
//            moveTo(size.width / 2, 0f)
//            lineTo(0f, size.height / 3 * 2)
//            arcTo(
//                rect = Rect(0f, size.height / 3 * 2, size.width, size.height),
//                startAngleDegrees = 180f,
//                sweepAngleDegrees = -180f,
//                forceMoveTo = true
//            )
//            lineTo(size.width / 2, 0f)
//        }
//        drawPath(
//            path,
//            Brush.verticalGradient(
//                0f to Color.White,
//                0.5f to Color.White.copy(alpha = 0.2f)
//            )
//        )
//    }
//})