SELECT
    i.codigo,
    i.titulo,
    i.tipo,
    i.disponivel
FROM item i
ORDER BY i.codigo;

SELECT
    u.nome AS usuario,
    i.titulo AS item,
    e.data_retirada,
    e.data_devolucao_prevista
FROM emprestimo e
JOIN usuario u ON u.id = e.usuario_id
JOIN item i ON i.id = e.item_id
WHERE e.data_devolucao IS NULL
ORDER BY u.nome, i.titulo;

SELECT
    u.nome,
    COALESCE(SUM(e.valor_multa), 0.00) AS total_multa
FROM usuario u
LEFT JOIN emprestimo e ON e.usuario_id = u.id
GROUP BY u.id, u.nome
ORDER BY total_multa DESC, u.nome;


SELECT
    i.codigo,
    i.titulo,
    i.tipo,
    i.disponivel
FROM item i
LEFT JOIN emprestimo e ON e.item_id = i.id
WHERE e.id IS NULL
ORDER BY i.codigo;
