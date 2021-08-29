package pacote.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import pacote.dominio.Fisioterapeuta;

public class DAOFisioterapeuta {
    
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
        
    public boolean insereFisioterapeuta(Fisioterapeuta fisioterapeuta){
        conectar();
        String sql = "INSERT INTO fisioterapeuta(nome, nascimento, genero, cpf, telefone, crefito, especialidade) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
        Date auxDataNascimento = new Date();
        auxDataNascimento = fisioterapeuta.getNascimento();
        java.sql.Date sqlDataNascimento = new java.sql.Date(auxDataNascimento.getTime());
            
        try {
            comando = con.prepareStatement(sql);
                
            comando.setString(1, fisioterapeuta.getNome());
            comando.setDate(2, sqlDataNascimento);
            comando.setString(3, fisioterapeuta.getGenero());
            comando.setString(4, fisioterapeuta.getCpf());
            comando.setString(5, fisioterapeuta.getTelefone());
            comando.setString(6, fisioterapeuta.getCrefito());
            comando.setString(7, fisioterapeuta.getEspecialidade());
                
            comando.execute();
            return true;
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir registro " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
        return false;
    }
    
    public ArrayList<Fisioterapeuta> visualizarFisioterapeuta(){
        conectar();
            
        ResultSet rs;
            
        String sql = "SELECT * FROM fisioterapeuta";
            
        ArrayList<Fisioterapeuta> listaFisioterapeuta = new ArrayList<>();
            
        try {
            comando = con.prepareStatement(sql);
                
            rs = comando.executeQuery();
                
            while (rs.next() ){
                Fisioterapeuta fisioterapeuta = new Fisioterapeuta(rs.getString("nome"), rs.getDate("nascimento"), rs.getString("genero"), 
                        rs.getString("cpf"), rs.getString("telefone"), rs.getString("crefito"), rs.getString("especialidade"));
                fisioterapeuta.setIdFisioterapeuta(rs.getInt("idFisioterapeuta"));
                listaFisioterapeuta.add(fisioterapeuta);
                    
            }
                
            fechar();
                
            return listaFisioterapeuta;
                
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
                
            fechar();
                
            return null;
        }
    }
    
    public boolean alteraFisioterapeuta(Fisioterapeuta fisioterapeuta){
        conectar();
                
        String sql = "UPDATE fisioterapeuta SET nome = ?, nascimento = ?, genero = ?, cpf = ?, telefone = ?, "
                + "crefito = ?, especialidade = ? WHERE idFisioterapeuta = ?";
                
        java.sql.Date sqlDataNascimento = new java.sql.Date(fisioterapeuta.getNascimento().getTime());
            
        try {
            comando = con.prepareStatement(sql);
                
            comando.setString(1, fisioterapeuta.getNome());
            comando.setDate(2, sqlDataNascimento);
            comando.setString(3, fisioterapeuta.getGenero());
            comando.setString(4, fisioterapeuta.getCpf());
            comando.setString(5, fisioterapeuta.getTelefone());
            comando.setString(6, fisioterapeuta.getCrefito());
            comando.setString(7, fisioterapeuta.getEspecialidade());
            comando.setInt(8, fisioterapeuta.getIdFisioterapeuta());
                
            comando.executeUpdate();
                
            return true;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
                
        return false;
    }
    
    public boolean deletarFisioterapeuta(Integer id){
        conectar();
        
        String sql = "DELETE FROM fisioterapeuta WHERE idFisioterapeuta = ?";
        
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
