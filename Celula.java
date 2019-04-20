public class Celula {
    
    private boolean estado;
    private int indice;
    public Celula(boolean estado, int indice) {
        this.estado = estado;
        this.indice = indice;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    public int getIndice() {
        return indice;
    }

    public boolean getEstado() {
        return this.estado;
    }
    
    @Override
    public String toString() {
        if (this.estado) {
            return "1";
        } else {
            return "O";
        }
    }

}