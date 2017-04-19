/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.beans.Produto;
import model.dao.ProdutoDAO;
import view.JifCadastrodeProduto;

/**
 *
 * @author jp
 */
public class ProdutoCtrl
{
    public ProdutoCtrl(JifCadastrodeProduto telaCad)
    {
        telaCad.adicionaOuvinteBotaoConfirma(new OuvinteConfirmaProduto(telaCad));
    }
    
    private class OuvinteConfirmaProduto implements ActionListener
    {
        private JifCadastrodeProduto tela;
        
        private OuvinteConfirmaProduto(JifCadastrodeProduto tela)
        {
            this.tela = tela;
        }
           
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (this.tela.getReferencia() == null || this.tela.getNome() == null ||
                this.tela.getValorCompra() == -1 || this.tela.getValorVenda() == -1)
            {
                JOptionPane.showMessageDialog(null, "Todos os campos obrigatorios devem ser preenchidos",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try
            {
                Produto p = new Produto();

                p.setCodBarras(this.tela.getCodBarras());
                p.setCor(this.tela.getCor());
                p.setMarca(this.tela.getMarca());
                p.setMaterial(this.tela.getMaterial());
                p.setNome(this.tela.getNome());
                p.setQtd(this.tela.getQtd());
                p.setReferencia(this.tela.getReferencia());
                p.setValorCompra(this.tela.getValorCompra());
                p.setValorVenda(this.tela.getValorVenda());

                ProdutoDAO prod = new ProdutoDAO();
                prod.insere(p);
                prod.end();

                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
                this.tela.limpaCampos();
            }

            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Verifique a validade dos campos informados\n"
                    + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}
