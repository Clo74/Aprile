/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principale.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name="v_scont_prod")
public class vistaScont implements Serializable {
    //id, dataS, idNeg, idRiga, idProd, qta, tipo, descrizione, przListVendL, przFinaleVendL
    
    @Id
    @Column(name="idRiga")
    private int id;
    
    @Column(name="dataS")
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate data;    

    @Column(name="id")
    private int idT;

    @Column(name="idNeg")
    private int idNeg;

    @Column(name="idProd")
    private int idProd;    
    
    @Column(name="tipo")
    private String tipo;     

    @Column(name="descrizione")
    private String descrizione;     
    
    @Column(name="przListVendL")
    private double prezzoVL;

    @Column(name="przFinaleVendL")
    private double przFinaleVendL;
    
    @Column(name="qta")
    private int qta;

    public vistaScont() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final vistaScont other = (vistaScont) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
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

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public int getIdNeg() {
        return idNeg;
    }

    public void setIdNeg(int idNeg) {
        this.idNeg = idNeg;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzoVL() {
        return prezzoVL;
    }

    public void setPrezzoVL(double prezzoVL) {
        this.prezzoVL = prezzoVL;
    }

    public double getPrzFinaleVendL() {
        return przFinaleVendL;
    }

    public void setPrzFinaleVendL(double przFinaleVendL) {
        this.przFinaleVendL = przFinaleVendL;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }
    
}
