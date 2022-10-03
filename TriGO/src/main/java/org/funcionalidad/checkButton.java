package org.funcionalidad;
import java.awt.Color;
public class checkButton {
    int color;
    boolean Bdisponible;
    checkButton()
    {
        color = 0;
        Bdisponible = true;
    }
    public void setColor(int i, Tablero tableroJuego)
    {
        this.color = tableroJuego.estadoPosicion(i);
    }
    public Color getColor()
    {
        if (this.color==1) { return Color.BLUE;}
        else if (this.color==2) {return Color.GREEN;}
        else { return Color.LIGHT_GRAY;}
    }
    public boolean cambiarDisponibilidad(int i, Tablero tableroJuego)
    {
        this.Bdisponible = !this.Bdisponible;
        return this.Bdisponible;
    }
}


