package refactorizado;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.awt.*;

public class JugadorMaquina extends Jugador {
    GameState estadoBot;
    Point lastPointBot;
    Point lastCaptureBot;
    public JugadorMaquina(int color, Juego juegoEnlazado){
        super(color, juegoEnlazado);
        estadoBot = GameState.DEPLOY;
        lastPointBot = new Point(0,0);
    }
    /*
    * Metodo que envia el flujo de datos*/
    public void eventClick(int row, int column) {
        Point respuesta;
        if(this.juegoEnlazado.getGameState()!= GameState.SELECT_CAPTURE_RED && this.juegoEnlazado.getGameState() != GameState.SELECT_CAPTURE_BLUE) {
            if(this.juegoEnlazado instanceof  JuegoFase2){
                respuesta=chooseOwnFichaBot();
                this.juegoEnlazado.realizarMovimiento((int)respuesta.getX(), (int)respuesta.getY());
            }
            respuesta = this.deployingBot();

            this.juegoEnlazado.realizarMovimiento((int)respuesta.getX(), (int)respuesta.getY());
        }else if(juegoEnlazado.getGameState() == GameState.SELECT_CAPTURE_BLUE){
            respuesta = this.capturingBot();
            juegoEnlazado.capturarPieza(juegoEnlazado.jugadores[0],new Point((int)respuesta.getX(), (int)respuesta.getY()) );
            juegoEnlazado.currentGameState = GameState.MOVING;
            juegoEnlazado.changeTurn();
        } else if(juegoEnlazado.getGameState() == GameState.SELECT_CAPTURE_RED){
            respuesta = this.capturingBot();
            juegoEnlazado.capturarPieza(juegoEnlazado.jugadores[1], new Point((int)respuesta.getX(), (int)respuesta.getY()));
            juegoEnlazado.currentGameState = GameState.MOVING;
            juegoEnlazado.changeTurn();
        }
//        System.out.println(respuesta.x + "- "+ respuesta.y);
            juegoEnlazado = juegoEnlazado.selfCast();
    }

    public Point deployingBot(){
        while(true){
            int randRow = ThreadLocalRandom.current().nextInt(0, juegoEnlazado.tablero.getRows()-1);
            int randCol = ThreadLocalRandom.current().nextInt(0, juegoEnlazado.tablero.getColumns()-1);
            if (juegoEnlazado.tablero.getFicha(new Point(randRow,randCol)).esLinea(juegoEnlazado.tablero.getFicha(this.lastPointBot)) && juegoEnlazado.tablero.getFicha(new Point(randRow,randCol)).state == FichaState.EMPTY){
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
    public Point chooseOwnFichaBot(){
        Random randomGen = new Random();
        int index = randomGen.nextInt(this.juegoEnlazado.getPlayerTurn().fichasJugador.size()-1);
        this.lastCaptureBot=this.juegoEnlazado.getPlayerTurn().fichasJugador.get(index);
        return this.lastCaptureBot;
    }
    public Point capturingBot(){
        Random randomGen = new Random();
        int index = randomGen.nextInt(this.juegoEnlazado.getOpositivePlayerTurn().fichasJugador.size()-1);
        this.lastCaptureBot=this.juegoEnlazado.getOpositivePlayerTurn().fichasJugador.get(index);
        return this.lastCaptureBot;
    }


}
