package refactorizado;

import java.awt.*;
import java.util.ArrayList;

abstract public class Juego {
    public static int NUM_FICHAS=9;

    protected static final int NUM_PLAYERS = 2;
    protected ArrayList<ArrayList<Point>> lastMill;
    public Tablero tablero;
    public Point lastPoint;
    public Jugador[] jugadores = new Jugador[NUM_PLAYERS];
    protected char turn = 'X';
    protected GameState currentGameState;

    public Juego(){
        tablero= new Tablero();
        lastMill = new ArrayList<>();
        preparePlayers();
    }

    private void preparePlayers(){
        jugadores[0] = new JugadorHumano(1, this);
        jugadores[1] = new JugadorMaquina(2, this);
    }

    public boolean findTri(){
        for (int row = 0; row < this.tablero.getRows(); ++row) {
            for (int col = 0; col < this.tablero.getColumns(); ++col) {
                if (isTri(new Point(row, col))) {
                    return true;
                }
            }
        }
        return false;
    }
    public Point findTriCoordenada(){
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

    }

    public void changeTurn(){turn =  (turn=='X')? 'O' : 'X';}

    public boolean contieneCombinacion(ArrayList<ArrayList<Point>> grande, ArrayList<Point> elemento) {
        if (grande.size() > 1) {
            if (grande.get(0).containsAll(elemento)) {
                return true;
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
        if(turn=='X'){
            return jugadores[0];
        }
        else{
            return jugadores[1];
        }
    }
    public char getTurn() {
        return turn;
    }

    public void desplegarFicha(int row, int column) {
    }


    public void capturarPieza(Jugador atacado, Point posicionCapturada) {
        if(atacado.fichasJugador.contains(posicionCapturada)) {
            atacado.reducirNumFichasEnJuego(posicionCapturada);
            this.tablero.piezasTablero[posicionCapturada.x][posicionCapturada.y].state = FichaState.EMPTY;
            turn = (turn == 'X')? 'O' : 'X';
            updateGameState(posicionCapturada.x, posicionCapturada.y);
        }
    }

    public void updateGameState(int x, int y) {
    }

    public Juego resetGame() {
        return (JuegoFase1) this;
        // this =
//        initGame();
    }

    abstract void realizarMovimiento(int row, int col);

    public abstract Juego selfCast();
}