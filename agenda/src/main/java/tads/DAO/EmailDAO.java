package tads.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;



import tads.MODELS.Email;

public class EmailDAO {
    Connection conn = new Conexao().conectaBd();
    PreparedStatement pstn;
    
    public void cadastrarEmail(Email email){
        String sql = "insert into trabalho_final_email (email,codigo) values (?,?)";
        

        try {
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, email.getEmail());
            pstn.setString(2, String.valueOf(email.getCodigo()));
            

            pstn.execute();
            pstn.close();
        } catch (Exception e) {
            System.out.println("ERRO AO CADASTRAR EMAIL"+e);
        }
    }

    public void alterarEmail(int codigo,String email){
        try {
            String sql = "update trabalho_final_email set email=? where codigo=?;";
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, email);
            pstn.setString(2, String.valueOf(codigo));
            pstn.execute();
            pstn.close();
        } catch (Exception e) {
            System.out.println( "Codigo nao corresponde a pessoa" +e);
        }
    }

    public void adicionarEmail(int codigo1,String email1){
        try {
            String sql = "insert trabalho_final_email (email,codigo) values (?,?)";
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, email1);
            pstn.setString(2, String.valueOf(codigo1));
            pstn.execute();
            pstn.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

}
