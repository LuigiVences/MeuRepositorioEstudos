CREATE TABLE roles (
id SERIAL,
name VARCHAR(100) NOT NULL,
description TEXT,
active BOOLEAN DEFAULT TRUE NOT NULL,
created_at TIMESTAMP NOT NULL,
created_by_id INTEGER NOT NULL,
deactivated_at TIMESTAMP,
deactivated_by_id INTEGER,
CONSTRAINT pk_roles PRIMARY KEY(id),
CONSTRAINT uq_role_name_unique UNIQUE(name),
CONSTRAINT fk_roles_created_by FOREIGN KEY(created_by_id) REFERENCES users(id),
CONSTRAINT fk_roles_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES users(id)

);