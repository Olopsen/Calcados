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
public class ItensVenda
{
    private int idItem;
    private int qtd;
    private double valorPagoUnid;
    private int venda_cod;
    private int produto_id;

    public int getIdItem()
    {
        return idItem;
    }

    public void setIdItem(int idItem)
    {
        this.idItem = idItem;
    }

    public int getQtd()
    {
        return qtd;
    }

    public void setQtd(int qtd)
    {
        this.qtd = qtd;
    }

    public double getValorPagoUnid()
    {
        return valorPagoUnid;
    }

    public void setValorPagoUnid(double valorPagoUnid)
    {
        this.valorPagoUnid = valorPagoUnid;
    }

    public int getVenda_cod()
    {
        return venda_cod;
    }

    public void setVenda_cod(int venda_cod)
    {
        this.venda_cod = venda_cod;
    }

    public int getProduto_id()
    {
        return produto_id;
    }

    public void setProduto_id(int produto_id)
    {
        this.produto_id = produto_id;
    }
    
    
    
    
}
