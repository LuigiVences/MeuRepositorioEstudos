CREATE TABLE pacientes (
	id bigserial NOT NULL,
	nome varchar NOT NULL,
	email varchar NOT NULL,
	cpf varchar NOT NULL,
	logradouro varchar NOT NULL,
	bairro varchar NOT NULL,
	cep varchar NOT NULL,
	complemento varchar NULL,
	numero varchar NULL,
	uf varchar NOT NULL,
	cidade varchar NOT NULL,
	telefone varchar NOT NULL,
	ativo bool STORAGE DEFAULT DEFAULT TRUE NOT NULL,
	CONSTRAINT pacientes_pk PRIMARY KEY (id),
	CONSTRAINT pacientes_email UNIQUE (email),
	CONSTRAINT pacientes_cpf UNIQUE (cpf)
);
