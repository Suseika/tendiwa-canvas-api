package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.circles.Circle
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.segments.Segment
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

fun Polygon.draw(canvas: Canvas, color: Color) =
    canvas.drawPolygon(this, color)

fun SegmentGroup.draw(canvas: Canvas, color: Color) =
    canvas.drawSegmentGroup(this, color)

fun Point.draw(canvas: Canvas, color: Color, radius: Double) =
    canvas.drawPoint(this, color, radius)

fun ((Double) -> Double).segmentsForDrawing(domain: IntRange): List<Segment> =
    (domain.start until domain.endInclusive)
        .mapIndexed { index, x ->
            val x1d = x.toDouble()
            val x2d = x + 1.toDouble()
            Segment(
                Point(x1d, this(x1d)),
                Point(x2d, this(x2d))
            )
        }
