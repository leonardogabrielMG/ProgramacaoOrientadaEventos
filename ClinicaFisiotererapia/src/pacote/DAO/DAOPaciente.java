package pacote.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import pacote.dominio.Paciente;

public class DAOPaciente {
    
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
        
    public boolean inserePaciente(Paciente paciente){
        conectar();
        String sql = "INSERT INTO paciente(nome, nascimento, genero, cpf, telefone, convenio) VALUES (?, ?, ?, ?, ?, ?)";
            
        Date auxDataNascimento = new Date();
        auxDataNascimento = paciente.getNascimento();
        java.sql.Date sqlDataNascimento = new java.sql.Date(auxDataNascimento.getTime());
            
        try {
            comando = con.prepareStatement(sql);
                
            comando.setString(1, paciente.getNome());
            comando.setDate(2, sqlDataNascimento);
            comando.setString(3, paciente.getGenero());
            comando.setString(4, paciente.getCpf());
            comando.setString(5, paciente.getTelefone());
            comando.setString(6, paciente.getConvenio());
                
            comando.execute();
            return true;
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir registro " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
        return false;
    }
    
    public ArrayList<Paciente> visualizarPaciente(){
        conectar();
            
        ResultSet rs;
            
        String sql = "SELECT * FROM paciente";
            
        ArrayList<Paciente> listaPaciente = new ArrayList<>();
            
        try {
            comando = con.prepareStatement(sql);
                
            rs = comando.executeQuery();
                
            while (rs.next() ){
                Paciente paciente = new Paciente(rs.getString("nome"), rs.getDate("nascimento"), rs.getString("genero"), 
                        rs.getString("cpf"), rs.getString("telefone"), rs.getString("convenio"));
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                listaPaciente.add(paciente);
                    
            }
                
            fechar();
                
            return listaPaciente;
                
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
                
            fechar();
                
            return null;
        }
    }
    
    public boolean alteraPaciente(Paciente paciente){
        conectar();
                
        String sql = "UPDATE paciente SET nome = ?, nascimento = ?, genero = ?, cpf = ?, telefone = ?, "
                + "convenio = ? WHERE idPaciente = ?";
                
        java.sql.Date sqlDataNascimento = new java.sql.Date(paciente.getNascimento().getTime());
            
        try {
            comando = con.prepareStatement(sql);
                
            comando.setString(1, paciente.getNome());
            comando.setDate(2, sqlDataNascimento);
            comando.setString(3, paciente.getGenero());
            comando.setString(4, paciente.getCpf());
            comando.setString(5, paciente.getTelefone());
            comando.setString(6, paciente.getConvenio());
            comando.setInt(7, paciente.getIdPaciente());
                
            comando.executeUpdate();
                
            return true;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
                
        return false;
    }
    
    public boolean deletarPaciente(Integer id){
        conectar();
        
        String sql = "DELETE FROM paciente WHERE idPaciente = ?";
        
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
