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

insert into document_type (document_type,description,role) values ('HORSES_MOUTH', 'The Horses Mouth. The free, monthly parish magazine, distributed to all households within the parish','HORSES_MOUTH');
insert into document_type (document_type,description,role) values ('PC_MINUTES', 'PC Meeting Minutes','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_AGENDA', 'PC Meeting Agenda','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_DOCS', 'Miscellaneous PC Documents','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ANNUAL_RETURN', 'Annual Return','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ASSET_REGISTER', 'Asset Register','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_BUDGET_FORECAST', 'Budget Forecast','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_BALANCE_SHEET', 'Balance Sheet','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_INCOME_&_EXPENDITURE', 'Annual Return','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_BANK_RECONCILLIATION', 'Bank Reconcilliation','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_SUPPORTING_ACCOUNT_DOCUMENTS', 'Supporting Account Documents','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ACTION_PLAN', 'Action Plan','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ANNUAL_REPORT', 'Annual Report','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_GOVERNANCE_&_POLICIES', 'Governance and Policies','HORSLEY_PC');


# --- !Downs

delete from role;
delete from person;
delete from user_role;
delete from document_type;

