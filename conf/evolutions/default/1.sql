# --- !Ups

create table  "person" (
  id          bigint NOT NULL,
  surname     VARCHAR(254),
  firstname   VARCHAR(254),
  email       VARCHAR(254),
  constraint pk_person primary key (id));

create sequence person_seq;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;
drop table person;

SET REFERENTIAL_INTEGRITY TRUE;
drop sequence if exists person_seq;
