# Respuestas de preguntas
## Pregunta 1 
Escribe el Javadoc del método calculateTax describiendo su contrato, en el código anterior.
Revisa el archivo TaxCalculator.java

```   
    /**  
     * Calcula el impuesto de acuerdo con el 18% de algún valor nominal
     *
     * @param value el valor nominal para el cálculo de impuestos. value >= 0.
     * @return el impuesto calculado. taxValue >= 0.
     */
```

## Pregunta 2 
Escribe una versión de TaxCalculator usando asserts para ello completa el archivo TaxCalculator1.java

Se recomienda acceder al archivo para ver el código completo, en este se usan los siguientes Asserts:

``assert value >= 0 : "El valor no puede ser negativo";``

``assert taxValue >= 0 : "El valor calculado no puede ser negativo";
``

## Pregunta 3 
¿puedes aplicar el mismo razonamiento a las postcondiciones?,¿como relacionas el siguiente
listado que devuelve un código de error en lugar de una excepción?


## Pregunta 4 
Escribe para el método add() sus pre/postcondiciones.

``assert product != null : "No puedes ingresar un producto vacío";``

``assert qtyToAdd > 0 : "La cantidad a agregar tiene que ser mayor a 0";``

``assert basket.containsKey(product) : "El producto no se encuentra en la cesta";``
## Pregunta 5 
Modelar otra postcondiciones aquí, como "el nuevo valor total debe ser mayor que el valor
total anterior". Usa la clase BigDecimal en lugar de un double. BigDecimals se recomienda siempre que
desees evitar problemas de redondeo que pueden ocurrir cuando usas doubles.

``assert (prev_totalValue.compareTo(this.totalValue) == -1) : "El valor total actual debe ser mayor al anterior valor" ;``

## Pregunta 6 
Escribe las pre/post condiciones del método remove().

``assert product != null : "El producto no puede ser nulo";``

``assert basket.containsKey(product) : "El producto tiene que estar registrado en la cesta";``

``assert !basket.containsKey(product) : "El producto no ha sido eliminado";``


## Pregunta 7 
Explica el siguiente listado de invariantes de la clase Basket
```
public class Basket {
    public void add(Product product, int qtyToAdd) {
        // ... method here ...
        assert totalValue.compareTo(BigDecimal.ZERO) >= 0 : "Total value can't be negative."
    }
    public void remove(Product product) {
        // ... method here ...
        assert totalValue.compareTo(BigDecimal.ZERO) >= 0 : "Total value can't be negative."
    }
}
```
Cada que un método manipule la variable totalValue tenemos que asegurarnos de que esta siga siendo positiva al final de cada método.

## Pregunta 8
¿Qué función tiene el método invariant() en el siguiente listado?
```
public class Basket {
    public void add(Product product, int qtyToAdd) {
        // ... method here ...
        assert invariant() :"Invariant does not hold";
    }
    public void remove(Product product) {
        // ... method here ...
        assert invariant() :"Invariant does not hold";
    }
    private boolean invariant() {
        return totalValue.compareTo(BigDecimal.ZERO) >= 0;
    }
}
```

En caso hubieran más métodos que manipulan totalValue, el método invariant() ayudará a que se reduzca la duplicación de código.
Así podremos asegurarnos de comprobar que el totalValue sea positivo después de cada método que lo use.
## Pregunta 9 
Sea la siguiente figura que el método de calculateTax() y otras tres clases (imaginarias) que
lo usan. Cuando se crearon estas clases, conocían las precondiciones del calculateTax () en ese punto:
"value debe ser mayor o igual a 0".
## Pregunta 10
Explica qué sucede si cada una de las clases hijas se asigna a la clase cliente: