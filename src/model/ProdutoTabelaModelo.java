/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.beans.Produto;

/**
 *
 * @author jp
 */
public class ProdutoTabelaModelo extends AbstractTableModel
{
    private ArrayList<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Referência", "Nome", "Preço", "Quant"};
    
    private ArrayList<Integer> TotaisQueForamMudados = new ArrayList<>();
    private boolean foiEditado = false;
    private boolean habEdicao = false;
    
    
    public ArrayList<Produto> getDados()
    {
        return this.dados;
    }
    
    public ArrayList<Integer> getlinhasQueForamMudadas()
    {
        return this.TotaisQueForamMudados;
    }
    
    public void setHabEdicao(boolean b)
    {
        this.habEdicao = b;
    }

    public boolean foiEditado()
    {
        return foiEditado;
    }

    public void setFoiEditado(boolean foiEditado)
    {
        this.foiEditado = foiEditado;
    }
    
    
    
    @Override
    public String getColumnName(int col)
    {
        return colunas[col];
    }
    
    @Override
    public int getRowCount()
    {
        return this.dados.size();
    }

    @Override
    public int getColumnCount()
    {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int lin, int col)
    {
        switch (col)
        {
            case 0:
                return this.dados.get(lin).getReferencia();
            case 1:
                return this.dados.get(lin).getNome();
            case 2:
                return this.dados.get(lin).getValorVenda();
            case 3:
                return this.dados.get(lin).getQtd();
        }
        
        return null;
    }
    
    
    @Override
    public boolean isCellEditable(int lin, int col)
    {
        if (!this.habEdicao || col < 2)
            return false;
        return true;
    }

    @Override
    public void setValueAt(Object valor, int lin, int col)
    {
        switch (col)
        {
            case 2:
                double preco = Double.parseDouble((String) valor);
                if (preco < 1) preco = 1;
                this.dados.get(lin).setValorVenda(preco);
                this.foiEditado = true;
                break;
            case 3:
                int quant = Integer.parseInt((String) valor);
                if (quant < 1) quant = 1;
                this.dados.get(lin).setQtd(quant);
                this.foiEditado = true;
                break;
        }
        
        if (!this.TotaisQueForamMudados.contains(lin))
            this.TotaisQueForamMudados.add(lin);
    }
    
    
    public void adicionaLinhas(ArrayList<Produto> prods)
    {
        this.dados = prods;
        this.fireTableDataChanged();
    }
    
    public void adicionaLinha(Produto prod)
    {
        this.dados.add(prod);
        this.fireTableDataChanged();
    }
    
    public void limpaTabela()
    {
        this.dados.removeAll(this.dados);
        this.fireTableDataChanged();
    }
}
