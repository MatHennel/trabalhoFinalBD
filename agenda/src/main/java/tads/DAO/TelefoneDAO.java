package tads.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;



import tads.MODELS.Telefone;

public class TelefoneDAO {
    Connection conn = new Conexao().conectaBd();
    PreparedStatement pstn;

    public void cadastrarTelefone(Telefone telefone){
        String sql = "insert into trabalho_final_telefone (telefone,codigo) values (?,?)";
         

        try {
            pstn = conn.prepareStatement(sql);
            
            pstn.setString(1, String.valueOf(telefone.getTelefone()));
            pstn.setString(2, String.valueOf(telefone.getCodigo()));
            pstn.execute();
            pstn.close();

        } catch (Exception e) {
            System.out.println("ERRO AO CADASTRAR TELEFONE" + e);
        }
    }

    public void alterarTelefone(int codigo,int telefone){
        try {
            String sql = "update trabalho_final_telefone set telefone=? where codigo=?;";
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, String.valueOf(telefone));
            pstn.setString(2, String.valueOf(codigo));
            pstn.execute();
            pstn.close();
        } catch (Exception e) {
            System.out.println( "Codigo nao corresponde a pessoa" +e);
        }
    }

    public void adicionarTelefone(int codigo1,int telefone1){
        try {
            String sql = "insert trabalho_final_telefone (telefone,codigo) values (?,?)";
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, String.valueOf(telefone1));
            pstn.setString(2, String.valueOf(codigo1));
            pstn.execute();
            pstn.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
