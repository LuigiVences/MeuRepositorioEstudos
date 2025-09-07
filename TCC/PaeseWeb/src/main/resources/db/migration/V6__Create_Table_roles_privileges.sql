CREATE SEQUENCE IF NOT EXISTS role_privilege_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE roles_privileges(
id BIGINT DEFAULT nextval('role_privilege_seq'),
role_id INTEGER,
privilege_id INTEGER,
active BOOLEAN DEFAULT TRUE NOT NULL,
granted_at TIMESTAMP NOT NULL,
granted_by_id INTEGER NOT NULL,
revoked_at TIMESTAMP,
revoked_by_id INTEGER,
CONSTRAINT pk_roles_privileges PRIMARY KEY(id),
CONSTRAINT fk_roles_privileges_role_id FOREIGN KEY(role_id) REFERENCES roles(id),
CONSTRAINT fk_roles_privileges_privilege_id FOREIGN KEY(privilege_id) REFERENCES privileges(id),
CONSTRAINT uq_roles_priviles UNIQUE(role_id, privilege_id),
CONSTRAINT fk_granted_by FOREIGN KEY(granted_by_id) REFERENCES users(id),
CONSTRAINT fk_revoked_by FOREIGN KEY(revoked_by_id) REFERENCES users(id)

);