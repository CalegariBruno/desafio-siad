CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    cep BIGINT,
    cidade VARCHAR(100),
    bairro VARCHAR(100),
    rua VARCHAR(100),
    numero VARCHAR(10),
    id_pessoa VARCHAR(100),
    CONSTRAINT fk_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa_fisica(id)
);