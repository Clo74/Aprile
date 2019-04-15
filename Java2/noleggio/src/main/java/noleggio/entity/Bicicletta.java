/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.entity;

/**
 *
 * @author tss
 */
public class Bicicletta {
    private int id;
    private String nr_telaio;
    private String cat_prodotto;
    
    public Bicicletta(){
        
    }

    @Override
    public int hashCode() {
        /*se il codice id è duplicato lui ne crea uno a caso*/
        int hash = 3;
        hash = 53 * hash + this.id;
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
        final Bicicletta other = (Bicicletta) obj;
        return this.id == other.id;
    }

    public Bicicletta(int id, String nr_telaio, String cat_prodotto) {
        this.id = id;
        this.nr_telaio = nr_telaio;
        this.cat_prodotto = cat_prodotto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNr_telaio() {
        return nr_telaio;
    }

    public void setNr_telaio(String nr_telaio) {
        this.nr_telaio = nr_telaio;
    }

    public String getCat_prodotto() {
        return cat_prodotto;
    }

    public void setCat_prodotto(String cat_prodotto) {
        this.cat_prodotto = cat_prodotto;
    }
    
    
}
