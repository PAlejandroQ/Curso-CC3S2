package org.funcionalidad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroGUITest {

    @Test
    void TestTableroMarcado(){
        Juego game = new Juego();
        TableroGUI tableroGUI= new TableroGUI(game);
        TableroGUI.main(null);
        game.desplegarFicha(0,0);
        assertEquals(Juego.Cell.BLUE, game.getCell(0,0));
    }





}