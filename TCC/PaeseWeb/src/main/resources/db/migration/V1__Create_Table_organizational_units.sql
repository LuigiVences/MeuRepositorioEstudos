CREATE TABLE organizational_units(
id SERIAL,
name VARCHAR(255) NOT NULL,
parent_id INTEGER,
type VARCHAR (70) NOT NULL,
active BOOLEAN DEFAULT TRUE,
created_at TIMESTAMP,
created_by_id INTEGER,
deactivated_at TIMESTAMP,
deactivated_by_id INTEGER,
CONSTRAINT pk_organizational_unit PRIMARY KEY(id),
CONSTRAINT uq_organizational_unit_name_unique UNIQUE(name)
);

CREATE INDEX idx_organizational_unit_parent_id ON organizational_units(parent_id);