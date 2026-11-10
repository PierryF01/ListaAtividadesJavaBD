package implemented;

import abstracts.ItemBiblioteca;

public class Livro extends ItemBiblioteca {

    private static final int PRAZO_EMPRESTIMO = 14;
    private static final double MULTA_POR_DIA = 0.50;

    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazo() {
        return PRAZO_EMPRESTIMO;
    }

    @Override
    public double getMultaDia() {
        return MULTA_POR_DIA;
    }
}
