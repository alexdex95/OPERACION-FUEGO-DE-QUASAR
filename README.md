# OPERACION-FUEGO-DE-QUASAR
JEFFERSON ALEXANDER MORENO BARRERA
*****************************************************************************************************************************************************************
###  Tecnologias
1. Maven
2. Spring Boot
3. Java 11

###  Librerías
1. trilateration
2. commons-math3
3. commons-lang3

### Entregables.
1.  Repositorio privado Github: https://github.com/alexdex95/OPERACION-FUEGO-DE-QUASAR
2.  Host: Google Cloud
3.  Documentacion:

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

