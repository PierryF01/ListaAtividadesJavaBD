package implemented;

import abstracts.Usuario;

public class Professor extends Usuario {

    private static final int LIMITE_EMPRESTIMOS = 5;

    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int getItensPermitidos() {
        return LIMITE_EMPRESTIMOS;
    }
}
