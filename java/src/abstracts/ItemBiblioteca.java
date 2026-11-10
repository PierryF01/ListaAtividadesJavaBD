
package abstracts;

public abstract class ItemBiblioteca {

    private final String codigo;
    private final String titulo;
    private boolean disponivel;

    protected ItemBiblioteca(String codigo, String titulo) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Informe o código do item.");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Informe o título do item.");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    // Métodos que serão definidos pelas subclasses
    public abstract int getPrazo();

    public abstract double getMultaDia();

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (!disponivel) {
            throw new IllegalStateException("Item indisponível para empréstimo.");
        }

        disponivel = false;
    }

    public void devolver() {
        if (disponivel) {
            throw new IllegalStateException("O item já está disponível.");
        }

        disponivel = true;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Título: " + titulo
                + " | Disponibilidade: "
                + (disponivel ? "Disponível" : "Emprestado");
    }
}
