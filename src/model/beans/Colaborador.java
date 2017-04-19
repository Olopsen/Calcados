/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import model.dao.ColaboradorDAO;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class Colaborador
{
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String cargo;
    private String login;
    private String senha;
    private LocalDate dataNasc;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private String telefone;
    private String endereco;
    private double salario;
    private double comissao;
    
    public int getId()
    {
        return id;
    }
    
    public Colaborador setId(int id)
    {
        this.id = id;
        return this;
    }

    public String getNome()
    {
        return nome;
    }

    public Colaborador setNome(String nome)
    {
        this.nome = nome;
        return this;
    }

    public String getCpf()
    {
        return cpf;
    }

    public Colaborador setCpf(String cpf)
    {
        this.cpf = cpf;
        return this;
    }

    public String getRg()
    {
        return rg;
    }

    public Colaborador setRg(String rg)
    {
        this.rg = rg;
        return this;
    }

    public String getCargo()
    {
        return cargo;
    }

    public Colaborador setCargo(String cargo)
    {
        this.cargo = cargo;
        return this;
    }

    public String getLogin()
    {
        return login;
    }

    public Colaborador setLogin(String login)
    {
        this.login = login;
        return this;
    }

    public String getSenha()
    {
        return senha;
    }

    public Colaborador setSenha(String senha)
    {
        this.senha = senha;
        return this;
    }

    public LocalDate getDataNasc()
    {
        return dataNasc;
    }

    public Colaborador setDataNasc(LocalDate dataNasc)
    {
        this.dataNasc = dataNasc;
        return this;
    }

    public LocalDate getDataAdmissao()
    {
        return dataAdmissao;
    }

    public Colaborador setDataAdmissao(LocalDate dataAdmissao)
    {
        this.dataAdmissao = dataAdmissao;
        return this;
    }

    public LocalDate getDataDemissao()
    {
        return dataDemissao;
    }

    public Colaborador setDataDemissao(LocalDate dataDemissao)
    {
        this.dataDemissao = dataDemissao;
        return this;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public Colaborador setTelefone(String telefone)
    {
        this.telefone = telefone;
        return this;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public Colaborador setEndereco(String endereco)
    {
        this.endereco = endereco;
        return this;
    }

    public double getSalario()
    {
        return salario;
    }

    public Colaborador setSalario(double salario)
    {
        this.salario = salario;
        return this;
    }

    public double getComissao()
    {
        return comissao;
    }

    public Colaborador setComissao(double comissao)
    {
        this.comissao = comissao;
        return this;
    }
}
