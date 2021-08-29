/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote.visao.fisioterapeuta;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pacote.DAO.DAOFisioterapeuta;
import pacote.dominio.Fisioterapeuta;
import pacote.visao.principal;

/**
 *
 * @author LEO
 */
public class fisioterapeutaEditar extends javax.swing.JFrame {

    /**
     * Creates new form fisioterapeutaEditar
     */
    public fisioterapeutaEditar() {
        initComponents();
        
        DAOFisioterapeuta visualizar = new DAOFisioterapeuta();
        List<Fisioterapeuta> visualizarFisioterapeuta = new ArrayList<>();
        visualizarFisioterapeuta = visualizar.visualizarFisioterapeuta();
        
        DefaultTableModel modelo = (DefaultTableModel) tabelaEditarFisioterapeuta.getModel();
        
        visualizarFisioterapeuta.forEach(f -> {
            Object[] dados = {f.getIdFisioterapeuta(), f.getNome(), converteDataString(f.getNascimento()), f.getGenero(), f.getCpf(), f.getTelefone(), 
                f.getCrefito(), f.getEspecialidade()};
            modelo.addRow(dados);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEditarFisioterapeuta = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDITAR FISIOTERAPEUTA");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDITAR FISIOTERAPEUTA");

        tabelaEditarFisioterapeuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nome", "Data nascimento", "Genero", "CPF", "Telefone", "Crefito", "Especialidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEditarFisioterapeuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEditarFisioterapeutaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEditarFisioterapeuta);

        btVoltar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 494, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new principal().setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tabelaEditarFisioterapeutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEditarFisioterapeutaMouseClicked
        // TODO add your handling code here:
        int linha = tabelaEditarFisioterapeuta.getSelectedRow();
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente editar o registro de " + tabelaEditarFisioterapeuta.getValueAt(linha, 1) + "?" );
        if (resposta == 0) {
            Fisioterapeuta fisioterapeuta = new Fisioterapeuta(tabelaEditarFisioterapeuta.getValueAt(linha, 1).toString(), 
                    converteStringDate(tabelaEditarFisioterapeuta.getValueAt(linha, 2).toString()), 
                    tabelaEditarFisioterapeuta.getValueAt(linha, 3).toString(), tabelaEditarFisioterapeuta.getValueAt(linha, 4).toString(), 
                    tabelaEditarFisioterapeuta.getValueAt(linha, 5).toString(), tabelaEditarFisioterapeuta.getValueAt(linha, 6).toString(), 
                    tabelaEditarFisioterapeuta.getValueAt(linha, 7).toString());
            fisioterapeuta.setIdFisioterapeuta(Integer.parseInt(tabelaEditarFisioterapeuta.getValueAt(linha, 0).toString()));
            
            new fisioterapeutaEditarFormulario(fisioterapeuta).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_tabelaEditarFisioterapeutaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fisioterapeutaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fisioterapeutaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fisioterapeutaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fisioterapeutaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fisioterapeutaEditar().setVisible(true);
            }
        });
    }
    
    public static String converteDataString (Date data)
    {
        DateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
        String auxData = formatado.format(data);
        return auxData;
    }
    
    public static Date converteStringDate(String data) 
    {
        DateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
        Date novaData = null;
        try {
            novaData = formatado.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(fisioterapeutaEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novaData;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEditarFisioterapeuta;
    // End of variables declaration//GEN-END:variables
}
