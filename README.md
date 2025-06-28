# Prueba de Java Básico  
**Autor:** Cintia Cabrera Gamaza

---

Esta prueba consiste en la realización de un **CRUD utilizando JPA** para interactuar con una base de datos, gestionando desde la consola las siguientes operaciones:

## Funcionalidades

1. **Agregar un nuevo cliente**
2. **Listar todos los clientes**
3. **Actualizar información de un cliente**
4. **Eliminar un cliente**
5. **Buscar cliente por ciudad**

---

## Estructura de archivos

El proyecto está organizado para separar la funcionalidad en distintos paquetes:

- **`Main`**  
  Punto de entrada del programa, donde se encuentra el hilo de ejecución principal.

- **Paquetes:**
  - **`entities`**  
    Incluye la entidad `Cliente` con sus respectivos atributos y métodos.
  - **`controllers`**  
    Contiene el controlador de cliente, encargado de la lógica principal para la gestión de clientes.
  - **`persistence`**  
    Alberga la configuración de persistencia y el archivo de persistencia de cliente, donde se ejecutan exclusivamente las consultas a la base de datos solicitadas siempre desde el controlador de cliente.

---

## Extra

- Se han utilizado **estructuras de control** y **manejo de excepciones** para evitar interrupciones erróneas en la ejecución del programa.

