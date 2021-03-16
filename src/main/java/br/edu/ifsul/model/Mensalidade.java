/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pichau
 */
@Entity
@Table(name = "tb_mensalidade")
public class Mensalidade implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_mensaldiade", sequenceName = "seq_mensaldiade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_mensaldiade", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O valor deve ser informada")
    @Column(name = "valor", nullable = false)
    private double valor;

    @NotNull(message = "A data de vencimento deve ser informada")
    @Column(name = "data_vencimento", nullable = false)
    private Calendar dataVencimento;

    @NotNull(message = "O valor do pagamento deve ser informada")
    @Column(name = "valor_pagamento", nullable = false)
    private double valorPagamento;

    @NotNull(message = "A data de pagamento ser informada")
    @Column(name = "data_pagamento", nullable = false)
    private Calendar dataPagamento;

    @NotNull(message = "O aluguel deve ser informado")
    @ManyToOne
    @JoinColumn(name = "aluguel", referencedColumnName = "id", nullable = false)
    private Aluguel aluguel;

    public Mensalidade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return dataVencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.dataVencimento = vencimento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

}
