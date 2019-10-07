package org.tendiwa.canvas.api

import java.awt.Color

fun HsbColor(
    h: Double,
    s: Double,
    b: Double
): Color =
    Color.getHSBColor(h.toFloat(), s.toFloat(), b.toFloat())

fun HsbColor(
    h: Float,
    s: Float,
    b: Float
): Color =
    Color.getHSBColor(h, s, b)
