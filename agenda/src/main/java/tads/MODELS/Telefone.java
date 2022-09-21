package tads.MODELS;


public class Telefone {
    private double telefone;
    private int codigo;
    public Telefone(double telefone, int codigo) {
        this.telefone = telefone;
        this.codigo = codigo;
    }
    public double getTelefone() {
        return telefone;
    }
    public void setTelefone(double telefone) {
        this.telefone = telefone;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return telefone + ", ";
    }

}
