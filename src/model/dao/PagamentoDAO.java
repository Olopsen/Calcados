/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.beans.Pagamento;

/**
 *
 * @author jp
 */
public class PagamentoDAO
{
    private Connection conexao;
    
    public PagamentoDAO()
    {
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void end()
    {
        try                     { this.conexao.close(); }
        catch (SQLException e)  { System.err.println("Erro ao fechar conexao com pagamento"); }
    }
    
    public void inserir(Pagamento pag)
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("insert into pagamento "
                + "(valorTotal, qtdParcelas, formaPag, venda_cod) values (?, ?, ?, ?)");
            
            query.setDouble(1, pag.getValoTotal());
            query.setInt(2, pag.getQtdParcelas());
            query.setInt(3, pag.getFormaPag());
            query.setInt(4, pag.getVenda_cod());
            
            query.execute();
            query.close();
        }
        
        catch (SQLException e) { throw new RuntimeException("Erro em inserir pagamento"); }
    }
}
