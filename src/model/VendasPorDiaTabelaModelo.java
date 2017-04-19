/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.beans.VendasPorDia;

/**
 *
 * @author jp
 */
public class VendasPorDiaTabelaModelo extends AbstractTableModel
{
    private ArrayList<VendasPorDia> dados = new ArrayList<>();
    private String[] colunas = {"Nome funcinario", "ID funcionario", "Nome cliente", "CPF cliente", "hora", "Valor total"};
    
    
    
    public ArrayList<VendasPorDia> getDados()
    {
        return this.dados;
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
                return this.dados.get(lin).getColaborador();
            case 1:
                return this.dados.get(lin).getIdC();
            case 2:
                return this.dados.get(lin).getCliente();
            case 3:
                return this.dados.get(lin).getCpfCli();
            case 4:
                return this.dados.get(lin).getHora();
            case 5:
                return this.dados.get(lin).getValorTotal();
        }
        
        return null;
    }
    
    
    @Override
    public boolean isCellEditable(int lin, int col)
    {
        return false;
    }
    
    public void adicionaLinhas(ArrayList<VendasPorDia> vendas)
    {
        this.dados = vendas;
        this.fireTableDataChanged();
    }
    
    public void limpaTabela()
    {
        this.dados.removeAll(this.dados);
        this.fireTableDataChanged();
    }
}
