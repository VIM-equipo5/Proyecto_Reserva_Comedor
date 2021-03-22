![banerGit](https://user-images.githubusercontent.com/22893383/107159880-121e0b80-6993-11eb-92e3-1efd1d8f4dba.PNG)

# Proyecto: Reserva de Comedor T-System

### 1. Equipo Desarrollo 

| Developer | Rama | Rol | Fecha Incorporación | 
| --- | :---:  | :---:  | :---:  | 
| Miguel Á. Sastre | Master / MiguelSastre | Project Manager/Dev | 05/03/2021 |  
| Ingrid Dominguez | IngridDominguez |  Developer| 05/03/2021 |   
| Vyacheslav Khaydorov  | VyacheslavKhaydorov  |  Developer| 05/03/2021 |     

### 2. Descripción
```
Proyecto final para el curso de Fullstack con Java, Angular y MySQL.
```

#### Enunciado de la actividad
```
Les nostres oficines de Barcelona són ubicades a un edifici on també disposem d’un menjador amb servei de càtering. 
Amb l’objectiu d’evitar aglomeracions en hores punta, necessitem una aplicació web que permeti realitzar la reserva 
d’àpats en diferents franges horàries.

L’aplicació web mostrarà una llista amb fotografies dels diferents àpats dins de 4 categories: 
  * entrants
  * primers
  * segons 
  * postres 
Per tal que els usuaris puguin seleccionar-los i realitzar la seva reserva en franges de 15 minuts. 
L’horari comença a les 12:00 i acaba a les 15:00 (per tant, hi haurà 16 franges de 15 minuts).
```
##### Els requisits funcionals de l’aplicació són els següents:
![Requisitos](https://user-images.githubusercontent.com/22893383/110512149-3f321b00-8105-11eb-88c4-17ec90a0b76a.PNG)

```
Els possibles punts d’extensió d’aquesta pràctica són permetre la generació d’informes de les 
  reserves d’un dia, setmana o mes concrets, permetre als usuaris l’enviament de feedback sobre els 
  diferents àpats i incloure una llista d’al·lergogens a cadascun dels plats alhora que l’usuari 
  indica les seves al·lèrgies, de manera que es puguin mostrar alertes visuals específiques per l’usuari.
```

##### Exemple de diagrama de classes per aquesta pràctica:
![image](https://user-images.githubusercontent.com/22893383/110512797-d39c7d80-8105-11eb-9523-9405f5f9241a.png)


### 3. Diseño de base de datos

#### Modelo Entidad/Relación
![modeloERv3](https://user-images.githubusercontent.com/22893383/110511220-4c9ad580-8104-11eb-82bf-e462807ab34a.png)

#### Modelo relacional

* **Rol** (PK_idRol, NombreRol, Descripción)
* **Usuario** (PK_idUsuario, nombreUsuario, contraseña, nombre, apellido, fechaNacimiento, DNI, tlfContacto, 
    FK_idRol)
* **FranjaHoraria** (PK_idFraja, capacidadMax, ocupacionActual,FranjaInicio, FranjaFin)
* **Reserva** (PK_idReserva, cantidadComensales, precioTotal, FechaReserva, fechaReservada,
    FK_idUsuario, FK_idFranja)
* **Bebidas** (PK_idBebida, nombre, precioUnitario, imagen, descripción)
* **Platos** (PK_idPlato, nombre, descripcion, imagen, precioUnitario, tipo, 
	  FK_idCategoria)
* **OfrecerBebida** (FK_idReserva,Fk_idBebida, cantidadBebidas)
* **PedirPlato** (PK_idReserva, PK_idPlato, cantidadPlatos)
* **Categoria** (PK_idCategoria, nombre, descripcion)

#### Esquema EER
![EER](https://user-images.githubusercontent.com/22893383/110511925-0bef8c00-8105-11eb-9949-833c2dc4fa2d.png)

#### 4. URIs endpoints.
```
Usuario
GET       /api/usuarios
POST      /api/usuarios
GET       /api/usuarios/{id}
PUT       /api/usuarios/{id}
DELETE    /api/usuarios/{id}

UsuarioApi
GET       /api/users
POST      /api/users
GET       /api/users/{id}
PUT       /api/users/{id}
DELETE    /api/users/{id}

Bebida
GET       /api/bebidas
POST      /api/bebidas
GET       /api/bebidas/{id}
PUT       /api/bebidas/{id}
DELETE    /api/bebidas/{id}

Categoria
GET       /api/categorias
POST      /api/categorias
GET       /api/categorias/{id}
PUT       /api/categorias/{id}
DELETE    /api/categorias/{id}

FranjaHoraria
GET       /api/franjashorarias
POST      /api/franjashorarias
GET       /api/franjashorarias/{id}
PUT       /api/franjashorarias/{id}
DELETE    /api/franjashorarias/{id}

OfrecerBebida
GET       /api/ofrecerBebidas
POST      /api/ofrecerBebidas
GET       /api/ofrecerBebidas/{id}
PUT       /api/ofrecerBebidas/{id}
DELETE    /api/ofrecerBebidas/{id}

PedirPlatos
GET       /api/pedirPlatos
POST      /api/pedirPlatos
GET       /api/pedirPlatos/{id}
PUT       /api/pedirPlatos/{id}
DELETE    /api/pedirPlatos/{id}

Platos
GET       /api/platos
POST      /api/platos
GET       /api/platos/{id}
PUT       /api/platos/{id}
DELETE    /api/platos/{id}

Reserva
GET       /api/reservas
POST      /api/reservas
GET       /api/reservas/{id}
PUT       /api/reservas/{id}
DELETE    /api/reservas/{id}

Rol
GET       /api/roles
POST      /api/roles
GET       /api/roles/{id}
PUT       /api/roles/{id}
DELETE    /api/roles/{id}
```


