CREATE TABLE pessoa_fisica(
    id VARCHAR(100) PRIMARY KEY,
    cpf VARCHAR(11),
    FOREIGN KEY (id) REFERENCES Pessoa(id)
);