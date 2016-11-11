# --- !Ups

create table  "person" (
  user_id     bigint NOT NULL,
  surname     VARCHAR(254),
  firstname   VARCHAR(254),
  email       VARCHAR(254) NOT NULL,
  password    VARCHAR(16) NOT NULL,
  PRIMARY KEY (user_id));

create sequence person_seq;

create table  "role" (
  role        VARCHAR(12) NOT NULL,
  description VARCHAR(254),
  PRIMARY KEY (role));

create table  "user_role" (
  user_role_id  bigint NOT NULL,
  role          VARCHAR(12) NOT NULL REFERENCES role(role),
  user_id       bigint NOT NULL REFERENCES person(user_id),
  PRIMARY KEY  (user_role_id));

create sequence user_role_seq;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;
drop table person;
drop table user_role;
drop table role;

SET REFERENTIAL_INTEGRITY TRUE;
drop sequence if exists person_seq;
drop sequence if exists user_role_seq;