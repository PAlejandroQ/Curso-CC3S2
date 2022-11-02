package org.funcionalidad;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


public class TableroVacioTest {
    private Juego game;

    @Before
    public void setUp() throws Exception {
        game=new Juego();
    }

    @After
    public void tearDown() throws Exception {
    }

    // Criterio de aceptacion 1.1 Tablero vacío

    @Test
    @DisplayName("Tablero vacio")
    public void testNewJuego() {
        int column=0;
        for (int row = 0; row<7; row++) {
            if(row==0 || row==6){
                for (column = 0; column<7; column+=3) {
                    assertEquals("", game.getCell(row, column), Juego.Cell.EMPTY);
                }
            }
            if(row==1 || row==5){
                for (column = 1; column<7; column+=2) {
                    assertEquals("", game.getCell(row, column), Juego.Cell.EMPTY);
                }
            }

            if(row==2 || row==4){
                for (column = 2; column<5; column++) {
                    assertEquals("", game.getCell(row, column), Juego.Cell.EMPTY);
                }
            }
            if(row==3){
                column=0;
               while(column!=3 && column<7){
                   assertEquals("", game.getCell(row, column), Juego.Cell.EMPTY);
                   column++;
               }
            }
        }
        assertEquals("",     game.getTurn(), 'X');
    }

}