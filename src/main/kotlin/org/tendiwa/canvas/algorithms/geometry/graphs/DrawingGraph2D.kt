package org.tendiwa.canvas.algorithms.geometry.graphs

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.graphs.edges
import org.tendiwa.plane.geometry.graphs.Graph2D
import java.awt.Color

fun Canvas.draw(graph: Graph2D, color: Color) {
    graph.edges.forEach { draw(it, color) }
}
