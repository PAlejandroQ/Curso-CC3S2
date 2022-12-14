package refactorizado;

import java.awt.*;
import java.util.ArrayList;

abstract public class Jugador {
    public FichaState color;
    private int FICHAS;
    public ArrayList<Point> fichasJugador;
    public Juego juegoEnlazado;
    protected boolean IS_FLYING = false;

    public enum State {
        SELECTING, MOVING
    }

    protected Jugador.State estado;

    /**
     * Constructor que toma el valor de un entero como indice y un Juego para asociar
     * Preconditions: 0 < indexColor < 3 && juegoEnlazado != NULL
     * Postconditions: creación de un jugador inicializando: las fichas en 9,
     *                 el color de fichas de acuerdo con el indexColor, un arrayList de sus fichas
     *
     * @param indexColor
     * @param juegoEnlazado
     */

    public Jugador(int indexColor, Juego juegoEnlazado) {
        this.juegoEnlazado = juegoEnlazado;
        this.FICHAS = Juego.NUM_FICHAS;
        this.fichasJugador = new ArrayList<Point>();
        this.color = (indexColor == 1)? FichaState.BLUE : FichaState.RED;
    }

    public int getNumFichas(){
        return this.FICHAS;
    }

    public int getNumFichasEnJuego(){
        return this.fichasJugador.size();
    }

    public void aumentarNumFichasEnJuego(Point nuevaFicha){
        this.fichasJugador.add(nuevaFicha);
    }

    public void reducirNumFichasEnJuego(Point fichaPerdida){
        this.fichasJugador.remove(fichaPerdida);
    }

    public void setMoving(){
        this.estado= Jugador.State.MOVING;
    }
    public void setSelecting(){
        this.estado= Jugador.State.SELECTING;
    }
    public void setFlying(){
        this.IS_FLYING = true;
    }

    public boolean isFlying(){ return this.IS_FLYING;}
    public Jugador.State getState(){
        return this.estado;
    }

    public void reducinNumFicha(){--this.FICHAS;}

    public FichaState getColor(){ return this.color;}

    abstract void eventClick(int row, int column);
}
