/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.beans.Cliente;
import model.dao.ClienteDAO;
import view.jfBuscaCliente;
import view.jifCadastroCliente;

/**
 *
 * @author jp
 */
public class ClienteCtrl
{   
    // construtor para tela de cadastro de cliente
    public ClienteCtrl(jifCadastroCliente telaCad)
    {
        telaCad.adicionaOuvinteJCadClienteSalvar(new OuvinteJCadClienteSalvar(telaCad));
    }
    
    // construtor para tela de busca de cliente
    public ClienteCtrl(jfBuscaCliente telaBuscaCliente)
    {
        telaBuscaCliente.adicionaOuvinte(new OuvinteJBuscaCliente(telaBuscaCliente));
    }
    
    
    
    // controle para tela de cadastro de cliente
    private class OuvinteJCadClienteSalvar implements ActionListener
    {
        private jifCadastroCliente telaCad;
        
        private OuvinteJCadClienteSalvar(jifCadastroCliente telaCad)
        {
            this.telaCad = telaCad;
        }
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == this.telaCad.getClienteSalvar())
            {
                
                if (this.telaCad.getjClienteCpf() == null || this.telaCad.getjClienteNome() == null ||
                    this.telaCad.getjClienteRg() == null)
                {
                    JOptionPane.showMessageDialog(null, "Todos os campos obrigatorios devem ser preenchidos",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try
                {
                    Cliente cli = new Cliente();

                    cli.setCpf(this.telaCad.getjClienteCpf());
                    cli.setDataNasc(this.telaCad.getjClienteDataNasc());
                    cli.setEndereco(this.telaCad.getjClienteEndereco());
                    cli.setNome(this.telaCad.getjClienteNome());
                    cli.setObservacao(this.telaCad.getjClienteObservacao());
                    cli.setRg(this.telaCad.getjClienteRg());
                    cli.setTelefone1(this.telaCad.getjClienteCelular());
                    cli.setTelefone2(this.telaCad.getjClienteTelefone());

                    ClienteDAO clie = new ClienteDAO();
                    clie.insere(cli);
                    clie.end();

                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
                }

                catch (Exception ex)
                {
                    if (ex.getMessage().contains("Duplicate entry"))
                        JOptionPane.showMessageDialog(null, "CPF ou RG já cadastrados", "Erro", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Verifique a validade dos campos informados\n"
                            + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    
    // controle para tela de busca de cliente
    private class OuvinteJBuscaCliente implements ActionListener
    {
        private jfBuscaCliente tela;
        
        private OuvinteJBuscaCliente(jfBuscaCliente tela)
        {
            this.tela = tela;
        }
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ClienteDAO dao = new ClienteDAO();
            ArrayList<Cliente> vet;
            
            if (e.getSource() == this.tela.getPesquisar())
            {
                // Limpa o resultado de pesquisas anteriores na tabela
                if (this.tela.getTabelaModelo().getRowCount() > 0)
                    this.tela.getTabelaModelo().limpaTabela();


                if (this.tela.getEstadoCpf())
                    vet = dao.selectPorCpf(this.tela.getCpf());

                else if (this.tela.getEstadoNome())
                    vet = dao.selectPorNome(this.tela.getNome());

                else
                {
                    JOptionPane.showMessageDialog(null,"Sua pesquisa ira retornar todos os clientes");
                    vet = dao.selectTudo();
                }
                
                this.tela.getTabelaModelo().adicionaLinhas(vet);
            }
            
            else if (e.getSource() == this.tela.getSalvarMudancas())
            {
                ArrayList<Integer> linhasMud = this.tela.getTabelaModelo().getlinhasQueForamMudadas();
                vet = this.tela.getTabelaModelo().getDados();
                
                if (linhasMud.size() < 1)
                    return;
                
                int resposta = JOptionPane.showConfirmDialog(tela, "Deseja realmente gravar a(s) mudança(s) feita(s)?");
                if(resposta != 0)
                {
                    vet.removeAll(vet);
                    this.tela.getTabelaModelo().fireTableDataChanged();
                    return;
                }
                
                int count = 0;
                for (Integer i : this.tela.getTabelaModelo().getlinhasQueForamMudadas())
                {
                    dao.atualiza(vet.get(i));
                    count++;
                }
                
                linhasMud.removeAll(linhasMud);
                JOptionPane.showMessageDialog(tela, "Foram atualizados " + count + " registro(s)");
            }
            
            else if (e.getSource() == this.tela.getExcluir())
            {
                
                int[] linhas = this.tela.getTabela().getSelectedRows();
                if (linhas.length == 0)
                    return;
                
                int resposta = JOptionPane.showConfirmDialog(tela, "Deseja realmente excluir o(s) registro(s) selecionado(s)?");
                if(resposta != 0)
                    return;
                    
                vet = this.tela.getTabelaModelo().getDados();
                ArrayList<Cliente> vet_aux = new ArrayList<>();
                
                int count = 0;
                for (int i = 0; i < linhas.length; i++)
                {
                    vet_aux.add(vet.get(linhas[i]));
                    dao.deletar(vet.get(linhas[i]).getId());
                    count++;
                }
                
                for (Cliente cli : vet_aux)
                    vet.remove(cli);
                
                JOptionPane.showMessageDialog(tela, "Foram removidos " + count + " registro(s)");
                this.tela.getTabelaModelo().fireTableDataChanged();
            }
        }
    }
}
