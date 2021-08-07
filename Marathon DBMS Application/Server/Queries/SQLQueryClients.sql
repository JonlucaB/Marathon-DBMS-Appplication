CREATE DATABASE Clients;
USE Clients;

CREATE TABLE ClientInfo
(
ClientID INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
ClientFirstName VARCHAR(15) NOT NULL,
ClientLastName VARCHAR(15) NOT NULL,
ClientPhoneNumber BIGINT NOT NULL,
ClientEmail VARCHAR(25) NOT NULL,
ClientAddress VARCHAR(30),
ClientCity VARCHAR(20),
ClientCountry VARCHAR(20),
ClientAge INT DEFAULT 0,
ClientDOB DATE
);

--ALTER TABLE ClientInfo ALTER COLUMN ClientFirstName VARCHAR(15) NOT NULL;

--ALTER TABLE ClientInfo ALTER COLUMN ClientLasttName VARCHAR(15) NOT NULL;

--ALTER TABLE ClientInfo ALTER COLUMN ClientPhoneNumber BIGINT NOT NULL;

--ALTER TABLE ClientInfo ADD ClientEmail VARCHAR(20) NOT NULL;

--ALTER TABLE ClientInfo ADD ClientAge INT DEFAULT 0;

--ALTER TABLE ClientInfo DROP COLUMN ClientAge;

--ALTER TABLE ClientInfo ADD ClientDOB DATE;

--ALTER TABLE ClientInfo ADD ClientAgent INT 

DROP TABLE ClientInfo;

CREATE TABLE EmployeeInfo
(
	EmployeeID INT IDENTITY(1,1) NOT NULL,
	EmployeeFirstName VARCHAR(15) NOT NULL,
	EmployeeLastName VARCHAR(15) NOT NULL,
	EmployeePhoneNumber BIGINT,
	SpecializeIn VARCHAR(40),
	PRIMARY KEY(EmployeeID)
);

--ALTER TABLE EmployeeInfo ADD SpecializeIn VARCHAR(40);

CREATE TABLE TCLSample (ClientID INT, ClientFirstName VARCHAR(20), ClientLastName VARCHAR(40), ClientRating INT);
INSERT INTO TCLSample VALUES(1, 'Jim', 'Jones', 23);
INSERT INTO TCLSample VALUES(2, 'Pam', 'Weasly', 48);
INSERT INTO TCLSample VALUES(3, 'Bob', 'Builder', 30);
INSERT INTO TCLSample VALUES(4, 'Rick', 'Sanchez', 100);

UPDATE EmployeeInfo SET SpecializeIn = 'Europe and Mediterranian' WHERE EmployeeID = 1;

DROP TABLE EmployeeInfo;

--------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO ClientInfo VALUES ('Jane', 'Doe', 1234567890, 'JaneD@email.com','123 road street', 'San Antonio', 'USA', 19, '2001-07-06');
INSERT INTO ClientInfo VALUES ('Robert', 'Smith', 2234567890, 'RoberthS@email.com','123 Mulberry street', 'San Antonio', 'USA', 31, '1990-06-14');
INSERT INTO ClientInfo VALUES ('Mkie', 'Scott', 3234567890, 'MScott@email.com','123 Mary street', 'San Antonio', 'USA', 52, '1969-06-14');
INSERT INTO ClientInfo VALUES ('Tim', 'Durby', 4234567890, 'TDurby@email.com','123 Lake street', 'San Antonio', 'USA', 46, '1970-08-12');
INSERT INTO ClientInfo VALUES ('Jimmy', 'Page', 423123890, 'LedZep@email.com','42069 Rock', 'London', 'UK', 72, '1950-03-18');
INSERT INTO ClientInfo VALUES ('Sarah', 'Palmer', 41231567890, 'Spalm@email.com','4087 Cliff Ct', 'Tenessee', 'USA', 67, '1955-12-03');
INSERT INTO ClientInfo VALUES ('Michelle', 'Lotskin', 4375567890, 'LotsOfSkin@email.com','1001 Sweet Palm Ln', 'Miami', 'USA', 51, '1970-09-28');

INSERT INTO EmployeeInfo VALUES ('Natalie', 'Biagini', 5129473385, 'Europe and Mediterranean');

SELECT * FROM EmployeeInfo;

SELECT * INTO ClientInfoBackup FROM ClientInfo;

SELECT * FROM ClientInfoBackup;

CREATE PROCEDURE Client_City @CCity VARCHAR(40)
AS
SELECT * FROM ClientInfo
WHERE ClientCity = @CCity
GO
SELECT * FROM ClientInfo
EXECUTE Client_City @CCity = 'San Antonio'

CREATE LOGIN SAMPLE WITH PASSWORD = 'sample';

CREATE USER SAMPLE FOR LOGIN SAMPLE;

GRANT SELECT ON ClientInfo TO SAMPLE;
REVOKE SELECT ON ClientInfo TO SAMPLE;

--TCL Commands

BEGIN TRY 
BEGIN TRANSACTION
INSERT INTO TCLSample VALUES (5, 'Avinash', 'Akatosh', 55);
UPDATE TCLSample SET ClientFirstName = 'Akash' Where ClientID = 5;
UPDATE TCLSample SET ClientRating = 67/0 WHERE ClientID = 5;
COMMIT TRANSACTION
PRINT 'TRANSACTION COMPLETED'
END TRY
BEGIN CATCH
ROLLBACK TRANSACTION
PRINT 'TRANSACTION UNSUCCESSFUL AND ROLLED BACK'
END CATCH;

SELECT * FROM TCLSample;

--Exception Handling

BEGIN TRY 
SELECT ClientPhoneNumber+ClientFirstName FROM ClientInfo;
END TRY
BEGIN CATCH
PRINT 'NOT POSSIBLE'
END CATCH;