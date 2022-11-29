package refactorizado;


import java.awt.*;
import java.util.ArrayList;

public class Ficha {
    public FichaState state;
    public Point coordenada;
    public ArrayList<Point> vecinos;

    /**
     * Constructor que toma el valor de una coordenada para una ficha
     * Preconditions: coordenada != NULL
     * Postconditions: creación de una ficha vacía en la coordenada dada y creación de sus vecinos
     *                 como una lista
     * @param coordenada lugar asignado para una ficha
     */
    public Ficha(Point coordenada) {
        this.vecinos = new ArrayList<Point>();
        this.coordenada = coordenada;
        this.state = FichaState.EMPTY;
    }


    public void changeStateFicha(FichaState newState) {
        this.state = newState;
    }

    public boolean esLinea(Ficha finTri){
        double distancia = Math.sqrt(Math.pow((finTri.coordenada.x-this.coordenada.x),2)+Math.pow((finTri.coordenada.y-this.coordenada.y),2));
        return distancia % 1 == 0;
    }
    public boolean esEquipo(Ficha fActual) {

        if(fActual.state == this.state && fActual.state!= FichaState.EMPTY && fActual.state!= FichaState.DISABLE) return true;
        else return false;
    }
    public void setVecinos(Point vecino)
    {
        this.vecinos.add(vecino);
    }

}
