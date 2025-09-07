CREATE SEQUENCE IF NOT EXISTS privilege_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE privileges (
id BIGINT DEFAULT nextval('privilege_seq'),
name VARCHAR(100) NOT NULL,
description TEXT,
active BOOLEAN DEFAULT TRUE NOT NULL,
created_at TIMESTAMP,
created_by_id INTEGER NOT NULL,
deactivated_at TIMESTAMP,
deactivated_by_id INTEGER,
CONSTRAINT pk_privileges PRIMARY KEY(id),
CONSTRAINT uq_privilege_name_unique UNIQUE(name),
CONSTRAINT fk_privileges_created_by FOREIGN KEY(created_by_id) REFERENCES users(id),
CONSTRAINT fk_privileges_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES users(id)

);