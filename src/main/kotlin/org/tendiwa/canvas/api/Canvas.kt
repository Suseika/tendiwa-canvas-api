package org.tendiwa.canvas.api

import org.tendiwa.geometry.circles.Circle
import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.rectangles.Rectangle
import org.tendiwa.geometry.segments.Segment
import org.tendiwa.grid.dimensions.GridDimension
import org.tendiwa.grid.rectangles.GridRectangle
import java.awt.Color

/**
 * A place to draw things in.
 */
interface Canvas {
    val scale: Int

    val size: GridDimension

    val textLineHeight: Int

    fun draw(x: Int, y: Int, color: Color)

    fun draw(rectangle: Rectangle, color: Color)

    fun draw(rectangle: GridRectangle, color: Color)

    fun write(text: String, start: Point, color: Color)

    fun draw(segment: Segment, color: Color)

    fun draw(circle: Circle, color: Color)

    /**
     * Width of a text in pixels if it was to be drawn in this canvas.
     */
    fun textWidth(text: String): Int

    fun clear()

    fun fillBackground(color: Color)

    fun drawText(text: String, start: Point, color: Color, fontScale: Double = 1.0)
}
