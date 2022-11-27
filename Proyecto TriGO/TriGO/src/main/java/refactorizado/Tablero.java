package refactorizado;

public class Tablero {
    int[] posiciones;
    Tablero(int Nposiciones)
    {
        posiciones = new int[Nposiciones];
    }
    public int estadoPosicion(int i)
    {
        return posiciones[i];
    }
}
