package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Pichau
 */
@Entity
@Table(name = "tb_condominio")
public class Condominio implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "cep", nullable = false)
    private String cep;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UnidadeCondominial> unidadesCondominiais = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_condominio_recurso",
            joinColumns
            = @JoinColumn(name = "condominio", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "recurso", referencedColumnName = "id",
                    nullable = false)
    )
    private Set<Recurso> recursos = new HashSet<>();

    public Condominio() {

    }

    public void adicionarUnidadeCondominial(UnidadeCondominial obj) {
        obj.setCondominio(this);
        this.unidadesCondominiais.add(obj);
    }

    public void removerUnidadeCondominial(int index) {
        this.unidadesCondominiais.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<UnidadeCondominial> getUnidadesCondominiais() {
        return unidadesCondominiais;
    }

    public void setUnidadesCondominiais(List<UnidadeCondominial> unidadesCondominiais) {
        this.unidadesCondominiais = unidadesCondominiais;
    }

    public Set<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(Set<Recurso> recursos) {
        this.recursos = recursos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
