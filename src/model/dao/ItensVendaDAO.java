/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.beans.ItensVenda;

/**
 *
 * @author jp
 */
public class ItensVendaDAO
{
    private Connection conexao;
    
    public ItensVendaDAO()
    {
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void end()
    {
        try                     { this.conexao.close(); }
        catch (SQLException e)  { System.err.println("Erro ao fechar conexao com produto"); }
    }
    
    public void insere(ItensVenda it)
    {
        try
        {
            PreparedStatement insert = this.conexao.prepareStatement("insert into itensVenda "
                + "(qtd, valorPagoUnid, venda_cod, produto_id) values (?, ?, ?, ?)");
            
            insert.setInt(1, it.getQtd());
            insert.setDouble(2, it.getValorPagoUnid());
            insert.setInt(3, it.getVenda_cod());
            insert.setInt(4, it.getProduto_id());
            
            insert.execute();
            insert.close();
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em inserir itensVenda" + e.getMessage());
        }
    }
}
