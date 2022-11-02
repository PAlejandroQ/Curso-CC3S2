package org.funcionalidad;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

import static org.funcionalidad.Juego.*;

public class Jugador {
    int color;
//    public int FICHAS_LEFT;
    public int FICHAS;
    public ArrayList<Point> fichasJugador;

    public enum State{
        SELECTING, MOVING, FLYING;
    }
    public Cell col;

    protected State estado;
    //Stack<Ficha> fichas = new Stack<>();
    //Ficha[] fichasEnJuego = {};

    public Jugador(int color)
    {
        this.color = color;
//        this.FICHAS_LEFT = NUM_FICHAS;
        this.FICHAS = 9;
        this.fichasJugador = new ArrayList<Point>();
        this.col = (color ==1)? Cell.BLUE : Cell.RED;
//        for(int i = 0; i< FICHAS_LEFT; ++i)
//        {
//            fichas.add(i, new Ficha(color,new Point(1,1)));
//        }
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

    public void reducinNumFicha(){--this.FICHAS;}

    public Cell getColor(){ return this.col;}
}