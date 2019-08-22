package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.circles.Circle
import org.tendiwa.plane.geometry.lines.Line
import org.tendiwa.plane.geometry.lines.yAt
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.segmentTo
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
    drawPixel(Circle(point, radius), color)
}

fun Polygon.draw(canvas: Canvas, color: Color) =
    canvas.drawPolygon(this, color)

fun SegmentGroup.draw(canvas: Canvas, color: Color) =
    canvas.drawSegmentGroup(this, color)

fun Point.draw(canvas: Canvas, color: Color, radius: Double) =
    canvas.drawPoint(this, color, radius)

fun Line.draw(canvas: Canvas, color: Color) {
    Point(
        0.0,
        this.yAt(0.0)
    )
        .segmentTo(
            Point(
                canvas.viewport.width.toDouble(),
                this.yAt(canvas.viewport.width.toDouble())
            )
        )
        .draw(canvas, color)
}
