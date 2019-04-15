/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jooorario;

/**
 *
 * @author tss
 */
public class Tempo {

    private int ore;
    private int minuti;
    private int secondi;

    public Tempo(int ore, int minuti, int secondi) {

        if (validOra(ore, minuti, secondi)) {
            this.ore = ore;
            this.minuti = minuti;
            this.secondi = secondi;
        } else {
            throw new IllegalArgumentException("inserire un'ora valida");
        }

    }

    public boolean validOra(int Ore, int Minuti, int Secondi) {

        //valido le ore minuti secondi
        if (Ore < 0 || Ore > 23) {
            return false;
        }
        if (Minuti < 0 || Minuti > 59) {
            return false;
        }
        if (Secondi < 0 || Secondi > 59) {
            return false;
        }

        return true;
    }

    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public void addOrari(Tempo ora2) {
        int appOre = 0;
        int appMinuti = 0;
        int appSecondi = 0;

        appSecondi = ora2.getSecondi() + getSecondi();
        if (appSecondi > 59) {
            appSecondi = appSecondi - 59;
            appMinuti = 1;
        } 
        secondi = appSecondi;
        appMinuti += ora2.getMinuti() + getMinuti();
        if (appMinuti > 59) {
            appMinuti = appMinuti - 59;
            appOre = 1;
        }
        minuti = appMinuti;
        appOre += getOre() + ora2.getOre();
        if (appOre > 23) { appOre= appOre - 24;}
        ore=appOre;
        
    }

    public void sottOrari(Tempo ora2) {
        int appOre = 0;
        int appMinuti = 0;
        int appSecondi = 0;

        appSecondi = getSecondi() - ora2.getSecondi();
        if (appSecondi <0) {
            appSecondi =  59 + appSecondi;
            appMinuti = -1;
        } 
        secondi = appSecondi;
        appMinuti += getMinuti() - ora2.getMinuti();
        if (appMinuti <0) {
            appMinuti = 59 + appMinuti ;
            appOre = -1;
        }
        minuti = appMinuti;
        appOre += ora2.getOre() - getOre();
        if (appOre < 0) { appOre= 24 - appOre ;}
        ore=appOre;

    }
    
    @Override
    public String toString() {
        
        return getOre() + ":" + getMinuti() + ":" + getSecondi();
        
        
        
    }
}
