package org.funcionalidad;

import java.awt.*;
import java.util.ArrayList;

public class Ficha {
    int color;
    Juego.Cell state;
    Point coordenada;
    ArrayList<Point> vecinos;
    public Ficha(int color, Point coordenada){
        this.color=color;
        this.vecinos = new ArrayList<Point>();
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
        else if (this.color==2) {return Color.RED;}
        else { return Color.LIGHT_GRAY;}
    }
    public void changeState(Juego.Cell newState)
    {
        this.state = newState;
    }

    public boolean esLinea(Ficha finTri)
    {
        double distancia = Math.sqrt(Math.pow((finTri.coordenada.x-this.coordenada.x),2)+Math.pow((finTri.coordenada.y-this.coordenada.y),2));
        return distancia % 1 == 0;
    }
    public boolean esEquipo(Ficha fActual)
    {

        if(fActual.state == this.state && fActual.state!= Juego.Cell.EMPTY && fActual.state!=Juego.Cell.DISABLE) return true;
        else return false;
    }
    public void setVecinos(Point vecino)
    {
        this.vecinos.add(vecino);
    }
//    public Ficha findVecinoTeam()
//    {
//        return new Ficha(1,new Point(1,1));
//    }
}
