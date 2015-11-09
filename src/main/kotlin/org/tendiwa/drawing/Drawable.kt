package org.tendiwa.drawing

/**
 * Something that can be drawn in a [Canvas]. Drawable is essentially a
 * macros for calling primitive Canvas commands.
 */
interface Drawable {
    fun drawIn(canvas: Canvas)
}
