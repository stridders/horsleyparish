# --- !Ups

create table  "document_type" (
  document_type   VARCHAR(30),
  description     VARCHAR(254),
  role            VARCHAR(12) NOT NULL REFERENCES role(role),
  PRIMARY KEY (document_type));

create table  "document" (
  document_id     bigint NOT NULL,
  document_type   VARCHAR(30) REFERENCES document_type(document_type),
  name            VARCHAR(254),
  document        bytea NOT NULL,
  upload_date     TIMESTAMP NOT NULL,
  user_id         bigint NOT NULL REFERENCES person(user_id),
  format          VARCHAR(5) NOT NULL,
  file_size       bigint NOT NULL,
  PRIMARY KEY (document_id));

create sequence document_seq;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;
drop table document;
drop table document_type;

SET REFERENTIAL_INTEGRITY TRUE;
drop sequence if exists document_seq;

