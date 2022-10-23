package org.funcionalidad;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

import static org.funcionalidad.Juego.*;

public class Jugador {
    int color;
//    public int FICHAS_LEFT;
    public int FICHAS_TABLERO;
    public ArrayList<Point> fichasJugador;

    public enum State{
        SELECTING, MOVING, FLYING;
    }

    protected State estado;
    //Stack<Ficha> fichas = new Stack<>();
    //Ficha[] fichasEnJuego = {};

    public Jugador(int color)
    {
        this.color = color;
//        this.FICHAS_LEFT = NUM_FICHAS;
        this.FICHAS_TABLERO = 9;
        this.fichasJugador = new ArrayList<Point>();

//        for(int i = 0; i< FICHAS_LEFT; ++i)
//        {
//            fichas.add(i, new Ficha(color,new Point(1,1)));
//        }
    }

    public int getNumFichas(){
        return this.FICHAS_TABLERO;
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
        this.estado=State.MOVING;
    }
    public void setSelecting(){
        this.estado=State.SELECTING;
    }
    public void setFlying(){
        this.estado= State.FLYING;
    }
    public State getState(){
        return this.estado;
    }
}