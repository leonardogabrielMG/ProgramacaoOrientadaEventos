package pacote.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import pacote.dominio.Clinica;

public class DAOClinica {
    
    private Connection con;
    
    private PreparedStatement comando;
    
    private void conectar(){
        con = FabricaConexao.conexao();
    }
    
    private void fechar(){
        try {
            comando.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conecxão " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    public boolean insereCLinica(Clinica clinica){
        conectar();
        String sql = "INSERT INTO clinica(cep, bairro, rua, numero, cnpj, telefone, razaoSocial, nomeFantasia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
        try {
            comando = con.prepareStatement(sql);
                
            comando.setString(1, clinica.getCep());
            comando.setString(2, clinica.getBairro());
            comando.setString(3, clinica.getRua());
            comando.setInt(4, clinica.getNumero());
            comando.setString(5, clinica.getCnpj());
            comando.setString(6, clinica.getTelefone());
            comando.setString(7, clinica.getRazaoSocial());
            comando.setString(8, clinica.getRazaoSocial());
                
            comando.execute();
            return true;
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir registro " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
        return false;
    }
    
    public ArrayList<Clinica> visualizarClinica(){
        conectar();
            
        ResultSet rs;
            
        String sql = "SELECT * FROM clinica";
            
        ArrayList<Clinica> listaClinicas = new ArrayList<>();
            
        try {
            comando = con.prepareStatement(sql);
                
            rs = comando.executeQuery();
                
            while (rs.next() ){
                Clinica clinica = new Clinica(rs.getString("cep"), rs.getString("rua"), rs.getString("bairro"), rs.getInt("numero"), 
                        rs.getString("cnpj"), rs.getString("telefone"), rs.getString("razaoSocial"), rs.getString("nomeFantasia"));
                clinica.setIdClinica(rs.getInt("idClinica"));
                listaClinicas.add(clinica);
                    
            }
                
            fechar();
                
            return listaClinicas;
                
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
                
            fechar();
                
            return null;
        }
    }
    
    public boolean alterarClinica(Clinica clinica){
        conectar();
                
        String sql = "UPDATE clinica SET cep = ?, rua = ?, bairro = ?, numero = ?, cnpj = ?, telefone = ?, "
                + "razaoSocial = ?, nomeFantasia = ? WHERE idClinica = ?";
                
        try {
            comando = con.prepareStatement(sql);
                
            comando.setString(1, clinica.getCep());
            comando.setString(2, clinica.getRua());
            comando.setString(3, clinica.getBairro());
            comando.setInt(4, clinica.getNumero());
            comando.setString(5, clinica.getCnpj());
            comando.setString(6, clinica.getTelefone());
            comando.setString(7, clinica.getRazaoSocial());
            comando.setString(8, clinica.getNomeFantasia());
            comando.setInt(9, clinica.getIdClinica());
                
            comando.executeUpdate();
                
            return true;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!" + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
                
        return false;
    }
    
    public boolean deletarClinica(Integer id){
        conectar();
        
        String sql = "DELETE FROM clinica WHERE idClinica = ?";
        
        try {
            comando = con.prepareStatement(sql);
            comando.setInt(1, id);
            comando.executeUpdate();
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir registro " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
        
        return false;
    }
}
