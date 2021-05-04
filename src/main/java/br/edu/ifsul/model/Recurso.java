/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_recurso")
public class Recurso implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    public Recurso() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*
    public List<Condominio> getCondominios() {
        return condominios;
    }

    public void setCondominios(List<Condominio> condominios) {
        this.condominios = condominios;
    }
     */
}
