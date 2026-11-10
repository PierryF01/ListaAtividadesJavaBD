
import abstracts.ItemBiblioteca;
import abstracts.Usuario;

public class Biblioteca {

    private final ItemBiblioteca[] acervo;
    private final Usuario[] usuariosResponsaveis;
    private int quantidadeItens;

    public Biblioteca(int capacidadeMaxima) {

        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException(
                    "A capacidade da biblioteca precisa ser positiva."
            );
        }

        this.acervo = new ItemBiblioteca[capacidadeMaxima];
        this.usuariosResponsaveis = new Usuario[capacidadeMaxima];
        this.quantidadeItens = 0;
    }

    // Cadastra um item no acervo
    public void adicionarItem(ItemBiblioteca item) {

        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }

        if (quantidadeItens >= acervo.length) {
            throw new IllegalStateException("A capacidade da biblioteca foi atingida.");
        }

        for (int i = 0; i < quantidadeItens; i++) {
            if (acervo[i].getCodigo().equals(item.getCodigo())) {
                throw new IllegalArgumentException(
                        "Já existe um cadastro com esse código."
                );
            }
        }

        acervo[quantidadeItens] = item;
        quantidadeItens++;

        System.out.println("Item adicionado ao acervo: " + item.getTitulo());
    }

    // Registra o empréstimo de um item
    public void emprestar(Usuario usuario, ItemBiblioteca item) {

        if (usuario == null || item == null) {
            throw new IllegalArgumentException(
                    "É necessário informar um usuário e um item."
            );
        }

        int indice = buscarIndiceItem(item);

        if (indice == -1) {
            throw new IllegalArgumentException(
                    "O item informado não está cadastrado nesta biblioteca."
            );
        }

        if (!item.isDisponivel()) {
            throw new IllegalArgumentException("O item não está disponível.");
        }

        if (usuario.getQuantidadeEmprestada() >= usuario.getItensPermitidos()) {
            throw new IllegalArgumentException(
                    "O limite de empréstimos deste usuário foi atingido."
            );
        }

        item.emprestar();
        usuario.registrarEmprestimo();
        usuariosResponsaveis[indice] = usuario;

        System.out.println(
                "Empréstimo registrado: " + item.getTitulo()
                        + " | Responsável: " + usuario.getNome()
        );
    }

    // Registra a devolução de um item
    public void devolver(Usuario usuario, ItemBiblioteca item) {

        if (usuario == null || item == null) {
            throw new IllegalArgumentException(
                    "É necessário informar um usuário e um item."
            );
        }

        int indice = buscarIndiceItem(item);

        if (indice == -1) {
            throw new IllegalArgumentException(
                    "O item não foi encontrado no acervo."
            );
        }

        if (item.isDisponivel() || usuariosResponsaveis[indice] == null) {
            throw new IllegalArgumentException(
                    "Não existe empréstimo ativo para este item."
            );
        }

        if (usuariosResponsaveis[indice] != usuario) {
            throw new IllegalArgumentException(
                    "A devolução deve ser realizada pelo responsável pelo empréstimo."
            );
        }

        item.devolver();
        usuario.registrarDevolucao();
        usuariosResponsaveis[indice] = null;

        System.out.println(
                "Item devolvido com sucesso: " + item.getTitulo()
        );
    }

    // Apresenta os itens cadastrados
    public void listarAcervo() {

        System.out.println("\n===== ACERVO DA BIBLIOTECA =====");

        if (quantidadeItens == 0) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }

        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println(acervo[i]);
        }
    }

    // Busca a posição de um item no array
    private int buscarIndiceItem(ItemBiblioteca item) {

        for (int i = 0; i < quantidadeItens; i++) {
            if (acervo[i] == item) {
                return i;
            }
        }

        return -1;
    }
}
