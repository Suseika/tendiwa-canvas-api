package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.geometry.points.radiusVector
import org.tendiwa.geometry.segments.Segment
import org.tendiwa.geometry.segments.vector
import org.tendiwa.geometry.vectors.*
import java.awt.Color

fun Canvas.drawArrow(segment: Segment, color: Color, arrowheadLength: Double = 1.0) {
    Arrow(segment, arrowheadLength / this.scale)
        .apply {
            this@drawArrow.draw(shaft, color)
            this@drawArrow.draw(rightHalfArrow, color)
            this@drawArrow.draw(leftHalfArrow, color)
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
                    .rotatedQuarterClockwise
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
                    .rotatedQuarterClockwise
                    .times(arrowheadLength / shaft.vector.magnitude)
            )
            .point
    )
}
