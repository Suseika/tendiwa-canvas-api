package org.tendiwa.canvas.api

import java.awt.Color;

val Color.inverse: Color
    get () = Color(this.rgb xor 0xFFFF)
