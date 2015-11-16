package org.tendiwa.canvas.api

import java.awt.Color

val Color.hue: Float
    get() = hsb[0]

val Color.saturation: Float
    get() = hsb[1]

val Color.brightness: Float
    get() = hsb[2]

private val Color.hsb: FloatArray
    get() = Color.RGBtoHSB(red, green, blue, null)



