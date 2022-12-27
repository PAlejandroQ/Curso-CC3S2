# Practica calificada 4

Link al repositorio usado para la parte 4:

https://github.com/PAlejandroQ/calculador

## Pregunta 1

* ¿Se necesita la infraestructura SOA para integrar los dos nuevos servicios?

  Si, ya que pese a que se necesitara una nueva implementación, esos servicios igual necesitaran de la infraestructura SOA. Esto se ve, en la Orchestration & Integration, el cual usara estos 2 nuevos servicios para trabajar en conjunto con los ya existentes.

* El servicio de evaluación de campañas necesita manejar una gran cantidad de datos. ¿Sería mejor utilizar la replicación de datos, la integración a nivel de interfaz de usuario o las
  llamadas de servicio para acceder a grandes cantidades de datos?

  Al tratarse de grandes cantidades de datos, la replicación no seria una buena opción, ya que se tendria más datos de los necesarios.En la integración a nivel de interfaz se busca ensamblar todo en un framework, pero para acceder a grandes datos, es mejor que cada servicio lo haga de manera independiente. Por ello seria mejor las llamadas de servicios.

* ¿Cuál de estas opciones de integración suele ofrecer SOA?

  Suele ofrecer:

  * Integracion de Web Service Provider
  * Integracion de Web service Consumer
  * Notificaciones de eventos.

* ¿Debe el servicio integrarse al portal existente o tener su propia interfaz de usuario?

  El servicio debe integrarse al existente, ya que cada vez que el portal lo necesite, accedera a este de manera semejante como se lo haría a una API.

* ¿Cuáles son los argumentos a favor de cada opción?

  Una interfaz permite a dos diferentes sistemas hablar mutuamente, sin sincronizar datos en tiempo real. Por otro lado, una integración hara que funcionaran de manera coordinada como piezas de un reloj.

* ¿Deberías implementar la nueva funcionalidad, el equipo de CRM?

  Si, ya que respeta la estructura seguida de independencia de servicios, agregandole su interfaz propia para que no necesite estar sincronizado con los demas servicios.

## Pregunta 2

1. En un sistema basado en microservicios puede haber diferentes tipos de comunicación; sin embargo, debe haber un tipo de comunicación predominante.¿Cuál escogerías?¿Qué otros están permitidos además?¿En qué situaciones?

   RESTful Web API como predominante ya que permitiria una baja latencia, y de hecho, es el primero que se viene a la mente cuando alguien piensa enc comunicació de microservicios.

   Streaming integration, podria ser tambien porque permitiria una comunicacion asincronita usando un sistema de colas de mensajes, que a diferencia del Messaging integration, mantiene los mensajes aun luego de haber sido consumidos por los microservicos sirviendo tambien como un almacenamiento.

   Por otro lado, estan permitidos los de messagin Integration, los de RPC Integration y RESTful Web API.

   Los Streaming y Messagin integration son  especialmente para servicios que podrian tener muchas llamadas pero que no necesiten unar respuesta inmedita, por lo que un sistema de colas vendria bien.

2. ¿Utilizarías la replicación de datos en un sistema basado en microservicios?¿En qué áreas?¿Cómo lo implementarías?

   Si lo utilizaría, en la área de las bases de datos a las que los microservicios acceden. De manera que cada servicio tiene una copia parcial de la base de datos principal donde usara únicamente lo que necesita. Puede aplicarse en diversas áreas, agrupando servicios semejantes, para que trabajen con  sus respectivas bases de datos duplicadas parciales

## Pregunta 3 

![image-20221222105126064](PC4.assets/image-20221222105126064.png)

Se intento compilarlo directamente desde la terminal en entorno de linux, pero esto causaba multiples errores, por lo que se lo compilo con IntelliJ.

![image-20221227114510653](PC4.assets/image-20221227114510653.png)

Posteriormente se intento ejecutar el comando `vagrant up`  dentro del otro repositorio entregado, pero no identificaba la ruta para la ejecución.

![image-20221227112256826](PC4.assets/image-20221227112256826.png)

Siguiendo varios post semejantes de este problema, se hicieron las configuraciones respectivas en los archivos indicados, pero el problema persistió.

![image-20221227112330722](PC4.assets/image-20221227112330722.png)

## Pregunta 4

### Completa las actividades 21 y 22 del curso. Muestra cada uno de los pasos seguidos.

1. Un Hello World de varias etapas introductorio.

   ![image-20221222092453772](PC4.assets/image-20221222092453772.png)
   
   Creación de un primer pipeline de prueba para familiarizarse con la interfaz.

![image-20221222092538710](PC4.assets/image-20221222092538710.png)

Creación de primer pipeline con 2 etapas.

### Sintaxis del pipeline

![image-20221222093514676](PC4.assets/image-20221222093514676.png)

![image-20221222093558355](PC4.assets/image-20221222093558355.png)

Ejecución de pipeline con comandos diversos para validar su funcionamiento.

![image-20221225173203693](PC4.assets/image-20221225173203693.png)

### Checkout

![image-20221222095122179](PC4.assets/image-20221222095122179.png)

Creación de un pipeline que consulta un repositorio creado específicamente para este propósito, cada vez que se haga el Build, el pipeline extraerá el código del repositorio localmente,

![image-20221222095041894](PC4.assets/image-20221222095041894.png)



### Creación de un proyecto Java Spring Boot![image-20221222100024199](PC4.assets/image-20221222100024199.png)

Generación de la estructura básica del proyecto con gradle. Se tuvo que experimentar con todas las versiones, 17, 11 y 8 ya que en los pasos anteriores hubieron muchos problemas con la version de java inclusive usando la version 8. Por lo que los pasos posteriores fueron rehechos desde este paso almenos unas 4 veces. Al ver que no funcionaba, se cambio de docker Jenkins con uno con version de java 17.

![image-20221222100207045](PC4.assets/image-20221222100207045.png)

Clonación del repositorio.

![image-20221225184209714](PC4.assets/image-20221225184209714.png)

Compilación del proyecto de manera local mediante el `./gradlew`

![image-20221222101403908](PC4.assets/image-20221222101403908.png)

Primer intento con Maiven, ocurrieron multiples errores, tanto de versiones, como en la ejecución de los demas pasos, por lo que se cambio al uso de gradle.

![image-20221222101517569](PC4.assets/image-20221222101517569.png)

Subir proyecto al repositorio.

![image-20221222104745187](PC4.assets/image-20221222104745187.png)

Multiples errores presentados

![image-20221222104806831](PC4.assets/image-20221222104806831.png)

> Luego de muchos intentos probando varias cosas se consiguió que compile pero usando un docker para jenkins con java 17 y con gradle.
>
> ![image-20221225222335210](PC4.assets/image-20221225222335210.png)

![image-20221225222300625](PC4.assets/image-20221225222300625.png)

![image-20221225222435872](PC4.assets/image-20221225222435872.png)

Añadiendo una etapa de compilación.



![image-20221226142838943](PC4.assets/image-20221226142838943.png)

Añadiendo una etapa de tests.

![image-20221226142820087](PC4.assets/image-20221226142820087.png)

Verificando que el proyecto compile y pase los tests.



![image-20221226144915219](PC4.assets/image-20221226144915219.png)

Añadiendo el JenkinsFile para no ser necesaria una configuracion desde el mismo jenkins.

![image-20221226152304482](PC4.assets/image-20221226152304482.png)

### Actividad 22

![image-20221226184924074](PC4.assets/image-20221226184924074.png)

Añadir Jacoco como dependencia.

![image-20221226184909968](PC4.assets/image-20221226184909968.png)

Verificar funcionamiento de los testeos con cobertura de código.

![image-20221226185111641](PC4.assets/image-20221226185111641.png)

Reporte de c de covertura de código Jacoco.

![image-20221226185254758](PC4.assets/image-20221226185254758.png)

![image-20221226191409498](PC4.assets/image-20221226191409498.png)

Verificando funcionamiento de nueva etapa de cobertura de código.

![image-20221226193752933](PC4.assets/image-20221226193752933.png)



Añadiendo pruebas de analisis de codigo estatico.

![image-20221226195331781](PC4.assets/image-20221226195331781.png)

Verificando que la nueva etapa se agrege correctamente.



![image-20221226211719539](PC4.assets/image-20221226211719539.png)

Añadiendo un trigger que cada minuto verifique si hubo algun commit en el repo para automaticamente iniciar el pipeline.

![image-20221226212151195](PC4.assets/image-20221226212151195.png)

Verificación de funcionamiento de esta nueva etapa.



![image-20221226222042502](PC4.assets/image-20221226222042502.png)



Notificación via correo electronico de las compilaciones a los desarrolladores.

![image-20221226224745164](PC4.assets/image-20221226224745164.png)

Especificación de los correos que recibiran las modificaciones.

![image-20221226224820102](PC4.assets/image-20221226224820102.png)

Comprobación de correo recibido de compilación.



![image-20221227084641443](PC4.assets/image-20221227084641443.png)

Configuraciones de los mensajes enviados tanto por correo como al grupo de slack asignado

![image-20221227084350513](PC4.assets/image-20221227084350513.png)

Verificación que el jenkins esta conectado al grupo y puede informar de reportes de errores.

![image-20221227085702167](PC4.assets/image-20221227085702167.png)



Verificando que todo funcione bien con las nuevas actualizaciones.

![image-20221227091808774](PC4.assets/image-20221227091808774.png)

Añadiendo pipeline con gestor de ramas.

![image-20221227091958724](PC4.assets/image-20221227091958724.png)



Creando una nueva rama y subiendola al repositorio para verificar su funcionamiento.

![image-20221227092218755](PC4.assets/image-20221227092218755.png)

Verificando que el pipeline detecta las nuevas ramas automáticamente dentro de un intervalo de un minuto.
