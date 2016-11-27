# --- !Ups

insert into role (role,description) values ('TEST_ROLE_1', 'Test use only');
insert into role (role,description) values ('TEST_ROLE_2', 'Test use only');
insert into role (role,description) values ('TEST_ROLE_3', 'Test use only');
insert into role (role,description) values ('ADMIN', 'Administrator');
insert into role (role,description) values ('HORSES_MOUTH', 'Can upload and manage magazine issues');
insert into role (role,description) values ('HORSLEY_PC', 'Parish Council Administrator: Can upload and manage PC meeting agendas and minutes');

insert into person (user_id, surname, firstname, email, password) values(0,'Test', 'Foo','foo@test.co.uk','abc123');
insert into person (user_id, surname, firstname, email, password) values(1,'Test', 'Bar','bar@test.co.uk','123abc');

insert into user_role (user_role_id, role, user_id) values(1,'TEST_ROLE_1',1);
insert into user_role (user_role_id, role, user_id) values(2,'TEST_ROLE_2',1);
insert into user_role (user_role_id, role, user_id) values(3,'TEST_ROLE_3',1);

# --- !Downs

delete from role;
delete from person;
delete from user_role;
