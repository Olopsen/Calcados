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
public class Pagamento
{
    private int id;
    private double valoTotal;
    private int qtdParcelas;
    private int formaPag;
    private int venda_cod;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getValoTotal()
    {
        return valoTotal;
    }

    public void setValoTotal(double valoTotal)
    {
        this.valoTotal = valoTotal;
    }

    public int getQtdParcelas()
    {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas)
    {
        this.qtdParcelas = qtdParcelas;
    }

    public int getFormaPag()
    {
        return formaPag;
    }

    public void setFormaPag(int formaPag)
    {
        this.formaPag = formaPag;
    }

    public int getVenda_cod()
    {
        return venda_cod;
    }

    public void setVenda_cod(int venda_cod)
    {
        this.venda_cod = venda_cod;
    }
    
    
    
}
