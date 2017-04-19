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
import model.beans.VendasPorDia;
import model.dao.VendasPorDiaDAO;
import model.dao.datasParaRelatoriosDAO;
import view.JfVendasPorDia;

/**
 *
 * @author jp
 */
public class VendasPorDiaCtrl implements ActionListener
{
    private JfVendasPorDia tela;
    private final int idData;
    
    public VendasPorDiaCtrl(JfVendasPorDia tela)
    {
        this.tela = tela;
        
        this.idData = 1;
        datasParaRelatoriosDAO d = new datasParaRelatoriosDAO();
        
        try
        {
            d.insereDatas(this.idData, null, null);
        }
        
        catch (RuntimeException ex)
        {
            if (!ex.getMessage().contains("Duplicate entry"))
            {
                JOptionPane.showMessageDialog(null, "Falha em processar as data no banco de dados"
                                , "Erro", JOptionPane.ERROR_MESSAGE);
                this.tela.fechar();
            }
        }
        d.end();
        this.tela.adicionarOuvinte(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        LocalDate dataIni, dataFim;
        dataIni = this.tela.getDataIni();
        dataFim = this.tela.getDataFim();
        
        if (dataIni == null || dataFim == null)
        {
            JOptionPane.showMessageDialog(null, "Verifique se as datas estão corretas"
                            , "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        datasParaRelatoriosDAO d = new datasParaRelatoriosDAO();
        d.updateDatas(this.idData, dataIni, dataFim);
        d.end();
        
        VendasPorDiaDAO dao = new VendasPorDiaDAO();
        ArrayList<VendasPorDia> v = dao.selectTudo();
        dao.end();
                
        this.tela.getTabelaModelo().adicionaLinhas(v);
        double total = 0;
        for (VendasPorDia ven : v)
            total += ven.getValorTotal();
        
        this.tela.setTotal(total);
    }
}
