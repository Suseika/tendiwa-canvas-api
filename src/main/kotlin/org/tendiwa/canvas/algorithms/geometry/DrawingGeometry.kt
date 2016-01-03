package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.circles.Circle
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.shapes.SegmentGroup
import java.awt.Color

fun Canvas.draw(polygon: Polygon, color: Color) {
    polygon.segments.forEach {
        this.draw(it, color)
    }
}

fun Canvas.draw(segmentGroup: SegmentGroup, color: Color) {
    segmentGroup.segments.forEach { draw(it, color) }
}

fun Canvas.draw(point: Point, color: Color, radius: Double) {
    draw(Circle(point, radius), color)
}
