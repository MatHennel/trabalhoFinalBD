package tads.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import tads.MODELS.Agenda;
import tads.MODELS.Email;
import tads.MODELS.Telefone;

public class AgendaDAO {

    Connection conn = new Conexao().conectaBd();;
    PreparedStatement pstn;
    ResultSet rs;

    public void cadastrarAgenda(Agenda agenda) {
        String sql = "insert into trabalho_final_agenda (nome) values (?)";
        

        try {
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, agenda.getNome());
            pstn.execute();
            pstn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "AgendaDAO" + e);
        }
    }

    public int returnCodigo() {
        String sql = "select codigo from trabalho_final_agenda";
        int codigo = 0;

        try {
            pstn = conn.prepareStatement(sql);
            rs = pstn.executeQuery();

            while (rs.next()) {
                codigo = rs.getInt("codigo");
            }

            

            return codigo;

        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public void returnListaAgenda(List<Agenda> lista) {
        Agenda agenda;
        Telefone telefone;
        Email email;
        String sql;

        try {
            sql = "SELECT codigo,nome from trabalho_final_agenda";
            pstn = conn.prepareStatement(sql);
            rs = pstn.executeQuery();

            while(rs.next()){
                agenda = new Agenda();
                agenda.setCodigo(rs.getInt("codigo"));
                agenda.setNome(rs.getString("nome"));

                lista.add(agenda);
            }

          

        } catch (Exception e) {
            System.out.println("Deu erro" + e);

        }

        try {
            sql = "SELECT codigo,telefone from trabalho_final_telefone";
            pstn = conn.prepareStatement(sql);
            rs = pstn.executeQuery();

            while(rs.next()){
                telefone = new Telefone(rs.getInt("telefone"), rs.getInt("codigo"));

                for (Agenda agenda2 : lista) {
                   if(agenda2.getCodigo() == telefone.getCodigo()){
                    agenda2.adicionarTelefone(telefone);
                   }
                }
            }


        } catch (Exception e) {
            System.out.println("Deu erro" + e);

        }

        try {
            sql = "SELECT codigo,email from trabalho_final_email";
            pstn = conn.prepareStatement(sql);
            rs = pstn.executeQuery();

            while(rs.next()){
                email = new Email(rs.getString("email"), rs.getInt("codigo"));

                for (Agenda agenda2 : lista) {
                    if(agenda2.getCodigo() == email.getCodigo()){
                        agenda2.adicionarEmail(email);
                    }
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void excluirAgenda(int codigo){
        
        try {
            String sql = "delete from trabalho_final_email where codigo=?";
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, String.valueOf(codigo));
            pstn.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            String sql = "delete from trabalho_final_telefone where codigo=?";
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, String.valueOf(codigo));
            pstn.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            String sql = "delete from trabalho_final_agenda where codigo=?";
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, String.valueOf(codigo));
            pstn.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void alterarNome(int codigo,String nome){
        try {
            String sql = "update trabalho_final_agenda set nome=? where codigo=?;";
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, nome);
            pstn.setString(2, String.valueOf(codigo));
            pstn.execute();
            pstn.close();
        } catch (Exception e) {
            System.out.println( "Codigo nao corresponde a pessoa" +e);
        }
    }

   

    

}
