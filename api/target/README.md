# API REST - Gestión de Libros

API REST desarrollada con Spring Boot como parte de la Práctica 4.  
Permite crear, leer, actualizar y eliminar libros de una base de datos H2 en memoria.

---

## 🛠️ Tecnologías utilizadas

- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## 📚 Endpoints

| Método | Ruta                  | Cuerpo (JSON)                          | Descripción                        | Respuestas posibles            |
|--------|-----------------------|----------------------------------------|------------------------------------|-------------------------------|
| GET    | `/api/libros`         | -                                      | Obtener todos los libros           | 200 OK                        |
| GET    | `/api/libros/{id}`    | -                                      | Obtener un libro por ID            | 200 OK, 404 Not Found         |
| POST   | `/api/libros`         | `{ "titulo": "X", "autor": "Y", "anio": 2024 }` | Crear un nuevo libro                | 201 Created                   |
| PUT    | `/api/libros/{id}`    | `{ "titulo": "Nuevo", ... }`          | Actualizar un libro existente      | 200 OK, 404 Not Found         |
| DELETE | `/api/libros/{id}`    | -                                      | Borrar un libro por ID             | 204 No Content, 404 Not Found |

---


