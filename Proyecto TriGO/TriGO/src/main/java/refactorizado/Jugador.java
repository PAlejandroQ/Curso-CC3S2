package refactorizado;

import org.funcionalidad.Juego;

import java.awt.*;
import java.util.ArrayList;

abstract public class Jugador {
    int color;
    //    public int FICHAS_LEFT;
    private int FICHAS;
    public ArrayList<Point> fichasJugador;

    private boolean IS_FLYING = false;

    public enum State{
        SELECTING, MOVING;
    }
    public Juego.Cell col;

    protected org.funcionalidad.Jugador.State estado;

    public Jugador(int color)
    {
        this.color = color;
//        this.FICHAS_LEFT = NUM_FICHAS;
        this.FICHAS = 9;
        this.fichasJugador = new ArrayList<Point>();
        this.col = (color ==1)? Juego.Cell.BLUE : Juego.Cell.RED;
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
        this.estado= org.funcionalidad.Jugador.State.MOVING;
    }
    public void setSelecting(){
        this.estado= org.funcionalidad.Jugador.State.SELECTING;
    }
    public void setFlying(){
        this.IS_FLYING = true;
    }

    public boolean isFlying(){ return this.IS_FLYING;}
    public org.funcionalidad.Jugador.State getState(){
        return this.estado;
    }

    public void reducinNumFicha(){--this.FICHAS;}

    public Juego.Cell getColor(){ return this.col;}
}
