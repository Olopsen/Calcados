/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.beans.Colaborador;
import model.dao.ColaboradorDAO;
import view.JifCadastroFuncionarios;

/**
 *
 * @author jp
 */
public class ColaboradorCtrl
{        
    public ColaboradorCtrl(JifCadastroFuncionarios telaCad)
    {
        telaCad.adicionarOuvinteJbSalvar(new OuvinteSalvarCadFuncionario(telaCad));
    }
    
    private class OuvinteSalvarCadFuncionario implements ActionListener
    {
        private JifCadastroFuncionarios telaCad;
        
        private OuvinteSalvarCadFuncionario(JifCadastroFuncionarios telaCad)
        {
            this.telaCad = telaCad;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            Colaborador co = new Colaborador();
        
            if (this.telaCad.getjFuncionarioCpf() == null || this.telaCad.getjFuncionarioNome() == null ||
                this.telaCad.getjFuncionarioSenha() == null || this.telaCad.getjFuncionarioLogin() == null ||
                this.telaCad.getjFuncionarioRg() == null)
            {
                JOptionPane.showMessageDialog(null, "Todos os campos obrigatorios devem ser preenchidos",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try
            {
                co.setCargo(this.telaCad.getjFuncionarioCargo());
                co.setComissao(this.telaCad.getjFuncionarioComissao());
                co.setCpf(this.telaCad.getjFuncionarioCpf());
                co.setTelefone(this.telaCad.getjFuncionarioCelular());
                co.setDataAdmissao(this.telaCad.getjFuncionarioDataAdmissao());
                co.setDataNasc(this.telaCad.getjFuncionarioDataNasc());
                co.setDataDemissao(null);
                co.setEndereco(this.telaCad.getjFuncionarioEndereco());
                co.setLogin(this.telaCad.getjFuncionarioLogin());
                co.setNome(this.telaCad.getjFuncionarioNome());
                co.setRg(this.telaCad.getjFuncionarioRg());
                co.setSalario(this.telaCad.getjFuncionarioSalario());
                co.setSenha(this.telaCad.getjFuncionarioSenha());

                ColaboradorDAO colab = new ColaboradorDAO();
                colab.insere(co);
                colab.end();

                JOptionPane.showMessageDialog(null, "Colaborador cadastrado com sucesso");
            }

            catch (Exception ex)
            {
                if (ex.getMessage().contains("Duplicate entry"))
                    JOptionPane.showMessageDialog(null, "CPF, RG ou login já cadastrados", "Erro", JOptionPane.ERROR_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Verifique a validade dos campos informados", "Erro", JOptionPane.ERROR_MESSAGE);

            }
        }
        
    }
}
