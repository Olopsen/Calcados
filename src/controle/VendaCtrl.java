/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.beans.Cliente;
import model.beans.Colaborador;
import model.beans.ItensVenda;
import model.beans.Produto;
import model.beans.Venda;
import model.dao.ClienteDAO;
import model.dao.ProdutoDAO;
import model.dao.VendaDAO;
import view.JifCadastrodeProduto;
import view.JfPagamento;
import view.jfVendas;
import view.jfBuscaClienteParaVenda;
import view.jfBuscaProd;

/**
 *
 * @author jp
 */
public class VendaCtrl implements ActionListener
{
    private jfVendas telaDaVenda;
    private Cliente ClienteDaVenda;
    private Colaborador funcionario;
    private Venda vend;
    private boolean jaClicado1;
    
    public VendaCtrl(jfVendas telaDaVenda, Colaborador c)
    {
        this.funcionario = c;
        this.telaDaVenda = telaDaVenda;
        telaDaVenda.adicionaOuvinte(this);
        this.jaClicado1 = false;
        
        // imprimindo algumas infromacões na textArea
        this.telaDaVenda.addInfo("=================================\n");
        this.telaDaVenda.addInfo("Atendente: " + this.funcionario.getNome() + "\n");
        DateTimeFormatter formato = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        this.telaDaVenda.addInfo(LocalDateTime.now().format(formato) + "\n=================================\n");
    }
    
    
    public void setClienteDaVenda(Cliente cli)
    {
        this.ClienteDaVenda = cli;
        this.telaDaVenda.addInfo("Cliente: " + this.ClienteDaVenda.getNome());
        this.telaDaVenda.addInfo("\n=================================\n");
    }
    

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.telaDaVenda.getBuscarCli())
        {
            if (this.jaClicado1)
                return;
            
            ClienteDAO dao = new ClienteDAO();
            jfBuscaClienteParaVenda telaBuscaCli = new jfBuscaClienteParaVenda(this);
            telaBuscaCli.setVisible(true);

            if (this.telaDaVenda.getCpfCliente() != null)
                telaBuscaCli.setTabelaDados(dao.selectPorCpf(this.telaDaVenda.getCpfCliente()));

            else if (this.telaDaVenda.getNomeCliente() != null)
                telaBuscaCli.setTabelaDados(dao.selectPorNome(this.telaDaVenda.getNomeCliente()));

            else
                telaBuscaCli.setTabelaDados(dao.selectTudo());

            dao.end();
            this.jaClicado1 = true;
        }
        
        else if (e.getSource() == this.telaDaVenda.getPesquisarProd())
        {
            ProdutoDAO dao = new ProdutoDAO();
            jfBuscaProd telaBuscaProd = new jfBuscaProd(this, this.telaDaVenda);
            telaBuscaProd.setVisible(true);
            
            ArrayList<Produto> v = dao.selectPorReferencia(this.telaDaVenda.getCampoPesquisaProd());
            if (v.size() > 0)
                telaBuscaProd.setTabelaDados(v);
            dao.end();
        }
        
        else if (e.getSource() == this.telaDaVenda.getDeletarProd())
        {
            int[] linhas = this.telaDaVenda.getTabela().getSelectedRows();
            if (linhas.length == 0)
                return;
            
            ArrayList<Produto> prods = this.telaDaVenda.getModeloDaTabela().getDados();
            for (int i = linhas.length - 1; i >= 0; i--)
                prods.remove(linhas[i]);
            this.telaDaVenda.atualizaTotal();
            this.telaDaVenda.getModeloDaTabela().fireTableDataChanged();
        }
        
        else if (e.getSource() == this.telaDaVenda.getConfirmaVenda())
        {
            ArrayList<Produto> prods = this.telaDaVenda.getModeloDaTabela().getDados();
            if (prods.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Pelo menos um produto deve ser selecionado");
                return;
            }
            
            this.vend = new Venda();
            
            if (this.ClienteDaVenda != null)
                vend.setCliente_id(this.ClienteDaVenda.getId());
            else
                vend.setCliente_id(-1);
            
            vend.setColaborador_id(this.funcionario.getId());
            vend.setData(LocalDate.now());
            vend.setHora(LocalTime.now());
            
            
            ArrayList<ItensVenda> itens = new ArrayList<>();
            
            for (Produto p : prods)
            {
                ItensVenda it = new ItensVenda();
                
                it.setProduto_id(p.getId());
                it.setQtd(p.getQtd());
                it.setValorPagoUnid(p.getValorVenda());
                
                itens.add(it);
            }
            
            vend.setProdutosVenda(itens);
            
            VendaDAO dao = new VendaDAO();
            dao.insere(vend);
            dao.end();
            
            double valorTotal = this.telaDaVenda.getPrecoTotal();
            
            JfPagamento tela_pag = new JfPagamento();
            PagamentoCtrl controle = new PagamentoCtrl(tela_pag, this.vend.getCod(), valorTotal, this.telaDaVenda);
            tela_pag.setVisible(true);
            this.telaDaVenda.setVisible(false);
        }
    }
}
