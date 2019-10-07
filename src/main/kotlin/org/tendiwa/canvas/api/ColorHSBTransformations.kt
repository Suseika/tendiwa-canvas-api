package org.tendiwa.canvas.api

import java.awt.Color

val Color.hue: Float
    get() = hsb[0]

val Color.saturation: Float
    get() = hsb[1]

val Color.brightness: Float
    get() = hsb[2]

 val Color.hsb: FloatArray
    get() = Color.RGBtoHSB(red, green, blue, null)

fun Color.rotateHue(amount: Double): Color {
    val hsb = this.hsb
    hsb[0]+= amount.toFloat()
    hsb[0] %= 1.0f
    return Color.getHSBColor(hsb[0], hsb[1], hsb[2])
}


