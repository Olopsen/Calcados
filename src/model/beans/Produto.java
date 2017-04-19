/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author jp
 */
public class Produto
{
    private int id;
    private String referencia;
    private String codBarras;
    private String nome;
    private String cor;
    private String material;
    private String marca;
    private String modelo;
    private double valorCompra;
    private double valorVendaAntigo;
    private double valorVenda;
    private int qtd;
    private int fornecedor_id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getReferencia()
    {
        return referencia;
    }

    public void setReferencia(String referencia)
    {
        this.referencia = referencia;
    }

    public String getCodBarras()
    {
        return codBarras;
    }

    public void setCodBarras(String codBarras)
    {
        this.codBarras = codBarras;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCor()
    {
        return cor;
    }

    public void setCor(String cor)
    {
        this.cor = cor;
    }

    public String getMaterial()
    {
        return material;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public double getValorCompra()
    {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra)
    {
        if (valorCompra < 0) valorCompra = 0;
        this.valorCompra = valorCompra;
    }

    public double getValorVendaAntigo()
    {
        return valorVendaAntigo;
    }

    public void setValorVendaAntigo(double valorVendaAntigo)
    {
        if (valorVendaAntigo < 0) valorVendaAntigo = 0;
        this.valorVendaAntigo = valorVendaAntigo;
    }

    public double getValorVenda()
    {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda)
    {
        if (valorVenda < 0) valorVenda = 0;
        this.valorVenda = valorVenda;
    }

    public int getQtd()
    {
        return qtd;
    }

    public void setQtd(int qtd)
    {
        if (qtd < 0) qtd = 0;
        this.qtd = qtd;
    }

    public int getFornecedor_id()
    {
        return fornecedor_id;
    }

    public void setFornecedor_id(int fornecedor_id)
    {
        this.fornecedor_id = fornecedor_id;
    }
    
}
