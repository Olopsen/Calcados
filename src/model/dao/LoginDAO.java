/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author jp
 */
public class LoginDAO
{    
    public static void registraAcesso(int colaborador_id) throws SQLException
    {
        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement insert = conexao.prepareStatement("insert into"
            + " registros_de_acesso (acesso, colaborador_id) values (?, ?)");
        insert.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
        insert.setInt(2, colaborador_id);
        insert.execute();
        
        insert.close();
        conexao.close();
    }
}
