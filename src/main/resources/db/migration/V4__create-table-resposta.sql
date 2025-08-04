CREATE TABLE resposta (

    id BIGSERIAL PRIMARY KEY,
    mensagem VARCHAR(1000) NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_titulo VARCHAR(100) NOT NULL,
    id_autor VARCHAR(100) NOT NULL,
    solucao VARCHAR(1000) NOT NULL,
    FOREIGN KEY (id_titulo) REFERENCES titulo(id),
    FOREIGN KEY (id_autor) REFERENCES autor(id)
);