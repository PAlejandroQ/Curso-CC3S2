package refactorizado;

import java.awt.*;

public class JuegoFase1 extends  Juego {
    public JuegoFase1(boolean isMachine) {
        super(isMachine);
        currentGameState = GameState.DEPLOY;
    }

    /**
     * Preconditions: none
     * Postconditions:
     * @param row
     * @param column
     */
    public void desplegarFicha(int row, int column) throws IllegalArgumentException{
        if (row >= 0 && row < this.tablero.getRows() && column >= 0 && column < this.tablero.getColumns() && this.tablero.piezasTablero[row][column].state == FichaState.EMPTY) {
            this.tablero.piezasTablero[row][column].state = (turn == 'X') ? FichaState.BLUE : FichaState.RED;
            this.getPlayerTurn().aumentarNumFichasEnJuego(new Point(row,column));
            this.getPlayerTurn().reducinNumFicha();
            this.lastPoint = this.tablero.piezasTablero[row][column].coordenada;

        } else{
            throw new IllegalArgumentException("Out of bound of table");
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
            System.out.println("Cambio de Fase");
        }
        System.out.println("Selfcast1");
        this.changeTurn();
        return this;
    }
}
