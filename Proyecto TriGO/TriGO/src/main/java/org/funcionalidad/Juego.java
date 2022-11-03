package org.funcionalidad;

import java.awt.*;
import java.util.*;

public class Juego {
    public static final int NUM_FICHAS = 9;
    protected static final int TOTALROWS = 7;
    protected static final int TOTALCOLUMNS = 7;

    protected static final int NUM_PLAYERS = 2;
    protected Ficha[][] piezasTablero;
    protected ArrayList<ArrayList<Point>> lastMill;
    private Point lastPoint;

    public Jugador[] jugadores = new Jugador[NUM_PLAYERS];

    public enum Cell {
        EMPTY, BLUE, RED, DISABLE, SHINY
    }

    protected Cell[][] grid;
    protected char turn;

    public enum GameState {
        DEPLOY, MOVING, BLUE_WON, RED_WON, SELECT_CAPTURE_BLUE, SELECT_CAPTURE_RED
    }

    protected GameState currentGameState;

    public Juego() {
        grid = new Cell[TOTALROWS][TOTALCOLUMNS];
        this.piezasTablero = new Ficha[TOTALROWS][TOTALCOLUMNS];
        lastMill = new ArrayList<>();
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

    private void preparePositions(){
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
    private void prepareVecinos(){
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
    public Ficha getFicha(Point posicion){
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

    public void desplegarFicha(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS && grid[row][column] == Cell.EMPTY) {
            grid[row][column] = (turn == 'X') ? Cell.BLUE : Cell.RED;
            this.piezasTablero[row][column].state = (turn == 'X') ? Cell.BLUE : Cell.RED;
            this.getPlayerTurn().aumentarNumFichasEnJuego(new Point(row,column));
            this.getPlayerTurn().reducinNumFicha();
            this.lastPoint = this.piezasTablero[row][column].coordenada;
            updateGameState(turn, row, column);

//            if(!this.checkStillMil(this.lastMill)) this.lastMill.clear();
            if(currentGameState!=GameState.SELECT_CAPTURE_RED && currentGameState!=GameState.SELECT_CAPTURE_BLUE){
                turn = (turn == 'X') ? 'O' : 'X';
            }
        }

    }

    private void updateGameState(char turn, int row, int column) {
        //continuacion de fase de movimiento
        System.out.println("NumFichas: "+getPlayerTurn().getNumFichasEnJuego());
        checkStillMil(this.lastMill);
        if(this.getPlayerTurn().getNumFichas()>0){
            currentGameState = GameState.DEPLOY;
        }
        else if(jugadores[1].getNumFichas()==0){
            for(Jugador jugador : jugadores){
                jugador.setSelecting();
            }
            currentGameState = GameState.MOVING;
        }

        if(this.getPlayerTurn().getNumFichasEnJuego()>3 && currentGameState!=GameState.DEPLOY){
            for(Jugador jugador : jugadores){
                jugador.setSelecting();
            }
            currentGameState = GameState.MOVING;
        } else if (this.getPlayerTurn().getNumFichasEnJuego() == 3 && currentGameState != GameState.DEPLOY) {
            this.getPlayerTurn().setFlying();

        }

        if (this.findTri()) {
            GameState temp = currentGameState;
            System.out.println("ColorMill: " + getFicha(lastMill.get(0).iterator().next()).state.toString());
            System.out.println("ColorJugador: "+getPlayerTurn().getColor().toString());
            if(getFicha(lastMill.get(0).iterator().next()).state == getPlayerTurn().getColor()) {
                currentGameState = (turn == 'X') ? GameState.SELECT_CAPTURE_RED : GameState.SELECT_CAPTURE_BLUE;
            }else{
                currentGameState = temp;
            }
        }


        if(this.getCantidadFichas(turn)==2 && currentGameState!=GameState.DEPLOY && currentGameState!=GameState.SELECT_CAPTURE_BLUE && currentGameState!=GameState.SELECT_CAPTURE_RED){
            currentGameState = (turn == 'X') ? GameState.BLUE_WON : GameState.RED_WON;
        }

        System.out.println("EstadoJuego: "+currentGameState.toString());

        /*
        if(this.getCantidadFichas(turn)>3  && jugadores[1].getNumFichas()==0){
            for(Jugador jugador : jugadores){
                jugador.setSelecting();
            }
            currentGameState =  GameState.MOVING;
        }

        // Jugador 2 se queda sin fichas para colocar -> ambos jugadores inician fase de movimiento
        else if(this.getPlayerTurn().getNumFichasEnJuego()==3 && currentGameState == GameState.MOVING){
            this.getPlayerTurn().setFlying();
            System.out.println("Flying v:");
        }
        else if (this.jugadores[1].getNumFichas() == 0){
            for(Jugador jugador : jugadores){
                jugador.setSelecting();
            }
            currentGameState = GameState.MOVING;
        }
        else{
            currentGameState = GameState.DEPLOY;
        }

        if (this.findTri()) {
            GameState temp = currentGameState;
            System.out.println("ColorMill: " + getFicha(lastMill.get(0).iterator().next()).state.toString());
            System.out.println("ColorJugador: "+getPlayerTurn().getColor().toString());
            if(getFicha(lastMill.get(0).iterator().next()).state == getPlayerTurn().getColor()) {
                currentGameState = (turn == 'X') ? GameState.SELECT_CAPTURE_RED : GameState.SELECT_CAPTURE_BLUE;
            }else{
                currentGameState = temp;
            }
        }

        if(this.getCantidadFichas(turn)==2 && currentGameState!=GameState.DEPLOY && currentGameState!=GameState.SELECT_CAPTURE_BLUE && currentGameState!=GameState.SELECT_CAPTURE_RED){
            currentGameState = (turn == 'X') ? GameState.BLUE_WON : GameState.RED_WON;
        }

        System.out.println(currentGameState.toString());
         */
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
    private void checkStillMil(ArrayList<ArrayList<Point>> listaConjuntos) {
//        ArrayList<Point> borrable = null;
//        for (ArrayList<Point> combinacion : listaConjuntos) {
//            Iterator<Point> intercombinacion = combinacion.iterator();
//            while (intercombinacion.hasNext())
//                if (getFicha(intercombinacion.next()).state == Cell.EMPTY || getFicha(intercombinacion.next()).state == Cell.DISABLE) {
//                    return false;
//                }
//        }


        System.out.println("Antes:");
        boolean deboBorrar = false;
        if (listaConjuntos.size() > 0) {
            Iterator<ArrayList<Point>> itr = listaConjuntos.iterator();
            while (itr.hasNext()) {

                Iterator<Point> itrPoints = itr.next().iterator();
                while (itrPoints.hasNext()) {
                    Point i = itrPoints.next();
                    System.out.println("----(" + i.x + ","+i.y+")");
                    if (getFicha(i).state == Cell.EMPTY ) {
                        System.out.print("Borra Uno");
                        deboBorrar = true;


                    }
//                break;
                }

//            break;
            }
        }

        if(deboBorrar) listaConjuntos.clear();
        System.out.println("Fin While:\n ");

//        for(ArrayList<Point> mill : lastMill){
//            for()
//        }

    }

    public boolean contieneCombinacion(ArrayList<ArrayList<Point>> grande, ArrayList<Point> elemento){
        if(grande.size()>1 ){
            if(grande.get(0).containsAll(elemento)){
                return true;
            }
        }

        return false;
    }
    private boolean isTri(Point esquina){

        Ficha lastMove = this.getFicha(esquina);
        for(Point intermedioP : lastMove.vecinos){
            Ficha intermedio = this.getFicha(intermedioP);
            if(lastMove.esEquipo(intermedio)) {

                for(Point extremoP : intermedio.vecinos)
                {
                    Ficha extremo = this.getFicha(extremoP);
                    ArrayList<Point> newMill = new ArrayList<Point>();
                    newMill.add(esquina);
                    newMill.add(intermedioP);
                    newMill.add(extremoP);

                    if(intermedio.esEquipo(extremo) && !extremo.coordenada.equals(lastMove.coordenada) && lastMove.esLinea(extremo) && !contieneCombinacion(this.lastMill,newMill))
                    {
                        this.lastMill.add(newMill);
                        return true;
                    }
//                    else{
//                        this.lastMill.clear();
//                    }
                }
            }
        }
        return false;
    }

//    public void quitarPieza(Point p,Ficha ultimoMov)
//    {
//        if(this.findTri())
//            this.grid[p.x][p.y] = Cell.EMPTY;
//    }


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
        if (turn == 'X'){
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


    public void capturarPieza(Jugador atacante, Jugador atacado, Point posicionCapturada) {
        if(atacante.fichasJugador.contains(posicionCapturada)) {
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
            if(jugador.isFlying()){
                for( int x=0; x<TOTALROWS; ++x){
                    for(int y=0; y<TOTALCOLUMNS; ++y) {
                        if(getFicha(new Point(x,y)).state==Cell.EMPTY && grid[x][y]!=Cell.DISABLE){
                            grid[x][y] = Cell.SHINY;
                        }
                    }
                }
            }else{
                for (Point vecino : actual.vecinos){
                    if(getFicha(vecino).state == Cell.EMPTY){
                        grid[vecino.x][vecino.y] = Cell.SHINY;
                    }
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
            getPlayerTurn().reducirNumFichasEnJuego(lastPoint);
            getPlayerTurn().aumentarNumFichasEnJuego(new Point(row, col));
            //
            jugador.setSelecting();
            updateGameState(turn, row, col);
            if(currentGameState!=GameState.SELECT_CAPTURE_BLUE && currentGameState!=GameState.SELECT_CAPTURE_RED){
                turn =  (turn=='X')? 'O' : 'X';
            }
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
