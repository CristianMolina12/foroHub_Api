# 🚀 ForoHub API

API REST desarrollada con **Spring Boot** para la gestión de un foro donde los usuarios pueden crear, consultar, actualizar y eliminar tópicos.
El sistema incluye **autenticación segura con JWT utilizando Spring Security**.

Este proyecto fue desarrollado como parte del **Challenge ForoHub de Alura + Oracle ONE**.

---

# 📌 Funcionalidades

* Registro y autenticación de usuarios
* Generación de token JWT
* Protección de endpoints con Spring Security
* CRUD completo de tópicos
* Validaciones con Bean Validation
* Persistencia con JPA / Hibernate
* Migraciones de base de datos con Flyway

---

# 🛠️ Tecnologías utilizadas

* Java 17+
* Spring Boot
* Spring Security
* JWT (Auth0)
* Spring Data JPA
* Hibernate
* Flyway
* MySQL
* Maven
* Lombok
* Insomnia (para pruebas de API)

---

# 🏗️ Arquitectura del proyecto

```
src/main/java/com/foroHub

controller      → Controladores REST
domain          → Entidades y repositorios
dto             → Objetos de transferencia de datos
infra/security  → Configuración de seguridad y JWT
```

---

# 🔐 Autenticación

La API utiliza **JWT (JSON Web Token)** para autenticar usuarios.

### Login

POST /login

Body:

```json
{
  "login": "usuario",
  "contrasena": "123456"
}
```

Respuesta:

```json
{
  "token": "jwt_token_generado"
}
```

---

# 📡 Endpoints principales

### Obtener tópicos

GET /topicos

### Crear tópico

POST /topicos

### Detalle de tópico

GET /topicos/{id}

### Actualizar tópico

PUT /topicos/{id}

### Eliminar tópico

DELETE /topicos/{id}

⚠️ Todos los endpoints requieren token JWT.

Header requerido:

```
Authorization: Bearer TOKEN
```

---

# ⚙️ Configuración del proyecto

### 1️⃣ Clonar repositorio

```
git clone https://github.com/CristianMolina12/foroHub_Api.git
```

---

### 2️⃣ Configurar base de datos

Crear una base de datos MySQL llamada:

```
forohub
```

Editar el archivo `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost/forohub
spring.datasource.username=usuario
spring.datasource.password=password

api.security.token.secret=clave_secreta
```

---

### 3️⃣ Ejecutar la aplicación

```
mvn spring-boot:run
```

El servidor se ejecutará en:

```
http://localhost:8080
```

---

# 🧪 Pruebas de la API

Se puede probar usando:

* Insomnia
* Postman

Flujo de prueba:

1. Realizar login
2. Copiar el token generado
3. Enviar el token en el header Authorization
4. Consumir los endpoints protegidos

---

# 👨‍💻 Autor

**Cristian Molina**

GitHub:
https://github.com/CristianMolina12

---

# 📚 Proyecto educativo

Este proyecto forma parte del programa:

**Oracle Next Education (ONE) + Alura Latam**

Challenge Backend **ForoHub API**.
