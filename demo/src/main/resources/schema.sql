-- TABLA CLIENTE
CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cedula INT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    celular BIGINT NOT NULL
);
-- TABLA MASCOTA
CREATE TABLE IF NOT EXISTS mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    raza VARCHAR(255),
    edad INT,
    peso FLOAT,
    enfermedad VARCHAR(255),
    foto VARCHAR(255),
    estado BOOLEAN,
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
--TABLA ADMIN
CREATE TABLE IF NOT EXISTS adm (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

--INSERCIÓN ADMIN
--INSERT INTO adm (usuario,contrasena)VALUES('ADMIN','ADMIN');
--INSERCIÓN CLIENTE
--INSERT INTO CLIENTE(celular, cedula, correo, nombre)VALUES (5551234567, 1, 'ana.perez@example.com', 'Ana Pérez');
--INSERT INTO CLIENTE (celular, cedula, correo, nombre)VALUES (5551234568, 2, 'juan.perez@example.com', 'Juan Pérez');
--INSERT INTO CLIENTE (celular, cedula, correo, nombre)VALUES(55554434568, 3, 'santi.ortiz@example.com', 'Santi Ortiz');
--INSERCIÓN MASCOTA
--INSERT INTO MASCOTA(NOMBRE,RAZA,EDAD,PESO,ENFERMEDAD,FOTO,ESTADO,CLIENTE_ID)VALUES('Firulais', 'Pastor Aleman', 5, 20.0, 'Moquillo', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg', TRUE, 1);
--INSERT INTO MASCOTA(NOMBRE,RAZA,EDAD,PESO,ENFERMEDAD,FOTO,ESTADO,CLIENTE_ID)VALUES('Rex', 'Pitbull', 3, 15.0, 'Rabia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/000_American_Pit_Bull_Terrier.jpg/480px-000_American_Pit_Bull_Terrier.jpg', TRUE, 2);
--INSERT INTO MASCOTA(NOMBRE,RAZA,EDAD,PESO,ENFERMEDAD,FOTO,ESTADO,CLIENTE_ID)VALUES('Boby', 'Chihuahua', 2, 5.0, 'Gripe', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg', TRUE, 3);



