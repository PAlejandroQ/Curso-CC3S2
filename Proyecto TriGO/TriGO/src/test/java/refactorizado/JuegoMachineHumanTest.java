package refactorizado;


import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;


class JuegoMachineHumanTest {

    private JuegoFase1 game;

    @BeforeEach
    void setUp() {
        game = new JuegoFase1(true);
    }

    @AfterEach
    void tearDown() {
    }

    @Nested
    class DespliegueHumanoTest{
        @Test
        void testDespliegueAzulValido(){
            assertEquals("", game.jugadores[0].juegoEnlazado.getTurn(), 'X');
            game.desplegarFicha(0, 0);
            assertEquals("", game.getGameState(), GameState.DEPLOY);
            assertEquals("", game.tablero.piezasTablero[0][0].state, FichaState.BLUE);
            game.selfCast();
            assertEquals("", game.jugadores[0].juegoEnlazado.getTurn(), 'O');
        }

    }

    @Nested
    class DespliegueMaquinaTest{
        @Test
        void testDespliegueMaquina(){
            int column;
            boolean isOnTable = false;
            game.jugadores[0].eventClick(0,0);
            assertEquals("", 'O', game.getTurn());
            game.jugadores[1].eventClick(0,0);

            for (int row = 0; row<7; row++) {
                if(row==0 || row==6){
                    for (column = 0; column<7; column+=3) {
                        if (game.tablero.piezasTablero[row][column].state == FichaState.RED){
                            System.out.println(row+" "+column);
                            isOnTable = true; break;
                        }
                    }
                }
                if(row==1 || row==5){
                    for (column = 1; column<7; column+=2) {
                        if (game.tablero.piezasTablero[row][column].state == FichaState.RED){
                            System.out.println(row+" "+column);
                            isOnTable = true; break;
                        }
                    }
                }

                if(row==2 || row==4){
                    for (column = 2; column<5; column++) {
                        if (game.tablero.piezasTablero[row][column].state == FichaState.RED){
                            System.out.println(row+" "+column);
                            isOnTable = true; break;
                        }
                    }
                }
                if(row==3){
                    column=0;
                    while(column!=3 && column<7){
                        if (game.tablero.piezasTablero[row][column].state == FichaState.RED){
                            System.out.println(row+" "+column);
                            isOnTable = true; break;
                        }
                        column++;
                    }
                }
            }
            assertEquals("",true, isOnTable);
            assertEquals("", 'X', game.getTurn());

        }
    }

}