/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="t_scontrini_testa")
public class ScontrinoT implements Serializable {
    //id_scontrino, data, id_negozio
    @Id
    @Column(name="id_scontrino")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        
    @Column(name="data_scontrino")
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate data;
    
    @Column(name="id_negozio")
    private int idNeg;
    
//    @ManyToOne
//    @JoinColumn(name = "id_negozio", referencedColumnName = "id_negozio")
//    private Negozio negozio;
    
    @OneToMany(mappedBy = "testa")
    @JsonbTransient
    @JoinColumn(name = "id_scontrino", referencedColumnName = "id_scontrino")
    private Set<ScontrinoR> righe = new TreeSet<>(); 

    public Set<ScontrinoR> getRighe() {
        return righe;
    }

    public void setRighe(Set<ScontrinoR> righe) {
        this.righe = righe;
    }

    public ScontrinoT() {
    }

    public int getIdNeg() {
        return idNeg;
    }

    public void setIdNeg(int idNeg) {
        this.idNeg = idNeg;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

//    public Negozio getNegozio() {
//        return negozio;
//    }
//
//    public void setNegozio(Negozio negozio) {
//        this.negozio = negozio;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final ScontrinoT other = (ScontrinoT) obj;
        return this.id == other.id;
    }
    
    
    
    
    
    
}
