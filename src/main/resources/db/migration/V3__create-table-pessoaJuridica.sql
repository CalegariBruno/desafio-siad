CREATE TABLE pessoa_juridica (
    id VARCHAR(100) PRIMARY KEY,
    cnpj VARCHAR(14),
    FOREIGN KEY (id) REFERENCES Pessoa(id)
);