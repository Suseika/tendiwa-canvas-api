package org.tendiwa.canvas.algorithms.geometry;

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.geometry.constructors.spanVerticalSegment
import org.tendiwa.geometry.dimensions.by
import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.points.move
import org.tendiwa.geometry.rectangles.Rectangle
import org.tendiwa.geometry.rectangles.move
import org.tendiwa.geometry.rectangles.start
import org.tendiwa.geometry.segments.Segment

internal class Billboard(
    point: Point,
    text: String,
    canvas: Canvas,
    postHeight: Double = 10.0,
    padding: Double = 2.0
) {
    val box: Rectangle
    val post: Segment
    val textStart: Point

    init {
        val rescaledPostHeight = postHeight / canvas.scale
        val textWidth = (canvas.textWidth(text).toDouble()) / canvas.scale
        val lineHeight = (canvas.textLineHeight.toDouble()) / canvas.scale
        val rescaledPadding = padding / canvas.scale
        post = point.spanVerticalSegment(rescaledPostHeight)
        val boxHeight = lineHeight + rescaledPadding * 2
        val boxWidth = textWidth + rescaledPadding * 2
        box = Rectangle(post.end, boxWidth by boxHeight)
            .move(boxWidth / 2, boxHeight)
        textStart = box.start.move(rescaledPadding, boxHeight - rescaledPadding)
    }
}
