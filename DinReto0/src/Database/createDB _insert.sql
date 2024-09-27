CREATE DATABASE  IF NOT EXISTS UserDB;
USE UserDB;
CREATE TABLE IF NOT EXISTS User (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(100),
    username VARCHAR(100),
    password VARCHAR(100),
    balance DECIMAL(10,2)
);

INSERT INTO User (dni, nombre, username, password, balance) VALUES
('29468264F', 'Amador', 'amador33', 'Amador1976','250836.37');
