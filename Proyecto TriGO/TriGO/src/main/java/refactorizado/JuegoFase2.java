package refactorizado;


import java.awt.*;
import java.util.ArrayList;

public class JuegoFase2 extends Juego{
    public JuegoFase2(Tablero tablero, Jugador[] jugadores, ArrayList<ArrayList<Point>> lastMill, Point lastPoint) {
        this.tablero = tablero;
        this.jugadores = jugadores;
        this.lastMill = lastMill;
        this.lastPoint = lastPoint;
        System.out.println("Fase 2");
        this.currentGameState = GameState.MOVING;
        jugadores[0].setSelecting();
        jugadores[1].setSelecting();
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
                if (this.tablero.piezasTablero[row][col].state == FichaState.SHINY) this.tablero.piezasTablero[row][col].state = FichaState.EMPTY;
            }
        }
    }

    public void seleccionarInicio(Jugador jugador, int row, int col){
        clearShinys();
        Ficha actual = this.tablero.getFicha(new Point(row, col));
        if(actual.state == jugador.getColor()){
            if(jugador.isFlying()){
                for( int x=0; x<this.tablero.getRows(); ++x){
                    for(int y=0; y<this.tablero.getColumns(); ++y) {
                        if(this.tablero.getFicha(new Point(x,y)).state== FichaState.EMPTY && this.tablero.piezasTablero[x][y].state!= FichaState.DISABLE){
                            this.tablero.piezasTablero[x][y].state = FichaState.SHINY;
                        }
                    }
                }
            }else{
                for(Point vecino : actual.vecinos){
                    if(this.tablero.getFicha(vecino).state == FichaState.EMPTY){
                        this.tablero.piezasTablero[vecino.x][vecino.y].state = FichaState.SHINY;
                    }
                }
            }
            System.out.println("Cambio a moving");
            jugador.setMoving();
        }
        this.lastPoint = this.tablero.piezasTablero[row][col].coordenada;
    }

    public void seleccionarDestino(Jugador jugador, int row, int col){
        if(this.tablero.piezasTablero[row][col].state == FichaState.SHINY){
            this.tablero.piezasTablero[row][col].state = jugador.getColor();
            //
            this.tablero.piezasTablero[lastPoint.x][lastPoint.y].state = FichaState.EMPTY;
            getPlayerTurn().reducirNumFichasEnJuego(lastPoint);
            getPlayerTurn().aumentarNumFichasEnJuego(new Point(row, col));
            //
            jugador.setSelecting();
            System.out.println("Seleccionado destino");
            updateGameState(row, col);
            if(currentGameState!= GameState.SELECT_CAPTURE_BLUE && currentGameState!= GameState.SELECT_CAPTURE_RED){
                this.changeTurn();
            }
            clearShinys();
        }else if (this.tablero.piezasTablero[row][col].state == getPlayerTurn().getColor()){
            jugador.setSelecting();
        }
    }

    public void moverFicha(int row, int col){
        Jugador jugador = this.getPlayerTurn();
        System.out.println(jugador.getState().toString());
        if(jugador.getState() == Jugador.State.SELECTING){
            seleccionarInicio(jugador, row, col);
        } else if (jugador.getState()== Jugador.State.MOVING){
            seleccionarDestino(jugador, row, col);
        }
    }

    public void realizarMovimiento(int row, int col){
        moverFicha(row, col);
    }

    @Override
    public Juego selfCast(){
        if(this.getPlayerTurn().getNumFichasEnJuego()>3 && currentGameState!= GameState.DEPLOY){
            for(Jugador jugador : jugadores){
                jugador.setSelecting();
            }
            currentGameState = GameState.MOVING;
        } else if (this.getPlayerTurn().getNumFichasEnJuego() == 3 && currentGameState ==GameState.DEPLOY) {
            this.getPlayerTurn().setFlying();

        }

        if (this.findTri()) {
            GameState temp = currentGameState;
            System.out.println("ColorMill: " + this.tablero.getFicha(lastMill.get(0).iterator().next()).state.toString());
            System.out.println("ColorJugador: "+getPlayerTurn().getColor().toString());
            if(this.tablero.getFicha(lastMill.get(0).iterator().next()).state == getPlayerTurn().getColor()) {
                currentGameState = (turn == 'X') ? GameState.SELECT_CAPTURE_RED : GameState.SELECT_CAPTURE_BLUE;
            }else{
                currentGameState = temp;
            }
        }


        if(this.getPlayerTurn().getNumFichasEnJuego()==2 && currentGameState!= GameState.DEPLOY && currentGameState!= GameState.SELECT_CAPTURE_BLUE && currentGameState!= GameState.SELECT_CAPTURE_RED){
            currentGameState = (turn == 'X') ? GameState.BLUE_WON : GameState.RED_WON;
        }

        return this;
    }

}