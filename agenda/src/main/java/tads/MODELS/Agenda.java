package tads.MODELS;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private int codigo;
    private String nome;
    private List<Telefone> telefoneLista = new ArrayList<>();
    private List<Email> emailLista = new ArrayList<>();
    
   
    public Agenda(String nome) {
        this.nome = nome;
        
    }
    public Agenda(int codigo, String nome, Telefone telefone, Email email) {
        this.codigo = codigo;
        this.nome = nome;
        telefoneLista.add(telefone);
        emailLista.add(email);
        
    }
    public Agenda() {
        
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Telefone> getTelefoneLista() {
        return telefoneLista;
    }
    public void setTelefoneLista(List<Telefone> telefoneLista) {
        this.telefoneLista = telefoneLista;
    }
    public List<Email> getEmailLista() {
        return emailLista;
    }
    public void setEmailLista(List<Email> email) {
        this.emailLista = email;
    }

    public void adicionarTelefone(Telefone telefone){
        telefoneLista.add(telefone);
    }

    public void adicionarEmail(Email email){
        emailLista.add(email);
    }

    @Override
    public String toString() {

        return "Codigo: " + codigo + "/" + "Nome: " + nome + "/" + "Telefones: " +  "["  + telefoneLista + "]" + "/" + "Emails: " + "[" + emailLista + "]\n";
    }

}
