/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Classe responsável por abrir conecções com o banco de dados, utilizada por todas as classes DAO.
 * Em caso de alteração do banco de dados utilizado ou da senha do SGBD as respectivas Strings
 * devem ser mudadas nos atributos da classe.
 * 
 * 
 */
public class ConnectionFactory
{
    private static String url = "jdbc:mysql://localhost/Calcados";
    private static String name = "root";
    private static String senha = "senhaBD 123";
    
    public static Connection getConnection() throws RuntimeException
    {
        try
        {
            return (Connection) DriverManager.getConnection(url,name,senha);
        } 
        catch (SQLException e)
        {
            throw new RuntimeException("Falha na conexao");
        }
    }
}
