CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    valor NUMERIC(10, 2),
    id_pessoa VARCHAR(100),
    CONSTRAINT fk_pessoa_juridica FOREIGN KEY (id_pessoa) REFERENCES pessoa_juridica(id)
);