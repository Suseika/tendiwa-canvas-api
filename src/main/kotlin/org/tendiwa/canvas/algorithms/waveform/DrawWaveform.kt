package org.tendiwa.canvas.algorithms.waveform

import org.tendiwa.canvas.api.Canvas
import org.tendiwa.canvas.api.rotateHue
import org.tendiwa.derasterization.toRectangle
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.grid.rectangles.GridRectangle
import org.tendiwa.plane.waveform.Waveform2D
import java.awt.Color

fun Canvas.draw(
    waveform: Waveform2D,
    source: Rectangle = viewport.toRectangle(),
    destination: GridRectangle = viewport,
    lowColor: Color,
    highColor: Color = lowColor.rotateHue(.5)
) {
    val lowRgb: FloatArray = FloatArray(4)
    lowColor.getRGBComponents(lowRgb)
    val highRgb: FloatArray = FloatArray(4)
    highColor.getRGBComponents(highRgb)
    val dRgb = FloatArray(4) { index -> (highRgb[index] - lowRgb[index]) }

    fun sampleToColor(s: Int): Color {
        val sample = s.coerceIn(waveform.min, waveform.max)
        val amount =
            if (waveform.max == waveform.min) {
                0.0
            } else {
                (sample - waveform.min).toDouble() / (waveform.max - waveform.min).toDouble()
            }
        return Color(
            lowRgb[0] + dRgb[0] * amount.toFloat(),
            lowRgb[1] + dRgb[1] * amount.toFloat(),
            lowRgb[2] + dRgb[2] * amount.toFloat()
        )
    }

    destination.forEachTile { x, y ->
        val sample = waveform.at(
            source.x + (x - destination.width) % source.width,
            source.y + (y - destination.height) % source.height
        )
        drawPixel(x, y, sampleToColor(sample))
    }
}