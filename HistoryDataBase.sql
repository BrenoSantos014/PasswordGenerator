CREATE DATABASE history_data_base;

USE history_data_base;

CREATE TABLE history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

INSERT INTO history (username, password)
VALUES ('admin', '123456');

SELECT * FROM history;