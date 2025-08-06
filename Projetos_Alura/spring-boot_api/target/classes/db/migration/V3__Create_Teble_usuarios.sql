CREATE TABLE usuarios (
	id bigserial NOT NULL,
	nome varchar NOT NULL,
	email varchar NOT NULL,
	login varchar NOT NULL,
	senha varchar NOT NULL,
	CONSTRAINT usuarios_pk PRIMARY KEY (id),
	CONSTRAINT usuarios_email UNIQUE (email),
	CONSTRAINT usuarios_login UNIQUE (login)
);
