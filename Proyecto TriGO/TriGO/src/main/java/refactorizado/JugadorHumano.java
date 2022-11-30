package refactorizado;


import java.awt.*;

public class JugadorHumano extends Jugador {
    public JugadorHumano(int color, Juego juegoEnlazado) {
        super(color, juegoEnlazado);

    }
    public void eventClick(int row, int column) {
        if(juegoEnlazado.getGameState()!= GameState.SELECT_CAPTURE_RED && juegoEnlazado.getGameState() != GameState.SELECT_CAPTURE_BLUE){
            juegoEnlazado.realizarMovimiento(row, column);
        }
        else if(juegoEnlazado.getGameState() == GameState.SELECT_CAPTURE_BLUE){
            juegoEnlazado.capturarPieza(juegoEnlazado.jugadores[0],new Point(row,column) );

        }
        else if(juegoEnlazado.getGameState() == GameState.SELECT_CAPTURE_RED) {
            juegoEnlazado.capturarPieza(juegoEnlazado.jugadores[1], new Point(row, column));

        }
        juegoEnlazado = juegoEnlazado.selfCast();
    }
}
