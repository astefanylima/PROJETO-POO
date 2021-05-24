INSERT INTO tb_PLACE (name, address) VALUES ('São Roque', 'Avenida 3 de Maio, Vila Mike');
INSERT INTO tb_PLACE (name, address) VALUES ('São Pedro', 'Avenida 15 de Novembro, Vila Matilde');
INSERT INTO tb_PLACE (name, address) VALUES ('São Luiz', 'Avenida 1 de Maio, Vila Mosteiro');

INSERT INTO tb_baseUser (name, email) VALUES ('Stefany', 'stefany-lima@gmail.com');
INSERT INTO tb_baseUser (name, email) VALUES ('Matheus', 'matheus-henrique@gmail.com');
INSERT INTO tb_baseUser(name, email) VALUES ('Glauco', 'glauco-todesco@gmail.com');

INSERT INTO tb_baseUser (name, email) VALUES ('Jones', 'jones-artur@gmail.com');
INSERT INTO tb_baseUser (name, email) VALUES ('Marco', 'marco-montebello@gmail.com');
INSERT INTO tb_baseUser(name, email) VALUES ('Talita', 'talita-gurgel@gmail.com');

INSERT INTO tb_admin (baseuser_id, phone_number) VALUES (1,'11950644065');
INSERT INTO tb_admin (baseuser_id, phone_number) VALUES (2,'11942700221');
INSERT INTO tb_admin (baseuser_id, phone_number) VALUES (3,'11910367272');

INSERT INTO tb_event (description, email_contact, end_date, end_time, name, start_date, start_time, admin_baseuser_id, AMOUNT_PAYED_TICKETS, AMOUNT_free_TICKETS, PRICE_TICKET) VALUES ('Evento para Gamers 01', 'gamersgtx01@gmail.com', '2021-11-30', '17:00', 'Evento para Gamers primeiro',  '2021-09-30', '15:30', 1, 200, 25, 29.99);
INSERT INTO tb_event (description, email_contact, end_date, end_time, name, start_date, start_time, admin_baseuser_id, AMOUNT_PAYED_TICKETS, AMOUNT_free_TICKETS, PRICE_TICKET) VALUES ('Evento para Gamers 02', 'gamersgtx02@gmail.com', '2021-09-17', '17:10', 'Evento para Gamers segundo',  '2021-07-17', '15:30', 1, 250, 75, 39.99);
INSERT INTO tb_event (description, email_contact, end_date, end_time, name, start_date, start_time, admin_baseuser_id, AMOUNT_PAYED_TICKETS, AMOUNT_free_TICKETS, PRICE_TICKET) VALUES ('Evento para Gamers 03', 'gamersgtx03@gmail.com', '2021-03-17', '17:20', 'Evento para Gamers terceiro',  '2021-01-17', '15:30', 3, 300, 125, 49.99);

INSERT INTO tb_attend (baseuser_id, balance) VALUES (4,0.0);
INSERT INTO tb_attend (baseuser_id, balance) VALUES (5,0.0);
INSERT INTO tb_attend (baseuser_id, balance) VALUES (6,0.0);
