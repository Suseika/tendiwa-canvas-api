package org.tendiwa.canvas.api

import org.tendiwa.grid.masks.FiniteGridMask
import org.tendiwa.grid.tiles.Tile
import java.awt.Color

fun Canvas.draw(mask: FiniteGridMask, color: Color) {
    mask.tiles.forEach { this.draw(it, color) }
}

fun Canvas.draw(tile: Tile, color: Color) {
    this.draw(tile.x, tile.y, color)
}
