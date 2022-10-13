package org.funcionalidad;

import java.awt.*;

public class Ficha {
    int color;
    int POS_X, POS_Y;
    boolean Bdisponible;
    public Ficha(int color){
        this.color=color;
        this.Bdisponible = true;
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

    public boolean esVecino() {
        return false;
    }
    public boolean esLinea()
    {
        return false;
    }
    public boolean esEquipo()
    {
        return false;
    }
    public Ficha findVecinoTeam()
    {
        return new Ficha(1);
    }
}
