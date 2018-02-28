package org.tendiwa.canvas.algorithms.geometry
import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.circles.Circle
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.toSegments
import org.tendiwa.plane.geometry.shapes.SegmentGroup
import org.tendiwa.plane.grid.rectangles.maxX
import org.tendiwa.plane.grid.rectangles.maxY
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

class FunctionGraph<D>(
    val function: (Double) -> Double,
    val domain: ClosedRange<D>,
    private val step: Double = 1.0
) where D : Comparable<D>,
        D : Number {

    val segments: List<Segment>
        get() =
            function.toSegments(domain, step)

    fun draw(canvas: Canvas) {
        segments.forEach {
            it.draw(canvas, Color.red)
        }
        listOf(
            Segment(
                Point(0.0, 0.0),
                Point(0.0, canvas.viewport.y.toDouble())
            ),
            Segment(
                Point(0.0, 0.0),
                Point(canvas.viewport.x.toDouble(), 0.0)
            ),
            Segment(
                Point(0.0, 0.0),
                Point(canvas.viewport.maxX.toDouble(), 0.0)
            ),
            Segment(
                Point(0.0, 0.0),
                Point(0.0, canvas.viewport.maxY.toDouble())
            )
        )
            .forEach {
                it.draw(canvas, Color.blue)
            }

    }
}

