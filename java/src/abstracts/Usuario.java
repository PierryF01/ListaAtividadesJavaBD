package abstracts;

public abstract class Usuario {

    private final String nome;
    private int quantidadeEmprestada;

    protected Usuario(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome deve ser informado.");
        }

        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }


    public abstract int getItensPermitidos();

    public void registrarEmprestimo() {

        if (quantidadeEmprestada >= getItensPermitidos()) {
            throw new IllegalStateException(
                    "Limite de empréstimos atingido."
            );
        }

        quantidadeEmprestada++;
    }

    public void registrarDevolucao() {

        if (quantidadeEmprestada == 0) {
            throw new IllegalStateException(
                    "Não existem empréstimos para devolver."
            );
        }

        quantidadeEmprestada--;
    }
}
