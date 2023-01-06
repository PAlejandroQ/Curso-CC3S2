# Práctica calificada 4

Link del repositorio usado:

https://github.com/PAlejandroQ/calculador2

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

## Pregunta 2

### Pregunta 1

Menciona diferentes enfoques para proporcionar a los agentes las credenciales del
servidor.

* Poner una llave SSH en el agente en el caso que no estemos usando un aprovisionamiento dinámico de dockers trabajadores.
* Poner una llave SSH en la imagen de agente si se usa aprovisionamiento dinamico de dockers trabajadores.
* Configurar las credenciales en Jenkins y que las use en el pipeline.
* Copiar dinamicamente la llave SSH en los trabajadores al iniciarse el constructor de Jenkins.

### Pregunta 2

Aprendimos mucho sobre los requisitos funcionales y las pruebas de aceptación
automatizadas. Pero,¿qué debemos hacer con los requisitos no funcionales? O aún más desafiante,¿qué pasa si no hay requisitos?¿Deberíamos omitirlos en el proceso de CD?

Los requisitos no funcionales pueden causar un riesgo significante en como el sistema opera. Si no hay requisitos, se los debe extraer en base a requerimientos que garantizen que el cliente este satisfecho aparte de que funcione bien.

No deben omitirse, incluso deben ser especificados en test de la misma manera que los requisitos de aceptación. Añadiendose una etapa al pipeline.

### Pregunta 3

¿Qué son las pruebas de rendimiento ?,¿qué es el (RTT, round-trip time) ?.

Las pruebas no funcionales más usadas,pues miden la estabilidad y el tiempo de respuesta del sistema. RTT es el tiempo que un paquete  de informacion demora en regresar a su emisor habiendo pasado por su lugar de destino esperado.

### Pregunta 4

¿Qué son las pruebas de carga?,¿en que ciclo del CD su uso es muy común?

Son pruebas orientadas a verificar el comportamiento del sistema ante una gran cantidad de solicitudes simultaneas. Su uso es común en la etapa de liberación.

### Pregunta 5

¿Qué son las pruebas de estrés?,¿estas pruebas son adecuadas para el proceso CD?

Son pruebas semejantes a las pruebas de carga, con la diferencia que se mantiene la latencia constante incrementando el rendimiento para saber el máximo numero de llamadas que puede soportar con un sistema aun operable. 

Esta prueba no es adecuada para el CD porque requiere largos test, por lo que debe preparado en scripts separados en Jenkins pipeline.

### Pregunta 6:

¿Qué son las pruebas de escalabilidad?,¿estas pruebas son fáciles de incluir en el pipeline de CD ?¿por qué?

Son pruebas que permiten explicar como es que el rendimiento y la latencia cambia cuando se añaden más servidores y servicios. Se espera un comportamiento lineal.

Estas pruebas deben ser automatizadas, pero de manera similar a los test de estrés, no deben ser puestas en el CD, sino separados.

### Pregunta 7

¿Qué es un Soak test o pruebas de resistencia o pruebas de longevidad ?,¿tiene sentido ejecutarlos dentro del pipeline CD?

Ejecuta el sistema por un largo periodo de tiempo para ver si el performance tiende a caer en ese periodo. Puede detectar fugas de memoria o problemas de estabilidad.

No tiene mucho sentido ponerlos dentro del CD, por lo que van aparte.

### Pregunta 8

¿De qué tratan las pruebas de seguridad?.¿Las pruebas de seguridad deben incluirse en el
proceso de CD como una etapa del pipeline?,¿como se utilizan en el framework (BDD)?

Tratan aspectos que son requerimientos puramente funcionales como las autorizaciones, autenticaciones y asignación de roles.

Deben ser incluidas en el proceso CD

### Pregunta 9

¿De qué trata las pruebas de mantenibilidad?

Buscan explicar que tan simple es el sistema de mantener por la calidad de su código. Sonar tool puede tambien dar una vista superficial acerca de la calidad de código en el análisis de código estático.

### Pregunta 10

¿ Qué son las pruebas de recuperación?¿Relaciona su uso con la herramienta Chaos Monkey ?

Es una técnica para determinar que tan rápido el sistema puede recuperarse despues de un crasheo por errores de software o hardware. 

La herramienta Chaos Monkey termina aleatoriamente instancias del entorno de produccion para forzar a los ingenieros a escribir código que haga al sistema resistente a fallos.



### Control de versiones de Jenkins

#### Uso de fecha y hora

Añadiendo las versiones con TIMESTAMP:

![image-20230105163132803](README.assets/image-20230105163132803.png)

## Creando clusters

![image-20230106063130764](README.assets/image-20230106063130764.png)



![image-20230106065046987](README.assets/image-20230106065046987.png)

![image-20230106065110518](README.assets/image-20230106065110518.png)

### Versionado

![image-20230106065838061](README.assets/image-20230106065838061.png)

### El entorno de staging remoto

![image-20230106070350959](README.assets/image-20230106070350959.png)

### El entorno de pruebas de aceptación

![image-20230106070528861](README.assets/image-20230106070528861.png)

![image-20230106071139712](README.assets/image-20230106071139712.png)

### Lanzamiento

![image-20230106071531755](README.assets/image-20230106071531755.png)

### Prueba de humo

![image-20230106071722943](README.assets/image-20230106071722943.png)

### Pregunta 11

Pasos realizados:

```groovy
pipeline {
	agent any
	triggers {
        	pollSCM('* * * * *')
		}
	stages {
		stage("Compile") {
			steps {
				sh "./gradlew compileJava"
			}
		}
		stage("Unit test") {
			steps {
				sh "./gradlew test"
			}
		}
		stage("Code coverage") {
		    steps {
			sh "./gradlew jacocoTestReport"
			publishHTML (target: [
			reportDir: 'build/reports/jacoco/test/html',
			reportFiles: 'index.html',
			reportName:"JaCoCo Report"
			])
			sh "./gradlew jacocoTestCoverageVerification"
		    }
        	}
		stage("Static code analysis") {
		    steps {
			sh "./gradlew checkstyleMain"
			publishHTML (target: [
			reportDir: 'build/reports/checkstyle/',
			reportFiles: 'main.html',
			reportName:"Checkstyle Report"
			])
		    }
		}
		stage("Package") {
			steps {
			sh "./gradlew build"
			}
		}
		stage("Docker build") {
			steps {
			sh "docker build -t alejandroqo/calculador:${BUILD_TIMESTAMP} ."

			}
		}
		stage("Docker push") {
			steps {
				sh "docker push alejandroqo/calculador:${BUILD_TIMESTAMP}"
			}
		}
		stage("Update version") {
               		steps {
                    		sh "sed  -i 's/{{VERSION}}/${BUILD_TIMESTAMP}/g' deployment.yaml"
               		}
          	}
		stage("Deploy to staging") {
			steps {
				//sh "docker run -d --rm -p 8765:8080 --name calculador alejandroqo/calculador:${BUILD_TIMESTAMP}
			sh "kubectl config use-context kind-staging"
			sh "kubectl apply -f hazelcast.yaml"
			sh "kubectl apply -f deployment.yaml"
			sh "kubectl apply -f service.yaml"
			}
		}
		stage("Acceptance test") {
			steps {
				sleep 60
				//sh "./gradlew acceptanceTest -D calculador.url=http://localhost:8765"
				sh "chmod +x acceptance-test.sh && ./acceptance-test.sh"

			}
		}
		stage("Release") {
               		steps {
                    		sh "kubectl config use-context kind-production"
                    		sh "kubectl apply -f hazelcast.yaml"
                    		sh "kubectl apply -f deployment.yaml"
				sh "kubectl apply -f service.yaml"
               		}
          	}
		stage("Smoke test") {
              		steps {
                  		sleep 60
                  		sh "chmod +x smoke-test.sh && ./smoke-test.sh"
              		}
          	}
	}
		
		post {
			always {
			    mail to: 'ppaabblloo4283@gmail.com',
			    	subject:"Completed Pipeline: ${currentBuild.fullDisplayName}",
			    	body:"Your build completed, please check: ${env.BUILD_URL}"
			    sh "docker stop calculador"
			}
			failure {
			    slackSend channel: '#sprint',
			    color: 'danger',
			    message:"The pipeline ${currentBuild.fullDisplayName} failed."
			}
		
		}
	}
```

Al principio, elige el agente donde ejecutará el pipeline, y como inicialmente configuramos para que el mismo Jenkins no ejecute ninguna tarea, entonces elegirá al agente que le añadimos.

![image-20230106075048097](README.assets/image-20230106075048097.png)

* Posteriormente, activa el trigger que verificara cada minuto si hubo algun cambio en el repositorio. De detectar alguno, inicia automaticamente el pipeline.
* Luego se realiza la etapa de compilacion, de los test unitarios, se verifica la covertura de código con Jacoco.
* Despues se hace una verificacion de código estatico, aca Sonar tool pueden entrar en acción.
* Ahora que se tiene la compilación lista, se creara una imagen que contiene la construcción obtenida previamente.
* Esta imagen es subida al dockerHub con su respectiva etiqueta de versionado por tiempo.
* Se actualiza el valor de la version, y se inicia el dezpliegue en el cluster. kind-staging.
* Se inicia el cache con el hazelcast, el deployment y el servicio. 
* Luego que hayan pasado la prueba de aceptación, se lo despliega pero ya en el cluster de producción `kind-produccion`.
* Finalmente se realiza un testeo de humo unicamente para verificar que no haya alguna eventualidad adicional.

![image-20230106075953363](README.assets/image-20230106075953363.png)

> Hubo problemas en el test de aceptacion pese a que si lee el puerto y la IP del nodoPort adecuadamente.

![image-20230106080614254](README.assets/image-20230106080614254.png)
