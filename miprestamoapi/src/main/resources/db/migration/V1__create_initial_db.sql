CREATE TABLE identification_document (
	id VARCHAR(50) PRIMARY KEY,
	type VARCHAR(50) NOT NULL,
    prefix VARCHAR(50) NOT NULL
);

CREATE TABLE client (
	id SERIAL PRIMARY KEY,
	document_list INT[] NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    second_name VARCHAR(20) NOT NULL,
    fisrt_last_name VARCHAR(20) NOT NULL,
    second_last_name VARCHAR(20) NOT NULL,
    business_name VARCHAR(20) NOT NULL,
    address VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

INSERT INTO identification_document (id, type, prefix) VALUES ('TD-001', 'CEDULA DE CIUDADANIA', 'CC');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-002', 'CEDULA DE EXTRANGERIA', 'CE');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-003', 'PASAPORTE', 'PP');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-004', 'NIT', 'NIT');

INSERT INTO client (id, document_list, first_name, second_name, fisrt_last_name, second_last_name, business_name, address, phone)
VALUES (1, '{1,2}', 'Elkin', 'Giovanni', 'Giraldo', 'Pinedo', 'egiraldo', 'Calle 160 # 72 - 51', '3152636667');
INSERT INTO client (id, document_list, first_name, second_name, fisrt_last_name, second_last_name, business_name, address, phone)
VALUES (2, '{3}', 'Martha', 'Jeannet', 'Pinedo', 'Chaves', 'mpinedoc', 'Calle 160 # 72 - 51', '3158762689');
INSERT INTO client (id, document_list, first_name, second_name, fisrt_last_name, second_last_name, business_name, address, phone)
VALUES (3, '{4,5,6}', 'Jairo', '', 'Giraldo', 'Jimenez', 'jgiraldoj', 'Calle 160 # 72 - 51', '3162532151');










