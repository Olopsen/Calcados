/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author jp
 */
public class datasParaRelatoriosDAO
{
    private Connection conexao;
    
    public datasParaRelatoriosDAO()
    {
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void end()
    {
        try                     { this.conexao.close(); }
        catch (SQLException e)  { System.err.println("Erro ao fechar conexao com datasParaRelatoriosDAO"); }
    }
    
    public void insereDatas(int id, LocalDate dataIni, LocalDate dataFim)
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("insert into datasParaRelatorios (dataIni, dataFim, id) "
                + "values (?, ?, ?)");
            
            if (dataIni != null) query.setDate(1, java.sql.Date.valueOf(dataIni));
            else query.setDate(1, null);
            
            if (dataFim != null) query.setDate(2, java.sql.Date.valueOf(dataFim));
            else query.setDate(2, null);
            
            query.setInt(3, id);
            
            query.execute();
            
            query.close();
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em inserir datas" + e.getMessage());
        }
    }
    
    public void updateDatas(int idData, LocalDate dataIni, LocalDate dataFim)
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("update datasParaRelatorios "
                + "set dataIni = ?, dataFim = ? where id = ?");
            
            if (dataIni != null) query.setDate(1, java.sql.Date.valueOf(dataIni));
            else query.setDate(1, null);
            
            if (dataFim != null) query.setDate(2, java.sql.Date.valueOf(dataFim));
            else query.setDate(2, null);
            
            query.setInt(3, idData);
            
            query.execute();
            
            query.close();
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em atualizar datas" + e.getMessage());
        }
    }
    
    public void removeDatas(LocalDate dataIni, LocalDate dataFim)
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("delete from datasParaRelatorios where "
                + "dataIni = ? and dataFim = ?");
            
            if (dataIni != null) query.setDate(1, java.sql.Date.valueOf(dataIni));
            else query.setDate(1, null);
            
            if (dataFim != null) query.setDate(2, java.sql.Date.valueOf(dataFim));
            else query.setDate(2, null);
            
            query.execute();
            
            query.close();
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em deletar datas" + e.getMessage());
        }
    }
}
