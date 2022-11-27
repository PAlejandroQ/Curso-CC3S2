package refactorizado;

import java.awt.*;

public class JuegoFase1 extends  Juego{
    public JuegoFase1(int totalRows, int totalColumns) {
        super(totalRows, totalColumns);
    }
    public void desplegarFicha(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS && piezasTablero[row][column].state == FichaState.EMPTY) {
            piezasTablero[row][column].state = (turn == 'X') ? FichaState.BLUE : FichaState.RED;
            this.piezasTablero[row][column].state = (turn == 'X') ? FichaState.BLUE : FichaState.RED;
            this.getPlayerTurn().aumentarNumFichasEnJuego(new Point(row,column));
            this.getPlayerTurn().reducinNumFicha();
            this.lastPoint = this.piezasTablero[row][column].coordenada;
            updateGameState(turn, row, column);

//            if(!this.checkStillMil(this.lastMill)) this.lastMill.clear();
            if(currentGameState!= GameState.SELECT_CAPTURE_RED && currentGameState!= GameState.SELECT_CAPTURE_BLUE){
                turn = (turn == 'X') ? 'O' : 'X';
            }
        }

    }

    private void updateGameState(char turn, int row, int column) {
    }
}
