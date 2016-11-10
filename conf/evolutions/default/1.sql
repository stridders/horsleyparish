# --- !Ups

create table  "user" (
  id          bigint NOT NULL,
  surname     VARCHAR(254),
  firstname   VARCHAR(254),
  email       VARCHAR(254),
  constraint pk_user primary key (id));

create sequence user_seq;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;
drop table user;

SET REFERENTIAL_INTEGRITY TRUE;
drop sequence if exists user_seq;
