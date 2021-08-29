package pacote.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import pacote.dominio.Avaliacao;

public class DAOAvaliacao {
    
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
    
    public boolean insereAvaliacao(Avaliacao avaliacao){
        conectar();
        String sql = "INSERT INTO avaliacao(idConsultaRef, exercicioRealizado, observacao, evolucao, minutosExercitando) VALUES (?, ?, ?, ?, ?)";
            
        try {
            comando = con.prepareStatement(sql);
                
            comando.setInt(1, avaliacao.getIdConsultaRef());
            comando.setString(2, avaliacao.getExercicioRealizado());
            comando.setString(3, avaliacao.getObservacao());
            comando.setString(4, avaliacao.getEvolucao());
            comando.setInt(5, avaliacao.getMinutosExercitando());
                
            comando.execute();
            return true;
        }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir registro " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
        return false;
    }
    
    public ArrayList<Avaliacao> visualizarAvalicao(){
        conectar();
            
        ResultSet rs;
            
        String sql = "SELECT * FROM avaliacao";
            
        ArrayList<Avaliacao> listaAvaliacao = new ArrayList<>();
            
        try {
            comando = con.prepareStatement(sql);
                
            rs = comando.executeQuery();
                
            while (rs.next() ){
                Avaliacao avaliacao = new Avaliacao(rs.getInt("idConsultaRef"), rs.getString("exercicioRealizado"), 
                        rs.getString("observacao"), rs.getString("evolucao"), rs.getInt("minutosExercitando"));
                avaliacao.setIdAvaliacao(rs.getInt("idAvaliacao"));
                listaAvaliacao.add(avaliacao);
                    
            }
                
            fechar();
                
            return listaAvaliacao;
                
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados " + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
                
            fechar();
                
            return null;
        }
    }
    
    public boolean alterarAvaliacao(Avaliacao avaliacao){
        conectar();
                
        String sql = "UPDATE avaliacao SET idConsultaRef = ?, exercicioRealizado = ?, observacao = ?, evolucao = ?, minutosExercitando = ? "
                + "WHERE idAvaliacao = ?";
                
        try {
            comando = con.prepareStatement(sql);
                
            comando.setInt(1, avaliacao.getIdConsultaRef());
            comando.setString(2, avaliacao.getExercicioRealizado());
            comando.setString(3, avaliacao.getObservacao());
            comando.setString(4, avaliacao.getEvolucao());
            comando.setInt(5, avaliacao.getMinutosExercitando());
            comando.setInt(6, avaliacao.getIdAvaliacao());
                
            comando.executeUpdate();
                
            return true;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro!" + e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE, null);
        }finally{
            fechar();
        }
                
        return false;
    }
    
    public boolean deletarAvaliacao(Integer id){
        conectar();
        
        String sql = "DELETE FROM avaliacao WHERE idAvaliacao = ?";
        
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
    
    public ArrayList<Integer> buscaCodigoConsulta(){
        conectar();
            
        ResultSet rs;
            
        String sql = "SELECT idConsulta FROM consulta";
            
        ArrayList<Integer> listaConsulta = new ArrayList<>();
            
        try {
            comando = con.prepareStatement(sql);
                
            rs = comando.executeQuery();
                
            while (rs.next() ){
                int nome = rs.getInt("idConsulta");
                
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
