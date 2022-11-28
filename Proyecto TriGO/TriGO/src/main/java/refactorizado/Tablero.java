package refactorizado;

import org.funcionalidad.Juego;

import java.awt.*;

public class Tablero {
    protected static int TOTALROWS=7 ;
    protected static int TOTALCOLUMNS=7;
    protected Ficha[][] piezasTablero;
    public Tablero() {
        this.piezasTablero = new Ficha[TOTALROWS][TOTALCOLUMNS];
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                this.piezasTablero[row][col] = new Ficha(-1,new Point(row,col));
            }
        }
        preparePositions();
        prepareVecinos();
    }
    private void preparePositions(){
        this.piezasTablero[0][1].state = FichaState.DISABLE;
        this.piezasTablero[0][2].state = FichaState.DISABLE;
        this.piezasTablero[0][4].state = FichaState.DISABLE;
        this.piezasTablero[0][5].state = FichaState.DISABLE;
        this.piezasTablero[1][0].state = FichaState.DISABLE;
        this.piezasTablero[1][2].state = FichaState.DISABLE;
        this.piezasTablero[1][4].state = FichaState.DISABLE;
        this.piezasTablero[1][6].state = FichaState.DISABLE;
        this.piezasTablero[2][0].state = FichaState.DISABLE;
        this.piezasTablero[2][1].state = FichaState.DISABLE;
        this.piezasTablero[2][5].state = FichaState.DISABLE;
        this.piezasTablero[2][6].state = FichaState.DISABLE;
        this.piezasTablero[3][3].state = FichaState.DISABLE;//
        this.piezasTablero[6][1].state = FichaState.DISABLE;
        this.piezasTablero[6][2].state = FichaState.DISABLE;
        this.piezasTablero[6][4].state = FichaState.DISABLE;
        this.piezasTablero[6][5].state = FichaState.DISABLE;
        this.piezasTablero[5][0].state = FichaState.DISABLE;
        this.piezasTablero[5][2].state = FichaState.DISABLE;
        this.piezasTablero[5][4].state = FichaState.DISABLE;
        this.piezasTablero[5][6].state = FichaState.DISABLE;
        this.piezasTablero[4][0].state = FichaState.DISABLE;
        this.piezasTablero[4][1].state = FichaState.DISABLE;
        this.piezasTablero[4][5].state = FichaState.DISABLE;
        this.piezasTablero[4][6].state = FichaState.DISABLE;
    }

    private void prepareVecinos(){
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


    public int getRows(){return TOTALROWS;}
    public int getColumns(){return TOTALCOLUMNS;}
}
