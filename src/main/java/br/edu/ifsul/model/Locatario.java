/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_locatario")
public class Locatario extends Pessoa implements Serializable {

    @Column(name = "renda", nullable = false)
    private double renda;

    @Column(name = "local_trabalho")
    private String localTrabalho;

    @Column(name = "telefone_trabalho")
    private String telefoneTrabalho;

    public Locatario() {

    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

}
