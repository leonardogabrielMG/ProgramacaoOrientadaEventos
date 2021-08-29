package pacote.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import pacote.dominio.Consulta;

public class DAOConsulta {
    
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
        
    public boolean insereConsulta(Consulta consulta){
        conectar();
        String sql = "INSERT INTO consulta(nomePaciente, nomeFisioterapeuta, data, status, descricao) VALUES (?, ?, ?, ?, ?)";
            
        Date auxDataNascimento = new Date();
        auxDataNascimento = consulta.getData();
        java.sql.Date sqlDataNascimento = new java.sql.Date(auxDataNascimento.getTime());
            
        try {
            comando = con.prepareStatement(sql);
                
            comando.setString(1, consulta.getNomePaciente());
            comando.setString(2, consulta.getNomeFisioterapeuta());
            comando.setDate(3, sqlDataNascimento);
            comando.setString(4, consulta.getStatus());
            comando.setString(5, consulta.getDescricao());
                
            comando.execute();
            return true;
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao agendar consulta " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
        return false;
    }
    
    public ArrayList<Consulta> visualizarConsulta(){
        conectar();
            
        ResultSet rs;
            
        String sql = "SELECT * FROM consulta";
            
        ArrayList<Consulta> listaConsulta = new ArrayList<>();
            
        try {
            comando = con.prepareStatement(sql);
                
            rs = comando.executeQuery();
                
            while (rs.next() ){
                Consulta consulta = new Consulta(rs.getString("nomePaciente"), rs.getString("nomeFisioterapeuta"), rs.getDate("data"), 
                        rs.getString("descricao"), rs.getString("status"));
                consulta.setIdConsulta(rs.getInt("idConsulta"));
                listaConsulta.add(consulta);
                    
            }
                
            fechar();
                
            return listaConsulta;
                
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
                
            fechar();
                
            return null;
        }
    }
    
    public boolean alteraConsulta(Consulta consulta){
        conectar();
                
        String sql = "UPDATE consulta SET nomePaciente = ?, nomeFisioterapeuta = ?, data = ?, descricao = ?, status = ? WHERE idConsulta = ?";
                
        java.sql.Date sqlDataNascimento = new java.sql.Date(consulta.getData().getTime());
            
        try {
            comando = con.prepareStatement(sql);
                
            comando.setString(1, consulta.getNomePaciente());
            comando.setString(2, consulta.getNomeFisioterapeuta());
            comando.setDate(3, sqlDataNascimento);
            comando.setString(4, consulta.getDescricao());
            comando.setString(5, consulta.getStatus());
            comando.setInt(6, consulta.getIdConsulta());
                
            comando.executeUpdate();
                
            return true;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
                
        return false;
    }
    
    public boolean deletaConsulta(Integer id){
        conectar();
        
        String sql = "DELETE FROM CONSULTA WHERE idConsulta = ?";
        
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
    
    public ArrayList<String> buscarFisioterapeuta(){
        conectar();
            
        ResultSet rs;
            
        String sql = "SELECT nome FROM fisioterapeuta";
            
        ArrayList<String> listaConsulta = new ArrayList<>();
            
        try {
            comando = con.prepareStatement(sql);
                
            rs = comando.executeQuery();
                
            while (rs.next() ){
                String nome = rs.getString("nome");
                
                listaConsulta.add(nome);
                    
            }
                
            fechar();
                
            return listaConsulta;
                
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
                
            fechar();
                
            return null;
        }
    }
    
    public ArrayList<String> buscarPaciente(){
        conectar();
            
        ResultSet rs;
            
        String sql = "SELECT nome FROM paciente";
            
        ArrayList<String> listaConsulta = new ArrayList<>();
            
        try {
            comando = con.prepareStatement(sql);
                
            rs = comando.executeQuery();
                
            while (rs.next() ){
                String nome = rs.getString("nome");
                
                listaConsulta.add(nome);
                    
            }
                
            fechar();
                
            return listaConsulta;
                
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
                
            fechar();
                
            return null;
        }
    }
}
