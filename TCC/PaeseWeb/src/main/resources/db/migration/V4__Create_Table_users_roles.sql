CREATE SEQUENCE IF NOT EXISTS user_role_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE users_roles(
id BIGINT DEFAULT nextval('user_role_seq'),
user_id INTEGER,
role_id INTEGER,
active BOOLEAN DEFAULT TRUE,
granted_at TIMESTAMP NOT NULL,
granted_by_id INTEGER NOT NULL,
revoked_at TIMESTAMP,
revoked_by_id INTEGER,
CONSTRAINT pk_users_roles PRIMARY KEY(id),
CONSTRAINT fk_users_roles_user_id FOREIGN KEY(user_id) REFERENCES users(id),
CONSTRAINT fk_users_roles_role_id FOREIGN KEY(role_id) REFERENCES roles(id),
CONSTRAINT uq_user_role UNIQUE(user_id, role_id),
CONSTRAINT fk_granted_by FOREIGN KEY(granted_by_id) REFERENCES users(id),
CONSTRAINT fk_revoked_by FOREIGN KEY(revoked_by_id) REFERENCES users(id)

);