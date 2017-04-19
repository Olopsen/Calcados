/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Login;
import model.beans.Colaborador;
import view.TelaLogin;
import view.principal;

/**
 *
 * @author jp
 */
public class LoginCtrl implements ActionListener
{
    private TelaLogin login;
    private principal tela;
    
    public LoginCtrl()
    {
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        this.login = new TelaLogin();
        this.login.setVisible(true);
        this.login.adicionarOuvinte(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //apagar esse
//        this.tela = new principal();
//        this.tela.setVisible(true);
//        this.login.dispose();
        
//    decomentar esse
        try
        {
            Colaborador c = Login.loginValido(login.getJLogin(), login.getJSenha());
            this.tela = new principal(c);
            this.tela.setVisible(true);
            this.login.dispose();
        }
        catch (SQLException | RuntimeException ex)
        {
            this.login.limpaCampos();
            JOptionPane.showMessageDialog(null, "Senha ou login invalidos");
        }
    }
    
}
