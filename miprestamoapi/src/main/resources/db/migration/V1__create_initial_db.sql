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

CREATE TABLE product (
	id VARCHAR(50) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE commitment (
	id uuid DEFAULT uuid_generate_v4 () PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200) NOT NULL,
    initial_debt BIGINT NOT NULL,
    current_debt BIGINT NOT NULL,
    period_debt BIGINT NOT NULL,
    periods INTEGER NOT NULL,
    current_period INT NOT NULL,
    disabled BOOLEAN NOT NULL,
    status VARCHAR(20) NOT NULL,
    product_id VARCHAR(50) NOT NULL,
    client_id INTEGER NOT NULL
);

CREATE TABLE bank (
	id VARCHAR(50) PRIMARY KEY,
	name VARCHAR(50) NOT NULL
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

INSERT INTO product (id, name, description) VALUES ('PR-001', 'Tarjeta de crédito VISA', 'Alguna descripción');
INSERT INTO product (id, name, description) VALUES ('PR-002', 'Tarjeta de crédito MASTERD CARD', 'Alguna descripción');
INSERT INTO product (id, name, description) VALUES ('PR-003', 'Crédito libre inversión', 'Alguna descripción');
INSERT INTO product (id, name, description) VALUES ('PR-004', 'Crédito Educativo', 'Alguna descripción');
INSERT INTO product (id, name, description) VALUES ('PR-005', 'Crédito de libranza', 'Alguna descripción');

INSERT INTO commitment (name, description, initial_debt, current_debt, period_debt, periods, current_period, disabled, status, product_id, client_id)
VALUES ('Pago carro', 'ayuda para la casa', 12000000, 9000000, 1000000, 12, 4, FALSE, 'PENDING', 'PR-005', 1);

INSERT INTO bank (id, name) VALUES ('RC-001', 'Banco1');
INSERT INTO bank (id, name) VALUES ('RC-002', 'Recaudadora1');
INSERT INTO bank (id, name) VALUES ('RC-003', 'Pasarela1');








