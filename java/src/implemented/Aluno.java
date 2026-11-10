package implemented;

import abstracts.Usuario;

public class Aluno extends Usuario {

    private static final int LIMITE_EMPRESTIMOS = 3;

    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public int getItensPermitidos() {
        return LIMITE_EMPRESTIMOS;
    }
}
