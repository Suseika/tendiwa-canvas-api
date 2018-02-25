package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.points.radiusVector
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.vector
import org.tendiwa.plane.geometry.vectors.magnitude
import org.tendiwa.plane.geometry.vectors.plus
import org.tendiwa.plane.geometry.vectors.point
import org.tendiwa.plane.geometry.vectors.rotatedQuarterCCW
import org.tendiwa.plane.geometry.vectors.times
import java.awt.Color

fun Canvas.drawArrow(arrow: Arrow, color: Color) {
    arrow
        .apply {
            this@drawArrow.drawSegment(shaft, color)
            this@drawArrow.drawSegment(rightHalfArrow, color)
            this@drawArrow.drawSegment(leftHalfArrow, color)
        }
}

class Arrow(val shaft: Segment, arrowheadLength: Double = 1.0) {
    val rightHalfArrow = Segment(
        shaft.end,
        shaft.end.radiusVector
            .plus(
                shaft.vector
                    .times((-arrowheadLength / shaft.vector.magnitude))
            )
            .plus(
                shaft.vector
                    .rotatedQuarterCCW
                    .times((-arrowheadLength / shaft.vector.magnitude))
            )
            .point
    )

    val leftHalfArrow = Segment(
        shaft.end,
        shaft.end.radiusVector
            .plus(
                shaft.vector
                    .times(-arrowheadLength / shaft.vector.magnitude)
            )
            .plus(
                shaft.vector
                    .rotatedQuarterCCW
                    .times(arrowheadLength / shaft.vector.magnitude)
            )
            .point
    )
}

fun Arrow.draw(canvas: Canvas, color: Color) =
    canvas.drawArrow(this, color)
