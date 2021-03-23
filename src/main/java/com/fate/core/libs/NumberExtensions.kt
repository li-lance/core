package com.fate.core.libs

/**
 * Author：lance.li on 3/22/21 18:04
 * email：foryun@live.com
 */
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import kotlin.math.roundToInt


val Int.isEven: Boolean
  get() = ((this and 1) == 0)

val Int.isOdd: Boolean
  get() = !isEven

val Long.isEven: Boolean
  get() = ((this and 1L) == 0L)

val Long.isOdd: Boolean
  get() = !isEven


fun Int.dpToPx(context: Context): Int {
  return toFloat().dpToPx(context).roundToInt()
}


fun Float.dpToPx(context: Context): Float {
  return (this * context.displayMetrics.density)
}


fun Int.spToPx(context: Context): Int {
  return toFloat().spToPx(context).roundToInt()
}


fun Float.spToPx(context: Context): Float {
  return (this * context.displayMetrics.scaledDensity)
}


fun Int.pxToDp(context: Context): Int {
  return toFloat().pxToDp(context).roundToInt()
}


fun Float.pxToDp(context: Context): Float {
  return (this / context.displayMetrics.density)
}


fun Int.pxToSp(context: Context): Int {
  return toFloat().pxToSp(context).roundToInt()
}


fun Float.pxToSp(context: Context): Float {
  return (this / context.displayMetrics.scaledDensity)
}


fun Int.containsBits(bits: Int): Boolean {
  return ((this and bits) == bits)
}


/**
 * Adjusts value of the alpha channel of the color.
 *
 * @param alpha The alpha to set. Accepts values in a range from 0.0 (min)
 * to 1.0 (max).
 *
 * @return The color with adjusted alpha
 */
fun @receiver:ColorInt Int.adjustAlpha(@FloatRange(from = 0.0, to = 1.0) alpha: Float): Int {
  val alphaChannel = (255 * alpha).toInt()
  val redChannel = Color.red(this)
  val greenChannel = Color.green(this)
  val blueChannel = Color.blue(this)

  return Color.argb(alphaChannel, redChannel, greenChannel, blueChannel)
}


fun @receiver:ColorInt Int.withHalfAlpha(): Int {
  return adjustAlpha(alpha = 0.5f)
}


fun @receiver:ColorInt Int.toColorStateList(): ColorStateList {
  return ColorStateList.valueOf(this)
}