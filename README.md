# API de Carrito de Compra

Esta API proporciona funcionalidades para gestionar un carrito de compra en una aplicación de comercio electrónico. Permite a los usuarios agregar productos al carrito, realizar pedidos y realizar operaciones relacionadas con la gestión de compras.

## Requisitos

- Java (versión recomendada: 8 o superior)
- MySQL (puede configurarse para utilizar otro sistema de base de datos relacional)

## Instalación

 Clona este repositorio:

   ```
   bash
   git clone https://github.com/shanting18/Carrito_De_Compra
   cd tu-repo
   ```

Crea una base de datos MySQL y configura las credenciales en el archivo application.properties:
 ```
spring.datasource.url=jdbc:mysql://localhost:3306/tu_basededatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
 ```   
 
 Autenticación con JWT:

Para acceder a las rutas protegidas, incluida la gestión del carrito de compra, agrega un encabezado Authorization a tus solicitudes HTTP con el formato:

 ``` 
Authorization: Bearer tu-token-jwt

//Registrar 
{
    "username":"camila",
    "password":"12345",
    "email": "camila@mail.com",
    "roles":["ADMIN" O "USER"]
}

//Login

{
    "username":"camila",
    "password":"12345"
}
 ``` 
Puedes obtener un token JWT al autenticarte mediante una ruta de inicio de sesión.

para agregar, actualizar y eliminar los productos se necesita tener el rol de el administrador (ADMIN) es el unico con la autorizacion para realizar dichas actividades.

```
//Agregar producto

{
    "nombre": "celular",
    "precio": 60,
    "cantidad": 80,
    "descripcion": "disposito movil",
    "categoria":"tecnologia",
    "estado": true
}
```
para colocar un producto en el carrito se necesita la autenticacion del usuario(USER)

```
//Producto en el carrito
{
    "cantidadEnCarrito": 17,
    "producto": {"nombre": "celular"},
    "cliente": {"id": 3}
}
```
