package refactorizado;

import java.awt.*;
import java.util.ArrayList;

abstract public class Juego {
    public static int NUM_FICHAS;
    protected static int TOTALROWS;
    protected static int TOTALCOLUMNS;

    protected static final int NUM_PLAYERS = 2;
    protected Ficha[][] piezasTablero;
    protected ArrayList<ArrayList<Point>> lastMill;
    public Point lastPoint;
    public ArrayList<Jugador> jugadores;
    protected char turn;
    protected GameState currentGameState;



    private boolean findTri() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                if (isTri(new Point(row, col))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkStillMil(ArrayList<ArrayList<Point>> listaConjuntos) {

    }

    public boolean contieneCombinacion(ArrayList<ArrayList<Point>> grande, ArrayList<Point> elemento) {
        if (grande.size() > 1) {
            if (grande.get(0).containsAll(elemento)) {
                return true;
            }
        }

        return false;
    }

    private boolean isTri(Point esquina) {

        Ficha lastMove = this.getFicha(esquina);
        for (Point intermedioP : lastMove.vecinos) {
            Ficha intermedio = this.getFicha(intermedioP);
            if (lastMove.esEquipo(intermedio)) {

                for (Point extremoP : intermedio.vecinos) {
                    Ficha extremo = this.getFicha(extremoP);
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

    public Ficha getFicha(Point esquina) {
        return null;
    }

    public GameState getGameState() {
        return currentGameState;
    }

    public Jugador getPlayerTurn(){
        if(turn=='X'){
            return jugadores.get(0);
        }
        else{
            return jugadores.get(1);
        }
    }

    public String setTitle() {
        return null;
    }

    public int getTotalRows() {
        return TOTALROWS;
    }

    public int getTotalColumns() {
        return TOTALCOLUMNS;
    }

    public void desplegarFicha(int row, int column) {
    }
    public char getTurn() {
        return turn;
    }
    abstract void updateGameState(int row, int column);
    public void capturarPieza(Jugador atacado, Point posicionCapturada) {
        if(atacado.fichasJugador.contains(posicionCapturada)) {
            atacado.reducirNumFichasEnJuego(posicionCapturada);
            this.piezasTablero[posicionCapturada.x][posicionCapturada.y].state = FichaState.EMPTY;
            turn = (turn == 'X')? 'O' : 'X';
            updateGameState(posicionCapturada.x, posicionCapturada.y);
        }
    }
    public Juego resetGame() {
        return (JuegoFase1) this;
//        initGame();
    }

}