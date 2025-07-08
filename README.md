# SpringBoot REST UserCreation App

Este proyecto fue creado usando SpringBoot con Java.

Expone una API RESTful de creación de usuarios cuyos endpoints aceptan y retornan
solamente JSON, inclusive para los mensajes de error.

## Registro de Usuario

Ese endpoint debe recibir un usuario con los campos "nombre", "correo",
"contraseña", más un listado de objetos "teléfono", respetando el siguiente
formato:
```
    {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "hunter2",
        "phones": [
            {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
            }
        ]
    }
```

## Construcción y Ejecución

Para construir o ejecutar el proyecto, hacer uso de las siguientes tareas:

| Tarea               | Descripción                      |
|---------------------|----------------------------------|
| `./gradlew test`    | Ejecuta las pruebas              |
| `./gradlew build`   | Construye todo                   |
| `./gradlew bootRun` | Ejecuta el servidor              |

Si el servidor se inicia correctamente, se mostrara la siguiente salida :

```
2025-07-08 13:57:30.789  INFO 6811 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2025-07-08 13:57:30.810  INFO 6811 --- [  restartedMain] c.n.c.s.r.usercreation.UserCreationApp   : Started UserCreationApp in 5.875 seconds (JVM running for 6.626)
```

## Uso de Aplicación

Una vez ejecutandose la aplicación se puede visualizar el Swagger en http://localhost:8080/swagger-ui/index.html
o descargar el JSON de OpenAPI mediante http://localhost:8080/v3/api-docs e importar en una
herramienta como [POSTMAN](https://www.postman.com/).
