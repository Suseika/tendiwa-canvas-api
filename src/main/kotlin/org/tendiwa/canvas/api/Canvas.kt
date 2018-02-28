package org.tendiwa.canvas.api

import org.tendiwa.plane.geometry.circles.Circle
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.grid.rectangles.GridRectangle
import java.awt.Color

/**
 * A place to draw things in.
 */
interface Canvas {
    val scale: Int

    val viewport: GridRectangle

    val textLineHeight: Int

    fun drawCircle(x: Int, y: Int, color: Color)

    fun drawRectangle(rectangle: Rectangle, color: Color)

    fun drawGridRectangle(rectangle: GridRectangle, color: Color)

    fun drawText(text: String, start: Point, color: Color)

    fun drawText(text: String, start: Point, color: Color, fontScale: Double = 1.0)

    fun drawSegment(segment: Segment, color: Color)

    fun drawCircle(circle: Circle, color: Color)

    /**
     * Width of a text in pixels if it was to be drawn in this canvas.
     */
    fun textWidth(text: String): Int

    fun clear()

    fun fillBackground(color: Color)

}

fun Circle.draw(canvas: Canvas, color: Color) =
    canvas.drawCircle(this, color)

fun Rectangle.draw(canvas: Canvas, color: Color) =
    canvas.drawRectangle(this, color)

fun GridRectangle.draw(canvas: Canvas, color: Color) =
    canvas.drawGridRectangle(this, color)

fun String.draw(canvas: Canvas, start: Point, color: Color, fontScale: Double = 1.0) =
    canvas.drawText(this, start, color, fontScale)

fun Segment.draw(canvas: Canvas, color: Color) =
    canvas.drawSegment(this, color)
