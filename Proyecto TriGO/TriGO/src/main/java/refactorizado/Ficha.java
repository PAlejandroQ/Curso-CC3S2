package refactorizado;


import java.awt.*;
import java.util.ArrayList;

public class Ficha {
    int color;
    public FichaState state;
    public Point coordenada;
    public ArrayList<Point> vecinos;

    /**
     * Constructor that takes the x and y position for the
     * turtle
     * Preconditions: parameters x and y are coordinates from 0 to
     *    the width and height of the world.
     * Postconditions: the turtle is placed in (x,y) coordinates
     * @param x the x position to place the turtle
     * @param y the y position to place the turtle
     */

    public Ficha(int color, Point coordenada){
        this.color=color;
        this.vecinos = new ArrayList<Point>();
        this.coordenada = coordenada;
        this.state = FichaState.EMPTY;
    }


    public Color getColor()
    {
        if (this.color==1) { return Color.BLUE;}
        else if (this.color==2) {return Color.RED;}
        else { return Color.LIGHT_GRAY;}
    }
    public void changeStateFicha(FichaState newState)
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

        if(fActual.state == this.state && fActual.state!= FichaState.EMPTY && fActual.state!= FichaState.DISABLE) return true;
        else return false;
    }
    public void setVecinos(Point vecino)
    {
        this.vecinos.add(vecino);
    }

}
