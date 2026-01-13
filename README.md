CREATE DATABASE apu_db;

USE apu_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);
INSERT INTO users (name, email, password)
VALUES ('Appu', 'appu@gmail.com', '12345');

SELECT * FROM users;
