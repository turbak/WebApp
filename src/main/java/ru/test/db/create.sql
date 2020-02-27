CREATE TABLE profiles (
      name CHAR(12) PRIMARY KEY ,
      password text not null ,
      first_name text not null ,
      last_name text not null
);

DROP SEQUENCE if EXISTS referrer_seq;
CREATE SEQUENCE referrer_seq
    START WITH 1
    INCREMENT BY 50;
DROP SEQUENCE IF EXISTS profile_seq;
CREATE SEQUENCE profile_seq
    START WITH 1
    INCREMENT BY 50;

INSERT INTO referrers(referrer_id, num_of_followers, ref_name) VALUES (0, 0, null);