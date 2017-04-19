/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.beans.Pagamento;
import model.beans.Venda;
import model.dao.PagamentoDAO;
import model.dao.VendaDAO;
import view.JfPagamento;
import view.jfVendas;

/**
 *
 * @author jp
 */
public class PagamentoCtrl implements ActionListener
{
    private jfVendas telaDaVenda;
    private JfPagamento tela;
    private double total;
    private int cod_venda;
    
    public PagamentoCtrl(JfPagamento tela, int cod_venda, double total, jfVendas telaDaVenda)
    {
        this.tela = tela;
        this.total = total;
        this.cod_venda = cod_venda;
        this.telaDaVenda = telaDaVenda;
        
        this.tela.setValorTotal(total);
        tela.adicionaOuvintes(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.tela.getConfirma())
        {
            Pagamento pag = new Pagamento();
            
            pag.setValoTotal(this.total);
            pag.setVenda_cod(this.cod_venda);
            
            if (this.tela.isAvista())
                pag.setFormaPag(1);
            else if (this.tela.isCheque())
                pag.setFormaPag(3);
            else
                pag.setFormaPag(2);

            pag.setQtdParcelas(this.tela.getNumParcelas());
             
            PagamentoDAO dao = new PagamentoDAO();
            dao.inserir(pag);
            dao.end();
            
            this.tela.setVisible(false);
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso");
            this.telaDaVenda.fechaVenda();
            this.tela.dispose();
        }
        
        else if (e.getSource() == this.tela.getRetornar())
        {
            VendaDAO dao = new VendaDAO();
            dao.delete(cod_venda);
            dao.end();
            this.telaDaVenda.setVisible(true);
            this.tela.dispose();
        }
    }
    
}
