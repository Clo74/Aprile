/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

/**
 *
 * @author tss
 */
public class Auto extends Veicolo implements Finanziabile {

    
    public enum Alimentazione {
        DIESEL,BENZINA
    }

    private final int porte;
    private final Alimentazione alimentazione;

    public Auto(String marca, int anno, int cilindrata, int porte, Alimentazione alimentazione) {
        super(marca, anno, cilindrata);
        this.porte = porte;
        this.alimentazione = alimentazione;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + String.format("porte %s \t alimentazione %s", this.porte,this.alimentazione);
        
    }
    
    public int getPorte() {
        return porte;
    }

    public Alimentazione getAlimentazione() {
        return alimentazione;
    }

    @Override
    public void finanzia(int tasso, int cifra) {
        System.out.println("finanzia auto");
    }
}
