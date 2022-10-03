# Pregunta 6

## Responde las siguientes preguntas

### ¿Qué puedes decir de las siguientes declaraciones ?

1. El diagrama también debe mostrar una dependencia de SuperAwesomeApp en SuperFastList, ya que una clase no puede depender solo de una interfaz y debe tener acceso a la implementación.

   Incorrecto, ya que por principios SOLID se debe buscar evitar esa dependencia, y de hecho esa es la razón que se realice ese desacople. Por otra parte, no es necesario tener acceso a la implementación, si es que ya se pueden acceder a sus métodos y atributos a través de la interfaz.

2. SuperFastList depende de SuperFastCollection porque lo implementa, y un cambio en la interfaz probablemente implica un cambio en la clase.

   Correcto, ya que si por ejemplo se modificara el tipo de dato de un parametro, tambien se tendria que cambiar su metodo correspondiente de la clase al que hacia referencia para asi seguir haciendo accesible ese metodo a travez de la interfaz.

3. Si este diagrama es correcto, no se puede crear una instancia de SuperFastList dentro de SuperAwesomeApp, pero se puede pasar un objeto de tipo SuperFastList a SuperAwesomeApp.

### Jessica quiere tu opinión

1. Sería deseable reemplazar SuperFastCollection por java.util.List si es posible.

   Si seria deseable, **si y solo si** SuperFastCollection no posee algun método que no este implementado tambien en java.util.List, puesto que como la interfaz es correctamente implementada en ambos casos, no se notaria la diferencia desde la misma interfaz. Además al ser una clase propia de Java, se garantizaría una mayor fiabilidad sin la necesidad de añadir código adicional.

2. **No será posible reemplazar SuperFastCollection por java.util.List si SuperFastCollection contiene métodos adicionales que no están en java.util.List**

   Es correcto, ya que de darse el caso, ocurrirían errores al llamarse a esos métodos a través de la interfaz, al no haber sido implementados en ningun lugar previamente.

3. Puede que no sea posible reemplazar SuperFastCollection por java.util.List, porque SuperAwesomeApp puede llamar a métodos que no pertenecen a java.util.List

   Caso en el cual habrian errores.

4. Puede que no sea posible reemplazar SuperFastCollection por java.util.List, porque SuperFastList puede contener métodos que no pertenecen a java.util.List

   Este caso seria poco probable, ya que de no necesitar a SuperFastCollection hubiera usado las clases de java.util.List directamente.

Por tanto mi opinión es que no será posible reemplazar la clase SuperFastCollection  por  java.util.List ya que esta debe  poseer métodos especializados para su proyecto que java.util.List no poseerá y quedaran sin implementar para la interfaz.

### Para que SuperAwesomeApp llame a este nuevo método,¿cuál debe ser el tipo declarado/tipo de tiempo de ejecución del parámetro?

1.  SuperFastCollection / SuperFastList
2. **SuperFastCollection / ExtraSuperFastList**
3. SuperFastList / ExtraSuperFastList
4. ExtraSuperFastList / ExtraSuperFastList

Para acceder a este metodo se lo haria a travez de la interfaz SuperFastCollection la cual buscaria su implementacion en la clase ExtraSuperFastList.