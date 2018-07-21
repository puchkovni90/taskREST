-- Database: "jerseyWeb"
DROP DATABASE "jerseyWeb";
CREATE DATABASE "jerseyWeb"
  WITH OWNER = postgres
       ENCODING = 'WIN1251'
       TABLESPACE = pg_default
       LC_COLLATE = 'Russian_Russia.1251'
       LC_CTYPE = 'Russian_Russia.1251'
       CONNECTION LIMIT = -1;
-- USE jerseyWeb
-- for PostgreSQL only!
\c jerseyWeb;
-- Table: users
-- DROP TABLE users;
CREATE TABLE users
(
     id serial NOT NULL,
     username character varying(100),
     passwd_hashcode integer,
     CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
OIDS=FALSE
);
ALTER TABLE users
OWNER TO postgres;
-- Fill
INSERT INTO users (username, passwd_hashcode) VALUES ('user0','-928147211'),
     ('user1','-928147210'),
     ('user2','-928147209'),
     ('user3','-928147208'),
     ('user4','-928147207'),
     ('user5','-928147206'),
     ('user6','-928147205'),
     ('user7','-928147204'),
     ('user8','-928147203'),
     ('user9','-928147202'),
     ('user10','1292207610'),
     ('user11','1292207611'),
     ('user12','1292207612'),
     ('user13','1292207613'),
     ('user14','1292207614');