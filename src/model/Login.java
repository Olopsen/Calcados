/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import model.beans.Colaborador;
import model.dao.ColaboradorDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.dao.LoginDAO;

/**
 *
 * @author jp
 */
public class Login
{
    public static Colaborador loginValido(String usuario, String senha) throws SQLException, RuntimeException
    {
        ColaboradorDAO co = new ColaboradorDAO();
        ArrayList<Colaborador> colaboradores = co.leitura();
        co.end();
        
        for (Colaborador i : colaboradores)
        {
            if (i.getLogin().equals(usuario) && i.getSenha().equals(senha))
            {
                LoginDAO.registraAcesso(i.getId());
                return i;
            }
        }
        
        throw new RuntimeException("Falha no login");
    }
}
