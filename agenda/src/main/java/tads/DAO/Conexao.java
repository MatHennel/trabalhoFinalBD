package tads.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.swing.JOptionPane;



public class Conexao {
    public Connection conectaBd(){
        Connection conn = null;
        
        

        try {
           
            conn = DriverManager.getConnection(
                "jdbc:mysql://wagnerweinert.com.br/tads21_matheushennel",
                "tads21_matheushennel",
                "tads21_matheushennel"


            );
            System.out.println("CONECTADO AO BANCO");
            return conn;

        } catch (SQLException e) {
            System.out.println("erro");
            
            return null;
        }
        
    }
    
}