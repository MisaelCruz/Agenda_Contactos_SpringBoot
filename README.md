# Agenda de Contactos - Spring Boot 📑

Aplicación web para la gestión y administración de contactos, desarrollada para dominar la integración de capas, validaciones del servidor y persistencia de datos en el ecosistema de Java.

---

## Tecnologías y Herramientas Utilizadas

* **Backend:** Java, Spring Boot, Spring Data JPA, Hibernate, Jakarta Validation.
* **Frontend:** HTML5, Thymeleaf, Bootstrap 5 (Estilos e íconos dinámicos).
* **Base de Datos:** MySQL.
* **IDE & Control de Versiones:** Spring Tools Suite (STS 4) y Git/GitHub.

---

## Características Principales

* **Operaciones CRUD Completas:** Creación, lectura, actualización y eliminación lógica/física de contactos de forma dinámica.
* **Validaciones del Lado del Servidor:** Integración de `@jakarta.validation.Valid` para garantizar la integridad de los datos (campos obligatorios, formatos de texto y restricciones) antes de interactuar con la base de datos.
* **Arquitectura Eficiente de Vistas:** Formulario dinámico y reutilizable (`nuevo.html`) mediante expresiones condicionales y operadores ternarios de Thymeleaf para alternar limpiamente entre los flujos de registro y edición.
* **Trazabilidad de Base de Datos:** Mapeo de entidades con Hibernate (`@Entity`) configurado con generación y formateo de consultas SQL visibles en consola para depuración en tiempo real.
