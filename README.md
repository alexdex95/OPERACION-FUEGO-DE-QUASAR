# OPERACION-FUEGO-DE-QUASAR
JEFFERSON ALEXANDER MORENO BARRERA
*****************************************************************************************************************************************************************
###  Ejecucion del proyecto

Google Drive:https://drive.google.com/drive/folders/18KewVKU2lXlNO6Se6pAPfV8D5tn-saWY?usp=sharing

###  Diagrama de estructura interna del proyecto

![image](https://user-images.githubusercontent.com/59813210/167305647-1ee69cd3-b655-473a-a20c-3bc421a9f014.png)

###  Solucion de la prueba 

Para el desarrollo de la prueba se realizó una investigación del algoritmo de Trilateración
el cual consiste en encontrar la ubicación (coordenadas X e Y) de un punto en específico con base en 3 distancia, una vez
se entendió este algoritmo se decidieron las tecnologías a trabajar en el cual se escogieron las siguientes:

1.  Maven: Gestor de dependencias para el manejo del empaquetado e implementación de librerías externas
2.  Spring Boot: Modulo de spring para el desarrollo de la API REST 
3.  Java 11: leguaje de codificación del aplicativo
4.  Eclipse: IDE de desarrollo
5.  Google Cloud: Plataforma cloud para hostear la API
6.  GIT: software de manejo de versiones de la API
7.  Postaman: Plataforma para el diseño y pruebas de API
8.  JUnit: Biblioteca para desarrollo de pruebas unitarias a la API
9.  Google Drive: manuales de uso de la API
10. GitHub: Plataforma para alojar el código fuente de la API     

###  Librerías Externas
1. trilateration
2. commons-math3
3. commons-lang3

### Entregables.
1.  Repositorio privado Github: https://github.com/alexdex95/OPERACION-FUEGO-DE-QUASAR
2.  Host: Google Cloud
3.  Documentacion

### URL API REST

Metodos GET

https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret_split

Metodo Post

https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret
https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret_split/kenobi
https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret_split/skywalker
https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret_split/sato

### JSON DE ENTRADA
##### Servicio topsecret metodo POST 

```json
    {
       "satellites":[
          {
             "name":"kenobi",
             "distance":500.21,
             "message":["este","","","mensaje",""
    		 ]
          },
          {
             "name":"skywalker",
             "distance":100.34,
    				 "message":["","es","","","secreto"
    				 ]
          },
          {
             "name":"sato",
             "distance":700.72,
    		  	 "message":["este","","un","",""
             ]
          }
       ]
    }
```
##### Servicio topsecret_split metodo POST
https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret_split/kenobi

```json
    {
       "distance":-500.21,
       "message":["este","","","mensaje",""]
    }
```

https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret_split/skywalker

```json
    {
       "distance":100.34,
       "message":["","es","","","secreto"]
    }
```

https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret_split/sato

```json
    {
       "distance":700.72,
       "message":["este","","un","",""]
    }
```

##### Servicio topsecret_split metodo GET
Header

Key = Content-Type 

Value = application/json

https://melioq.uc.r.appspot.com/OperationQuasarFire/topsecret_split

