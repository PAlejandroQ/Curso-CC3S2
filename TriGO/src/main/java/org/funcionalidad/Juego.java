package org.funcionalidad;

import java.awt.*;

public class Juego {
    public static final int NUM_FICHAS = 9;
    protected static final int TOTALROWS = 7;
    protected static final int TOTALCOLUMNS = 7;
    protected Ficha[][] piezasTablero;
    private Point lastPoint;

    public enum Cell {
        EMPTY, BLUE, RED, DISABLE
    }

    protected Cell[][] grid;
    protected char turn;

    public enum GameState {
        PLAYING, DRAW, BLUE_WON, RED_WON
    }

    protected GameState currentGameState;

    public Juego() {
        grid = new Cell[TOTALROWS][TOTALCOLUMNS];
        this.piezasTablero = new Ficha[TOTALROWS][TOTALCOLUMNS];
        initGame();

    }

    private void initGame() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                grid[row][col] = Cell.EMPTY;
                this.piezasTablero[row][col] = new Ficha(-1,new Point(row,col));
            }
        }
        currentGameState = GameState.PLAYING;
        turn = 'X';
        preparePositions();
        prepareVecinos();
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
        this.piezasTablero[0][3].setVecinos(piezasTablero[0][3].coordenada);
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
    private Ficha getFicha(Point posicion)
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
            this.lastPoint = this.piezasTablero[row][column].coordenada;
            updateGameState(turn, row, column);
            turn = (turn == 'X') ? 'O' : 'X';

        }

    }

    private void updateGameState(char turn, int row, int column) {
        if (this.findTri()) {
            currentGameState = (turn == 'X') ? GameState.BLUE_WON : GameState.RED_WON;
        } else if (isDraw()) {
            currentGameState = GameState.DRAW;
        }
    }

    private boolean isDraw() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                if (grid[row][col] == Cell.EMPTY && grid[row][col]!=Cell.DISABLE) {
                    return false;
                }
            }
        }
        return true;
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

    public GameState getGameState() {
        return currentGameState;
    }


}
