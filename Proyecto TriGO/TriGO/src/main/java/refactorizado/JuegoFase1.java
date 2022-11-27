package refactorizado;

import java.awt.*;
import java.util.ArrayList;

public class JuegoFase1 extends  Juego{
    public JuegoFase1(int totalRows, int totalColumns, ArrayList<Jugador> jugadoresList) {
        this.TOTALCOLUMNS = totalColumns;
        this.TOTALROWS = totalRows;
        this.piezasTablero = new Ficha[TOTALROWS][TOTALCOLUMNS];
        lastMill = new ArrayList<>();
        jugadores = jugadoresList;
//        initGame();

    }
    public void desplegarFicha(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS && piezasTablero[row][column].state == FichaState.EMPTY) {
            piezasTablero[row][column].state = (turn == 'X') ? FichaState.BLUE : FichaState.RED;
            this.piezasTablero[row][column].state = (turn == 'X') ? FichaState.BLUE : FichaState.RED;
            this.getPlayerTurn().aumentarNumFichasEnJuego(new Point(row,column));
            this.getPlayerTurn().reducinNumFicha();
            this.lastPoint = this.piezasTablero[row][column].coordenada;
            updateGameState(row, column);

//            if(!this.checkStillMil(this.lastMill)) this.lastMill.clear();
            if(currentGameState!= GameState.SELECT_CAPTURE_RED && currentGameState!= GameState.SELECT_CAPTURE_BLUE){
                turn = (turn == 'X') ? 'O' : 'X';
            }
        }

    }


    public void updateGameState(int row, int column){
        if (this.getGameState() == GameState.DEPLOY) {
            this.desplegarFicha(row, column);
        }
//        else if(this.getGameState()== GameState.MOVING){
//            this.moverFicha(row, column);
//        }
        else if(this.getGameState()== GameState.SELECT_CAPTURE_RED){
            this.capturarPieza(this.jugadores.get(1), new Point(row,column));
        }
        else if(this.getGameState()== GameState.SELECT_CAPTURE_BLUE){
            this.capturarPieza(this.jugadores.get(0),new Point(row,column) );
        }
        else {
            this.resetGame();
        }
    }

}
