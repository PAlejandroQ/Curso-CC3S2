package refactorizado;

import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class HumanVsHumanDeployTest {
    private JuegoFase1 game;

    @BeforeEach
    void setUp() {
        game = new JuegoFase1(false);
    }

    @AfterEach
    void tearDown() {
    }
    @Nested
    class DespliegueAzulTest{
        @Test
        void testDespliegueAzulValido(){
            assertEquals("",'X', game.getTurn());
            game.desplegarFicha(0, 0);
            assertAll(
                    () -> assertEquals("", GameState.DEPLOY, game.getGameState()),
                    () -> assertEquals("", FichaState.BLUE, game.tablero.piezasTablero[0][0].state)
            );
            game.selfCast();
            assertEquals("", 'O', game.getTurn());

        }

        @Test
        void testDespliegueAzulOcupado(){
            assertEquals("", game.getGameState(), GameState.DEPLOY);
            game.jugadores[0].eventClick(0,0);
            assertEquals("",game.tablero.piezasTablero[0][0].state, FichaState.BLUE);
            game.jugadores[0].eventClick(3,0);
            assertEquals("",game.tablero.piezasTablero[3][0].state, FichaState.RED);

            Throwable throwable = assertThrows(IllegalArgumentException.class, () -> game.desplegarFicha(3,0));
            Assertions.assertEquals("Out of bound of the table or not empty", throwable.getMessage());
            assertEquals("", 'X', game.getTurn());
        }

        @Test
        void testDespliegueAzulFueraTablero(){
            Throwable throwable = assertThrows(IllegalArgumentException.class, () -> game.jugadores[0].eventClick(0,9));
            Assertions.assertEquals("Out of bound of the table or not empty", throwable.getMessage());
        }
    }

    @Nested
    class DespliegueRojoTest{
        @Test
        void testDespliegueRojoValido(){
            game.selfCast();
            assertEquals("",'O', game.getTurn());
            game.desplegarFicha(0, 0);
            assertAll(
                    () -> assertEquals("", GameState.DEPLOY, game.getGameState()),
                    () -> assertEquals("", FichaState.RED, game.tablero.piezasTablero[0][0].state)
            );
            game.selfCast();
            assertEquals("", 'X', game.getTurn());

        }

        @Test
        void testDespliegueRojoOcupado(){
            game.selfCast();
            assertEquals("", game.getGameState(), GameState.DEPLOY);
            game.desplegarFicha(0,0);
            assertEquals("", FichaState.RED, game.tablero.piezasTablero[0][0].state);
            game.selfCast();
            game.desplegarFicha(3,0);
            assertEquals("", FichaState.BLUE, game.tablero.piezasTablero[3][0].state);
            game.selfCast();
            Throwable throwable = assertThrows(IllegalArgumentException.class, () -> game.desplegarFicha(3,0));
            Assertions.assertEquals("Out of bound of the table or not empty", throwable.getMessage());
            assertEquals("", 'O', game.getTurn());
        }

        @Test
        void testDespliegueRojoFueraTablero(){
            game.selfCast();
            assertEquals("", game.getTurn(), 'O');
            Throwable throwable = assertThrows(IllegalArgumentException.class, () -> game.desplegarFicha(0,9));
            Assertions.assertEquals("Out of bound of the table or not empty", throwable.getMessage());

        }

    }

    @Nested
    class MillFormationsTest{
        @Test
        void millAzulTest(){
            game.jugadores[0].eventClick(0,0);
            game.jugadores[1].eventClick(1,1);

            game.jugadores[0].eventClick(0,3);
            game.jugadores[1].eventClick(1,3);

            game.jugadores[0].eventClick(0,6);
            game.jugadores[0].eventClick(1,1);

            assertEquals("", FichaState.EMPTY, game.tablero.piezasTablero[1][1].state);
            assertEquals("", 'O', game.getTurn());

        }
        @Test
        void millRojoTest(){
            game.jugadores[0].eventClick(1,1);
            game.jugadores[1].eventClick(0,0);

            game.jugadores[0].eventClick(1,3);
            game.jugadores[1].eventClick(0,3);

            game.jugadores[0].eventClick(3,0);

            game.jugadores[1].eventClick(0,6);
            game.jugadores[1].eventClick(1,1);

            assertEquals("", FichaState.EMPTY, game.tablero.piezasTablero[1][1].state);
            assertEquals("", 'X', game.getTurn());

        }

    }

}