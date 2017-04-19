/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.beans.Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.RuntimeException;

/**
 *
 * @author jp
 */
public class ColaboradorDAO
{
    private Connection conexao;
    
    public ColaboradorDAO()
    {
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void end()
    {
        try
        {
            this.conexao.close();
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao fechar conexao com colaborador");
        }
    }
    
    public ArrayList<Colaborador> leitura() throws RuntimeException
    {
        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement("select * from colaborador");
            ArrayList<Colaborador> colaboradores = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Colaborador c = new Colaborador();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setCargo(rs.getString("cargo"));
                c.setLogin(rs.getString("login"));
                c.setSenha(rs.getString("senha"));
                if(rs.getDate("dataNasc") != null) c.setDataNasc(rs.getDate("dataNasc").toLocalDate());
                if(rs.getDate("dataAdmissao") != null) c.setDataAdmissao(rs.getDate("dataAdmissao").toLocalDate());
                if(rs.getDate("dataDemissao") != null) c.setDataAdmissao(rs.getDate("dataDemissao").toLocalDate());
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setSalario(rs.getDouble("salario"));
                c.setComissao(rs.getDouble("comissao"));
                
                colaboradores.add(c);
            }
            
            rs.close();
            stmt.close();            
            
            return colaboradores;
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em ler os colaboradores do banco de dados: " +
                e.getMessage());
        }
    }
    
    public ArrayList<Colaborador> buscaNome(String nome)
    {
        ArrayList<Colaborador> todos_colab = this.leitura();
        ArrayList<Colaborador> busca = new ArrayList<>();
        
        for (Colaborador c : todos_colab)
        {
            if (c.getNome().equalsIgnoreCase(nome))
                busca.add(c);
        }
        
        return busca;
    }
    
    public void insere(Colaborador co) throws RuntimeException
    {
        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement("insert into colaborador "
                + "(nome, cpf, rg, cargo, login, senha, dataNasc, dataAdmissao, dataDemissao, "
                + "telefone, endereco, salario, comissao) values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, co.getNome());
            stmt.setString(2, co.getCpf());
            stmt.setString(3, co.getRg());
            stmt.setString(4, co.getCargo());
            stmt.setString(5, co.getLogin());
            stmt.setString(6, co.getSenha());
            
            if (co.getDataNasc() != null) stmt.setDate(7, java.sql.Date.valueOf(co.getDataNasc()));
            else stmt.setDate(7, null);
            if (co.getDataAdmissao() != null) stmt.setDate(8, java.sql.Date.valueOf(co.getDataAdmissao()));
            else stmt.setDate(8, null);
            if (co.getDataDemissao() != null) stmt.setDate(9, java.sql.Date.valueOf(co.getDataDemissao()));
            else stmt.setDate(9, null);
            
            stmt.setString(10, co.getTelefone());
            stmt.setString(11, co.getEndereco());
            stmt.setDouble(12, co.getSalario());
            stmt.setDouble(13, co.getComissao());
            
            stmt.execute();
            stmt.close();
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em inserir colaborador" + e.getMessage());
        }
    }
}
