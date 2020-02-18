DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id SERIAL primary key,
    login char(12) NOT NULL UNIQUE ,
    password text NOT NULL,
    name text NOT NULL,
    surname text NOT NULL
);