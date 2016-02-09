package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.geometry.points.radiusVector
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.vector
import org.tendiwa.plane.geometry.vectors.*
import java.awt.Color

fun Canvas.drawArrow(segment: Segment, color: Color, arrowheadLength: Double = 1.0) {
    Arrow(segment, arrowheadLength / this.scale)
        .apply {
            this@drawArrow.drawSegment(shaft, color)
            this@drawArrow.drawSegment(rightHalfArrow, color)
            this@drawArrow.drawSegment(leftHalfArrow, color)
        }
}

private class Arrow(val shaft: Segment, arrowheadLength: Double) {
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
