CREATE DATABASE history_data_base;

USE history_data_base;

CREATE TABLE history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL
);

INSERT INTO history (username, user_password)
VALUES ('admin', '123456'),
 ('teste', '123');
SELECT * FROM history;
update * From history;