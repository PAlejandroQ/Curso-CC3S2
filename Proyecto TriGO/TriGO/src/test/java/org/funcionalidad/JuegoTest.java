package org.funcionalidad;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {
    private Juego game;
    private TableroGUI tableroTest;


    @BeforeEach
    public void setUp() throws Exception {
        game=new Juego();

    }
    @Test
    void getTotalRows() {
        assertEquals(7, game.getTotalRows());
    }

    @Test
    void getTotalColumns() {
        assertEquals(7, game.getTotalColumns());
    }

    @Test
    void getCellvalid() {
        assertEquals(Juego.Cell.EMPTY, game.getCell(0,0));
    }

    @Test
    void getCellnull(){
        assertEquals(null, game.getCell(8,8));
    }

    @Test
    void getTurn() {
        assertTrue(game.getTurn() == 'X' || game.getTurn()=='O');
    }

    @Test
    void getGameState() {
        assertTrue(game.getGameState() instanceof Juego.GameState);
    }

    //AC 5.1 Retiro común al detectar un tres en raya azul recién armado
    @Test
    void testCapturaAzul(){
        game.desplegarFicha(0,0);//B
        game.desplegarFicha(1,1);
        game.desplegarFicha(0,3);//B
        game.desplegarFicha(1,3);
        assertEquals("", game.getTurn(), 'X');
        game.desplegarFicha(0,6);//B
        assertEquals("", game.getGameState(), Juego.GameState.SELECT_CAPTURE_RED);
        game.capturarPieza(game.jugadores[1],new Point(1,1));
        assertEquals("", game.getCell(1, 1), Juego.Cell.EMPTY);
        assertEquals("", game.getTurn(), 'O');
    }

    //AC 6.1 Retiro común al detectar un tres en raya rojo recién armado
    @Test
    void testCapturaRojo(){
        game.desplegarFicha(1,1);
        game.desplegarFicha(0,0);//R
        game.desplegarFicha(2,2);
        game.desplegarFicha(0,3);//R
        game.desplegarFicha(3,0);//B
        assertEquals("", game.getTurn(), 'O');
        game.desplegarFicha(0,6);//R
        assertEquals("", game.getGameState(), Juego.GameState.SELECT_CAPTURE_BLUE);
        game.capturarPieza(game.jugadores[0],new Point(1,1));
        assertEquals("", game.getCell(1, 1), Juego.Cell.EMPTY);
        assertEquals("", game.getTurn(), 'X');
    }

}