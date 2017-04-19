/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.time.LocalDate;

/**
 *
 * @author jp
 */
public class Cliente
{
    private int id;
    private String telefone1;
    private String telefone2;
    private String endereco;
    private String cpf;
    private String nome;
    private String rg;
    private String observacao;
    private LocalDate dataNasc;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTelefone1()
    {
        return telefone1;
    }

    public void setTelefone1(String telefone1)
    {
        this.telefone1 = telefone1;
    }

    public String getTelefone2()
    {
        return telefone2;
    }

    public void setTelefone2(String telefone2)
    {
        this.telefone2 = telefone2;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public String getObservacao()
    {
        return observacao;
    }

    public void setObservacao(String anotacoes)
    {
        this.observacao = anotacoes;
    }

    public LocalDate getDataNasc()
    {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc)
    {
        this.dataNasc = dataNasc;
    }
}
