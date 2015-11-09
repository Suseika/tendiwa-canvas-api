package org.tendiwa.drawing

import org.tendiwa.geometry.continuum.circles.Circle
import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.rectangles.Rectangle
import org.tendiwa.geometry.continuum.segments.Segment
import org.tendiwa.geometry.grid.GridDimension
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile
import java.awt.Color

/**
 * A place to draw things in.
 */
interface Canvas {
    val scale: Int

    val size: GridDimension

    val textLineHeight: Int

    fun draw(drawable: Drawable) = drawable.drawIn(this)

    fun drawAll(drawables: Collection<Drawable>) {
        drawables.forEach { it.drawIn(this@Canvas) }
    }

    fun draw(x: Int, y: Int, color: Color)

    fun draw(tile: Tile, color: Color)

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
}
