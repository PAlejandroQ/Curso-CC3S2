package org.funcionalidad;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {
    private Juego game;

    @BeforeAll
    public void setUpGeneral() throws Exception{
           TableroGUI tableroTest = new TableroGUI(new Juego());
//            TableroGUI.GameBoardCanvas.
    }

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
    @Test
    void checkMillInDeployment(){

    }

}