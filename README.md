# # API-ABstract

Tecnología utilizada: Springboot

Lenguaje: Java 11

Data base: H2

Documentacion en Postman: [https://documenter.getpostman.com/view/24571389/2s8YsnWbRh](https://documenter.getpostman.com/view/24571389/2s946icWn8)


# # Como ejecutar el proyecto:
1- Descarga el proyecto utlizando la opcion de clonar proyecto disponible en GitHub y copiando el URL en tu IDE de preferencia.

2- Ir a la main class del proyecto y ejecutarlo, o mismo ejecutarlo utilizando la opcion run de tu IDE de preferencia.
El proyecto se deplegara en el puerto 8080 (en caso de querer modificar el puerto, se puede hacer desde el application.properties,
en la opcion que dice: server.port=8080)

3- Los diferentes endpoints pueden ser ejecutados a traves de Postman siguiendo la documentacion provista anteriormente.
Tener en cuenta de que en caso de ejecutarlo de forma local utilizar: http://localhost:8080 (o el puerto elegido).

# # Datos a tener en cuenta:
-H2 en una base de datos relacional en memoria que en el caso de este proyecto no es persistida. Con esto se quiere decir que una vez que el proyecto deje de correr los datos guardados en ella van a ser borrados y por ello no se recomienda su uso en ambientes productivos.
Tambien implica que cada vez que se reinicie el codigo, antes de hacer cualquier cosa, se corra el request: Generate Data Base, que podemos encontrar en la documentacion de Postman provista anteriormente.

-En caso de querer acceder a la consola de H2 primero asegurarse de que en el application.properties el siguiente elemento este de esta manera: spring.h2.console.enabled=true (en caso de estar false no permitira acceder a la consola)
Una vez verificado eso, se puede acceder a la misma con el siguiente endpoint: http://localhost:8080/h2-console y usando como password = password.

-Si se quiere mas informacion sobre como incorporar H2 a tus proyectos y su uso recomiendo el siguiente link: https://refactorizando.com/base-de-datos-memoria-h2-spring-boot/
