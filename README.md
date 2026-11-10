# Sistema de Biblioteca — Java e PostgreSQL

Este projeto foi desenvolvido como resolução de uma lista de exercícios de Programação Orientada a Objetos (POO) com Java e Banco de Dados com PostgreSQL.

O sistema tem como objetivo gerenciar o acervo de uma biblioteca, permitindo o controle de livros, revistas, usuários e empréstimos, aplicando conceitos de programação orientada a objetos e banco de dados relacionais.

## Exercício 1 — Sistema de Biblioteca em Java

Implementação de um sistema utilizando os conceitos de:

- Classes abstratas;
- Herança;
- Encapsulamento;
- Polimorfismo.

O sistema possui classes responsáveis pelo gerenciamento dos itens da biblioteca, dos usuários e das operações de empréstimo e devolução.

A classe `Dvd` também foi implementada para demonstrar a extensibilidade do sistema, permitindo adicionar uma nova categoria de item sem modificar os métodos existentes da classe `Biblioteca`.

### Como executar

1. Abra a pasta `java` no IntelliJ IDEA.
2. Acesse `src/Main.java`.
3. Execute a classe `Main` para visualizar o funcionamento do sistema.

## Exercício 2 — Modelagem do Banco de Dados

Foi desenvolvido um banco de dados relacional utilizando PostgreSQL para armazenar as informações da biblioteca.

O arquivo `sql/atividade5.sql` contém os comandos responsáveis pela criação e estruturação das seguintes tabelas:

- `item`: armazena os dados dos livros e revistas.
- `usuario`: armazena os dados dos alunos e professores.
- `emprestimo`: registra as retiradas e devoluções dos itens.

Também foram definidas chaves primárias, chaves estrangeiras e restrições para garantir a integridade dos dados.

O modelo relacional utiliza os tipos `LIVRO` e `REVISTA`, conforme o enunciado da atividade.

## Exercício 3 — Consultas SQL

O arquivo `sql/atividade6.sql` contém as quatro consultas solicitadas:

1. Listagem de todos os itens do acervo, incluindo código, título, tipo e disponibilidade.
2. Listagem dos empréstimos em aberto, apresentando o nome do usuário e o título do item.
3. Cálculo do total de multas acumuladas por usuário.
4. Identificação dos itens que nunca foram emprestados.

As consultas utilizam recursos do SQL, como `JOIN`, `LEFT JOIN`, `GROUP BY`, `SUM()` e `IS NULL`.

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