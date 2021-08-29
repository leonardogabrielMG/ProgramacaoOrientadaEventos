package pacote.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FabricaConexao {
    public static Connection conexao(){
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = ("jdbc:mysql://127.0.0.1/clinicafisioterapia");
            
            con = DriverManager.getConnection(url, "root", "");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex){
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}