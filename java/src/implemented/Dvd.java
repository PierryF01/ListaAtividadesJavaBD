package implemented;

import abstracts.ItemBiblioteca;

public class Dvd extends ItemBiblioteca {

    private static final int PRAZO_EMPRESTIMO = 3;
    private static final double MULTA_POR_DIA = 1.50;

    public Dvd(String codigo, String titulo) {
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
