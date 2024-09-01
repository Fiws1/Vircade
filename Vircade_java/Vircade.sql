/* Creacion base de datos*/
create database if not exists ProyectoConAutos;
use ProyectoConAutos;

/* Creacion Tablas*/

create table if not exists Rol (
    Id_Rol INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_Rol VARCHAR(20) NOT NULL
);

INSERT INTO Rol (Nombre_Rol) VALUES ('Administrador'), ('Cliente');

create table if not exists Usuario (
    Correo VARCHAR(20) PRIMARY KEY,
    Contrasena_Usu VARCHAR(255) NOT NULL,
    Primer_Nombre VARCHAR(50) NOT NULL,
    Segundo_Nombre VARCHAR(50),
    Primer_Apellido VARCHAR(50) NOT NULL,
    Segundo_Apellido VARCHAR(50),
    Numero_telefono VARCHAR(15) NOT NULL,
    Rol INT NOT NULL,
    FOREIGN KEY (Rol) REFERENCES Rol(Id_Rol)
);


create table if not exists Asesor
(
Id_Asesor int primary key auto_increment,
p_nom_asesor varchar(20) not null,
s_nom_asesor varchar(20),
p_ape_asesor varchar(20) not null,
s_ape_asesor varchar(20),
Correo_asesor varchar(20) not null,
Telefono_asesor int unsigned not null,
Concesionario_Asig int not null
);

create table if not exists Concesionario
(
Id_Concesionario int primary key auto_increment,
Concesionario varchar(20) not null,
Direccion varchar(20) not null,
Disponibilidad int not null
);

create table if not exists Tipo_Vehiculo
(
Id_tipo_vehiculo int primary key auto_increment,
tipo_vehiculo varchar(20) not null
);

create table if not exists Disponibilidad
(
Id_dispo int primary key auto_increment,
Disponibilidad enum ("si", "no") not null
);

create table if not exists Marca
(
Id_marca int primary key auto_increment,
Marca varchar(20) not null
);

create table if not exists Vehiculo
(
Id_Vehiculo int primary key auto_increment,
Vehiculo varchar(20) not null,
Linea varchar(20) not null,
cilindraje varchar(10) not null,
Color varchar(10) not null,
Precio int unsigned not null,
Imagen blob not null,
Modelo_vehiculo int not null,
Marca_vehiculo int not null,
Combustible_vehiculo int not null,
Tipo_vehiculo int not null,
concesionario int not null
);

create table if not exists Modelo
(
Id_modelo int primary key auto_increment,
Modelo mediumint unsigned not null
);

create table if not exists Combustible
(
Id_combustible int primary key auto_increment,
Tipo_combustible varchar(20) not null
);

create table if not exists Cita (
ID int primary key auto_increment,
Fecha date not null,
Hora time not null,
Tipo_cita varchar(15) not null,
Cliente_relacionado varchar(50) not null,
Concesionario_Asig int not null
);


/* Creacion Llaves Foraneas*/


alter table Vehiculo add foreign key (Modelo_vehiculo) references Modelo (Id_modelo);

alter table Vehiculo add foreign key (Marca_vehiculo) references Marca (Id_marca);

alter table Vehiculo add foreign key (Combustible_vehiculo) references Combustible (Id_combustible);

alter table Vehiculo add foreign key (Tipo_vehiculo) references Tipo_Vehiculo (Id_tipo_vehiculo);

alter table Concesionario add foreign key (Disponibilidad) references Disponibilidad (Id_dispo);

alter table Vehiculo add foreign key (Concesionario) references Concesionario (Id_Concesionario);

alter table Cita add foreign key (Cliente_relacionado) references Usuario (Correo);

alter table Cita add foreign key (Concesionario_Asig) references Concesionario (Id_Concesionario);

alter table Asesor add foreign key (Concesionario_Asig) references Concesionario (Id_Concesionario);



          -- ASESOR
     -- insertar Asesor
DELIMITER //
CREATE PROCEDURE insertAsesor
(
Id_AsesorP int,
p_nom_asesorP varchar(20),
s_nom_asesorP varchar(20),
p_ape_asesorP varchar(20),
s_ape_asesorP varchar(20),
Correo_asesorP varchar(20),
Telefono_asesorP int,
Concesionario_AsingP int
)
BEGIN
INSERT INTO asesor
(
Id_Asesor, p_nom_asesor, s_nom_asesor, p_ape_asesor, s_ape_asesor, Correo_asesor, Telefono_asesor, Concesionario_Asing)
VALUES
(Id_AsesorP, p_nom_asesorP, s_nom_asesorP, p_ape_asesorP, s_ape_asesorP, Correo_asesorP, Telefono_asesorP, Concesionario_AsingP);
END//
DELIMITER ;
     -- actualizar Asesor
DELIMITER //
CREATE PROCEDURE actualizarAsesor
(
Id_AsesorP int,
p_nom_asesorP varchar(20),
s_nom_asesorP varchar(20),
p_ape_asesorP varchar(20),
s_ape_asesorP varchar(20),
Correo_asesorP varchar(20),
Telefono_asesorP int,
Concesionario_Asing int
)
BEGIN
UPDATE asesor
SET
p_nom_asesor = p_nom_asesorP,
s_nom_asesor = Ps_nom_asesorP,
p_ape_asesor = p_ape_asesorP,
s_ape_asesor = s_ape_asesorP,
Correo_asesor = Correo_asesorP,
Telefono_asesor = Telefono_asesorP,
Concesionario_Asing = Concesionario_AsingP
WHERE Id_Asesor = Id_AsesorP;
END//
DELIMITER ;
     -- eliminar Asesor
DELIMITER //
CREATE PROCEDURE eliminarAsesor
(
Id_AsesorP int
)
BEGIN
DELETE FROM asesor
WHERE Id_Asesor = Id_AsesorP;
END//
DELIMITER ;
         -- CITA
     -- insertar Cita
DELIMITER //
CREATE PROCEDURE insertCita
(
IDP int,
FechaP date,
HoraP time,
Tipo_citaP varchar(15),
Cliente_relacionadoP varchar(20),
Concesionario_AsigP int
)
BEGIN
INSERT INTO cita
(
ID, Fecha, Hora, Tipo_cita, Cliente_relacionado, Concesionario_Asig
)
VALUES
(
IDP, FechaP, HoraP, Tipo_citaP, Cliente_relacionadoP, Concesionario_AsigP
);
END //
DELIMITER ;
     -- actualizar Cita
DELIMITER //
CREATE PROCEDURE actualizarCita
(
IDP int,
FechaP date,
HoraP time,
Tipo_citaP varchar(15),
Cliente_relacionadoP varchar(20),
Concesionario_AsigP int
)
BEGIN
UPDATE cita
SET
Fecha = FechaP,
Hora = HoraP,
Tipo_cita = Tipo_citaP,
Cliente_relacionado = Cliente_relacionadoP,
Concesionario_Asig = Concesionario_AsigP
WHERE ID = IDP;
END //
DELIMITER ;
     -- eliminar Cita
DELIMITER //
CREATE PROCEDURE eliminarCita
(
IDP int
)
BEGIN
DELETE FROM cita
WHERE ID = IDP;
END //
DELIMITER ;

         -- conbustible
     -- insertar Conbustible
DELIMITER //
CREATE PROCEDURE insertConbustible
(
Id_combustibleP int,
Tipo_combustibleP varchar (20)
)
BEGIN
INSERT INTO combustible
(Id_combustible,Tipo_combustible)
VALUES
(Id_combustibleP,Tipo_combustibleP);
END//
DELIMITER ;
     -- actualizar Conbustible
DELIMITER //
CREATE PROCEDURE actualizarConbustible
(
Id_combustibleP int ,
Tipo_combustibleP varchar (20)
)
BEGIN
UPDATE proyectoconautos.combustible
SET
Tipo_combustible = Tipo_combustibleP
WHERE Id_combustible = Id_combustibleP;
END//
DELIMITER ;
     -- eliminar Combustible
DELIMITER //
CREATE PROCEDURE eliminarCombustible
(
Id_combustibleP int
)
BEGIN
DELETE FROM cliente
WHERE Id_combustible = Id_combustibleP;
END //
DELIMITER ;
         -- Concesionario
     -- insertar Concesionario
DELIMITER //
CREATE PROCEDURE insertConcesionario
(
Id_ConcesionarioP int ,
ConcesionarioP varchar(20) ,
DireccionP varchar(20) ,
DisponibilidadP int
)
BEGIN
INSERT INTO concesionario
(Id_Concesionario, Concesionario, Direccion, Disponibilidad)
VALUES
(Id_ConcesionarioP, ConcesionarioP, DireccionP, DisponibilidadP);
END//
DELIMITER ;
     -- actualizar Concesionario
DELIMITER //
CREATE PROCEDURE actualizarConcesionario
(
Id_ConcesionarioP int ,
ConcesionarioP varchar(20) ,
DireccionP varchar(20) ,
DisponibilidadP int
)
BEGIN
UPDATE proyectoconautos.concesionario
SET
Id_Concesionario = Id_Concesionario,
Concesionario = Concesionario,
Direccion = Direccion,
Disponibilidad = Disponibilidad
WHERE Id_Concesionario = Id_Concesionario;
END//
DELIMITER ;
     -- eliminar Concesionario
DELIMITER //
CREATE PROCEDURE eliminarConcesionario
(
Id_ConcesionarioP int
)
BEGIN
DELETE FROM proyectoconautos.concesionario
WHERE Id_Concesionario = Id_Concesionario;
END//
DELIMITER ;
         -- DISPONIBILIDAD
     -- insertar Disponibilidad
DELIMITER //
CREATE PROCEDURE insertDisponibilidad
(
Id_dispoP int ,
DisponibilidadP enum ("si", "no") 
)
BEGIN
INSERT INTO disponibilidad
(
Id_dispo, Disponibilidad
)
VALUES
(Id_dispoP, DisponibilidadP);
END//
DELIMITER ;
     -- actualizar Disponibilidad
DELIMITER //
CREATE PROCEDURE actualizarDisponibilidad
(
Id_dispoP int ,
DisponibilidadP enum ("si", "no") 
)
BEGIN
UPDATE disponibilidad
SET
Id_dispo = Id_dispoP,
Disponibilidad = DisponibilidadP
WHERE Id_dispo = Id_dispoP;
END//
DELIMITER ;
     -- eliminar Disponibilidad
DELIMITER //
CREATE PROCEDURE elimiterDisponibilidad
(
Id_dispoP int
)
BEGIN
DELETE FROM disponibilidad
WHERE Id_dispo = Id_dispoP;
END //
DELIMITER ;
         -- MARCA
     -- insertar Marca
DELIMITER //
CREATE PROCEDURE insertMarca
(
Id_marcaP int,
MarcaP varchar (20)
)
BEGIN
INSERT INTO marca
(
Id_marca, Marca
)
VALUES
(
Id_marcaP, MarcaP
);
END//
DELIMITER ;
     -- actualizar Marca
DELIMITER //
CREATE PROCEDURE actualizarMarca
(
Id_marcaP int,
MarcaP varchar (20)
)
BEGIN
UPDATE marca
SET
Marca = MarcaP
WHERE Id_marca = Id_marcaP;
END//
DELIMITER ;
     -- eliminar Marca
DELIMITER //
CREATE PROCEDURE eliminarMarca
(
Id_marcaP int
)
BEGIN
DELETE FROM marca
WHERE Id_marca = Id_marcaP;
END //
DELIMITER ;

         -- MODELO
     -- insertar Modelo
DELIMITER //
CREATE PROCEDURE insertModelo
(
Id_modeloP int,
ModeloP mediumint
)
BEGIN
INSERT INTO modelo
(Id_modelo, Modelo)
VALUES
(Id_modeloP, ModeloP);
END//
DELIMITER ;
     -- actualizar Modelo
DELIMITER //
CREATE PROCEDURE actualizarModelo
(
ModeloP mediumint
)
BEGIN
UPDATE modelo
SET
Modelo = ModeloP
WHERE Id_modelo = Id_modeloP;
END //
DELIMITER ;
     -- eliminar Modelo
DELIMITER //
CREATE PROCEDURE eliminarModelo
(
Id_modeloP int
)
BEGIN
DELETE FROM modelo
WHERE Modelo = ModeloP;
END //
DELIMITER ;

         -- tipo vehiculo
     -- insertar Tipo Vehiculo
DELIMITER //
CREATE PROCEDURE insertTipo_vehiculo
(
Id_tipo_vehiculoP int,
tipo_vehiculoP varchar (20)
)
BEGIN
INSERT INTO tipo_vehiculo
(Id_tipo_vehiculo, tipo_vehiculo)
VALUES
(Id_tipo_vehiculoP, tipo_vehiculoP);
END //
DELIMITER ;
     -- modificar Tipo Vehiculo
DELIMITER //
CREATE PROCEDURE actualizarTipo_vehiculo
(
Id_tipo_vehiculoP int,
tipo_vehiculoP varchar (20)
)
BEGIN
UPDATE modelo
SET
tipo_vehiculo = tipo_vehiculoP
WHERE Id_tipo_vehiculo = Id_tipo_vehiculoP;
END //
DELIMITER ;
     -- eliminar Tipo vehiculo
DELIMITER //
CREATE PROCEDURE eliminarTipo_vehiculo
(
Id_tipo_vehiculoP int
)
BEGIN
DELETE FROM tipo_vehiculo
WHERE Id_tipo_vehiculo = Id_tipo_vehiculoP;
END //
DELIMITER ;
         -- USUARIO
     -- inser Usuario
DELIMITER //
CREATE PROCEDURE insertUsuario
(
CorreoP varchar (20),
Contrasena_UsuP Varchar (20),
 Primer_NombreP VARCHAR(50),
    Segundo_NombreP VARCHAR(50),
    Primer_ApellidoP VARCHAR(50) ,
    Segundo_ApellidoP VARCHAR(50),
    Numero_telefonoP VARCHAR(15) ,
    RolP INT 
  
)
BEGIN
INSERT INTO usuario
(Correo, Contrasena_Usu, Primer_Nombre, Segundo_Nombre, Primer_Apellido, Segundo_Apellido, Numero_telefono, Rol )
VALUES
(CorreoP, Contrasena_UsuP, Primer_NombreP, Segundo_NombreP, Primer_ApellidoP, Segundo_ApellidoP, Numero_telefonoP, RolP);
END //
DELIMITER ;
     -- actualizar Usuario
DELIMITER //
CREATE PROCEDURE actualizarUsuario
(
CorreoP varchar (20),
Contrasena_UsuP Varchar (20),
Primer_NombreP VARCHAR(50),
    Segundo_NombreP VARCHAR(50),
    Primer_ApellidoP VARCHAR(50) ,
    Segundo_ApellidoP VARCHAR(50),
    Numero_telefonoP VARCHAR(15) ,
    RolP INT 
)
BEGIN
UPDATE usuario
SET
Correo = Correo,
Contrasena_Usu = Contrasena_Usu,
Primer_Nombre = Primer_Nombre,
Segundo_Apellido = Segundo_Apellido,
Primer_Apellido = Primer_Apellido,
Segundo_Apellido = Segundo_Apellido,
Numero_telefono = Numero_telefono,
Rol = Rol
WHERE Correo = Correo;
END //
DELIMITER ;
     -- eliminar Usuario
DELIMITER //
CREATE PROCEDURE eliminarUsuario
(
CorreoP varchar (20)
)
BEGIN
DELETE FROM usuario
WHERE Correo = Correo;
END //
DELIMITER ;
         -- VEHICULO
     -- insert Vehiculo
DELIMITER //
CREATE PROCEDURE insertVehiculo
(
Id_VehiculoP int,
VehiculoP varchar(20),
LineaP varchar(20),
cilindrajeP varchar(10),
ColorP varchar(10),
PrecioP int,
ImagenP blob,
Modelo_vehiculoP int,
Marca_vehiculoP int,
Combustible_vehiculoP int,
Tipo_vehiculoP int,
concesionarioP int
)
BEGIN
INSERT INTO vehiculo
(Id_Vehiculo, Vehiculo, Linea, cilindraje, Color, Precio, Imagen, Modelo_vehiculo, Marca_vehiculo, Combustible_vehiculo, Tipo_vehiculo, concesionario)
VALUES
(Id_VehiculoP, VehiculoP, LineaP, cilindrajeP, ColorP, PrecioP, ImagenP, Modelo_vehiculoP, Marca_vehiculoP, Combustible_vehiculoP, Tipo_vehiculoP, concesionarioP);
END //
DELIMITER ;
     -- actualizar Vehiculo
DELIMITER //
CREATE PROCEDURE actualizarVehiculo
(
Id_VehiculoP int,
VehiculoP varchar(20),
LineaP varchar(20),
cilindrajeP varchar(10),
ColorP varchar(10),
PrecioP int,
ImagenP blob,
Modelo_vehiculoP int,
Marca_vehiculoP int,
Combustible_vehiculoP int,
Tipo_vehiculoP int,
concesionarioP int
)
BEGIN
UPDATE vehiculo
SET
Vehiculo = VehiculoP,
Linea = LineaP,
cilindraje = cilindrajeP,
Color = ColorP,
Precio = PrecioP,
Imagen = ImagenP,
Modelo_vehiculo = Modelo_vehiculoP,
Marca_vehiculo = Marca_vehiculoP,
Combustible_vehiculo = Combustible_vehiculoP,
Tipo_vehiculo = Tipo_vehiculoP,
concesionario = concesionarioP
WHERE Id_Vehiculo = Id_VehiculoP;
END //
DELIMITER ;
     -- eliminar Vehiculo
DELIMITER //
CREATE PROCEDURE eliminarVehiculo
(
Id_VehiculoP int
)
BEGIN
DELETE FROM vehiculo
WHERE Id_Vehiculo = Id_VehiculoP;
END //
DELIMITER ;

-- Inserciones en la tabla registro
call insertRegistro ('juan@example.com','Juan', 'Carlos', 'Perez', 'Gomez', 123456789);
call insertRegistro ('saoli@gmail.com','Juan', 'Carlos', 'Perez', 'Gomez', 987654321);

-- Inserciones en la tabla Tipo_Vehiculo
call insertTipo_vehiculo (1,'Sedan');
call insertTipo_vehiculo (2,'SUV');
call insertTipo_vehiculo (3,'Camioneta');
call insertTipo_vehiculo (4,'Compacto');

-- Inserciones en la tabla Marca
call insertMarca (1,'Toyota');
call insertMarca (2,'Honda');
call insertMarca (3,'Ford');
call insertMarca (4,'Chevrolet');

-- Inserciones en la tabla Modelo
call insertModelo (1,2022);
call insertModelo (2,2023);
call insertModelo (3,2024);

-- Inserciones en la tabla Combustible
call insertConbustible (1,'Gasolina');
call insertConbustible (2,'Diesel');
call insertConbustible (3,'Híbrido');

-- Inserciones en la tabla disponibilidad
call insertDisponibilidad (1,'si');
call insertDisponibilidad (2,'no');

-- Inserciones en la tabla Concesionario
call insertConcesionario (1,'Concesionario A', 'Calle Principal 123', 1);

-- Inserciones en la tabla Cita
call insertarCita (1,'12/12/2023','10:00','Recomendacion',1,1);

-- Inserciones en la tabla Cliente
call insertCliente (1,'Juan', 'Carlos', 'Perez', 'Gomez', 123456789, 'juan@example.com', 1);
call insertCliente (2,'Juan', 'Carlos', 'Perez', 'Gomez', 987654321, 'saoli@gmail.com', 1);

-- Inserciones en la tabla Asesor
call insertAsesor (1,'Pedro', 'Luis', 'Garcia', 'Martinez', 'pedro@example.com', 9876543210, 1);

-- Inserciones en la tabla Usuario
call insertUsuario ('juan@example.com', 'password123', 1);
call insertUsuario ('saoli@gmail.com', 'password123', 2);

-- Inserciones en la tabla Vehiculo
call insertVehiculo (1,'Corolla', 'Sedan', '2000cc', 'Azul', 25000,'.IMG', 1, 1, 1, 1, 1);
call insertVehiculo (2,'CR-V', 'SUV', '2500cc', 'Gris', 30000,'.IMG', 2, 2, 2, 2, 1);
call insertVehiculo (3,'F-150', 'Pickup', '3500cc', 'Negro', 35000,'.IMG', 3, 3, 3, 3, 1);

SELECT 
    M.Modelo, 
    V.Linea, 
    TV.tipo_vehiculo, 
    V.Precio
FROM 
    Vehiculo V
INNER JOIN 
    Modelo M ON V.Modelo_vehiculo = M.Id_modelo
INNER JOIN 
    Tipo_Vehiculo TV ON V.Tipo_vehiculo = TV.Id_tipo_vehiculo
INNER JOIN 
    Combustible C ON V.Combustible_vehiculo = C.Id_combustible
INNER JOIN 
    Disponibilidad D ON V.Disponibilidad = D.Id_dispo
WHERE 
    C.Tipo_combustible = 'Diesel' AND 
    D.Disponibilidad = 'si';

SELECT 
    C.p_nom_cliente, 
    C.s_nom_cliente, 
    C.Correo_cliente
FROM 
    Cliente C
INNER JOIN 
    Vehiculo V ON C.Id_cliente = V.Id_Vehiculo
INNER JOIN 
    Cita CT ON C.Id_cliente = CT.Cliente_relacionado
INNER JOIN 
    Asesor A ON CT.ID = A.Id_Asesor;

SELECT 
    M.Modelo, 
    V.Linea, 
    TV.tipo_vehiculo, 
    V.Precio
FROM 
    Vehiculo V
INNER JOIN 
    Modelo M ON V.Modelo_vehiculo = M.Id_modelo
INNER JOIN 
    Tipo_Vehiculo TV ON V.Tipo_vehiculo = TV.Id_tipo_vehiculo;