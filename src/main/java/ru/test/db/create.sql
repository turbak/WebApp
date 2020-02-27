CREATE TABLE profiles (
      name CHAR(12) PRIMARY KEY ,
      password text not null ,
      first_name text not null ,
      last_name text not null
);

CREATE SEQUENCE referrer_seq
    START WITH 1
    INCREMENT BY 1;