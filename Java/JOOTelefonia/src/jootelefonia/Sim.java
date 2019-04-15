/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jootelefonia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Sim {

    private final String nrTel;
    private double credito;
    private double cosMin;
    private  List<Telefonate> traffico = new ArrayList<>();

    public Sim(String nrTel, double credito, double cosMin) {
        this.nrTel = nrTel;
        this.credito = credito;
        this.cosMin = cosMin;
    }

    public String getNrTel() {
        return nrTel;
    }

    public double getCredito() {
        return credito;
    }

    public void insTelef(String tel, int min) {
        //inserisco la telefonata e calo il credito disponibile
        double appCostoTot = this.cosMin * min;
        Telefonate appTel = new Telefonate(tel, min, appCostoTot);
        
        traffico.add(appTel);
        
        this.credito -= appCostoTot;

    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public void setCosMin(double cosMin) {
        this.cosMin = cosMin;
    }

    public int getMinTot(){
        int minTot=0;
        for (Telefonate telefonate : traffico) {
            minTot+=telefonate.minuti;
        }
        
        return minTot;
        
    }
    
    public List<Telefonate> trafficoSim() {
        return traffico.stream().collect(Collectors.toList());
    }
    
    public long telefVersoNr (String num) {
        
        return traffico.stream().filter(t -> t.telChiamato.equals(num)).count();
        
    }
    
    
    @Override
    public String toString() {
        StringBuilder app = new StringBuilder();

        app.append("Telefono: ").append(this.nrTel).append(" credito: ").append(this.credito).append(" costo al minuto: ").append(this.cosMin);
        app.append("\n --------------------");
        
        this.traffico.stream().forEach(t -> app.append("\n Nr.Chiamato:").append(t.telChiamato).append(" durata:").append(t.minuti) );
        return app.toString();
    }

    private class Telefonate {

        private final String telChiamato;
        private final int minuti;
        private final double costo;

        public Telefonate(String telChiamato, int minuti, double costo) {
            this.telChiamato = telChiamato;
            this.minuti = minuti;
            this.costo = costo;
        }



    }

}
