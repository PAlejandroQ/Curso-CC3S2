# Pregunta 3

## ¿Cuáles de las siguientes afirmaciones sobre la herencia son correctas?. Explica tu respuesta.

1. Una clase puede extender directamente cualquier número de clases.

   Es correcto, pues una clase puede heredar a cualquier numero de clases. Prueba de ello es que cualquier clase de Java que creemos, de por si ya es una extensión de la clase `Object` proveniente de `java.lang.Object` que extendemos todo el tiempo.

2. Una clase puede implementar cualquier número de interfaces.

   Es correcto, ya que una interfaz es como una plantilla para la construcción de clases que contiene las cabeceras de métodos sin implementar, por lo que da la libertad de implementar múltiples interfaces para una misma clase.

3. Todas las variables heredan java.lang.Object.

   Incorrecto, ya que las variables heredan de `java.lang` el cual contiene a los boleanos, double, float, integer, string, etc, y no de `java.lang.Object` el cual esta destinado a la creación de clases.

4. Si la clase A se extiende por B, entonces B es una superclase de A.

   Falso, dado que al decir que A se extiende por B, significa que A esta heredando a B pues B extiende a A. Es decir, A es una superclase de B y no alrevez.

5. Si la clase C implementa la interfaz D, entonces C es un subtipo de D.

   Incorrecto, pues las clases pertenecen a una jerarquía de clases, mientras que una interfaz **no**, por tanto puede darse el caso que clases sin relación de herencia posean la misma interfaz implementada, contradiciendo el hecho que C sea un subtipo de D solamente por ser su interfaz.

6. La herencia múltiple es la propiedad de una clase de tener múltiples superclases directas.

   Es correcto, tal como el caso de una clase de `ProfesorUniversitario` que herede de la clase `Investigador` y de `Profesor` al mismo tiempo. Esto es es posible en Python, pero no en Java, aunque esta permite la creación de interfaces que simulan herencias múltiples.