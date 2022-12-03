package refactorizado;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.awt.*;

public class JugadorMaquina extends Jugador {
    GameState estadoBot;
    Point respuesta;
    Point lastPointBot;
    Point lastCaptureBot;
    ArrayList<Point> posicionesMovibles;
    public JugadorMaquina(int color, Juego juegoEnlazado){
        super(color, juegoEnlazado);
        estadoBot = GameState.DEPLOY;
        lastPointBot = new Point(0,0);
        posicionesMovibles = new ArrayList<Point>();
    }
    /*
    * Metodo que envia el flujo de datos*/
    public void eventClick(int row, int column) {

        if(this.juegoEnlazado.getGameState()!= GameState.SELECT_CAPTURE_RED && this.juegoEnlazado.getGameState() != GameState.SELECT_CAPTURE_BLUE) {
            if(this.juegoEnlazado instanceof  JuegoFase2){
                respuesta=chooseOwnFichaBot();
                this.juegoEnlazado.realizarMovimiento((int)respuesta.getX(), (int)respuesta.getY());
                respuesta=this.selectDestinoBot(respuesta);
                this.juegoEnlazado.realizarMovimiento((int)respuesta.getX(), (int)respuesta.getY());
            }else{
            respuesta = this.deployingBot();
            this.juegoEnlazado.realizarMovimiento((int)respuesta.getX(), (int)respuesta.getY());
            }
        }else if(juegoEnlazado.getGameState() == GameState.SELECT_CAPTURE_BLUE){
            respuesta = this.capturingBot();
            juegoEnlazado.capturarPieza(juegoEnlazado.jugadores[0],new Point((int)respuesta.getX(), (int)respuesta.getY()) );
            //juegoEnlazado.currentGameState = GameState.MOVING;
            //juegoEnlazado.changeTurn();
        } else if(juegoEnlazado.getGameState() == GameState.SELECT_CAPTURE_RED){
            respuesta = this.capturingBot();
            juegoEnlazado.capturarPieza(juegoEnlazado.jugadores[1], new Point((int)respuesta.getX(), (int)respuesta.getY()));
            //juegoEnlazado.currentGameState = GameState.MOVING;
            //juegoEnlazado.changeTurn();
        }
//        System.out.println(respuesta.x + "- "+ respuesta.y);
            juegoEnlazado = juegoEnlazado.selfCast();
    }

    public Point deployingBot(){
        while(true){
            int randRow = ThreadLocalRandom.current().nextInt( juegoEnlazado.tablero.getRows()-1);
            int randCol = ThreadLocalRandom.current().nextInt( juegoEnlazado.tablero.getColumns()-1);
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
        for(Point fichaBot : this.juegoEnlazado.getPlayerTurn().fichasJugador){
            if(this.casillasDisponiblesBot(fichaBot).size()>0){
                System.out.println(fichaBot.toString()+"-ADD");
                this.posicionesMovibles.add(fichaBot);
            }
        }

        Random randomGen = new Random();
        int index = randomGen.nextInt(this.posicionesMovibles.size()-1);
        this.lastCaptureBot=this.posicionesMovibles.get(index);
        this.posicionesMovibles.clear();
        return this.lastCaptureBot;
    }
    public Point capturingBot(){
        Random randomGen = new Random();
        int index = randomGen.nextInt(this.juegoEnlazado.getOpositivePlayerTurn().fichasJugador.size()-1);
        this.lastCaptureBot=this.juegoEnlazado.getOpositivePlayerTurn().fichasJugador.get(index);
        return this.lastCaptureBot;
    }
    public Point selectDestinoBot(Point piezaMoverBot){
        /*
        * Crear array de shinis, y que elija aleatoriamente un shiny para
        * */
        ArrayList<Point> posicionesPosibles = this.casillasDisponiblesBot(piezaMoverBot);
//        int randNeighbor = ThreadLocalRandom.current().nextInt(posicionesPosibles.size()-1);
        return posicionesPosibles.get(0);
    }
    public ArrayList<Point> casillasDisponiblesBot(Point piezaPropia){
        ArrayList<Point> casillasDisponibles = new ArrayList<Point>();
        for(Point vecino : this.juegoEnlazado.tablero.getFicha(piezaPropia).vecinos){
            if(this.juegoEnlazado.tablero.getFicha(vecino).state !=FichaState.RED && this.juegoEnlazado.tablero.getFicha(vecino).state !=FichaState.BLUE) // o una condicion por complemento
                casillasDisponibles.add(vecino);
        }
        return casillasDisponibles;
    }
}
