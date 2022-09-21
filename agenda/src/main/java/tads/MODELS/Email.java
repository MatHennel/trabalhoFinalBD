package tads.MODELS;

public class Email {
    private String email;
    private int codigo;

    public Email(String email, int codigo) {
        this.codigo = codigo;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return email + ", " ;
    }
}
