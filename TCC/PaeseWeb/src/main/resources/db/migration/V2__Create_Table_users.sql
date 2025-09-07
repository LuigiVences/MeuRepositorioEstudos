CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE users(
id BIGINT DEFAULT nextval('user_seq'),
name VARCHAR (100) NOT NULL,
email VARCHAR (100) NOT NULL,
password_hash VARCHAR (100),
password_initialized BOOLEAN DEFAULT FALSE,
last_password_change_at TIMESTAMP,
active BOOLEAN DEFAULT FALSE,
created_at TIMESTAMP,
created_by_id INTEGER,
deactivated_at TIMESTAMP,
deactivated_by_id INTEGER,
organizational_unit_id INTEGER,
CONSTRAINT pk_user PRIMARY KEY(id),
CONSTRAINT uq_ser_email_unique UNIQUE(email),
CONSTRAINT fk_users_organizational_unit FOREIGN KEY(organizational_unit_id) REFERENCES organizational_units(id),
CONSTRAINT fk_users_created_by FOREIGN KEY(created_by_id) REFERENCES users(id),
CONSTRAINT fk_users_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES users(id)

);