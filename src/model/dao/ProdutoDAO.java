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
import model.beans.Produto;

/**
 *
 * @author jp
 */
public class ProdutoDAO
{
    private Connection conexao;
    
    public ProdutoDAO()
    {
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void end()
    {
        try                     { this.conexao.close(); }
        catch (SQLException e)  { System.err.println("Erro ao fechar conexao com produto"); }
    }
    
    
    public ArrayList<Produto> selectTudo()
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("select * from produto");
            ArrayList<Produto> vet = leitura(query);
            query.close();
            return vet;
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em ler os produtos do banco de dados: " + e.getMessage());
        }
    }
    
    public ArrayList<Produto> selectPorReferencia(String referencia) throws RuntimeException
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("select * from produto p where p.referencia = ?");
            query.setString(1, referencia);
            ArrayList<Produto> vet = leitura(query);
            query.close();
            return vet;
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em ler os produtos do banco de dados: " + e.getMessage());
        }
    }
    
    
    private ArrayList<Produto> leitura(PreparedStatement query) throws SQLException
    {
        ResultSet rs = query.executeQuery();            
        ArrayList<Produto> produtos = new ArrayList<>();

        while (rs.next())
        {
            Produto p = new Produto();

            p.setId(rs.getInt("id"));
            p.setReferencia(rs.getString("referencia")); //
            p.setCodBarras(rs.getString("codBarras"));
            p.setNome(rs.getString("nome")); //
            p.setCor(rs.getString("cor"));
            p.setMaterial(rs.getString("material"));
            p.setMarca(rs.getString("marca"));
            p.setModelo(rs.getString("modelo"));
            p.setValorCompra(rs.getDouble("valorCompra"));
            p.setValorVendaAntigo(rs.getDouble("valorVendaAntigo"));
            p.setValorVenda(rs.getDouble("valorVenda")); //
            p.setQtd(rs.getInt("qtd")); // botar 1 por padrao na tela

            produtos.add(p);
        }

        rs.close();
        query.close();

        return produtos;
    }
    
    
    public void insere(Produto p) throws RuntimeException
    {
        try
        {
            PreparedStatement insert = this.conexao.prepareStatement("insert into produto "
                + "(referencia, codBarras, nome, cor, material, marca, modelo, valorCompra, valorVendaAntigo, "
                + "valorVenda, qtd) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            insert.setString(1, p.getReferencia());
            insert.setString(2, p.getCodBarras());
            insert.setString(3, p.getNome());
            insert.setString(4, p.getCor());
            insert.setString(5, p.getMaterial());
            insert.setString(6, p.getMarca());
            insert.setString(7, p.getModelo());
            insert.setDouble(8, p.getValorCompra());
            insert.setDouble(9, p.getValorVendaAntigo());
            insert.setDouble(10, p.getValorVenda());
            insert.setInt(11, p.getQtd());
            
            insert.execute();
            insert.close();
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em inserir cliente" + e.getMessage());
        }
    }
}
