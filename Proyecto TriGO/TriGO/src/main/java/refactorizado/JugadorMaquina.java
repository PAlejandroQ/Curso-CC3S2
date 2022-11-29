package refactorizado;


import java.awt.*;

public class JugadorMaquina extends Jugador{
    public JugadorMaquina(int color, Juego juegoEnlazado){
        super(color, juegoEnlazado);

    }
    public void eventClick(int row, int column)
    {

        if(juegoEnlazado.tablero.getFicha(new Point(0,0)).state == FichaState.EMPTY  )
        {
            juegoEnlazado.realizarMovimiento(0, 0);
        }else{
            if(juegoEnlazado.findTri()){
                Point opcion = juegoEnlazado.findTriCoordenada();
                juegoEnlazado.realizarMovimiento((int)opcion.getX(), (int)opcion.getY());
            }else{
                for (int rows = 0; row < juegoEnlazado.tablero.getRows(); ++row) {
                    for (int col = 0; col < juegoEnlazado.tablero.getColumns(); ++col) {
                        if (juegoEnlazado.tablero.getFicha(new Point(rows,col)).esLinea(juegoEnlazado.tablero.getFicha(juegoEnlazado.lastPoint))) {
                            juegoEnlazado.realizarMovimiento(rows, col);
                            break;

                        }
                    }
                }
            }
        }





    }
    /*
    void makeMoveByMaquina(Juego juegoEnCurso)
    {
        //Añadir algoritmo de jugador computadora.


        juegoEnCurso.moverFicha(1,1);
    }*/
}
