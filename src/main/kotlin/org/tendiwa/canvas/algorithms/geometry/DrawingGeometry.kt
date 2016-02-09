package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.circles.Circle
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.shapes.SegmentGroup
import java.awt.Color

fun Canvas.drawPolygon(polygon: Polygon, color: Color) {
    polygon.segments.forEach {
        this.drawSegment(it, color)
    }
}

fun Canvas.drawSegmentGroup(segmentGroup: SegmentGroup, color: Color) {
    segmentGroup.segments.forEach { drawSegment(it, color) }
}

fun Canvas.drawPoint(point: Point, color: Color, radius: Double) {
    drawCircle(Circle(point, radius), color)
}
