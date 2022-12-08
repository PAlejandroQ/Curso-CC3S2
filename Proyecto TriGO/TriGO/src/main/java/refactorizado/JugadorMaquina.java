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

        if(this.juegoEnlazado.getGameState() != GameState.SELECT_CAPTURE_RED && this.juegoEnlazado.getGameState() != GameState.SELECT_CAPTURE_BLUE) {
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

        } else if(juegoEnlazado.getGameState() == GameState.SELECT_CAPTURE_RED){
            respuesta = this.capturingBot();
            juegoEnlazado.capturarPieza(juegoEnlazado.jugadores[1], new Point((int)respuesta.getX(), (int)respuesta.getY()));

        }
            juegoEnlazado = juegoEnlazado.selfCast();
    }

    public Point deployingBot(){
        int maxIter=0;
        while(true){
            int randRow = ThreadLocalRandom.current().nextInt( 50) % juegoEnlazado.tablero.getColumns();
            int randCol = ThreadLocalRandom.current().nextInt( 50) % juegoEnlazado.tablero.getColumns();
            if (juegoEnlazado.tablero.getFicha(new Point(randRow,randCol)).esLinea(juegoEnlazado.tablero.getFicha(this.lastPointBot)) && juegoEnlazado.tablero.getFicha(new Point(randRow,randCol)).state == FichaState.EMPTY){
                this.lastPointBot = new Point(randRow,randCol);
                break;
            }
            maxIter++;
            if(maxIter > 50) {
                if (juegoEnlazado.tablero.getFicha(new Point(randRow,randCol)).state == FichaState.EMPTY || juegoEnlazado.tablero.getFicha(new Point(randRow,randCol)).state == FichaState.SHINY){
                    this.lastPointBot = new Point(randRow,randCol);
                    break;
                }
            }

        }
        return this.lastPointBot;
    }
    public Point chooseOwnFichaBot(){
        for(Point fichaBot : this.juegoEnlazado.getPlayerTurn().fichasJugador){
            if(this.casillasDisponiblesBot(fichaBot).size()>0){
                System.out.println(fichaBot.toString()+"-ADD");
                this.posicionesMovibles.add(fichaBot);
            }
        }
        if(this.posicionesMovibles.isEmpty()) {
            this.juegoEnlazado.winForNotBeingAbleToMove();
            return this.lastCaptureBot;
        }
        Random randomGen = new Random();
        int index = randomGen.nextInt(50) % this.posicionesMovibles.size();
        this.lastCaptureBot = this.posicionesMovibles.get(index);
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
        * Crear array de shynis, y que elija aleatoriamente un shiny para
        * */
        if(!this.IS_FLYING){
            ArrayList<Point> posicionesPosibles = this.casillasDisponiblesBot(piezaMoverBot);
            this.lastPointBot = posicionesPosibles.get(0);
            return this.lastPointBot;
        }else{
            return this.deployingBot();
        }

    }
    public ArrayList<Point> casillasDisponiblesBot(Point piezaPropia){
        ArrayList<Point> casillasDisponibles = new ArrayList<Point>();

        for(Point vecino : this.juegoEnlazado.tablero.getFicha(piezaPropia).vecinos){
            if(this.juegoEnlazado.tablero.getFicha(vecino).state != FichaState.RED && this.juegoEnlazado.tablero.getFicha(vecino).state != FichaState.BLUE) // o una condicion por complemento
                casillasDisponibles.add(vecino);
        }
        return casillasDisponibles;
    }
}
