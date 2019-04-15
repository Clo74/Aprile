/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nostalciac.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_corsi")
public class Corso implements Serializable {
            @Id
            @Column(name = "id_corso")
            private int id;
            @Column(name = "nome_corso")
            private String nome;
            @Column(name = "edizione")
            private String edizione;
            @Column(name = "data_inizio")
            private LocalDate inizio;
            @Column(name = "data_fine")
            private LocalDate fine;
            @Column(name = "note_corso")
            private String note;
            
            @ManyToOne
            @JoinColumn(name = "id_sede")
            private Sede sede;

    public Corso() {
    }

    @Override
    public String toString() {
        return "Corso{" + "id=" + id + ", nome=" + nome + ", edizione=" + edizione + ", dataIniz=" + inizio + ", dataFine=" + fine + ", note=" + note + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
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
        final Corso other = (Corso) obj;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdizione() {
        return edizione;
    }

    public void setEdizione(String edizione) {
        this.edizione = edizione;
    }

    public LocalDate getInizio() {
        return inizio;
    }

    public void setDataIniz(LocalDate dataIniz) {
        this.inizio = dataIniz;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate dataFine) {
        this.fine = dataFine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
            
            
            
}
