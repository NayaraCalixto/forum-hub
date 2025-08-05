CREATE TABLE resposta (

    id BIGSERIAL PRIMARY KEY,
    mensagem VARCHAR(10000) NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_titulo BIGINT NOT NULL,
    id_autor BIGINT NOT NULL,
    solucao VARCHAR(10000) NOT NULL,
    FOREIGN KEY (id_titulo) REFERENCES topico(id),
    FOREIGN KEY (id_autor) REFERENCES usuario(id)
);