CREATE TABLE identification_document (
	id VARCHAR(50) PRIMARY KEY,
	type VARCHAR(50) NOT NULL,
    prefix VARCHAR(50) NOT NULL
);

CREATE TABLE client (
	id SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    second_name VARCHAR(20),
    first_last_name VARCHAR(20) NOT NULL,
    second_last_name VARCHAR(20),
    business_name VARCHAR(20),
    address VARCHAR(20),
    phone VARCHAR(20)
);

CREATE TABLE document_details (
	id SERIAL PRIMARY KEY,
	client_id INT NOT NULL,
    identification_document_id VARCHAR(50) NOT NULL,
    document_number VARCHAR(20) NOT NULL
);

INSERT INTO identification_document (id, type, prefix) VALUES ('TD-001', 'CEDULA DE CIUDADANIA', 'CC');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-002', 'CEDULA DE EXTRANGERIA', 'CE');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-003', 'PASAPORTE', 'PP');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-004', 'NIT', 'NIT');

INSERT INTO client (first_name, second_name, first_last_name, second_last_name, business_name, address, phone)
VALUES ('Elkin', 'Giovanni', 'Giraldo', 'Pinedo', 'egiraldo', 'Calle 160 # 72 - 51', '3152636667');
INSERT INTO client (first_name, second_name, first_last_name, second_last_name, business_name, address, phone)
VALUES ('Martha', 'Jeannet', 'Pinedo', 'Chaves', 'mpinedoc', 'Calle 160 # 72 - 51', '3158762689');
INSERT INTO client (first_name, second_name, first_last_name, second_last_name, business_name, address, phone)
VALUES ('Jairo', '', 'Giraldo', 'Jimenez', 'jgiraldoj', 'Calle 160 # 72 - 51', '3162532151');

INSERT INTO document_details (client_id, identification_document_id, document_number) VALUES (1, 'TD-001', '11111');
INSERT INTO document_details (client_id, identification_document_id, document_number) VALUES (1, 'TD-004', '22222');
INSERT INTO document_details (client_id, identification_document_id, document_number) VALUES (2, 'TD-001', '33333');
INSERT INTO document_details (client_id, identification_document_id, document_number) VALUES (3, 'TD-001', '44444');
INSERT INTO document_details (client_id, identification_document_id, document_number) VALUES (3, 'TD-002', '55555');
INSERT INTO document_details (client_id, identification_document_id, document_number) VALUES (3, 'TD-003', '66666');



