package org.funcionalidad;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AzulMovimientosTest {
    private final Juego game=new Juego();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    void makeMove() {
    }

    @Test
    void moverFicha() {
    }
    //AC 2.1 Posicionamiento de despliegue válido
    @Test
    void testDespliegueAzulValido(){
        game.makeMove(0, 0);
        assertEquals("",game.getGameState(),Juego.GameState.DEPLOY);
        assertEquals("", game.getCell(0, 0), Juego.Cell.BLUE);
        assertEquals("", game.getTurn(), 'O');
    }
    // AC 2.2  Posicionamiento de despliegue inválido en una celda ocupada
    @Test
    void testDespliegueAzulOcupado(){
        assertEquals("",game.getGameState(),Juego.GameState.DEPLOY);
        game.makeMove(0, 0);
        game.makeMove(3, 0);
        assertEquals("", game.getCell(3, 0), Juego.Cell.RED);
        assertEquals("", game.getTurn(), 'X');
        game.makeMove(0, 0);
        assertEquals("", game.getTurn(), 'X');

    }
    // AC 2.3  Posicionamiento de despliegue inválido fuera del tablero
    @Test
    void testDespliegueAzulFueraTablero(){
        assertEquals("",game.getGameState(),Juego.GameState.DEPLOY);
        game.makeMove(0, 9);
        assertEquals("", game.getTurn(), 'X');
    }


}