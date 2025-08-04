CREATE TYPE status_enum AS ENUM ('ABERTO', 'RESPONDIDO', 'FECHADO');

CREATE TABLE topico (

    CREATE TABLE topico (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensagem VARCHAR(1000) NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status status_enum  NOT NULL,
    id_autor VARCHAR(100) NOT NULL,
    id_curso VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_autor) REFERENCES autor(id),
    FOREIGN KEY (id_curso) REFERENCES curso(id)
);
