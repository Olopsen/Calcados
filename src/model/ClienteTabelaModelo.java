/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.beans.Cliente;

/**
 *
 * @author jp
 */
public class ClienteTabelaModelo extends AbstractTableModel
{
    private ArrayList<Cliente> dados = new ArrayList<>();
    private String[] colunas = {"nome", "cpf", "endereço", "celular", "rg"};
    
    private ArrayList<Integer> linhasQueForamMudadas = new ArrayList<>();
    
    
    
    public ArrayList<Cliente> getDados()
    {
        return this.dados;
    }
    
    public ArrayList<Integer> getlinhasQueForamMudadas()
    {
        return this.linhasQueForamMudadas;
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
                return this.dados.get(lin).getNome();
            case 1:
                return this.dados.get(lin).getCpf();
            case 2:
                return this.dados.get(lin).getEndereco();
            case 3:
                return this.dados.get(lin).getTelefone1();
            case 4:
                return this.dados.get(lin).getRg();
        }
        
        return null;
    }
    
    
    @Override
    public boolean isCellEditable(int lin, int col)
    {
        return true;
    }

    @Override
    public void setValueAt(Object valor, int lin, int col)
    {
        switch (col)
        {
            case 0:
                this.dados.get(lin).setNome((String) valor);
                break;
            case 1:
                this.dados.get(lin).setCpf((String) valor);
                break;
            case 2:
                this.dados.get(lin).setEndereco((String) valor);
                break;
            case 3:
                this.dados.get(lin).setTelefone1((String) valor);
                break;
            case 4:
                this.dados.get(lin).setRg((String) valor);
                break;
        }
        
        if (!this.linhasQueForamMudadas.contains(lin))
            this.linhasQueForamMudadas.add(lin);
    }
    
    
    
    public void adicionaLinhas(ArrayList<Cliente> cli)
    {
        this.dados = cli;
        this.fireTableDataChanged();
    }
    
    public void limpaTabela()
    {
        this.dados.removeAll(this.dados);
        this.fireTableDataChanged();
    }
    
}
