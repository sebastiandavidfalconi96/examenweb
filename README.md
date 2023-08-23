Nombre: Sebastian Falconi

# API de Gestión de Tareas con Spring Boot

Este repositorio contiene el código fuente para una API de gestión de tareas desarrollada utilizando Spring Boot. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una entidad de tarea.

## Configuración Inicial

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu IDE preferido que sea compatible con Spring Boot. Se recomienda intellij idea.

## Base de Datos en Memoria (H2)

La aplicación utiliza una base de datos en memoria H2. La configuración de la conexión a la base de datos se encuentra en el archivo `application.properties`.

## Modelo de Datos

La entidad `Task` representa una tarea con los siguientes atributos:
- id (identificador único de la tarea)
- nombre (nombre de la tarea)
- descripcion (descripción de la tarea)
- fecha (fecha de la tarea)
- estado (estado actual de la tarea)

## Endpoints de la API

La API expone los siguientes endpoints:

- `GET /api/tasks`: Obtiene la lista de todas las tareas.
- `GET /api/tasks/{id}`: Obtiene los detalles de una tarea específica por su ID.
- `POST /api/tasks`: Crea una nueva tarea.
- `PUT /api/tasks/{id}`: Actualiza los detalles de una tarea existente por su ID.
- `DELETE /api/tasks/{id}`: Elimina una tarea por su ID.

## Uso de la API

- Para obtener la lista de tareas: Envía una solicitud GET a `http://localhost:8080/api/tasks`.
- Para crear una nueva tarea: Envía una solicitud POST a `http://localhost:8080/api/tasks` con un cuerpo JSON que contenga los detalles de la tarea.
- Para obtener detalles de una tarea específica: Envía una solicitud GET a `http://localhost:8080/api/tasks/{id}`.
- Para actualizar una tarea existente: Envía una solicitud PUT a `http://localhost:8080/api/tasks/{id}` con un cuerpo JSON que contenga los nuevos detalles de la tarea.
- Para eliminar una tarea: Envía una solicitud DELETE a `http://localhost:8080/api/tasks/{id}`.


