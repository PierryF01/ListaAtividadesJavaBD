CREATE TABLE item (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(8) NOT NULL UNIQUE,
    titulo VARCHAR(100) NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    edicao VARCHAR(100) NOT NULL,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT chk_tipo_item
        CHECK (tipo IN ('LIVRO', 'REVISTA'))
);

CREATE TABLE usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    limite_itens INT NOT NULL,

    CONSTRAINT chk_tipo_usuario
        CHECK (tipo IN ('ALUNO', 'PROFESSOR')),

    CONSTRAINT chk_limite_itens
        CHECK (limite_itens > 0)
);

CREATE TABLE emprestimo (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10, 2) NOT NULL DEFAULT 0.00,

    CONSTRAINT fk_emprestimo_item
        FOREIGN KEY (item_id) REFERENCES item(id),

    CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario(id),

    CONSTRAINT chk_valor_multa
        CHECK (valor_multa >= 0),

    CONSTRAINT chk_data_prevista
        CHECK (data_devolucao_prevista >= data_retirada),

    CONSTRAINT chk_data_devolucao
        CHECK (
            data_devolucao IS NULL
            OR data_devolucao >= data_retirada
        )
);



INSERT INTO item (codigo, titulo, tipo, autor, edicao)
VALUES
    ('LIV001', 'Dom Casmurro', 'LIVRO', 'Machado de Assis', '1ª Edição'),
    ('LIV002', 'O Pequeno Príncipe', 'LIVRO', 'Antoine de Saint-Exupéry', '2ª Edição'),
    ('REV001', 'National Geographic', 'REVISTA', 'Vários Autores', 'Edição 150'),
    ('REV002', 'Superinteressante', 'REVISTA', 'Vários Autores', 'Edição 220');



INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
    ('Lucas Martins', 'ALUNO', 3),
    ('Mariana Costa', 'PROFESSOR', 5);


INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
SELECT
    i.id,
    u.id,
    CURRENT_DATE - 15,
    CURRENT_DATE - 1,
    CURRENT_DATE,
    2.50
FROM item i
CROSS JOIN usuario u
WHERE i.codigo = 'LIV001'
  AND u.nome = 'Lucas Martins';


INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
SELECT
    i.id,
    u.id,
    CURRENT_DATE - 2,
    CURRENT_DATE + 5,
    NULL,
    0.00
FROM item i
CROSS JOIN usuario u
WHERE i.codigo = 'REV001'
  AND u.nome = 'Mariana Costa';

UPDATE item i
SET disponivel = NOT EXISTS (
    SELECT 1
    FROM emprestimo e
    WHERE e.item_id = i.id
      AND e.data_devolucao IS NULL
);


CREATE UNIQUE INDEX uq_item_emprestimo_aberto
ON emprestimo (item_id)
WHERE data_devolucao IS NULL;
