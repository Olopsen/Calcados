/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author EDUARDE
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jbAcessar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlogin = new javax.swing.JTextField();
        jSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de login");
        setPreferredSize(new java.awt.Dimension(550, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jbAcessar.setText("Acessar");
        jbAcessar.setToolTipText("Obs: ao clicar  voce vai comfirmar os dados ");
        jbAcessar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(jbAcessar);
        jbAcessar.setBounds(190, 210, 150, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("SENHA:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 120, 80, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("LOGIN:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 70, 70, 22);

        jlogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jloginActionPerformed(evt);
            }
        });
        getContentPane().add(jlogin);
        jlogin.setBounds(190, 70, 150, 30);
        getContentPane().add(jSenha);
        jSenha.setBounds(190, 120, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imglogin.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(550, 300));
        jLabel1.setMinimumSize(new java.awt.Dimension(550, 300));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcessarActionPerformed
        
    }//GEN-LAST:event_jbAcessarActionPerformed

    private void jloginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jloginActionPerformed
    {//GEN-HEADEREND:event_jloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jloginActionPerformed

    
    public void adicionarOuvinte(ActionListener ouvinte)
    {
        this.jbAcessar.addActionListener(ouvinte);
        
    }
    
    public String getJLogin()
    {
        return this.jlogin.getText();
    }
    
    public String getJSenha()
    {
        return new String(this.jSenha.getPassword());
    }
    
    public void limpaCampos()
    {
        this.jlogin.setText("");
        this.jSenha.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaLogin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jSenha;
    private javax.swing.JButton jbAcessar;
    private javax.swing.JTextField jlogin;
    // End of variables declaration//GEN-END:variables
}
