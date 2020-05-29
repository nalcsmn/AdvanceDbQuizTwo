create database one;
use one;

CREATE TABLE details(
	userId INT PRIMARY KEY AUTO_INCREMENT,
    lastName VARCHAR(255),
    firstName VARCHAR(255),
    middleName VARCHAR(255),
    edad int
);


INSERT INTO details (lastName, firstName, middleName, edad) VALUES 
('Lacsamana', 'Neil','De vera',23), ('Vergel De Dios', 'Kurt','qwe',20),('Rivera', 'Reese','qwe',20);

select * from details;

SELECT * FROM details where user_id = 1;
