# Lista de preguntas final

## Introducción a la entrega continua

1. ¿Cuáles son las tres fases del proceso de entrega tradicional?

   * Desarrollo.- Los desarrolladores trabajan en el producto usualmente con tecnicas agiles como Scrum para incrementar la velocidad del desarrollo y la comunicación con el cliente. Se obtienen retroalimentaciones del cliente mediante sesiones de Demos del producto.
   * Pruebas de aceptación del usuario.- Congela el código para que ninguna modificación pudiera romper los test. Test de integración, de aceptación y análisis no funcionales son realizados.
   * Operaciones.- Usualmente la etapa más corta, involucra pasar el código al equipo de operaciones para que realicen el lanzamiento y monitoreen el entorno de producción. Si algo saliera mal, los desarrolladores son contactados para ayudar con la producción del sistema.

2. ¿Cuáles son las tres etapas principales de un pipeline de CD?

   * Integración continua.- Se asegura que el código que haya sido escrito por varios desarrolladores este integrado.
   * Pruebas de aceptación automatizadas.- Verifica si los requerimientos del cliente han sido satisfechos por las implementaciones de los desarrolladores.
   * Gestión de la configuración.- Configura el environment y despliega el software.

3. Menciona al menos tres beneficios de usar CD.

   * La configuración del CD pipeline es simple ya que todo es hecho dentro del equipo de desarrollo sin tener que pedirlo a los demás equipos.
   * Si alguno de los test de aceptación falla, se detiene el pipeline previniendo que el flujo de desplace a la las demás etapas.
   * Verifica las observaciones de calidad dentro del producto en vez de verificarlo despues.

4. ¿Cuáles son los tipos de pruebas que deben automatizarse como parte del pipeline de CD?

   * Pruebas de aceptación automatizadas.
   * Pruebas unitarias automatizadas.
   * Pruebas no funcionales.

5. ¿Deberíamos tener más pruebas de integración o unitarias? Explicar por qué.

   Basándonos en la piramide de testeo, debemos de tener más pruebas unitarias, ya que son las más rapidas y menos costosas, seguidas de pruebas de integración en menor cantidad ya que estos son más lentos y más caros crear.

6. ¿Qué significa el término DevOps?.

   Significa volver a las raices, es decir, que una sola persona o equipo es responsable de las 3 áreas mencionadas anteriormente. Este cambio es posible gracias a la automatización en el pipeline de entrega continua manejada por el equipo de desarrollo.

## Docker

1. ¿Cuál es la principal diferencia entre la creación de contenedores (como con Docker) y la
   virtualización (como con VirtualBox)?

   Las VM emulan la arquitectura de la computadora, por lo que tienen su propio sistema operativo, mientras que los contenedores comparten el sistema operativo del host manteniendo un aislamiento y dependencias propias.

2. ¿Cuáles son los beneficios de proporcionar una aplicación como una imagen de Docker? Nombra al menos dos.

   * Portabilidad, ya que es transportar todo el entorno completo en vez de solo código.
   * Aislamiento, de manera que cada aplicación y sus dependencias no afecta a las demás aplicaciones.
   * Environment, dado que todas las configuraciones necesarias se encuentran ya en el contenedor.

3. ¿Se puede ejecutar el demonio Docker de forma nativa en Windows y macOS?

   Docker Desktop proporciona una aplicación nativa, pero se ejecuta desde una VM ya que requiere de un kernel de Linux para operar como es WSL para windows.

4. ¿Cuál es la diferencia entre una imagen Docker y un contenedor Docker?

   Una imagen es un bloque construido sin estado, el cual puedes almacenar, enviar, nombrar y guardar como un archivo. Mientras que un contenedor es una instancia de una imagen con estado con la cual podemos interactuar y hacer cambios en sus estados.

5. ¿Qué significa cuando se dice que las imágenes de Docker tienen capas?

   Significa que una imagen puede reusar las capas de estructura de otras imagenes. Por ejemplo, la capa de abajo suele ser la del sistema operativo, luego se puede añadir una capa de un JDK, otra de git, etc, que seran usadas posteriormente en el caso que otras imágenes lo requieran.

6. ¿Cuáles son dos métodos para crear una imagen de Docker?

   * Docker commit.- Cuando modificamos un contenedor, y creamos una imagen a partir de ese nuevo estado.
   * Dockerfile.- Usando un lenguaje para espeificar las instrucciones a ejecutar al crear la imagen de Docker.

7. ¿Qué comando se usa para crear una imagen de Docker a partir de un Dockerfile?

   Docker build -t <nombreImagen> .

8. ¿Qué comando se usa para ejecutar un contenedor de Docker desde una imagen de Docker?

   Docker run

9. En la terminología de Docker,¿qué significa publicar un puerto?

   Significa exponer un camino a travez del cual el contenedor puede comunicarse con la máquina host, o con otros contenedores dentro de su misma subred de Dockers.

10. ¿Qué es un volumen Docker?

    Es el directorio del host del Docker montado dentro del contenedor, permitiendo que este escriba en el sistema de archivos del sistema como si lo estaría haciendo en el propio.

## Jenkins

1. ¿Se proporciona Jenkins en forma de imagen de Docker?
2. ¿Cuál es la diferencia entre un maestro de Jenkins y un agente de Jenkins (esclavo)?
3. ¿Cuál es la diferencia entre el escalado vertical y horizontal?
4. ¿Cuáles son las dos opciones principales para la comunicación maestro-agente al iniciar un
      agente Jenkins?
5. ¿Cuál es la diferencia entre configurar un agente permanente y un agente Docker permanente?
6. ¿Cuándo necesitarás crear una imagen de Docker personalizada para un agente de Jenkins?
7. ¿Cuándo necesitarás crear una imagen de Docker personalizada para un maestro de Jenkins?

## Pipelines

1. ¿Qué es un pipeline?
2. ¿Cuál es la diferencia entre un stage y un step en el pipeline?
3. ¿Qué es la sección post en el pipeline de Jenkins?
4. ¿Cuáles son las tres etapas más fundamentales del commit pipeline?
5. ¿Qué es un Jenkinsfile?
6. ¿Cuál es el propósito de la etapa de cobertura de código?
7. ¿Cuál es la diferencia entre los siguientes triggers de Jenkins: external y polling SCM ?
8. ¿Cuáles son los métodos de notificación de Jenkins más comunes? Nombra al menos tres.
9. ¿Cuáles son los tres flujos de trabajo de desarrollo más comunes?.

## Pruebas de aceptación automatizadas

1. ¿Qué es el Docker Registry?
2. ¿Qué es Docker Hub?
3. ¿Cuál es la convención para nombrar las imágenes de Docker
4. ¿Cuál es el entorno staging?
5. ¿Qué comandos de Docker usaría para crear una imagen y enviarla (push) a Docker Hub?
6. ¿Cuál es el objetivo principal de los frameworks de prueba de aceptación como Cucumber y
      FitNesse?
7. ¿Cuáles son las tres partes principales de una prueba de Cucumber?
8. ¿Qué es la aceptación TDD?

## Kubernetes

1. ¿Qué es un clúster de servidores?
2. ¿Cuál es la diferencia entre un plano de control de Kubernetes y un nodo de Kubernetes?
3. Menciona al menos tres plataformas en la nube que proporcionen un entorno de Kubernetes
listo para usar.
4. ¿Cuál es la diferencia entre una implementación y un servicio de Kubernetes?
5. ¿Cuál es el comando de Kubernetes para escalar implementaciones?
6. Nombre al menos dos sistemas de administración de clústeres que no sean Kubernetes.