package org.funcionalidad;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {

    @org.junit.jupiter.api.Test
    void getTotalRows() {
        Juego game = new Juego();
        assertEquals(7, game.getTotalRows());
    }

    @org.junit.jupiter.api.Test
    void getTotalColumns() {
        Juego game = new Juego();
        assertEquals(7, game.getTotalColumns());
    }

    @org.junit.jupiter.api.Test
    void getCellvalid() {
        Juego game = new Juego();
        assertEquals(Juego.Cell.EMPTY, game.getCell(0,0));
    }

    @org.junit.jupiter.api.Test
    void getCellnull(){
        Juego game = new Juego();
        assertEquals(null, game.getCell(8,8));
    }

    @org.junit.jupiter.api.Test
    void getTurn() {
        Juego game = new Juego();
        assertTrue(game.getTurn() == 'X' || game.getTurn()=='O');
    }

    @org.junit.jupiter.api.Test
    void getGameState() {
        Juego game = new Juego();
        assertTrue(game.getGameState() instanceof Juego.GameState);
    }

}