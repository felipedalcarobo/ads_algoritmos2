package model;

/**
 *
 * @author 631220016
 */
public class Categoria {
    
    private int id_categoria;
    private String categoria;

    @Override
    public String toString() {
        return categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
