# --- !Ups

insert into role (role,description) values ('ADMIN', 'Administrator');
insert into role (role,description) values ('HORSES_MOUTH', 'Can upload and manage magazine issues');
insert into role (role,description) values ('HORSLEY_PC', 'Parish Council Administrator: Can upload and manage PC meeting agendas and minutes');

insert into person (user_id, surname, firstname, email, password) values(0,'foo', 'bar','foo@bar.co.uk','foobar');
insert into person (user_id, surname, firstname, email, password) values(1,'Stride', 'Jon','horsley@jonstride.uk','sample');

insert into user_role (user_role_id, role, user_id) values(1,'ADMIN',1);

insert into document_type (document_type,description,role) values ('HORSES_MOUTH', 'The Horses Mouth. The free, monthly parish magazine, distributed to all households within the parish','HORSES_MOUTH');
insert into document_type (document_type,description,role) values ('PC_MEET_MINUTES', 'PC Meeting Minutes','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_MEET_AGENDA', 'PC Meeting Agenda','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_MISC_DOCS', 'Miscellaneous PC Documents','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ACCOUNT_ANNUAL_RETURN', 'Annual Return','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ACCOUNT_ASSET_REGISTER', 'Asset Register','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ACCOUNT_BUDGET_FORECAST', 'Budget Forecast','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ACCOUNT_BALANCE_SHEET', 'Balance Sheet','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ACCOUNT_INCOME_&_EXPENDITURE', 'Annual Return','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ACCOUNT_BANK_RECONCILLIATION', 'Bank Reconcilliation','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_ACCOUNT_SUPPORTING_ACCOUNT_DOCUMENTS', 'Supporting Account Documents','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_PUB_ACTION_PLAN', 'Action Plan','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_PUB_ANNUAL_REPORT', 'Annual Report','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_PUB_GOVERNANCE_&_POLICIES', 'Governance and Policies','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_PUB_RISK_ASSEMENT', 'Risk Assements/Health & Safety','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_PLANNING', 'Plans & Projects','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('MISC', 'Miscellaneous Documents','ADMIN');

# --- !Downs

delete from role;
delete from person;
delete from user_role;
delete from document_type;

