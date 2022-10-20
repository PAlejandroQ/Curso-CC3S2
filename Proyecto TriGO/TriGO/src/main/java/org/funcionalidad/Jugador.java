package org.funcionalidad;

import java.awt.*;
import java.util.Stack;

import static org.funcionalidad.Juego.*;

public class Jugador {
    int color;
    public int FICHAS_LEFT;
    public int FICHAS_TABLERO;
    Stack<Ficha> fichas = new Stack<>();
    Ficha[] fichasEnJuego = {};

    public Jugador(int color)
    {
        this.color = color;
        this.FICHAS_LEFT = NUM_FICHAS;
        this.FICHAS_TABLERO = 0;
        for(int i = 0; i< FICHAS_LEFT; ++i)
        {
            fichas.add(i, new Ficha(color,new Point(1,1)));
        }
    }

    public int getNumFichas(){
        return FICHAS_LEFT;
    }

    public int getNumFichasEnJuego(){
        return FICHAS_TABLERO;
    }

    public void aumentarNumFichasEnJuego(){
        ++this.FICHAS_TABLERO;
    }

    public void reducirNumFichasEnJuego(){
        --this.FICHAS_TABLERO;
    }
}