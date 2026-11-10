package implemented;

import abstracts.ItemBiblioteca;

public class Revista extends ItemBiblioteca {

    private static final int PRAZO_EMPRESTIMO = 7;
    private static final double MULTA_POR_DIA = 1.00;

    public Revista(String codigo, String titulo) {
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
