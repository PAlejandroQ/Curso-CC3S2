package refactorizado;


import java.awt.*;

public class JugadorHumano extends Jugador{
    public JugadorHumano(int color, Juego juegoEnlazado){
        super(color, juegoEnlazado);

    }
    public void eventClick(int row, int column)
    {
        juegoEnlazado.realizarMovimiento(row, column);
    }
}
