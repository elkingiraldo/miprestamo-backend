CREATE TABLE identification_document (
	id VARCHAR(50) PRIMARY KEY,
	type VARCHAR(50) NOT NULL,
    prefix VARCHAR(50) NOT NULL
);

CREATE TABLE client (
	id SERIAL PRIMARY KEY,
    firstName VARCHAR(20) NOT NULL,
    secondName VARCHAR(20) NOT NULL,
    fisrtLastName VARCHAR(20) NOT NULL,
    secondLastName VARCHAR(20) NOT NULL,
    businessName VARCHAR(20) NOT NULL,
    address VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

INSERT INTO identification_document (id, type, prefix) VALUES ('TD-001', 'CEDULA DE CIUDADANIA', 'CC');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-002', 'CEDULA DE EXTRANGERIA', 'CE');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-003', 'PASAPORTE', 'PP');
INSERT INTO identification_document (id, type, prefix) VALUES ('TD-004', 'NIT', 'NIT');