/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.beans.ItensVenda;
import model.beans.Venda;

/**
 *
 * @author jp
 */
public class VendaDAO
{
    private Connection conexao;
    
    public VendaDAO()
    {
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void end()
    {
        try                     { this.conexao.close(); }
        catch (SQLException e)  { System.err.println("Erro ao fechar conexao com produto"); }
    }
    
    public void insere(Venda ven)
    {
        try
        {
            PreparedStatement insert = this.conexao.prepareStatement("insert into venda "
                + "(data, hora, observacao, cliente_id, colaborador_id) values (?, ?, ?, ?, ?)");
            
            if (ven.getData() != null) insert.setDate(1, java.sql.Date.valueOf(ven.getData()));
            else insert.setDate(1, null);
            if (ven.getHora()!= null) insert.setTime(2, java.sql.Time.valueOf(ven.getHora()));
            else insert.setTime(2, null);
            insert.setString(3, ven.getObservacao());
            if (ven.getCliente_id() > 0) insert.setInt(4, ven.getCliente_id());
            else insert.setString(4, null);
            if (ven.getColaborador_id() > 0) insert.setInt(5, ven.getColaborador_id());
            else insert.setString(5, null);
            
            insert.execute();
            insert.close();
            
            int codigoDaVenda = this.selectCodDaVenda(ven);
            ven.setCod(codigoDaVenda);
            
            ItensVendaDAO itensDAO = new ItensVendaDAO();
            ArrayList<ItensVenda> itens = ven.getProdutosVenda();
            
            for (ItensVenda it : itens)
            {
                it.setVenda_cod(codigoDaVenda);
                itensDAO.insere(it);
            }
                
            itensDAO.end();
            
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em inserir vendas" + e.getMessage());
        }
    }
    
    
    private int selectCodDaVenda(Venda v) throws SQLException
    {
        PreparedStatement query = this.conexao.prepareStatement("select v.cod "
            + "from venda v where v.data = ? and v.hora = ?");
        
        query.setDate(1, java.sql.Date.valueOf(v.getData()));
        query.setTime(2, java.sql.Time.valueOf(v.getHora()));
        
        ResultSet rs = query.executeQuery();
        
        int a = 0;
        if (rs.next())
            a = rs.getInt("cod");
        if (rs.next())
            throw new RuntimeException("mais de uma venda encontrada para uma mesma data e hora");
        
        rs.close();
        query.close();
        return a;
    }
    
    public void delete(int cod)
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("delete from venda where cod = ?");
            query.setInt(1, cod);
            query.execute();
            query.close();
        }
        
        catch (SQLException e) { throw new RuntimeException("Erro ao apagar venda"); }
    }
}
