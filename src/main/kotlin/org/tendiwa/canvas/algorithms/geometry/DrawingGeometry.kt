package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.geometry.polygons.Polygon
import java.awt.Color;

fun Canvas.draw(polygon: Polygon, color: Color) {
    polygon.segments.forEach {
        this.draw(it, color)
    }
}
