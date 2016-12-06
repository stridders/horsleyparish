# --- !Ups

CREATE SEQUENCE person_user_id_seq;
CREATE TABLE  "person" (
  user_id         BIGINT PRIMARY KEY DEFAULT nextval('person_user_id_seq'),
  surname         VARCHAR(254),
  firstname       VARCHAR(254),
  email           VARCHAR(254) NOT NULL,
  password        VARCHAR(16) NOT NULL);
ALTER SEQUENCE person_user_id_seq OWNED BY person.user_id;


CREATE TABLE "role" (
  role            VARCHAR(20) PRIMARY KEY NOT NULL,
  description     VARCHAR(254));


CREATE SEQUENCE user_role_user_role_id_seq;
CREATE TABLE  "user_role" (
  user_role_id    BIGINT PRIMARY KEY DEFAULT nextval('user_role_user_role_id_seq'),
  role            VARCHAR(20) NOT NULL REFERENCES role(role),
  user_id         bigint NOT NULL REFERENCES person(user_id));
ALTER SEQUENCE user_role_user_role_id_seq OWNED BY user_role.user_role_id;


CREATE TABLE  "document_type" (
  document_type   VARCHAR(50) PRIMARY KEY,
  description     VARCHAR(254),
  role            VARCHAR(20) NOT NULL REFERENCES role(role));


CREATE SEQUENCE document_document_id_seq;
CREATE TABLE  "document" (
  document_id     BIGINT PRIMARY KEY DEFAULT nextval('document_document_id_seq'),
  document_type   VARCHAR(50) REFERENCES document_type(document_type),
  name            VARCHAR(254) NOT NULL,
  document        bytea,
  upload_date     TIMESTAMP NOT NULL,
  user_id         bigint NOT NULL REFERENCES person(user_id),
  format          VARCHAR(5) NOT NULL);
ALTER SEQUENCE document_document_id_seq OWNED BY document.document_id;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;
drop table person;
drop table user_role;
drop table role;
drop table document;
drop table document_type;

SET REFERENTIAL_INTEGRITY TRUE;
drop sequence if exists person_user_id_seq;
drop sequence if exists user_role_user_role_id_seq;
drop sequence if exists document_document_id_seq;