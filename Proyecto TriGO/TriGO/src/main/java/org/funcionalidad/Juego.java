package org.funcionalidad;

import java.awt.*;
import java.util.ArrayList;

public class Juego {
    public static final int NUM_FICHAS = 9;
    protected static final int TOTALROWS = 7;
    protected static final int TOTALCOLUMNS = 7;

    protected static final int NUM_PLAYERS = 2;
    protected Ficha[][] piezasTablero;
    protected ArrayList<Point> lastMill;
    private Point lastPoint;

    public Jugador[] jugadores = new Jugador[NUM_PLAYERS];

    public enum Cell {
        EMPTY, BLUE, RED, DISABLE, SHINY ;
    }

    protected Cell[][] grid;
    protected char turn;

    public enum GameState {
        DEPLOY, MOVING, FLIGHT, BLUE_WON, RED_WON, SELECT_CAPTURE_BLUE, SELECT_CAPTURE_RED
    }

    protected GameState currentGameState;

    public Juego() {
        grid = new Cell[TOTALROWS][TOTALCOLUMNS];
        this.piezasTablero = new Ficha[TOTALROWS][TOTALCOLUMNS];
        lastMill = new ArrayList<Point>();
        initGame();

    }

    private void initGame() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                grid[row][col] = Cell.EMPTY;
                this.piezasTablero[row][col] = new Ficha(-1,new Point(row,col));
            }
        }
        currentGameState = GameState.DEPLOY;
        turn = 'X';
        preparePlayers();
        preparePositions();
        prepareVecinos();
    }

    private void preparePlayers(){
        jugadores[0] = new Jugador(1);
        jugadores[1] = new Jugador(2);
    }

    private void preparePositions()
    {
        grid[0][1] = Cell.DISABLE;
        grid[0][2] = Cell.DISABLE;
        grid[0][4] = Cell.DISABLE;
        grid[0][5] = Cell.DISABLE;
        grid[1][0] = Cell.DISABLE;
        grid[1][2] = Cell.DISABLE;
        grid[1][4] = Cell.DISABLE;
        grid[1][6] = Cell.DISABLE;
        grid[2][0] = Cell.DISABLE;
        grid[2][1] = Cell.DISABLE;
        grid[2][5] = Cell.DISABLE;
        grid[2][6] = Cell.DISABLE;
        grid[3][3] = Cell.DISABLE;//
        grid[6][1] = Cell.DISABLE;
        grid[6][2] = Cell.DISABLE;
        grid[6][4] = Cell.DISABLE;
        grid[6][5] = Cell.DISABLE;
        grid[5][0] = Cell.DISABLE;
        grid[5][2] = Cell.DISABLE;
        grid[5][4] = Cell.DISABLE;
        grid[5][6] = Cell.DISABLE;
        grid[4][0] = Cell.DISABLE;
        grid[4][1] = Cell.DISABLE;
        grid[4][5] = Cell.DISABLE;
        grid[4][6] = Cell.DISABLE;
    }
    private void prepareVecinos()
    {
        // Cuadrado externo
        this.piezasTablero[0][0].setVecinos(piezasTablero[0][3].coordenada);
        this.piezasTablero[0][0].setVecinos(piezasTablero[3][0].coordenada);
        this.piezasTablero[3][0].setVecinos(piezasTablero[0][0].coordenada);
        this.piezasTablero[3][0].setVecinos(piezasTablero[6][0].coordenada);
        this.piezasTablero[3][0].setVecinos(piezasTablero[3][1].coordenada);
        this.piezasTablero[6][0].setVecinos(piezasTablero[6][3].coordenada);
        this.piezasTablero[6][0].setVecinos(piezasTablero[3][0].coordenada);
        this.piezasTablero[6][3].setVecinos(piezasTablero[6][0].coordenada);
        this.piezasTablero[6][3].setVecinos(piezasTablero[6][6].coordenada);
        this.piezasTablero[6][3].setVecinos(piezasTablero[5][3].coordenada);
        this.piezasTablero[6][6].setVecinos(piezasTablero[6][3].coordenada);
        this.piezasTablero[6][6].setVecinos(piezasTablero[3][6].coordenada);
        this.piezasTablero[3][6].setVecinos(piezasTablero[6][6].coordenada);
        this.piezasTablero[3][6].setVecinos(piezasTablero[0][6].coordenada);
        this.piezasTablero[3][6].setVecinos(piezasTablero[3][5].coordenada);
        this.piezasTablero[0][6].setVecinos(piezasTablero[3][6].coordenada);
        this.piezasTablero[0][6].setVecinos(piezasTablero[0][3].coordenada);
        this.piezasTablero[0][3].setVecinos(piezasTablero[0][6].coordenada);
        this.piezasTablero[0][3].setVecinos(piezasTablero[0][0].coordenada);
        this.piezasTablero[0][3].setVecinos(piezasTablero[1][3].coordenada);
        // Cuadrado intermedio
        this.piezasTablero[1][1].setVecinos(piezasTablero[3][1].coordenada);
        this.piezasTablero[1][1].setVecinos(piezasTablero[1][3].coordenada);
        this.piezasTablero[1][3].setVecinos(piezasTablero[1][1].coordenada);
        this.piezasTablero[1][3].setVecinos(piezasTablero[2][3].coordenada);
        this.piezasTablero[1][3].setVecinos(piezasTablero[1][5].coordenada);
        this.piezasTablero[1][3].setVecinos(piezasTablero[0][3].coordenada);
        this.piezasTablero[1][5].setVecinos(piezasTablero[1][3].coordenada);
        this.piezasTablero[1][5].setVecinos(piezasTablero[3][5].coordenada);//
        this.piezasTablero[3][5].setVecinos(piezasTablero[1][5].coordenada);
        this.piezasTablero[3][5].setVecinos(piezasTablero[3][6].coordenada);
        this.piezasTablero[3][5].setVecinos(piezasTablero[5][5].coordenada);
        this.piezasTablero[3][5].setVecinos(piezasTablero[3][4].coordenada);//
        this.piezasTablero[5][5].setVecinos(piezasTablero[3][5].coordenada);
        this.piezasTablero[5][5].setVecinos(piezasTablero[5][3].coordenada);//
        this.piezasTablero[5][3].setVecinos(piezasTablero[5][5].coordenada);
        this.piezasTablero[5][3].setVecinos(piezasTablero[4][3].coordenada);
        this.piezasTablero[5][3].setVecinos(piezasTablero[5][1].coordenada);
        this.piezasTablero[5][3].setVecinos(piezasTablero[6][3].coordenada);
        this.piezasTablero[5][1].setVecinos(piezasTablero[5][3].coordenada);
        this.piezasTablero[5][1].setVecinos(piezasTablero[3][1].coordenada);
        this.piezasTablero[3][1].setVecinos(piezasTablero[5][1].coordenada);
        this.piezasTablero[3][1].setVecinos(piezasTablero[3][0].coordenada);
        this.piezasTablero[3][1].setVecinos(piezasTablero[1][1].coordenada);
        this.piezasTablero[3][1].setVecinos(piezasTablero[3][2].coordenada);
        // Cuadrado interior
        this.piezasTablero[2][2].setVecinos(piezasTablero[2][3].coordenada);
        this.piezasTablero[2][2].setVecinos(piezasTablero[3][2].coordenada);
        this.piezasTablero[2][3].setVecinos(piezasTablero[2][2].coordenada);
        this.piezasTablero[2][3].setVecinos(piezasTablero[1][3].coordenada);
        this.piezasTablero[2][3].setVecinos(piezasTablero[2][4].coordenada);
        this.piezasTablero[2][4].setVecinos(piezasTablero[2][3].coordenada);
        this.piezasTablero[2][4].setVecinos(piezasTablero[3][4].coordenada);
        this.piezasTablero[3][4].setVecinos(piezasTablero[2][4].coordenada);
        this.piezasTablero[3][4].setVecinos(piezasTablero[3][5].coordenada);
        this.piezasTablero[3][4].setVecinos(piezasTablero[4][4].coordenada);
        this.piezasTablero[4][4].setVecinos(piezasTablero[3][4].coordenada);
        this.piezasTablero[4][4].setVecinos(piezasTablero[4][3].coordenada);
        this.piezasTablero[4][3].setVecinos(piezasTablero[4][4].coordenada);
        this.piezasTablero[4][3].setVecinos(piezasTablero[5][3].coordenada);
        this.piezasTablero[4][3].setVecinos(piezasTablero[4][2].coordenada);
        this.piezasTablero[4][2].setVecinos(piezasTablero[4][3].coordenada);
        this.piezasTablero[4][2].setVecinos(piezasTablero[3][2].coordenada);
        this.piezasTablero[3][2].setVecinos(piezasTablero[4][2].coordenada);
        this.piezasTablero[3][2].setVecinos(piezasTablero[3][1].coordenada);
        this.piezasTablero[3][2].setVecinos(piezasTablero[2][2].coordenada);
    }
    public Ficha getFicha(Point posicion)
    {
        return this.piezasTablero[posicion.x][posicion.y];
    }

    public void resetGame() {
        initGame();
    }

    public int getTotalRows() {
        return TOTALROWS;
    }

    public int getTotalColumns() {
        return TOTALCOLUMNS;
    }

    public Cell getCell(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS) {
            return grid[row][column];
        } else {
            return null;
        }
    }



    public char getTurn() {
        return turn;
    }

    public void makeMove(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS && grid[row][column] == Cell.EMPTY) {
            grid[row][column] = (turn == 'X') ? Cell.BLUE : Cell.RED;
            this.piezasTablero[row][column].state = (turn == 'X') ? Cell.BLUE : Cell.RED;
            this.getPlayerTurn().aumentarNumFichasEnJuego(new Point(row,column));
            this.lastPoint = this.piezasTablero[row][column].coordenada;
            updateGameState(turn, row, column);
            if(currentGameState!=GameState.SELECT_CAPTURE_RED && currentGameState!=GameState.SELECT_CAPTURE_BLUE){
                turn = (turn == 'X') ? 'O' : 'X';
            }
        }

    }

    private void updateGameState(char turn, int row, int column) {
        //continuacion de fase de movimiento
        if(this.getCantidadFichas(turn)>3 && currentGameState !=GameState.DEPLOY){
            currentGameState =  GameState.MOVING;
        }
        //Fase de vuelo (deberia ser por jugador v:)
        else if (this.getCantidadFichas(turn)==3 && currentGameState==GameState.MOVING ) {
            currentGameState = GameState.FLIGHT;
        }
        // Jugador 2 se queda sin fichas para colocar -> ambos jugadores inician fase de movimiento
        else if (this.jugadores[1].getNumFichas() == 0)
        {
            for(Jugador jugador : jugadores){
                jugador.setSelecting();
            }
            currentGameState = GameState.MOVING;
        }else{
            currentGameState = GameState.DEPLOY;
        }

        if (this.findTri()) {
            GameState temp = currentGameState;
            System.out.println(getFicha(lastMill.get(0)).state.toString());
            System.out.println(getPlayerTurn().getColor().toString());
            if(getFicha(lastMill.get(0)).state == getPlayerTurn().getColor()) {
                currentGameState = (turn == 'X') ? GameState.SELECT_CAPTURE_RED : GameState.SELECT_CAPTURE_BLUE;
//            currentGameState = (turn == 'X') ? GameState.BLUE_WON : GameState.RED_WON;
            }else{
                currentGameState = temp;
            }
        }

        System.out.println(currentGameState.toString());

        if(this.getCantidadFichas(turn)==2 && currentGameState!=GameState.DEPLOY && currentGameState!=GameState.SELECT_CAPTURE_BLUE && currentGameState!=GameState.SELECT_CAPTURE_RED){
            currentGameState = (turn == 'O') ? GameState.BLUE_WON : GameState.RED_WON;
        }
    }



    private boolean findTri()
    {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                if (isTri(new Point(row,col))) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isTri(Point esquina)
    {

        Ficha lastMove = this.getFicha(esquina);
        for(Point intermedioP : lastMove.vecinos)
        {
            Ficha intermedio = this.getFicha(intermedioP);
            if(lastMove.esEquipo(intermedio))
            {

                for(Point extremoP : intermedio.vecinos)
                {
                    Ficha extremo = this.getFicha(extremoP);
                    if(intermedio.esEquipo(extremo) && !extremo.coordenada.equals(lastMove.coordenada) && lastMove.esLinea(extremo))
                    {
                        this.lastMill.clear();
                        this.lastMill.add(esquina);
                        this.lastMill.add(intermedioP);
                        this.lastMill.add(extremoP);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void quitarPieza(Point p,Ficha ultimoMov)
    {
        if(this.findTri())
            this.grid[p.x][p.y] = Cell.EMPTY;
    }

  /*  private void finJuego(){
        int piezasRed=  0;
        int piezasBlue=  0 ;
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                Juego.Cell estado= this.piezasTablero[row][col].state;
                if(estado != Cell.EMPTY || estado != Cell.DISABLE) {
                    if (estado == Cell.RED) {
                        piezasRed++;
                    } else if (estado == Cell.BLUE) {
                        piezasBlue++;
                    }
                }
            }
        }
        if(piezasBlue==2 && currentGameState!=GameState.DEPLOY){
            currentGameState = (turn == 'O') ? GameState.BLUE_WON : GameState.RED_WON;
        }
    }*/

    int getCantidadFichas(char turn){
        int piezasRed=0,piezasBlue=0;
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                Juego.Cell estado= this.piezasTablero[row][col].state;
                if(estado != Cell.DISABLE) {
                    if (estado == Cell.RED) {
                        piezasRed++;
                    } else if (estado == Cell.BLUE) {
                        piezasBlue++;
                    }
                }
            }
        }
        if (turn == 'O'){
            return piezasBlue;
        }else
            return piezasRed;

    }


    public GameState getGameState() {
        return currentGameState;
    }

    public Jugador getPlayerTurn(){
        if(turn=='X'){
            return jugadores[0];
        }
        else{
            return jugadores[1];
        }
    }


    public void capturarPieza(Jugador atacante, Jugador atacado, Point posicionCapturada)
    {
        if(atacante.fichasJugador.contains(posicionCapturada))
        {
            atacante.reducirNumFichasEnJuego(posicionCapturada);
            this.piezasTablero[posicionCapturada.x][posicionCapturada.y].state = Cell.EMPTY;
            grid[posicionCapturada.x][posicionCapturada.y] = Cell.EMPTY;
            turn = (turn == 'X')? 'O' : 'X';
            updateGameState(turn, posicionCapturada.x, posicionCapturada.y);
        }
    }

    public void clearShinys(){
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                if (this.grid[row][col] == Cell.SHINY) this.grid[row][col] = Cell.EMPTY;
            }
        }
    }

    public void seleccionarInicio(Jugador jugador, int row, int col){
        clearShinys();
        Ficha actual = getFicha(new Point(row, col));
        if(actual.state == jugador.getColor()){
            for (Point vecino : actual.vecinos){
                if(getFicha(vecino).state == Cell.EMPTY){
                    grid[vecino.x][vecino.y] = Cell.SHINY;
                }
            }
            jugador.setMoving();
        }
        this.lastPoint = this.piezasTablero[row][col].coordenada;
    }

    public void seleccionarDestino(Jugador jugador, int row, int col){
        if(grid[row][col] == Cell.SHINY){
            grid[row][col] = jugador.getColor();
            getFicha(new Point(row, col)).state = jugador.getColor();
            // :v oe
            grid[lastPoint.x][lastPoint.y] = Cell.EMPTY;
            getFicha(lastPoint).state = Cell.EMPTY;
            //
            jugador.setSelecting();
            turn =  (turn=='X')? 'O' : 'X';
            updateGameState(turn, row, col);
            clearShinys();
        }else if (grid[row][col] == getPlayerTurn().getColor()){
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
}
