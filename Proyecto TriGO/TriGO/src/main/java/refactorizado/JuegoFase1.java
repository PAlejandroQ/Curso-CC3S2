package refactorizado;

import java.awt.*;

public class JuegoFase1 extends  Juego{
    public JuegoFase1() {

        super();
        currentGameState = GameState.DEPLOY;
    }
    public void desplegarFicha(int row, int column) {
        if (row >= 0 && row < this.tablero.getRows() && column >= 0 && column < this.tablero.getColumns() && this.tablero.piezasTablero[row][column].state == FichaState.EMPTY) {
            this.tablero.piezasTablero[row][column].state = (turn == 'X') ? FichaState.BLUE : FichaState.RED;
            this.tablero.piezasTablero[row][column].state = (turn == 'X') ? FichaState.BLUE : FichaState.RED;
            this.getPlayerTurn().aumentarNumFichasEnJuego(new Point(row,column));
            this.getPlayerTurn().reducinNumFicha();
            this.lastPoint = this.tablero.piezasTablero[row][column].coordenada;
            updateGameState(row, column);

//            if(!this.checkStillMil(this.lastMill)) this.lastMill.clear();
            if(currentGameState!= GameState.SELECT_CAPTURE_RED && currentGameState!= GameState.SELECT_CAPTURE_BLUE){
                turn = (turn == 'X') ? 'O' : 'X';
            }
        }
    }

    public void realizarMovimiento(int row, int col){
        desplegarFicha(row,col);
    }

    @Override
    public Juego selfCast(){
        if(jugadores[1].getNumFichas()==0){
            Juego fase2 = new JuegoFase2(this.tablero, this.jugadores, this.lastMill, this.lastPoint);
            jugadores[0].juegoEnlazado = fase2;
            jugadores[1].juegoEnlazado = fase2;
        }
        return this;
    }
}
