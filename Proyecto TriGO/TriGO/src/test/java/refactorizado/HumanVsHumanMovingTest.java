package refactorizado;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanVsHumanMovingTest {
    private Juego game = new JuegoFase1(false);
    @Test
    void movingTest(){
        game.jugadores[0].eventClick(0,3);
        game.jugadores[1].eventClick(0,0);

        game.jugadores[0].eventClick(0,6);
        game.jugadores[1].eventClick(2,3);

        game.jugadores[0].eventClick(3,2);
        game.jugadores[1].eventClick(2,4);

        game.jugadores[0].eventClick(3,4);
        game.jugadores[1].eventClick(3,1);

        game.jugadores[0].eventClick(3,5);
        game.jugadores[1].eventClick(3,6);

        game.jugadores[0].eventClick(4,2);
        game.jugadores[1].eventClick(4,3);

        game.jugadores[0].eventClick(4,4);
        game.jugadores[1].eventClick(5,3);

        game.jugadores[0].eventClick(5,1);
        game.jugadores[1].eventClick(6,0);

        game.jugadores[0].eventClick(5,5);
        game.jugadores[1].eventClick(6,6);
        game = game.selfCast();
        assertEquals('X', game.getTurn());
        assertEquals(GameState.MOVING, game.getGameState());
        game.jugadores[0].eventClick(3,2);
        game.jugadores[0].eventClick(2,2);
        assertEquals('O', game.getTurn());

        game.jugadores[1].eventClick(5,3);
        game.jugadores[1].eventClick(6,3);
        assertEquals('O', game.getTurn());
        game.jugadores[1].eventClick(0,3);

        assertEquals(FichaState.EMPTY, game.tablero.piezasTablero[0][3].state);
        assertEquals(FichaState.RED, game.tablero.piezasTablero[6][3].state);
        System.out.println(game.getGameState());
        assertEquals(GameState.MOVING, game.getGameState());

    }

}