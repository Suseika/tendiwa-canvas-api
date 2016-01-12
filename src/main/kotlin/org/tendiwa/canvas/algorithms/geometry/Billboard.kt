package org.tendiwa.canvas.algorithms.geometry;

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.dimensions.by
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.move
import org.tendiwa.plane.geometry.points.spanVerticalSegment
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.rectangles.move
import org.tendiwa.plane.geometry.rectangles.start
import org.tendiwa.plane.geometry.segments.Segment

internal class Billboard(
    point: Point,
    text: String,
    canvas: Canvas,
    pixelPostHeight: Double = 10.0,
    pixelPadding: Double = 2.0
) {
    val box: Rectangle
    val post: Segment
    val textStart: Point
    val padding: Double = pixelPadding / canvas.scale

    init {
        val rescaledPostHeight = pixelPostHeight / canvas.scale
        val textWidth: Double =
            (canvas.textWidth(text).toDouble()) / canvas.scale
        val lineHeight: Double =
            (canvas.textLineHeight.toDouble()) / canvas.scale
        post = point.spanVerticalSegment(rescaledPostHeight)
        val boxHeight: Double = lineHeight + padding * 2
        val boxWidth: Double = textWidth + padding * 2
        box = Rectangle(post.end, boxWidth by boxHeight)
            .move(-boxWidth / 2, 0.0)
        textStart = box.start.move(padding, padding)
    }
}
