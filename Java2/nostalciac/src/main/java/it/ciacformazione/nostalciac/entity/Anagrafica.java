/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author tss
 */

@Entity
@Table(name="t_anagrafiche")
public class Anagrafica implements Serializable {
    //id_anagrafica, cognome, nome, usr, pwd, mail, ruolo, citta, indirizzo, telefono, note, filefoto, data_nascita
    
    @Id
    @Column(name = "id_anagrafica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "cognome")
    private String cognome;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "usr")
    private String usr;
    
    @Column(name = "pwd")
    private String pwd;
    
    @Column(name = "mail")
    private String mail;
    
    @Column(name = "ruolo")
    private String ruolo;
    
    @Column(name = "citta")
    private String citta;
    
    @Column(name = "indirizzo")
    private String indirizzo;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "note")
    private String note;
    
    @Column(name = "data_nascita")
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate dataNas;

    @ManyToMany
    @JoinTable(
            name = "t_anagrafiche_corsi",
            joinColumns = @JoinColumn(name = "id_anagrafica",
                    referencedColumnName = "id_anagrafica"),
            inverseJoinColumns = @JoinColumn(name = "id_corso",
                    referencedColumnName = "id_corso")
    )
    private Set<Corso> corsi = new TreeSet<>();
    
       
     public Anagrafica(){
         
     }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDataNas() {
        return dataNas;
    }

    public void setDataNas(LocalDate dataNas) {
        this.dataNas = dataNas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
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
        final Anagrafica other = (Anagrafica) obj;
        return this.id == other.id;
    }


    @Override
    public String toString() {
        return "Anagrafica{" + "id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", usr=" + usr + ", pwd=" + pwd + ", mail=" + mail + ", ruolo=" + ruolo + ", citta=" + citta + ", indirizzo=" + indirizzo + ", telefono=" + telefono + ", note=" + note + ", dataNas=" + dataNas + '}';
    }


     
    

}
