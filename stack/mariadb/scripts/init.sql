-- create the databases
CREATE DATABASE IF NOT EXISTS crypto_wolf;
-- create the users for each database
CREATE USER 'mkel'@'localhost' IDENTIFIED BY '12345';

USE crypto_wolf;
CREATE TABLE Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);