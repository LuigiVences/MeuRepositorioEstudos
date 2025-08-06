CREATE TABLE medicos (
	id bigserial NOT NULL,
	nome varchar NOT NULL,
	email varchar NOT NULL,
	crm varchar NOT NULL,
	especialidade varchar NOT NULL,
	logradouro varchar NOT NULL,
	bairro varchar NOT NULL,
	cep varchar NOT NULL,
	complemento varchar NULL,
	numero varchar NULL,
	uf varchar NOT NULL,
	cidade varchar NOT NULL,
	telefone varchar NOT NULL,
	ativo bool STORAGE DEFAULT DEFAULT TRUE NOT NULL,
	CONSTRAINT medicos_pk PRIMARY KEY (id),
	CONSTRAINT medicos_email UNIQUE (email),
	CONSTRAINT medicos_crm UNIQUE (crm)
);
