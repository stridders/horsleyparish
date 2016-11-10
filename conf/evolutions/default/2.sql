# --- !Ups

alter table person add column
  password    VARCHAR(16);

# --- !Downs

alter table person drop column password;
