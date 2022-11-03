package org.funcionalidad;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class DespliegueRojoTest {
    private Juego game;

    @BeforeEach
    public void setUp() throws Exception {
        game=new Juego();
    }

    @After
    public void tearDown() throws Exception {
    }

    //AC 3.1 Posicionamiento de despliegue rojo válido
    @Test
    void testDespliegueRojoValido(){
        game.desplegarFicha(0, 3);
        game.desplegarFicha(0,0);
        assertEquals("",game.getGameState(),Juego.GameState.DEPLOY);
        assertEquals("", game.getCell(0, 0), Juego.Cell.RED);
        assertEquals("", game.getTurn(), 'X');
    }

    //AC 3.2  Posicionamiento de despliegue rojo  inválido en una celda ocupada
    @Test
    void testDespliegueRojoOcupado(){
        assertEquals("",game.getGameState(),Juego.GameState.DEPLOY);
        game.desplegarFicha(3, 0);
        game.desplegarFicha(3, 0);
        assertEquals("", game.getCell(3, 0), Juego.Cell.BLUE);
        assertEquals("", game.getTurn(), 'O');
    }

    // AC 3.3  Posicionamiento de despliegue rojo inválido fuera del tablero
    @Test
    void testDespliegueRojoFueraTablero(){
        game.desplegarFicha(0,0);
        assertEquals("",game.getGameState(),Juego.GameState.DEPLOY);
        game.desplegarFicha(0, 9);
        assertEquals("", game.getTurn(), 'O');
    }
}