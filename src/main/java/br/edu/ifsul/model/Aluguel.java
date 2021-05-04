/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "data_inicio_contrato", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataInicioContrato;

    @Column(name = "data_fim_contrato", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataFimContrato;

    @Column(name = "dia_vencimento", nullable = false)
    private Integer diaVencimento;

    @NotNull(message = "A unidade condominial deve ser informada")
    @ManyToOne
    @JoinColumn(name = "unidade_condominial", referencedColumnName = "id", nullable = false)
    private UnidadeCondominial unidadeCondominial;

    @NotNull(message = "O locatário deve ser informado")
    @ManyToOne
    @JoinColumn(name = "locatario", referencedColumnName = "id", nullable = false)
    private Locatario locatario;

    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mensalidade> mensalidades = new ArrayList<>();

    public Aluguel() {

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

    public Calendar getDataInicioContrato() {
        return dataInicioContrato;
    }

    public void setDataInicioContrato(Calendar dataInicioContrato) {
        this.dataInicioContrato = dataInicioContrato;
    }

    public Calendar getDataFimContrato() {
        return dataFimContrato;
    }

    public void setDataFimContrato(Calendar dataFimContrato) {
        this.dataFimContrato = dataFimContrato;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public UnidadeCondominial getUnidadeCondominial() {
        return unidadeCondominial;
    }

    public void setUnidadeCondominial(UnidadeCondominial unidadeCondominial) {
        this.unidadeCondominial = unidadeCondominial;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public List<Mensalidade> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }

}
