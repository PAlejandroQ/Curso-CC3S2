# Práctica calificada 4

## Completar actividades 23 y 24:

### Actividad 23

#### Docker registry

Docker Registry funcionando con las credenciales.

![image-20230102175257028](README.assets/image-20230102175257028.png)

![image-20230102175516853](README.assets/image-20230102175516853.png)

![image-20230102180005787](README.assets/image-20230102180005787.png)

#### Docker Push

![image-20230102181444913](README.assets/image-20230102181444913.png)

![image-20230102181546126](README.assets/image-20230102181546126.png)

![image-20230102182413107](README.assets/image-20230102182413107.png)

### Pruebas de aceptación en el pipeline de Jenkins

![image-20230102184311833](README.assets/image-20230102184311833.png)

Añadiendo las nuevas etapas al pipeline en Jenkinsfile:

![image-20230102190327680](README.assets/image-20230102190327680.png)

### Etapa de prueba de aceptacion

![image-20230102191750680](README.assets/image-20230102191750680.png)

![image-20230103000510666](README.assets/image-20230103000510666.png)

![image-20230102235543315](README.assets/image-20230102235543315.png)

Creación de los criterios de aceptación:

![image-20230103000744156](README.assets/image-20230103000744156.png)

Creacion de enlaces para que la especificacion de caracteristicas sea ejecutable.

![image-20230103001051764](README.assets/image-20230103001051764.png)

Configuraciones del gradle.build:

![image-20230103001243645](README.assets/image-20230103001243645.png)

Verificación de funcionamiento:

![image-20230103001447867](README.assets/image-20230103001447867.png)

Luego de corregir unos problemas en el borrado de los docker creados, finalmente funcionó correctamente, y verificado que no vuelva a fallar.

![image-20230103010919754](README.assets/image-20230103010919754.png)

## Actividad 24

Verificación de la instalación de kubectl:

![image-20230103200952034](README.assets/image-20230103200952034.png)



![image-20230103202429305](README.assets/image-20230103202429305.png)



![image-20230103202656133](README.assets/image-20230103202656133.png)



![image-20230103210453449](README.assets/image-20230103210453449.png)

Creación y definición del archivo `.yaml`:

![image-20230103211739909](README.assets/image-20230103211739909.png)

Verificación de las creacion de los tres Pods:

![image-20230103211931000](README.assets/image-20230103211931000.png)

Verificar que se hayan creado los 3 Pods, cada uno con un contenedor Docker:

![image-20230103215320839](README.assets/image-20230103215320839.png)

Verificar registros de un Pod con su contenedor:

![image-20230103215643297](README.assets/image-20230103215643297.png)



![image-20230103222853729](README.assets/image-20230103222853729.png)

Instalando el servicio equilibrador de carga del tráfico, verificación correcta del servicio, y que el servicio apunte a las 3 réplicas de Pod creadas anteriormente:

![image-20230103223319734](README.assets/image-20230103223319734.png)

Accediendo al servicio desde afuera con NodePort, primero buscando la IP del nodo:

![image-20230104092821179](README.assets/image-20230104092821179.png)

y posteriormente el puerto al que se esta redirigiendo el servicio:

![image-20230104092939352](README.assets/image-20230104092939352.png)

para finalmente verificar que se puede acceder a Calculador desde el exterior:

![image-20230104093009353](README.assets/image-20230104093009353.png)

### Kubernetes avanzado

#### Escalar una aplicación

Escalando la aplicación a 5 instancias:

![image-20230104093514627](README.assets/image-20230104093514627.png)

Verificando la ampliación:

![image-20230104093625194](README.assets/image-20230104093625194.png)

### Actualización de una aplicación

![image-20230104094105186](README.assets/image-20230104094105186.png)

Aplicando la configuración y verificando que Kubernetes finalizó los Pods antiguos y comenzó los nuevos:

![image-20230104094247638](README.assets/image-20230104094247638.png)

### Actualizaciónes continuas

![image-20230104103332516](README.assets/image-20230104103332516.png)

![image-20230104103419783](README.assets/image-20230104103419783.png)

Realizando limpieza:

![image-20230104103504597](README.assets/image-20230104103504597.png)

### Dependencias de la aplicación

Resolucion DNS de kubernetes, y Hazelcast:

![image-20230104113630961](README.assets/image-20230104113630961.png)

![image-20230104113602431](README.assets/image-20230104113602431.png)

Verificacion de pods:

![image-20230104113715394](README.assets/image-20230104113715394.png)

Verificacion de registros del Pod:

![image-20230104113820917](README.assets/image-20230104113820917.png)

### Implementación del sistema multiaplicación

![image-20230104143122402](README.assets/image-20230104143122402.png)

#### Borrando la prueba de contexto creada por Spring Boot

![image-20230104143057985](README.assets/image-20230104143057985.png)

### Agregar almacenamiento en caché de Spring Boot

![image-20230104144217699](README.assets/image-20230104144217699.png)

![image-20230104145712448](README.assets/image-20230104145712448.png)

Creando el nuevo contenedor:

![image-20230104150332275](README.assets/image-20230104150332275.png)

Subiendo el contenedor a dockerHub:

![image-20230104150354968](README.assets/image-20230104150354968.png)

Aplicando la implementación con los `.yaml`:

![image-20230104150619468](README.assets/image-20230104150619468.png)

Verificando que esta conectado al servidor Hazelcast desde los registros de Hazelcast:

![image-20230104152220121](README.assets/image-20230104152220121.png)

y tambien desde los pods de Calculador:

![image-20230104152400533](README.assets/image-20230104152400533.png)

