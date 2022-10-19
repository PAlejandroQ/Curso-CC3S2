package org.funcionalidad;

import java.awt.*;

public class Ficha {
    int color;
    Juego.Cell state;
    Point coordenada;
    Ficha[] vecinos;
    boolean Bdisponible;
    public Ficha(int color, Point coordenada){
        this.color=color;
        this.Bdisponible = true;
        this.vecinos = new Ficha[4];
        this.coordenada = coordenada;
        this.state = Juego.Cell.EMPTY;
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

    public boolean esLinea(Ficha finTri)
    {
        double distancia = Math.sqrt(Math.pow((finTri.coordenada.x-this.coordenada.x),2)+Math.pow((finTri.coordenada.y-this.coordenada.y),2));
        return distancia % 1 == 0;
    }
    public boolean esEquipo(Ficha fActual)
    {
        if(fActual.color == this.color) return true;
        else return false;
    }
//    public Ficha findVecinoTeam()
//    {
//        return new Ficha(1,new Point(1,1));
//    }
}
