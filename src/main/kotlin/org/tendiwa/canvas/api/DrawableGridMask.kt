package org.tendiwa.canvas.api

import org.tendiwa.plane.grid.masks.FiniteGridMask
import org.tendiwa.plane.grid.tiles.Tile
import java.awt.Color

fun Canvas.draw(mask: FiniteGridMask, color: Color) {
    mask.tiles.forEach { this.draw(it, color) }
}

fun Canvas.draw(tile: Tile, color: Color) {
    this.draw(tile.x, tile.y, color)
}
