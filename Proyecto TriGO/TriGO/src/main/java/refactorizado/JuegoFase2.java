package refactorizado;


import java.awt.*;

public class JuegoFase2 extends Juego{
    public JuegoFase2() {
    }

/*
    public void eventClick(int row, int column){
        super.eventClick(row,column);
//        if (this.getGameState() == GameState.DEPLOY) {
//            this.desplegarFicha(row, column);
//        }
        if(this.getGameState()== GameState.MOVING){
            this.moverFicha(row, column);
        }
//        else if(this.getGameState()== GameState.SELECT_CAPTURE_RED){
//            this.capturarPieza(this.jugadores.get(1), new Point(row,column));
//        }
//        else if(this.getGameState()== GameState.SELECT_CAPTURE_BLUE){
//            this.capturarPieza(this.jugadores.get(0),new Point(row,column) );
//        }
//        else {
//            this.resetGame();
//        }
    }
    */

    public void clearShinys(){
        for (int row = 0; row < this.tablero.getRows(); ++row) {
            for (int col = 0; col < this.tablero.getColumns(); ++col) {
                if (this.piezasTablero[row][col].state == FichaState.SHINY) this.piezasTablero[row][col].state = FichaState.EMPTY;
            }
        }
    }

    public void seleccionarInicio(Jugador jugador, int row, int col){
        clearShinys();
        Ficha actual = getFicha(new Point(row, col));
        if(actual.state == jugador.getColor()){
            if(jugador.isFlying()){
                for( int x=0; x<this.tablero.getRows(); ++x){
                    for(int y=0; y<this.tablero.getColumns(); ++y) {
                        if(getFicha(new Point(x,y)).state== FichaState.EMPTY && piezasTablero[x][y].state!= FichaState.DISABLE){
                            piezasTablero[x][y].state = FichaState.SHINY;
                        }
                    }
                }
            }else{
                for (Point vecino : actual.vecinos){
                    if(getFicha(vecino).state == FichaState.EMPTY){
                        piezasTablero[vecino.x][vecino.y].state = FichaState.SHINY.SHINY;
                    }
                }
            }
            jugador.setMoving();
        }
        this.lastPoint = this.piezasTablero[row][col].coordenada;
    }

    public void seleccionarDestino(Jugador jugador, int row, int col){
        if(piezasTablero[row][col].state == FichaState.SHINY){
            piezasTablero[row][col].state = jugador.getColor();
            getFicha(new Point(row, col)).state = jugador.getColor();
            //
            piezasTablero[lastPoint.x][lastPoint.y].state = FichaState.EMPTY;
            getFicha(lastPoint).state = FichaState.EMPTY;
            getPlayerTurn().reducirNumFichasEnJuego(lastPoint);
            getPlayerTurn().aumentarNumFichasEnJuego(new Point(row, col));
            //
            jugador.setSelecting();
            updateGameState(row, col);
            if(currentGameState!= GameState.SELECT_CAPTURE_BLUE && currentGameState!= GameState.SELECT_CAPTURE_RED){
                turn =  (turn=='X')? 'O' : 'X';
            }
            clearShinys();
        }else if (piezasTablero[row][col].state == getPlayerTurn().getColor()){
            jugador.setSelecting();
        }
    }

    public void moverFicha(int row, int col){
        Jugador jugador = getPlayerTurn();
        if(jugador.getState() == Jugador.State.SELECTING){
            seleccionarInicio(jugador, row, col);
        } else if (jugador.getState()== Jugador.State.MOVING){
            seleccionarDestino(jugador, row, col);
        }
    }

    public void realizarMovimiento(int row, int col){
        getPlayerTurn().eventClick(row, col);
    }

}
