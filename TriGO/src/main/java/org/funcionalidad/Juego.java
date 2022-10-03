package org.funcionalidad;

public class Juego {
    static public final int numPiezasJugador = 9;
    boolean turno;
    protected Tablero tableroJuego;
    protected int faseJuego;
    public Juego()
    {
        turno = true;
        tableroJuego = new Tablero();
        faseJuego = 0;
    }
    public void cambioTurno(){this.turno = !this.turno;}
    //public void checkMill(){}

    public static void main(String[] args) {
        System.out.println("Hello worlddddd!");
    }
}
