/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlez06_dadi;

/**
 *
 * @author tss
 */
public class JLez06_Dadi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int punteggio1;
        int punteggio2;
        int budget = 10;

        //lancio il primo dado

        do {
            punteggio1 = lanciaDado();
            punteggio2 = lanciaDado();

            System.out.println("Punteggio banco: " + punteggio1);

            System.out.println("Punteggio giocatore: " + punteggio2);

            
            if (punteggio1 > punteggio2) {
                System.out.println("Vince in banco " + punteggio1 + " Giocatore perde: " + punteggio2);
                budget = budget - 1;
            } else {
                System.out.println("Vince il giocatore " + punteggio2 + " Il banco perde: " + punteggio1);
                budget = budget + 1;
            }
           System.out.println("Budget: " + budget);
           System.out.println("---------------");

        } while (budget > 0 && budget < 20);
        
    }
    
    private static int lanciaDado(){
        int dado = (int) (Math.random() * 6 + 1);
        return dado;
    }
}
