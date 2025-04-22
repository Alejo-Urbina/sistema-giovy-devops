# sistema-educativomicroservicios-giovy-urbina

REPOSITORIO = https://github.com/Alejo-Urbina/sistema-educativomicroservicios-giovy-urbina/tree/develop

Sistema de Microservicios Educativos

Este proyecto implementa un sistema de gestión educativa basado en microservicios, utilizando Spring Boot, H2 en memoria, y comunicación mediante Feign Client. Además, está dockerizado para facilitar su despliegue.

✏️ Estructura del Proyecto

El sistema se compone de tres microservicios independientes, cada uno con su propio repositorio, configuración y base de datos H2 en memoria:

sistema-educativomicroservicios-giovy-urbina/
├── docker-compose.yml
├── usuarios-servicio/
│   ├── Dockerfile
│   ├── src/
│   └── build.gradle
├── asignaturas-servicio/
│   ├── Dockerfile
│   ├── src/
│   └── build.gradle
└── matriculas-servicio/
    ├── Dockerfile
    ├── src/
    └── build.gradle

Cada microservicio incluye:

Una base de datos H2 embebida.

Endpoints REST independientes.

Comunicación HTTP mediante Feign Client.

🔗 Comunicación entre Microservicios

Feign Clients:

El microservicio matriculas-servicio se comunica con:

usuarios-servicio para consultar datos de estudiantes o docentes.

asignaturas-servicio para consultar los datos de materias.

Ejemplo:

@FeignClient(name = "usuarios-servicio", url = "http://usuarios-servicio:8081")
public interface UsuarioCliente {
    @GetMapping("/usuarios/{id}")
    UsuarioRespuesta obtenerUsuario(@PathVariable("id") Integer id);
}

📚 Endpoints Principales

usuarios-servicio (puerto 8081)

POST /usuarios - Crea un usuario.

GET /usuarios/{id} - Consulta usuario por ID.

asignaturas-servicio (puerto 8082)

POST /asignatura - Crea una asignatura.

GET /asignatura/{id} - Consulta asignatura por ID.

matriculas-servicio (puerto 8080)

POST /matriculas - Registra una matrícula.

GET /matriculas/usuario/{id} - Consulta todas las asignaturas asociadas a un usuario, obtenidas desde asignaturas-servicio mediante Feign Client.

GET /matriculas/asignaturas/{id} - Consulta todas los usuarios asociadas a una asignatura, obtenidas desde usuarios-servicio mediante Feign Client.

🧱 Base de Datos H2

Todos los microservicios usan H2 en memoria y exponen la consola H2 en:

http://localhost:{puerto}/h2

Configuración básica (application.properties):

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:nombre_basedatos;DB_CLOSE_DELAY=-1
spring.jpa.hibernate.ddl-auto=update

🧪 Pruebas de Integración

Cada microservicio cuenta con **una prueba de integración** que verifica los principales endpoints:

- `usuarios-servicio`: Prueba del endpoint `GET /usuarios/{id}`
- `asignaturas-servicio`: Prueba del endpoint `GET /asignatura/{id}`
- `matriculas-servicio`: Prueba del endpoint `GET /matricula/usuario/{id}` utilizando mocks para los Feign Clients

#### 👉 Ejecutar las pruebas:
Desde la raíz de cada microservicio, corre el siguiente comando:

``bash
./gradlew test

🔐 Seguridad con JWT (usuarios-servicio)

Se implementó autenticación basada en **JWT** para proteger los endpoints:

- Se utiliza `Spring Security` para proteger el endpoint `GET /usuarios/{id}`.
- Se genera un token JWT con un usuario `admin` y se valida automáticamente en cada petición.
- El microservicio `matriculas-servicio` incluye un interceptor que envía el token JWT en los Feign Clients hacia `usuarios-servicio`.

Para probar autenticación:
1. Generar un token vía `/auth/login` (endpoint simulado o mockeado).
2. Incluir en las peticiones el encabezado:
   ```http
   Authorization: Bearer <token>
   ```

🚀 Docker y Docker Compose

Dockerfile genérico para cada microservicio:

FROM eclipse-temurin:17-jdk-alpine

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]

docker-compose.yml

services:
  usuarios-servicio:
    build: ./usuarios-servicio
    ports:
      - "8081:8080"

  asignaturas-servicio:
    build: ./asignaturas-servicio
    ports:
      - "8082:8080"

  matriculas-servicio:
    build: ./matriculas-servicio
    ports:
      - "8080:8080"

Comandos:

# Construir
./gradlew build

# Levantar servicios
docker-compose build
docker-compose up

# Apagar servicios
docker-compose down

📊 Consideraciones Finales

Cada microservicio es independiente.

La comunicación se realiza por HTTP.