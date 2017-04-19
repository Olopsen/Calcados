/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.beans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author jp
 */
public class ClienteDAO
{
    private Connection conexao;
    
    public ClienteDAO()
    {
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void end()
    {
        try                     { this.conexao.close(); }
        catch (SQLException e)  { System.err.println("Erro ao fechar conexao com cliente"); }
    }
    
    
    public void insere(Cliente cli) throws RuntimeException
    {
        try
        {
            PreparedStatement insert = this.conexao.prepareStatement("insert into cliente "
                + "(telefone1, telefone2, endereco, cpf, nome, rg, dataNasc, observacao) values (?, ?, ?, ?, ?, ?, ?, ?)");
            
            insert.setString(1, cli.getTelefone1());
            insert.setString(2, cli.getTelefone2());
            insert.setString(3, cli.getEndereco());
            insert.setString(4, cli.getCpf());
            insert.setString(5, cli.getNome());
            insert.setString(6, cli.getRg());
            if (cli.getDataNasc() != null) insert.setDate(7, java.sql.Date.valueOf(cli.getDataNasc()));
            else insert.setDate(7, null);
            insert.setString(8, cli.getObservacao());
            
            insert.execute();
            insert.close();
        }
        
        catch (SQLException e)
        {
            throw new RuntimeException("Falha em inserir cliente" + e.getMessage());
        }
    }
    
    
    
    public ArrayList<Cliente> selectTudo() throws RuntimeException
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("select * from cliente");
            ArrayList<Cliente> clientes = leitura(query);
            query.close();
            
            return clientes;
        }
        
        catch (SQLException e) { throw new RuntimeException("Erro em selectTudo em cliente"); }
    }
    
    
    public ArrayList<Cliente> selectPorNome(String nome) throws RuntimeException
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("select * from cliente c where c.nome like ?");
            String like_nome = "%";
            like_nome += (nome + "%");
            query.setString(1, like_nome);
            
            ArrayList<Cliente> clientes = leitura(query);
            query.close();
            
            return clientes;
        }
        
        catch (SQLException e) { throw new RuntimeException("Erro em selectPorNome em cliente"); }
    }
    
    
    public ArrayList<Cliente> selectPorCpf(String cpf) throws RuntimeException
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("select * from cliente c where c.cpf = ?");
            query.setString(1, cpf);
            
            ArrayList<Cliente> clientes = leitura(query);
            query.close();
            
            return clientes;
        }
        
        catch (SQLException e) { throw new RuntimeException("Erro em selectPorCpf em cliente"); }
    }
    
    
    private ArrayList<Cliente> leitura(PreparedStatement query) throws SQLException
    {
        ResultSet rs = query.executeQuery();
        ArrayList<Cliente> clientes = new ArrayList<>();

        while (rs.next())
        {
            Cliente c = new Cliente();
            
            // caso seja o cliente "anonimo nada ele nao sera incluso no resultado"
            if (!rs.getString("nome").equals("-"))
            {
                c.setCpf(rs.getString("cpf"));
                if(rs.getDate("dataNasc") != null) c.setDataNasc(rs.getDate("dataNasc").toLocalDate());
                c.setEndereco(rs.getString("endereco"));
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setRg(rs.getString("rg"));
                c.setTelefone1(rs.getString("telefone1"));
                c.setTelefone2(rs.getString("telefone2"));
                c.setObservacao(rs.getString("observacao"));

                clientes.add(c);
            }

        }

        rs.close();

        return clientes;
    }
    
    
    public void deletar(int id)
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("delete from cliente where id = ?");
            query.setInt(1, id);
            query.execute();
            query.close();      
        }
        
        catch (SQLException e) { throw new RuntimeException("Erro ao deletar cliente"); }
    }
    
    
    // Atualiza os atributos que sao mostrados por ClienteTabelaModelo
    public void atualiza(Cliente cli)
    {
        try
        {
            PreparedStatement query = this.conexao.prepareStatement("update cliente set nome = ?, "
                + "cpf = ?, endereco = ?, telefone1 = ?, rg = ? where id = ?");
            query.setString(1, cli.getNome());
            query.setString(2, cli.getCpf());
            query.setString(3, cli.getEndereco());
            query.setString(4, cli.getTelefone1());
            query.setString(5, cli.getRg());
            query.setInt(6, cli.getId());
            query.execute();
            query.close();
        }
        
        catch (SQLException ex)
        {
            throw new RuntimeException("Erro no update de cliente");
        }
    }
}
