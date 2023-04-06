package com.triankyy.jetgrocery.ui.theme

import android.graphics.Color.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val AppGreen = Color(0xFFdbeaac)
val AppGreenAccent = Color(0xFFEBF3D0)
val AppBlueDark = Color(0xFF202E55)
val AppRedAccent = Color(0xfffcdcdb)
val AppBlueAccent = Color(0xffd6e7fc)

fun Color.lighten(factor: Float): Color {
    // Convert the color to an ARGB color integer
    val argb = this.toArgb()

    // Convert the ARGB color to HSV color
    val hsv = FloatArray(3)
    RGBToHSV(red(argb), green(argb), blue(argb), hsv)

    // Increase the value by the specified factor
    hsv[2] *= (1.0f + factor)

    // Clamp the value to the maximum of 1.0
    hsv[2] = hsv[2].coerceAtMost(1.0f)

    // Convert the HSV color back to ARGB color
    val argbNew = HSVToColor(hsv)

    // Convert the ARGB color to Compose Color instance
    return Color(argbNew)
}

fun Color.darken(factor: Float): Color {
    // Convert the color to an ARGB color integer
    val argb = this.toArgb()

    // Convert the ARGB color to HSV color
    val hsv = FloatArray(3)
    RGBToHSV(red(argb), green(argb), blue(argb), hsv)

    // Decrease the value by the specified factor
    hsv[2] *= (1.0f - factor)

    // Clamp the value to the minimum of 0.0
    hsv[2] = hsv[2].coerceAtLeast(0.0f)

    // Convert the HSV color back to ARGB color
    val argbNew = HSVToColor(hsv)

    // Convert the ARGB color to Compose Color instance
    return Color(argbNew)
}