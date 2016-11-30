# --- !Ups

insert into document_type (document_type,description,role) values ('HORSES_MOUTH', 'The Horses Mouth. The free, monthly parish magazine, distributed to all households within the parish','HORSES_MOUTH');
insert into document_type (document_type,description,role) values ('PC_MINUTES', 'PC Meeting Minutes','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_AGENDA', 'PC Meeting Agenda','HORSLEY_PC');
insert into document_type (document_type,description,role) values ('PC_DOCS', 'Miscellaneous PC Documents','HORSLEY_PC');

# --- !Downs

delete from document_type;

