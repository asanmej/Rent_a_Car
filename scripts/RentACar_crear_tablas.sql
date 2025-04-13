-- Tabla de clientes
create table clientes (
     idCliente  NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY UNIQUE,
     nombre VARCHAR2(25) NOT NULL ,
     apellidos  VARCHAR2(25) NOT NULL,
     email VARCHAR2(25) NOT NULL,
     numeroTelefono VARCHAR2(12) NOT NULL,
     PRIMARY KEY (nombre, apellidos, numeroTelefono)
     );

INSERT INTO clientes VALUES (NULL,'Alejandro', 'Santos Mejías', 'aaaa@fjdsfkj.es', '111111111');
INSERT INTO clientes VALUES (NULL,'Pepito', 'Santos Mejías', 'bbbb@fjdsfkj.es', '222222222');
INSERT INTO clientes VALUES (NULL,'Fulanito', 'Santos Mejías', 'cccc@fjdsfkj.es', '333333333');
INSERT INTO clientes VALUES (NULL,'Jorgito', 'Santos Mejías', 'dddd@fjdsfkj.es', '+444444444');

-- DROP TABLE clientes;

-- Tabla de empleados
create table empleado (
     idEmpleado  NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY UNIQUE,
     nombre VARCHAR2(25) NOT NULL ,
     apellidos  VARCHAR2(25) NOT NULL,
     email VARCHAR2(25) NOT NULL,
     rol VARCHAR(15) NOT NULL CHECK (rol IN ('empleado', 'administrador', 'adminEmpleado')),
     usuario VARCHAR2(25) NOT NULL UNIQUE,
     password VARCHAR2(12) NOT NULL,
     PRIMARY KEY (nombre, apellidos, rol, usuario, password) 
     );
     
INSERT INTO empleado VALUES (NULL,'Alejandro', 'Santos Mejías', 'aaaa@fjdsfkj.es', 'administrador', 'asanmej', '1111');
INSERT INTO empleado VALUES (NULL,'Alejandro', 'Santos Mejías', 'aaaa@fjdsfkj.es', 'adminEmpleado', 'asm', '1111');
INSERT INTO empleado VALUES (NULL,'Fulanito', 'Santos Mejías', 'aaaa@fjdsfkj.es', 'empleado', 'abc', '1111');
INSERT INTO empleado VALUES (NULL,'Menganito', 'Santos Mejías', 'aaaa@fjdsfkj.es', 'empleado', 'empleado', '1111');

-- DROP TABLE empleado;

create table vehiculo (
     idVehiculo  NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY UNIQUE,
     nombre VARCHAR2(25) NOT NULL ,
     marca  VARCHAR2(25) NOT NULL,
     km NUMBER(10) NOT NULL,
     matricula VARCHAR(10) NOT NULL UNIQUE,
     fechaMantenimiento DATE NOT NULL,
     fechaAlta DATE NOT NULL,
     precioDia NUMBER(6,2) NOT NULL,
     categoriaVehiculo VARCHAR(12) CHECK(categoriaVehiculo IN ('turismo', 'furgoneta', 'motocicleta')),
     tipoVehiculo VARCHAR(12),     
     PRIMARY KEY (nombre, marca, matricula),
     CONSTRAINT chk_tipo_vehiculo CHECK (
        (categoriaVehiculo = 'turismo' AND tipoVehiculo IN ('pequeño', 'mediano', 'lujo')) OR
        (categoriaVehiculo = 'furgoneta' AND tipoVehiculo IN ('estandar', 'gran capacidad')) OR
        (categoriaVehiculo = 'motocicleta' AND tipoVehiculo IS NULL)
        )
     );

INSERT INTO vehiculo VALUES (1, 'Sandero', 'Corsa', 10000, 'ABC1234', '11-04-2025','11-04-2025', 14.2, 'furgoneta', 'estandar');
INSERT INTO vehiculo VALUES (2, 'Matiz', 'Chevroletz', 0, 'FDZ1011', '01-01-2023','05062024', 5.4, 'turismo', 'pequeño');
INSERT INTO vehiculo VALUES (3, 'K 1600 GTL', 'BMW', 100000, 'KAK2929', '02022018','05062019', 5.4, 'motocicleta', NULL);
INSERT INTO vehiculo VALUES (NULL, 'Matiz', 'Chevroletz', 0, 'FDZ11', '01-01-2023','05062024', 5.4, 'turismo', 'mediano');

--DELETE FROM vehiculo WHERE matricula = 'aaaa';
--UPDATE vehiculo SET marca = 'aaaa' WHERE idVehiculo = 14;
--UPDATE vehiculo SET preciodia = 10 WHERE tipoVehiculo = 'mediano' AND categoriaVehiculo = 'turismo';

-- DROP TABLE vehiculo CASCADE CONSTRAINTS;


-- Tabla Mantenimiento
CREATE TABLE mantenimiento (
    idVehiculo NUMBER ,
    fechaMantenimiento DATE NOT NULL,
    
    CONSTRAINT fk_mantenimiento_vehiculo 
        FOREIGN KEY (idVehiculo) 
        REFERENCES vehiculo(idVehiculo)
        ON DELETE CASCADE
);

INSERT INTO mantenimiento VALUES (3, '02-08-2018');
INSERT INTO mantenimiento VALUES (3, '02-01-2019');
INSERT INTO mantenimiento VALUES (3, '02-06-2018');
INSERT INTO mantenimiento VALUES (1, '11-04-2025');
INSERT INTO mantenimiento VALUES (2, '05-06-2025');

-- DROP TABLE mantenimiento;

-- Tabla Alquiler
CREATE TABLE alquiler (
    idAlquiler NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    idVehiculo NUMBER NOT NULL,
    idCliente NUMBER NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    idEmpleado NUMBER NOT NULL,
    CONSTRAINT fechaFin_before_fechaInicio CHECK(fechaFin > fechaInicio)
);

INSERT INTO alquiler VALUES (NULL, 2,1, '12-01-2025', '15-01-2025', 1);