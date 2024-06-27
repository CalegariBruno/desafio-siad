CREATE TABLE venda (
    id SERIAL PRIMARY KEY,
    total NUMERIC(10, 2),
    quantidade INT,
    id_pessoa VARCHAR(100),
    id_produto INT,
    CONSTRAINT fk_pessoa_fisica FOREIGN KEY (id_pessoa) REFERENCES pessoa_fisica(id),
    CONSTRAINT fk_produto FOREIGN KEY (id_produto) REFERENCES produto(id)
);