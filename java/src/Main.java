
import abstracts.ItemBiblioteca;
import implemented.Aluno;
import implemented.Dvd;
import implemented.Livro;
import implemented.Professor;
import implemented.Revista;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(10);

        // Criação dos itens
        Livro primeiroLivro = new Livro("L01", "O Pequeno Príncipe");
        Livro segundoLivro = new Livro("L02", "Dom Casmurro");

        Revista primeiraRevista = new Revista("R01", "National Geographic");
        Revista segundaRevista = new Revista("R02", "Superinteressante");

        ItemBiblioteca documentario = new Dvd("D01", "Documentário sobre tecnologia");

        // Cadastro dos itens na biblioteca
        biblioteca.adicionarItem(primeiroLivro);
        biblioteca.adicionarItem(segundoLivro);
        biblioteca.adicionarItem(primeiraRevista);
        biblioteca.adicionarItem(segundaRevista);
        biblioteca.adicionarItem(documentario);

        // Criação dos usuários
        Aluno estudante = new Aluno("Lucas");
        Professor docente = new Professor("Mariana");

        // Exibição inicial do acervo
        biblioteca.listarAcervo();

        // Teste de empréstimos
        System.out.println("\n===== EMPRÉSTIMOS DO ALUNO =====");

        biblioteca.emprestar(estudante, primeiroLivro);
        biblioteca.emprestar(estudante, primeiraRevista);
        biblioteca.emprestar(estudante, documentario);

        // Teste de limite de empréstimos
        System.out.println("\n===== VERIFICAÇÃO DO LIMITE =====");

        try {
            biblioteca.emprestar(estudante, segundoLivro);
        } catch (IllegalArgumentException e) {
            System.out.println("Empréstimo não autorizado: " + e.getMessage());
        }

        // Teste de devolução por usuário diferente
        System.out.println("\n===== TESTE DE DEVOLUÇÃO =====");

        try {
            biblioteca.devolver(docente, primeiroLivro);
        } catch (IllegalArgumentException e) {
            System.out.println("Devolução não autorizada: " + e.getMessage());
        }

        // Devolução pelo usuário responsável
        System.out.println("\n===== DEVOLUÇÃO DO ITEM =====");

        biblioteca.devolver(estudante, primeiroLivro);

        // Exibição do acervo após as operações
        biblioteca.listarAcervo();

        System.out.println("\nQuantidade de itens emprestados por "
                + estudante.getNome() + ": "
                + estudante.getQuantidadeEmprestada());
    }
}
