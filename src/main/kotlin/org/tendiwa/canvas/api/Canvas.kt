package org.tendiwa.canvas.api

import org.tendiwa.plane.geometry.circles.Circle
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.grid.dimensions.GridDimension
import org.tendiwa.plane.grid.rectangles.GridRectangle
import java.awt.Color

/**
 * A place to draw things in.
 */
interface Canvas {
    val scale: Int

    val size: GridDimension

    val textLineHeight: Int

    fun drawCircle(x: Int, y: Int, color: Color)

    fun drawRectangle(rectangle: Rectangle, color: Color)

    fun drawGridRectangle(rectangle: GridRectangle, color: Color)

    fun drawText(text: String, start: Point, color: Color)

    fun drawSegment(segment: Segment, color: Color)

    fun drawCircle(circle: Circle, color: Color)

    /**
     * Width of a text in pixels if it was to be drawn in this canvas.
     */
    fun textWidth(text: String): Int

    fun clear()

    fun fillBackground(color: Color)

    fun drawText(text: String, start: Point, color: Color, fontScale: Double = 1.0)
}
