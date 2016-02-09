package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.canvas.api.inverse
import org.tendiwa.plane.geometry.points.Point
import java.awt.Color

fun Canvas.drawBillboard(
    point: Point,
    text: String,
    textColor: Color,
    markerColor: Color = textColor.inverse
) {
    val billboard = Billboard(point, text, this)
    drawSegment(billboard.post, markerColor)
    drawRectangle(billboard.box, markerColor)
    drawText(text, billboard.textStart, textColor, 1.0 / this.scale)
}
