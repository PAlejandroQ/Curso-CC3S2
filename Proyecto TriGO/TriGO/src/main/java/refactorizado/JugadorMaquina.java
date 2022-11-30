package refactorizado;
import java.util.concurrent.ThreadLocalRandom;

import java.awt.*;

public class JugadorMaquina extends Jugador {
    GameState estadoBot;
    Point lastPointBot;
    public JugadorMaquina(int color, Juego juegoEnlazado){
        super(color, juegoEnlazado);
        estadoBot = GameState.DEPLOY;
        lastPointBot = null;
    }
    /*
    * Metodo que envia el flujo de datos*/
    public void eventClick(int row, int column) {
        Point respuesta = this.deployingBot();
        System.out.println(row + "- "+ column);
        juegoEnlazado.realizarMovimiento((int)respuesta.getX(), (int)respuesta.getY());
    }

    public Point deployingBot(){
        boolean isValidCoorenate=false;
        while(true){
            int randRow = ThreadLocalRandom.current().nextInt(0, juegoEnlazado.tablero.getRows()-1);
            int randCol = ThreadLocalRandom.current().nextInt(0, juegoEnlazado.tablero.getColumns()-1);
            if (juegoEnlazado.tablero.getFicha(new Point(randRow,randCol)).esLinea(juegoEnlazado.tablero.getFicha(this.lastPointBot)) && juegoEnlazado.tablero.getFicha(new Point(randRow,randCol)).state == FichaState.EMPTY){
                isValidCoorenate = true;
                this.lastPointBot = new Point(randRow,randCol);
                break;
            }



        }
        return this.lastPointBot;


//        if(lastPointBot == null) {
//            int randRow = ThreadLocalRandom.current().nextInt(0, juegoEnlazado.tablero.getRows()-1);
//            int randCol = ThreadLocalRandom.current().nextInt(0, juegoEnlazado.tablero.getColumns()-1);
//            this.lastPointBot = new Point(randRow,randCol);
//            return this.lastPointBot;
//        }else{
//            for (int rows = 0; rows < juegoEnlazado.tablero.getRows(); rows++) {
//                for (int col = 0; col < juegoEnlazado.tablero.getColumns(); col++) {
//                    if (juegoEnlazado.tablero.getFicha(new Point(rows,col)).esLinea(juegoEnlazado.tablero.getFicha(this.lastPointBot)) && juegoEnlazado.tablero.getFicha(new Point(rows,col)).state == FichaState.EMPTY) {
//                        this.lastPointBot = new Point(rows, col);
//                        break;
//
//
//                    }
//                }
//            }
//            return this.lastPointBot;
//        }

    }
    public Point movingBot(){
        return null;
    }
    public Point capturingBot(){
        return null;
    }


}
