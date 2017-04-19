/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class Venda
{
    private int cod;
    private LocalDate data;
    private LocalTime hora;
    private String observacao;
    private int cliente_id;
    private int colaborador_id;
    private ArrayList<ItensVenda> produtosVenda;

    public int getCod()
    {
        return cod;
    }

    public void setCod(int cod)
    {
        this.cod = cod;
    }

    public LocalDate getData()
    {
        return data;
    }

    public void setData(LocalDate data)
    {
        this.data = data;
    }

    public LocalTime getHora()
    {
        return hora;
    }

    public void setHora(LocalTime hora)
    {
        this.hora = hora;
    }

    public String getObservacao()
    {
        return observacao;
    }

    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }

    public int getCliente_id()
    {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id)
    {
        this.cliente_id = cliente_id;
    }

    public int getColaborador_id()
    {
        return colaborador_id;
    }

    public void setColaborador_id(int colaborador_id)
    {
        this.colaborador_id = colaborador_id;
    }

    public ArrayList<ItensVenda> getProdutosVenda()
    {
        return produtosVenda;
    }

    public void setProdutosVenda(ArrayList<ItensVenda> produtosVenda)
    {
        this.produtosVenda = produtosVenda;
    }
    
}
