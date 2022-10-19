package org.funcionalidad;

import java.awt.*;

public class Juego {
    public static final int NUM_FICHAS = 9;
    protected static final int TOTALROWS = 7;
    protected static final int TOTALCOLUMNS = 7;
    protected Ficha[][] piezasTablero;

    public enum Cell {
        EMPTY, CROSS, NOUGHT, DISABLE
    }

    protected Cell[][] grid;
    protected char turn;

    public enum GameState {
        PLAYING, DRAW, CROSS_WON, NOUGHT_WON
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
                this.piezasTablero[row][col] = new Ficha(1,new Point(row,col));
            }
        }
        currentGameState = GameState.PLAYING;
        turn = 'X';
        preparePositions();
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
            grid[row][column] = (turn == 'X') ? Cell.CROSS : Cell.NOUGHT;
            updateGameState(turn, row, column);
            turn = (turn == 'X') ? 'O' : 'X';

        }

    }

    private void updateGameState(char turn, int row, int column) {
        if (hasWon(turn, row, column)) {
            currentGameState = (turn == 'X') ? GameState.CROSS_WON : GameState.NOUGHT_WON;
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

    private boolean hasWon(char turn, int row, int column) {
        Cell token = (turn == 'X') ? Cell.CROSS : Cell.NOUGHT;
        return (grid[row][0] == token
                && grid[row][1] == token && grid[row][2] == token
                || grid[0][column] == token
                && grid[1][column] == token && grid[2][column] == token
                || row == column
                && grid[0][0] == token && grid[1][1] == token && grid[2][2] == token
                || row + column == 2
                && grid[0][2] == token && grid[1][1] == token && grid[2][0] == token);
    }
    private boolean isTri(Ficha ultimoMove)
    {
        for(Ficha intermedio : ultimoMove.vecinos)
        {
            if(ultimoMove.esEquipo(intermedio))
            {
                for(Ficha extremo : intermedio.vecinos)
                {
                    if(intermedio.esEquipo(extremo) && !extremo.coordenada.equals(ultimoMove.coordenada) && ultimoMove.esLinea(extremo))
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
        if(isTri(ultimoMov))
            this.grid[p.x][p.y] = Cell.EMPTY;
    }

    public GameState getGameState() {
        return currentGameState;
    }


}
