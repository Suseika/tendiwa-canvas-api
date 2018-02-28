package org.tendiwa.canvas.implementations

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.circles.Circle
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.grid.rectangles.GridRectangle
import java.awt.Color

/**
 * Canvas that does nothing.
 */
class NullCanvas() : Canvas {
    override val scale: Int
        get() = 1
    override val textLineHeight: Int
        get() = 1
    override val viewport: GridRectangle = GridRectangle(0, 0, 1, 1)

    override fun drawCircle(x: Int, y: Int, color: Color) {
    }

    override fun drawRectangle(rectangle: Rectangle, color: Color) {
    }

    override fun drawGridRectangle(rectangle: GridRectangle, color: Color) {
    }

    override fun drawText(text: String, start: Point, color: Color) {
    }

    override fun drawSegment(segment: Segment, color: Color) {
    }

    override fun drawCircle(circle: Circle, color: Color) {
    }

    override fun textWidth(text: String): Int =
        1

    override fun clear() {
    }

    override fun fillBackground(color: Color) {
    }

    override fun drawText(text: String, start: Point, color: Color, fontScale: Double) {
    }
}
