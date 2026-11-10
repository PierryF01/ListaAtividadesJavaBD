# Sistema de Biblioteca — Java e PostgreSQL

Projeto acadêmico desenvolvido como resolução de uma lista de exercícios de **Programação Orientada a Objetos (POO) com Java** e **Banco de Dados com PostgreSQL**.

O objetivo é desenvolver um sistema de gerenciamento de biblioteca, aplicando conceitos de orientação a objetos, modelagem de dados e consultas SQL.

## Exercício 1 — Sistema de Biblioteca em Java

Implementação de um sistema utilizando os conceitos de:

- Classes abstratas;
- Herança;
- Encapsulamento;
- Polimorfismo.

O sistema permite gerenciar livros, revistas, usuários e empréstimos, respeitando as regras específicas de cada categoria.

A classe `Dvd` também foi implementada como demonstração da extensibilidade do sistema, permitindo adicionar novos tipos de itens sem modificar os métodos existentes da classe `Biblioteca`.

### Como executar

1. Abra a pasta `java` no IntelliJ IDEA.
2. Acesse `src/Main.java`.
3. Execute a classe `Main`.

## Exercício 2 — Modelagem do Banco de Dados

Desenvolvimento de um banco de dados relacional utilizando PostgreSQL.

O arquivo `sql/atividade5.sql` contém os comandos para:

- Criar as tabelas `item`, `usuario` e `emprestimo`;
- Definir chaves primárias e estrangeiras;
- Aplicar restrições de integridade;
- Inserir dados para testes.

No modelo relacional, os tipos de itens utilizados são `LIVRO` e `REVISTA`, conforme o enunciado da atividade.

## Exercício 3 — Consultas SQL

O arquivo `sql/atividade6.sql` contém as quatro consultas solicitadas:

1. Listagem de todos os itens do acervo e suas disponibilidades.
2. Listagem dos empréstimos em aberto, exibindo o usuário e o item emprestado.
3. Cálculo do total de multas acumuladas por usuário.
4. Identificação dos itens que nunca foram emprestados.

São utilizados recursos SQL como `JOIN`, `LEFT JOIN`, `GROUP BY`, `SUM()` e `IS NULL`.

## Estrutura do Projeto

```text
ListaAtividadesJavaBD/
│
├── .gitignore
├── README.md
│
├── java/
│   └── src/
│       ├── abstracts/
│       │   ├── ItemBiblioteca.java
│       │   └── Usuario.java
│       │
│       ├── implemented/
│       │   ├── Aluno.java
│       │   ├── Professor.java
│       │   ├── Livro.java
│       │   ├── Revista.java
│       │   └── Dvd.java
│       │
│       ├── Biblioteca.java
│       └── Main.java
│
└── sql/
    ├── atividade5.sql
    └── atividade6.sql
```

## Tecnologias Utilizadas

- Java
- PostgreSQL
- SQL
- IntelliJ IDEA

---

**Projeto desenvolvido para fins acadêmicos, com foco na aplicação prática dos conceitos de Programação Orientada a Objetos e Banco de Dados Relacionais.**