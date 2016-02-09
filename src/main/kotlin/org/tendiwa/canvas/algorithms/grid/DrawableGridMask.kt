package org.tendiwa.canvas.algorithms.grid

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.plane.grid.masks.FiniteGridMask
import org.tendiwa.plane.grid.tiles.Tile
import java.awt.Color

fun Canvas.drawGridMask(mask: FiniteGridMask, color: Color) {
    mask.tiles.forEach { this.drawTile(it, color) }
}

fun Canvas.drawTile(tile: Tile, color: Color) {
    this.drawCircle(tile.x, tile.y, color)
}
