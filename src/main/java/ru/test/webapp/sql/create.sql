DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id SERIAL primary key,
    login char(12) NOT NULL,
    password text NOT NULL,
    name text NOT NULL,
    surname text NOT NULL
);
ALTER TABLE users ADD column name text;
ALTER TABLE users ADD column surname text;