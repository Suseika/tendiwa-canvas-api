package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.derasterization.toRectangle
import org.tendiwa.plane.geometry.points.distanceTo
import org.tendiwa.plane.geometry.rays.Ray
import org.tendiwa.plane.geometry.rays.closestIntersection
import org.tendiwa.plane.geometry.rays.segment
import org.tendiwa.plane.geometry.rectangles.contains
import java.awt.Color


fun Canvas.drawRay(ray: Ray, color: Color) {
    viewport
        .toRectangle()
        .apply {
            if (contains(ray.start)) {
                drawPoint(ray.start, color, 2.0)
            }
        }
        .let { ray.closestIntersection(it) }
        .apply {
            if (this != null) {
                drawSegment(ray.segment(ray.start.distanceTo(this) + 1.0), color)
            }
        }
}

fun Ray.draw(canvas: Canvas, color: Color) =
    canvas.drawRay(this, color)
