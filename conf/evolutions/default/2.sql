# --- !Ups

insert into role (role,description) values ('ADMIN', 'Administrator');
insert into role (role,description) values ('HORSES_MOUTH', 'Can upload and manage magazine issues');
insert into role (role,description) values ('HORSLEY_PC', 'Parish Council Administrator: Can upload and manage PC meeting agendas and minutes');

# --- !Downs

delete from role where role in ('ADMIN', 'HORSES_MOUTH', 'HORSLEY_PC');
