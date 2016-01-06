package org.tendiwa.canvas.algorithms.geometry

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.derasterization.toRectangle
import org.tendiwa.plane.geometry.points.distanceTo
import org.tendiwa.plane.geometry.rays.Ray
import org.tendiwa.plane.geometry.rays.closestIntersection
import org.tendiwa.plane.geometry.rays.segment
import org.tendiwa.plane.geometry.rectangles.contains
import org.tendiwa.plane.grid.constructors.GridRectangle
import java.awt.Color


fun Canvas.drawRay(ray: Ray, color: Color) {
    GridRectangle(size)
        .toRectangle()
        .apply {
            if (contains(ray.start)) {
                draw(ray.start, color, 2.0)
            }
        }
        .let { ray.closestIntersection(it) }
        .apply {
            if (this != null) {
                draw(ray.segment(ray.start.distanceTo(this) + 1.0), color)
            }
        }
}

