# ANIMANGA-V4-BACKEND
Una API que gestiona la compra y venta de mangas.

## Tecnología y lenguaje utilizado:
Para el desarrollo de la aplicación, se han utilizado los siguientes elementos:
- **Spring Boot** como framework.
- **Java** para el desarrollo del código que atiende las peticiones a la API.
- **PostgreSql** para la gestión de la base de datos.

## Entorno de desarrollo:
Para el desarrollo del proyecto, se ha utilizado el entorno de desarrollo **IntelliJ IDEA**.

## Pruebas:
Para poder probar la API, tendremos dos vías principales:
- **Documentación del proyecto en Swagger**: Accederemos a través de la ruta **http://localhost:8080/swagger-ui.html**. Aquí, podremos probar todos los endpoints
  disponibles en la API.
- **Aplicación de Postman**: Dentro del proyecto, se encuentra el archivo **animanga_collection.json**. Este archivo, podremos importarlo en las colecciones de Postman.
- **Base de datos PostgreSql**: Accederemos a través de un entorno como PgAdmin, o consultarlo directamente con docker Desktop,podremos acceder a la base de datos para comprobar la información ahí guardada, y, una vez 
  realicemos alguna petición mediante Postman o Swagger, veremos cómo se actualiza esta.
  


## Organización del proyecto:
En la carpeta principal nos encontramos diferentes elementos a tener en cuenta:
- **src**: Es la carpeta donde se aloja todo el código fuente utilizado en el desarrollo de la aplicación.
- **animanga_collection.json**: Es una colección de Postman, que podremos importar en dicho programa, y que nos permitirá acceder a los distintos endpoints de la aplicación.

