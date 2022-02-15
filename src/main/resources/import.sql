INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('André Luis' , '051-593-981.12' , '1000.0' , TIMESTAMP WITH TIME ZONE '1995-03-28T10:30:00Z' , '0' , 'andre' , '$2a$12$OAIFQ/Tkuz9qwq3QRY68xuAccyVhTZiXDPgU88guPEui8VH3xLfn6');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Roberto Vagner' , '223-233-111.13' , '3000.0' , TIMESTAMP WITH TIME ZONE '1968-06-14T10:30:00Z' , '3' , 'roberto' , '$2a$12$rzzgsM0Xk4enG.8HBFYdb.T2Bn2wbINR5zYgVXNUhAdynGyB3pB2i');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Leonice Aparecida' , '666-566-222.33' , '7500.0' , TIMESTAMP WITH TIME ZONE '1971-05-23T10:30:00Z' , '3' , 'leonice' , '$2a$12$vt.QM13oBev94klcZv1uOebey0BYDK8ku/uV6dviY3tKlCegU3HFq');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Guilherme incubado' , '051-593-981.12' , '4000.0' , TIMESTAMP WITH TIME ZONE '1995-03-28T10:30:00Z' , '0' , 'guilherme' , '$2a$12$k1r02GN4/HXt1tD6y694XeJrsZbU3aCcfC9n/I4a2aNhiA9JVBYna');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Camila' , '052-222-777.22' , '3000.0' , TIMESTAMP WITH TIME ZONE '1991-03-25T10:30:00Z' , '0' , 'camila' , '$2a$12$gveGxY43idTQupeV5cPeQ.08OHA.wklGkYJfTABRX3rGRyND8Wxb6');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Igor gomes' , '233-222-111.12' , '8000.0' , TIMESTAMP WITH TIME ZONE '1995-06-12T10:30:00Z' , '0' , 'igor' , '$2a$12$x.hTgAwxHzPIgARygfuvFuSG7HMhZHGDiaaP7keUltuo5kdHhZnP6');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Cassiano' , '222-111-333.12' , '2500.0' , TIMESTAMP WITH TIME ZONE '1994-07-01T10:30:00Z' , '0' , 'cassiano' , '$2a$12$VEY.YPs64dYbLEaVJO2DD.uz4iOg3CKx7jmMMuo7kT.Ti3ahpiaRy');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Firezin' , '222-111-555.12' , '2500.0' , TIMESTAMP WITH TIME ZONE '1995-01-18T10:30:00Z' , '1' , 'firezin' , '$2a$12$Q/xw0XpiVdiLXtfT8DagSuihFWojAy8U1sr81mGigHYpQxPPJO.pm');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Sergio Antonio' , '111-111-111.12' , '0000.0' , TIMESTAMP WITH TIME ZONE '1997-03-28T10:30:00Z' , '0' , 'sergio' , '$2a$12$1XEMk6khmS69WVfoGqeHO.GeFzA/mj5lzwWJ.sjNUIUrLC2oWo3hS');
INSERT INTO tb_client (name , cpf , income , birth_Date , children , login , password) VALUES ('Renner' , '999-888-777.12' , '5000.0' , TIMESTAMP WITH TIME ZONE '1994-03-28T10:30:00Z' , '0' , 'renner' , '$2a$12$EelF1slny9JPMx.5MCdzP.DV2ifieR50YK1mGiiaZijPygFYmkqd6');


INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_client_role (client_id, role_id) VALUES (1, 1);
INSERT INTO tb_client_role (client_id, role_id) VALUES (2, 1);
INSERT INTO tb_client_role (client_id, role_id) VALUES (2, 2);