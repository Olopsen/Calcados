/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.time.LocalTime;

/**
 *
 * @author jp
 */
public class VendasPorDia
{
    private String colaborador;
    private int idC;
    private String cliente;
    private String cpfCli;
    private LocalTime hora;
    private double valorTotal;

    public String getColaborador()
    {
        return colaborador;
    }

    public void setColaborador(String colaborador)
    {
        this.colaborador = colaborador;
    }

    public int getIdC()
    {
        return idC;
    }

    public void setIdC(int idC)
    {
        this.idC = idC;
    }

    public String getCliente()
    {
        return cliente;
    }

    public void setCliente(String cliente)
    {
        this.cliente = cliente;
    }

    public String getCpfCli()
    {
        return cpfCli;
    }

    public void setCpfCli(String cpfCli)
    {
        this.cpfCli = cpfCli;
    }

    public LocalTime getHora()
    {
        return hora;
    }

    public void setHora(LocalTime hora)
    {
        this.hora = hora;
    }

    public double getValorTotal()
    {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal)
    {
        this.valorTotal = valorTotal;
    }
}
