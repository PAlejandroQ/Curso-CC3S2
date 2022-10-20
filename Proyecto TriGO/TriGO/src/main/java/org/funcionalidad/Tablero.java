package org.funcionalidad;

public class Tablero {
    int[] posiciones;
    Tablero()
    {
        posiciones = new int[24];
    }
    public int estadoPosicion(int i)
    {
        return posiciones[i];
    }
}
