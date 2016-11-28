# --- !Ups

insert into document_type (document_type,description,role) values ('Horses Mouth', 'The Horses Mouth. The free, monthly parish magazine, distributed to all households within the parish','HORSES_MOUTH');
insert into document_type (document_type,description,role) values ('PC', 'Meeting Agendas and Minutes, and other publically-available documents','HORSLEY_PC');

# --- !Downs

delete from document_type;

