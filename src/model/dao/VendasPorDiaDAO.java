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
import model.beans.VendasPorDia;

/**
 *
 * @author jp
 */
public class VendasPorDiaDAO
{
    private Connection conexao;
    
    public VendasPorDiaDAO()
    {
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void end()
    {
        try                     { this.conexao.close(); }
        catch (SQLException e)  { System.err.println("Erro ao fechar conexao com a view"); }
    }
    
    public ArrayList<VendasPorDia> selectTudo() throws RuntimeException
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("select * from relatorioVendasPorDatas");
            ResultSet rs = query.executeQuery();
            
            ArrayList<VendasPorDia> vendas = new ArrayList<>();
            
            while (rs.next())
            {
                VendasPorDia v = new VendasPorDia();
                
                if (rs.getString("cliente") != null) v.setCliente(rs.getString("cliente"));
                else v.setCliente("");
                
                if (rs.getString("cpfCli") != null) v.setCpfCli(rs.getString("cpfCli"));
                else v.setCpfCli("");
                
                if (rs.getTime("hora") != null) v.setHora(rs.getTime("hora").toLocalTime());
                else v.setHora(null);
                
                v.setIdC(rs.getInt("idC"));
                v.setValorTotal(rs.getDouble("valorTotal"));
                v.setColaborador(rs.getString("colaborador"));
                
                vendas.add(v);
            }
            
            query.close();
            
            return vendas;
        }
        
        catch (SQLException e) { throw new RuntimeException("Erro em select da view"); }
    }
}
