package refactorizado;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

abstract public class Juego {
    public static int NUM_FICHAS=9;

    protected static final int NUM_PLAYERS = 2;
    protected ArrayList<ArrayList<Point>> lastMill;
    public Tablero tablero;
    public Point lastPoint;
    public Jugador[] jugadores = new Jugador[NUM_PLAYERS];
    protected char turn = 'X';
    protected GameState currentGameState;

    boolean isMachine = false;

    public Juego(){

    }

    public Juego(boolean isMachine) {
        tablero = new Tablero();
        lastMill = new ArrayList<>();
        this.isMachine = isMachine;
        preparePlayers();
    }

    private void preparePlayers() {
        jugadores[0] = new JugadorHumano(1, this);
        jugadores[1] = (isMachine) ? new JugadorMaquina(2, this) : new JugadorHumano(2, this);
    }

    public boolean findTri() {
        for (int row = 0; row < this.tablero.getRows(); ++row) {
            for (int col = 0; col < this.tablero.getColumns(); ++col) {
                if (isTri(new Point(row, col))) {
                    System.out.println("MILL");
                    return true;
                }
            }
        }
        System.out.println("No MILL");
        return false;
    }

    public Point findTriCoordenada() {
        for (int row = 0; row < this.tablero.getRows(); ++row) {
            for (int col = 0; col < this.tablero.getColumns(); ++col) {
                if (isTri(new Point(row, col))) {
                    return new Point(row,col);
                }
            }
        }
        return null;
    }

    private void checkStillMil(ArrayList<ArrayList<Point>> listaConjuntos) {
        System.out.println("Antes:");
        boolean deboBorrar = false;
        if (listaConjuntos.size() > 0) {
            Iterator<ArrayList<Point>> itr = listaConjuntos.iterator();
            while (itr.hasNext()) {

                Iterator<Point> itrPoints = itr.next().iterator();
                while (itrPoints.hasNext()) {
                    Point i = itrPoints.next();
                    System.out.println("----(" + i.x + "," + i.y+")");
                    if (this.tablero.getFicha(i).state == FichaState.EMPTY ) {
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

    public void changeTurn() {
        this.isEliminar();
        System.out.println(jugadores[0].juegoEnlazado.currentGameState.toString());
//            if(!this.checkStillMil(this.lastMill)) this.lastMill.clear();
        if(currentGameState != GameState.SELECT_CAPTURE_RED && currentGameState != GameState.SELECT_CAPTURE_BLUE){
<<<<<<< Updated upstream
            jugadores[0].juegoEnlazado.turn =  (jugadores[0].juegoEnlazado.turn=='X')? 'O' : 'X';
=======
            turn =  (turn=='X')? 'O' : 'X';
>>>>>>> Stashed changes
        }

    }

    public boolean contieneCombinacion(ArrayList<ArrayList<Point>> grande, ArrayList<Point> elemento) {
        if (grande.size() >= 1) {
            for(ArrayList<Point> mills : grande){
                if (mills.containsAll(elemento)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isTri(Point esquina) {

        Ficha lastMove = this.tablero.getFicha(esquina);
        for (Point intermedioP : lastMove.vecinos) {
            Ficha intermedio = this.tablero.getFicha(intermedioP);
            if (lastMove.esEquipo(intermedio)) {

                for (Point extremoP : intermedio.vecinos) {
                    Ficha extremo = this.tablero.getFicha(extremoP);
                    ArrayList<Point> newMill = new ArrayList<Point>();
                    newMill.add(esquina);
                    newMill.add(intermedioP);
                    newMill.add(extremoP);

                    if (intermedio.esEquipo(extremo) && !extremo.coordenada.equals(lastMove.coordenada) && lastMove.esLinea(extremo) && !contieneCombinacion(this.lastMill, newMill)) {
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


    public GameState getGameState() {
        return currentGameState;
    }

    public Jugador getPlayerTurn(){
        if(jugadores[0].juegoEnlazado.turn=='X') {
            return jugadores[0];
        }
            return jugadores[1];
    }
    public Jugador getOpositivePlayerTurn(){
        if(turn!='X') {
            return jugadores[0];
        }
        return jugadores[1];
    }

    public char getTurn() {
        return jugadores[0].juegoEnlazado.turn;
    }

    public void desplegarFicha(int row, int column) {
    }


    public void capturarPieza(Jugador atacado, Point posicionCapturada) {
        if(atacado.fichasJugador.contains(posicionCapturada)) {
            atacado.reducirNumFichasEnJuego(posicionCapturada);
            this.tablero.piezasTablero[posicionCapturada.x][posicionCapturada.y].state = FichaState.EMPTY;
        }
        if(jugadores[1].getNumFichas()==0){
            jugadores[0].juegoEnlazado.currentGameState = GameState.MOVING;
<<<<<<< Updated upstream
            jugadores[0].juegoEnlazado.turn = (jugadores[0].juegoEnlazado.turn == 'X')? 'O': 'X';
=======
>>>>>>> Stashed changes
        }
        else{
            jugadores[0].juegoEnlazado.currentGameState = GameState.DEPLOY;
        }

        System.out.println("Pieza capturada " + jugadores[0].juegoEnlazado.currentGameState.toString());
    }


    public void updateGameState(int x, int y) {
    }

    public Juego resetGame() {
        return new JuegoFase1(isMachine);
    }
    public void isEliminar(){
        this.checkStillMil(this.lastMill);
        if (this.findTri()) {
            GameState temp = currentGameState;
            System.out.println("ColorMill: " + this.tablero.getFicha(lastMill.get(0).iterator().next()).state.toString());
            System.out.println("ColorJugador: "+getPlayerTurn().getColor().toString());
            if(this.tablero.getFicha(lastMill.get(lastMill.size()-1).iterator().next()).state == getPlayerTurn().getColor()) {
                currentGameState = (jugadores[0].juegoEnlazado.turn == 'X') ? GameState.SELECT_CAPTURE_RED : GameState.SELECT_CAPTURE_BLUE;
            }else{
                currentGameState = temp;
            }
        }

        if(this.getPlayerTurn().getNumFichasEnJuego()==2 && currentGameState!= GameState.DEPLOY && currentGameState!= GameState.SELECT_CAPTURE_BLUE && currentGameState!= GameState.SELECT_CAPTURE_RED){
            currentGameState = (jugadores[0].juegoEnlazado.turn == 'X') ? GameState.BLUE_WON : GameState.RED_WON;
        }
    }

    abstract void realizarMovimiento(int row, int col);

    abstract Juego selfCast();
}